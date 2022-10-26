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

WebUI.openBrowser(GlobalVariable.webUrl)

WebUI.maximizeWindow()

WebUI.click(findTestObject('KatOne/Page_Katalon One/Login/a_Forgot your password'))

WebUI.setText(findTestObject('KatOne/Page_Katalon One/Login/Reset password/input_Email_email'), 'lotusgenshin93@gmail.com')

WebUI.click(findTestObject('KatOne/Page_Katalon One/Login/Reset password/div_reCAPTCHA_recaptcha-checkbox-border'))

WebUI.delay(10)

WebUI.click(findTestObject('KatOne/Page_Katalon One/Login/Reset password/button_Reset Password'))

CustomKeywords.'com.testwithhari.katalon.plugins.Gmail.readLatestEMailBodyContent'(GlobalVariable.username, GlobalVariable.password, 
    GlobalVariable.username)

