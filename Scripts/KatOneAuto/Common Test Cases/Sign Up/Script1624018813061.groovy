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

//'click SignUp'
//WebUI.click(findTestObject('Object Repository/KatOne/Page_Katalon One/Login/a_Sign Up'))

'Fill full name'
WebUI.sendKeys(findTestObject('KatOne/Page_Katalon One/Page_Sign up/input_A valid email is required for verification before using Katalon._user_login'), var_fullname)

'Fill email'
WebUI.sendKeys(findTestObject('KatOne/Page_Katalon One/Page_Sign up/input_Fill in First - Last name_user_email'), var_email)


'Fill password'
WebUI.sendKeys(findTestObject('KatOne/Page_Katalon One/Page_Sign up/input_Valid email is required to activate products_user_pass'), var_password)
		
'Click get started'
WebUI.click(findTestObject('KatOne/Page_Katalon One/Page_Sign up/input_Terms of Use_signup-btn'))

'wait For Page Load and get url aftr click set started'
if (var_statusExpectedResult.toString() == 'signup_successfully') {
	WebUI.delay(5)
	GlobalVariable.urlAfterChangePage = WebUI.getUrl()
}
else{WebUI.waitForPageLoad(5)}



