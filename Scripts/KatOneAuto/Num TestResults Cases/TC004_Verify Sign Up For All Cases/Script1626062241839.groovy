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

@com.kms.katalon.core.annotation.SetUp
def Setup() {
	WebUI.openBrowser('https://staging.katalon.com/sign-up/')
	WebUI.maximizeWindow()
}

'Call login functions'
WebUI.callTestCase(findTestCase('Test Cases/KatOne/Common Test Cases/Sign Up'), [('var_fullname'): var_fullname,('var_email'): var_email, ('var_password'): var_password], FailureHandling.STOP_ON_FAILURE)


'Get status expected test case result'
switch (var_statusExpectedResult.toString())
{
	case 'signup_successful':
	'Verify when expected test case sign up signup_successful'
	url = GlobalVariable.urlAfterChangePage
	WebUI.verifyMatch(url, 'https://staging.katalon.com/sign-up-survey/',false)
	break;
	
	case 'field_missing':
	'Verify when expected test case sign up with username, password or email is empty'
	break;
	
	case 'signup_existed':
	'Verify when expected test case sign up with account is existed in system'
	def errorMess = WebUI.getText(findTestObject('KatOne/Page_Katalon One/Page_Sign up/span_Sorry, this email has been registered'))
	WebUI.verifyEqual(errorMess.contains('Sorry, this email has been registered'), true)
	break;
	
	case 'incorrect_emailformatmess':
	'Verify when expected test case sign up with email is wrong format'
	def errorMess = WebUI.getText(findTestObject('KatOne/Page_Katalon One/Page_Sign up/span_Invalid email. Please try again'))
	WebUI.verifyEqual(errorMess.contains('Invalid email. Please try again'), true)
	break;
	
	case 'incorrect_emailformat':
	'Verify when expected test case sign up with email is wrong format with respond is html'
	
	'Get \'class\' attribute value of make appointment button'
	attribute = WebUI.getAttribute(findTestObject('KatOne/Page_Katalon One/Page_Sign up/input_Fill in First - Last name_user_email'), 'type')
	'Verify if \'class\' attribute value is correct for the button.'
	WebUI.verifyMatch(attribute, 'email', false)
	break;
	
	case 'incorrect_formatpassword':
	'Verify when expected test case sign up with password is wrong format rules'
	def errorMess = WebUI.getText(findTestObject('KatOne/Page_Katalon One/Page_Sign up/span_Password must be 8 characters minimum'))
	WebUI.verifyEqual(errorMess.contains('Password must be 8 characters minimum'), true)
	break;
	
	case 'incorrect_formatname':
	'Verify when expected test case sign up with fullname is wrong format rules'
	def errorMess = WebUI.getText(findTestObject('KatOne/Page_Katalon One/Page_Sign up/span_Your name contains invalid characters. Please enter a different name'))
	WebUI.verifyEqual(errorMess.contains('Your name contains invalid characters. Please enter a different name.'), true)
	break;
}

@com.kms.katalon.core.annotation.TearDown
def Teardown()
{
	WebUI.closeBrowser()
}

