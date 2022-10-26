import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

'Click button Edit'
WebUI.waitForElementClickable(findTestObject('KatOne/Page_Katalon One/Billing Management/button_Edit'), 10)
WebUI.click(findTestObject('KatOne/Page_Katalon One/Billing Management/button_Edit'))

'Typing bussiness name'
WebUI.sendKeys(findTestObject('KatOne/Page_Katalon One/Billing Management/input_Full Business Name_name'), var_name)

'Typing email'
WebUI.sendKeys(findTestObject('KatOne/Page_Katalon One/Billing Management/input_CC Email_email'), var_email)

'Typing country'
WebUI.sendKeys(findTestObject('KatOne/Page_Katalon One/Billing Management/input_Country_country'), var_country)

'Typing state'
WebUI.sendKeys(findTestObject('KatOne/Page_Katalon One/Billing Management/input_State_state'), var_state)

'Typing city'
WebUI.sendKeys(findTestObject('KatOne/Page_Katalon One/Billing Management/input_City_city'), var_city)

'Typing address 1'
WebUI.sendKeys(findTestObject('KatOne/Page_Katalon One/Billing Management/input_Address Line 1_address1'), var_address1)

'Typing address 2'
WebUI.sendKeys(findTestObject('KatOne/Page_Katalon One/Billing Management/input_Address Line 2_address2'), var_address2)

'Typing postal code'
WebUI.sendKeys(findTestObject('KatOne/Page_Katalon One/Billing Management/input_Postal Code_postalCode'), var_postalcode)

'Typing VATGSC ID'
WebUI.sendKeys(findTestObject('KatOne/Page_Katalon One/Billing Management/input_VATGSC ID_vatId'), var_vatgsc)

'waiting for button Save visible'
WebUI.waitForElementVisible(findTestObject('KatOne/Page_Katalon One/Billing Management/button_Save'), 5)

'Click button Save'
WebUI.click(findTestObject('KatOne/Page_Katalon One/Billing Management/button_Save'),FailureHandling.CONTINUE_ON_FAILURE)

