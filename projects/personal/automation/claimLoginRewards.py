from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

service = Service(executable_path="C:\chrome driver\chromedriver.exe")
options=webdriver.ChromeOptions()
options.add_argument("--incognito")
driver=webdriver.Chrome(service=service, options=options)
driver.get("https://www.coingecko.com/account/candy?locale=en")

driver.find_element(By.ID, "user_email").send_keys("fej27r3@gmail.com")
driver.find_element(By.ID, "user_password").send_keys("feaffesk2" + Keys.ENTER)
WebDriverWait(driver, 4).until(EC.presence_of_element_located((By.CLASS_NAME, "button_to")))
driver.find_element(By.CLASS_NAME, "button_to").click()
driver.quit()

