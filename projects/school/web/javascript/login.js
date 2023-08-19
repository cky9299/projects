// only fill in the username and password then able to submit
function loginBtn(){
      const input_nameBox = document.getElementById('nameBox');
      const input_pswBox = document.getElementById('pswBox');

      if(input_nameBox.checkValidity() && input_pswBox.checkValidity()){
            document.getElementById('submitBtn2').style.cursor = "pointer";
            document.getElementById('submitBtn2').disabled = false;
      }

      if(!input_nameBox.checkValidity() || !input_pswBox.checkValidity()){
            document.getElementById('submitBtn2').style.cursor = "not-allowed";
            document.getElementById('submitBtn2').disabled = true;
      }
}
var usersArray = ["TARC", "1111", "RETRO", "2222", "GAME", "3333"];

function checkUserName(userName) {
   if(userName == document.getElementById("nameBox").value){  
            return userName; 
   }
}
function loginverify() {
var UserName= usersArray.find(checkUserName);
var UserNameIndex= usersArray.findIndex(checkUserName);

if ( UserName== null) {   
            document.getElementById("wrongUN").innerHTML = "Invalid User Name";
            document.getElementById("nameBox").value="";  
            document.getElementById("nameBox").focus();    
            document.getElementById("pswBox").value = "";
            document.getElementById("nameBox").onchange = function(){
               document.getElementById("wrongUN").innerHTML = "";
            }
   } else { 
      if(usersArray[UserNameIndex+1]!= document.getElementById("pswBox").value){
            document.getElementById("wrongPSW").innerHTML = "Invalid Password";
            document.getElementById("pswBox").value="";         
            document.getElementById("pswBox").focus()
            document.getElementById("pswBox").onchange = function(){
               document.getElementById("wrongPSW").innerHTML = "";
            }
      }else {
            // document.getElementById("output2").innerHTML = "Valid Password";    
            name=usersArray[UserNameIndex];
            document.login.submit();
            window.open("CATALOGUE.HTML","_self");
      }
   }
}
