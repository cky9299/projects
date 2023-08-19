import numpy as np
from math import sqrt
import matplotlib.pyplot as plt
from datetime import datetime

import gzip
from random import randint

def RandomlyInitWeights(noNeuronsInPrecedingLayer, noNeuronsInSubsequentLayer):
    epsilon_init = sqrt(6/(noNeuronsInPrecedingLayer + noNeuronsInSubsequentLayer))
    w = np.random.rand(noNeuronsInPrecedingLayer, noNeuronsInSubsequentLayer) * 2 * epsilon_init - epsilon_init
    return w

def sigmoid(_z):
    a=1/(1+np.exp(-_z))
    return a

def FirstDerivativeOfSigmoid(_z):
    return sigmoid(_z) * (1 - sigmoid(_z))


def ForwardPass(x, m, w1, w2, w3):
    a1 = np.concatenate([np.ones((m, 1)), x], axis=1) #design matrix. m x (n+1). dimensions assume input to hidden weights
    a2 = sigmoid(a1 @ w1) #sigmoid(design matrix @ weights). weights_(n+1)xh. ans_mxh; #type int @ float
    a2 = np.concatenate([np.ones((a2.shape[0], 1)), a2], axis=1) #add bias. a2.shape[0] rtn m
    a3 = sigmoid(a2 @ w2)#a3
    a3 = np.concatenate([np.ones((a3.shape[0], 1)), a3], axis=1) #add bias. a2.shape[0] rtn m
    h = sigmoid(a3 @ w3)#a3    
    return h, a1, a2, a3

def LogicalArr(y,m,K):
    logicalArr = np.zeros((m,K))
    for i in range(m):
        logicalArr[i][y[i][0]] = 1
    return logicalArr

def CostFunc(logicalArr,h,m,lambda_,w1, w2, w3):
    crossEntropyError = -logicalArr * np.log(h) - (1-logicalArr) * np.log(1-h)
    costFuncOfNN = 1/m * np.sum(crossEntropyError)
    regularizationExpression = (lambda_ / (2 * m)) * (np.sum(np.square(w1[:, 1:])) + np.sum(np.square(w2[:, 1:]))) + np.sum(np.square(w3[:, 1:]))
    return costFuncOfNN + regularizationExpression
    
def Backpropagation(h,a1,a2,a3,logicalArr,w1,w2,w3):

    delta_4 = h - logicalArr
    delta_3 = delta_4 @ w3[1:, :].T * FirstDerivativeOfSigmoid(a2 @ w2)
    delta_2 = delta_3 @ w2[1:, :].T * FirstDerivativeOfSigmoid(a1 @ w1)
    Delta1 = delta_2.T @ a1 #hxm @ mx(n+1) = hx(n+1) = 25x785 #DEBUG delta1 mostly 0
    Delta2 = delta_3.T @ a2 #kxm @ mx(h+1) = kx(h+1)
    Delta3 = delta_4.T @ a3 #kxm @ mx(h+1) = kx(h+1)
    w1_grad = (1 / m) * Delta1 #hx(n+1) T = (n+1) x h
    w2_grad = (1 / m) * Delta2 #kx(h+1) T = (h+1) x k
    w3_grad = (1 / m) * Delta3 #kx(h+1) T = (h+1) x k
    #print(w1.shape, w1_grad.shape) #(n+1)xh, hx(n+1)
    w1_grad[1:, :] = w1_grad[1:, :] + (lambda_ / m) * w1[:, 1:].T #dont regularize the bias
    w2_grad[1:, :] = w2_grad[1:, :] + (lambda_ / m) * w2[:, 1:].T
    w3_grad[1:, :] = w3_grad[1:, :] + (lambda_ / m) * w3[:, 1:].T

    return w1_grad, w2_grad, w3_grad

def GradientDescent(alpha, convergenceThreshold, w1, w2, w3, logicalArr, m):    
    Carr=[100,999]
    Iter=1
    while abs(Carr[Iter]-Carr[Iter-1]) > convergenceThreshold:
        h_train, a1, a2, a3 = ForwardPass(x[:m,:], m, w1, w2, w3)
        w1_grad, w2_grad, w3_grad = Backpropagation(h_train,a1,a2,a3,logicalArr,w1,w2, w3)
        C = CostFunc(logicalArr,h_train,m,lambda_,w1, w2, w3)
        Carr.append(C)
#        print("C in while in GradientDescent=",C,'\n') #DEBUG        
#        print("Carr[i]-Carr[i-1] in while in GradientDescent=",Carr[Iter]-Carr[Iter-1],'\n') #DEBUG
        w1 -= alpha * w1_grad.T
        w2 -= alpha * w2_grad.T
        w3 -= alpha * w3_grad.T

        Iter+=1
      
    return w1, w2, w3, C, h_train

def CrossValidate(C_trainLen, m_train, m_cv, x, y, K, alpha, noHiddenNeurons, noHiddenNeurons1):
    scale = int(m_train / C_trainLen)
    C_train=[]; C_cv = []; mAxis = []; #mAxis contains the values of m that will form the x-axis; C forms the y-axis; each C is identified by its legend.
    '''
    print("Generating x-axis values... mAxis.append(i)...", datetime.now().strftime("%H:%M:%S"))
    for i in range(1, m_train, scale):
        mAxis.append(i)
        '''
    mAxis.append(m_train)

    for i in mAxis: #for each m
        print("Cal C... C.append for m=",i,"...", datetime.now().strftime("%H:%M:%S"))
        w1 = RandomlyInitWeights(785, noHiddenNeurons) #n, hidden
        w2 = RandomlyInitWeights(noHiddenNeurons+1, noHiddenNeurons1) #hidden, output
        w3 = RandomlyInitWeights(noHiddenNeurons1+1, 10) #n, hidden

        logicalArr_train = LogicalArr(y[:i,:], i, K)
        w1, w2, w3, C, h_train = GradientDescent(alpha, convergenceThreshold, w1, w2, w3, logicalArr_train, i)
        C_train.append(C)
        
        h_cv, a1, a2, a3 = ForwardPass(x[m_train:m_train+m_cv,:], m_cv, w1, w2, w3) #w1 and w2 r the trained weights. m_cv. x_cv
        logicalArr_cv = LogicalArr(y[m_train:m_train+m_cv,:], m_cv, K) #la_cv, y_cv
        C_cv.append(CostFunc(logicalArr_cv, h_cv, m_cv,lambda_,w1, w2, w3))
            
    return C_train, C_cv, mAxis, h_train, h_cv, logicalArr_train, logicalArr_cv, w1, w2, w3

def ProbabilityOfInvalidClassification(h,logicalArr_y,m,K): #h_mxK, la_mxK DEBUG
    h = h.tolist() #mxK
    predictedDigit = np.zeros((len(h),1)) #mx1

    for i in range(m):
        predictedDigit[i][0] = h[i].index(max(h[i]))
    
    logicalArr_predictedDigit = np.zeros((m,K))
    for i in range(m):
        fkingBot = int(predictedDigit[i][0])
        logicalArr_predictedDigit[i][fkingBot] = 1
    
    noInvalidPred=0; r=0; c=0
    while r < m:
        c=0
        while c < K:
            if logicalArr_predictedDigit[r][c] != logicalArr_y[r][c]:
                noInvalidPred+=1
                break
            c+=1
        r+=1

    return noInvalidPred / m * 100

def PlotLearningCurve(C_train, C_cv, mAxis, xLabel): #arr
    plot0=plt.figure(int(randint(1,1000000)))#, figsize=(15, 8), dpi=200 #Width, height in inches.
    plt.plot(mAxis, C_train, 'x')
    plt.plot(mAxis, C_cv, 'x') #The mew argument in the second plot() call sets the width of the marker edges.
    plt.plot(mAxis, C_train, '-', color='red', label='Training set') # the alpha parameter is used to adjust the transparency of a plot element, such as a line or marker. It is a float value between 0 and 1, where 0 is completely transparent and 1 is completely opaque.
    plt.plot(mAxis, C_cv, '-', color='green', label='cv set')
    plt.xlabel(xLabel)
    plt.ylabel('C')
    plt.legend(loc='upper left')
    
    save_directory = 'C:/comp/Scripts/ai/mnist/23/graphs/learning curve'
    filename = 'testerr='+str(testError)+', cverr='+str(cvError)+', trainerr='+str(trainError)+', noHiddenNeurons='+str(noHiddenNeurons)+', noHiddenNeurons1='+str(noHiddenNeurons1)+', lambda_='+str(lambda_)+', ct='+str(convergenceThreshold)+', a='+str(alpha)+', m='+str(m)+', exponentOfx='+str(exponentOfx)+'.png'
    save_path = f"{save_directory}/{filename}"
    plt.savefig(save_path)

    plot0.show()



#if __name__ == "__main__":
'''
m = 10000 #m_train : m_cv = 7 : 3
C_trainLen = 7
m_train = 7000
m_cv = 3000

m_test = 10000

'''
m = 60000 #m_train : m_cv = 7 : 3

C_trainLen = 1
m_train = 42000
m_cv = 18000
m_test = 10000
'''
C_trainLen = 1
m_train = 59999
m_cv = 1
m_test = 10000
'''

alpha = 1.5
convergenceThreshold = 3e-4

lambda_ = 3
noHiddenNeurons = 25
noHiddenNeurons1 = 25
exponentOfx = 1


with gzip.open(r'C:\comp\Scripts\ai\train-images-idx3-ubyte.gz', 'r') as f:
    # first 4 bytes is a magic number
    magic_number = int.from_bytes(f.read(4), 'big')
    # second 4 bytes is the number of images
    image_count = int.from_bytes(f.read(4), 'big')
    # third 4 bytes is the row count
    row_count = int.from_bytes(f.read(4), 'big')
    # fourth 4 bytes is the column count
    column_count = int.from_bytes(f.read(4), 'big')
    # rest is the image pixel data, each pixel is stored as an unsigned byte
    # pixel values are 0 to 255    
    image_data = f.read()
totalPixels=len(image_data) #=47040000; 28x28
noImg=int(totalPixels/784) #=60000.0 conv to int
x = np.frombuffer(image_data, dtype=np.uint8).reshape((noImg,784))
x = np.array(x,np.float64)

x=x**exponentOfx
scaleFactor = np.float64(255**exponentOfx)
x/=scaleFactor
#print('x in main\n',x,'\n') #DEBUG

with gzip.open(r'C:\comp\Scripts\ai\train-labels-idx1-ubyte.gz', 'r') as f:
    # first 4 bytes is a magic number
    magic_number = int.from_bytes(f.read(4), 'big')
    # second 4 bytes is the number of images
    label_count = int.from_bytes(f.read(4), 'big') #60 000
    labels=f.read()
y=np.frombuffer(labels, dtype=np.uint8).reshape((noImg,1))#2d arr (y_mx1)  #y=np.frombuffer(labels, dtype=np.uint8) #1d np arr 
#print('y in main\n',y,'\n') #DEBUG

K = 10 #no output neurons aka classifiers

C_train, C_cv, mAxis, h_train, h_cv, logicalArr_train, logicalArr_cv, w1, w2, w3 = CrossValidate(C_trainLen, m_train, m_cv, x, y, K, alpha, noHiddenNeurons, noHiddenNeurons1)
trainError = ProbabilityOfInvalidClassification(h_train, logicalArr_train, m_train, K)
cvError = ProbabilityOfInvalidClassification(h_cv,logicalArr_cv,m_cv,K)
print('Cal prob..', datetime.now().strftime("%H:%M:%S"))
print('ProbabilityOfInvalidClassification of train set: ', trainError,'%')
print('ProbabilityOfInvalidClassification of cv set: ', cvError,'%')

#extract test values and labels then
with gzip.open(r'C:\comp\Scripts\ai\t10k-images-idx3-ubyte.gz', 'r') as f: #X,a,y diff. w same coz trained
    # first 4 bytes is a magic number
    magic_number = int.from_bytes(f.read(4), 'big')
    # second 4 bytes is the number of images
    image_count = int.from_bytes(f.read(4), 'big')
    # third 4 bytes is the row count
    row_count = int.from_bytes(f.read(4), 'big')
    # fourth 4 bytes is the column count
    column_count = int.from_bytes(f.read(4), 'big')
    # rest is the image pixel data, each pixel is stored as an unsigned byte
    # pixel values are 0 to 255    
    image_data = f.read()
totalPixels=len(image_data) #=47040000
noImg=int(totalPixels/784) #=10000.0 conv to int
x = np.frombuffer(image_data, dtype=np.uint8).reshape((noImg,784))#x = np.frombuffer(image_data, dtype=np.uint8)
x = np.array(x,np.float64)
x=x**exponentOfx
scaleFactor = np.float64(255**exponentOfx)
x/=scaleFactor
X=np.insert(x,[0][0],1,1)

with gzip.open(r'C:\comp\Scripts\ai\t10k-labels-idx1-ubyte.gz', 'r') as f:
    # first 4 bytes is a magic number
    magic_number = int.from_bytes(f.read(4), 'big')
    # second 4 bytes is the number of images
    label_count = int.from_bytes(f.read(4), 'big') #10 000
    labels=f.read()
y=np.frombuffer(labels, dtype=np.uint8).reshape((noImg,1))#2d arr (y_mx1)  #y=np.frombuffer(labels, dtype=np.uint8) #1d np arr 

#cal h,la for test
h_test, a1, a2, a3 = ForwardPass(x, m_test, w1, w2, w3)
logicalArr_test = LogicalArr(y,m_test,K)
testError = ProbabilityOfInvalidClassification(h_test,logicalArr_test,m_test,K)
print('ProbabilityOfInvalidClassification of test set: ',testError,'%')
trainError = round(trainError, 3)
cvError = round(cvError, 3)
testError = round(testError, 3)
print('testerr='+str(testError)+', cverr='+str(cvError)+', trainerr='+str(trainError)+', noHiddenNeurons='+str(noHiddenNeurons)+', noHiddenNeurons1='+str(noHiddenNeurons1)+', lambda_='+str(lambda_)+', ct='+str(convergenceThreshold)+', a='+str(alpha)+', m='+str(m)+', exponentOfx='+str(exponentOfx)+'.png')
#PlotLearningCurve(C_train, C_cv, mAxis, "m")
save_directory = 'C:/comp/Scripts/ai/mnist/23/graphs/learning curve'
filename = 'testerr='+str(testError)+', cverr='+str(cvError)+', trainerr='+str(trainError)+', noHiddenNeurons='+str(noHiddenNeurons)+', noHiddenNeurons1='+str(noHiddenNeurons1)+', lambda_='+str(lambda_)+', ct='+str(convergenceThreshold)+', a='+str(alpha)+', m='+str(m)+', exponentOfx='+str(exponentOfx)+'.txt'
save_path = f"{save_directory}/{filename}"
with open(save_path,'a') as f:
    f.write(filename)
