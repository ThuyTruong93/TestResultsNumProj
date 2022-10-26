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
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

@com.kms.katalon.core.annotation.SetUp
def setUp() {
	WebUI.openBrowser(var_url)
	WebUI.maximizeWindow()
}

'call login function'
WebUI.callTestCase(findTestCase('KatOneAuto/Common Test Cases/Login'), [('var_username') : var_username, ('var_password') : var_password, ('var_statusExpectedResult'): var_statusExpectedResult], FailureHandling.STOP_ON_FAILURE)

'Get status expected test case result'
switch (var_statusExpectedResult.toString())
{
	case 'login_successfully':
	'Verify when expected test case login successfully'
	url = GlobalVariable.urlAfterChangePage
	WebUI.verifyMatch(url,var_url + '/profile',false)
	break
	
	case 'field_missing':
	'Verify when expected test case login with username or password is empty'
    break;
	
	case 'incorrect_account':
	'Verify when expected test case login fail with password is not correct'
	def errorMess = WebUI.getText(findTestObject('Object Repository/KatOne/Page_Katalon One/Login/span_Authentication failed. Attempt to log in again or contact supportkatalon.com'))
	WebUI.verifyElementText(findTestObject('Object Repository/KatOne/Page_Katalon One/Login/span_Authentication failed. Attempt to log in again or contact supportkatalon.com'), errorMess, FailureHandling.STOP_ON_FAILURE)
	break;
}

@com.kms.katalon.core.annotation.TearDown
def tearDown()
{
	WebUI.closeBrowser()
}

