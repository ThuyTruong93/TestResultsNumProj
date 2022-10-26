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

'Fill user name'
WebUI.sendKeys(findTestObject('KatOne/Page_Katalon One/Login/input_Email_email'), var_username)

'Fill password'
WebUI.sendKeys(findTestObject('KatOne/Page_Katalon One/Login/input_Password_password'), var_password)

'Click Sign In'
WebUI.click(findTestObject('Object Repository/KatOne/Page_Katalon One/Login/button_Sign In'))

'Get url after click Sign In'
if (var_statusExpectedResult.toString() == 'login_successfully') {
	WebUI.delay(10)
	GlobalVariable.urlAfterChangePage = WebUI.getUrl()
}
else{WebUI.waitForPageLoad(5)}


