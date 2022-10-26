package katOne

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class Login {

	@Keyword
	def static void loginUsers(String webUrl, String username, String password) {
		WebUI.openBrowser(webUrl)
		WebUI.maximizeWindow()
		WebUI.waitForElementVisible(findTestObject('KatOne/Page_Katalon One/Login/input_Email_email'), 0)
		WebUI.sendKeys(findTestObject('KatOne/Page_Katalon One/Login/input_Email_email'), username)
		WebUI.sendKeys(findTestObject('KatOne/Page_Katalon One/Login/input_Password_password'), password)
		WebUI.click(findTestObject('KatOne/Page_Katalon One/Login/span_Sign In'))
		WebUI.waitForElementVisible(findTestObject('KatOne/Page_Katalon One/Header/img_My profile_MuiAvatar-img'), 10)
	}


	@Keyword
	def static void loginUsersWithGlobalVariable() {
		loginUsers(GlobalVariable.webUrl, GlobalVariable.username, GlobalVariable.password)
	}


	@Keyword
	def static void loginWithGoogleAllReadyLogin(String webUrl) {
		WebUI.openBrowser('')
		WebUI.maximizeWindow()
		WebUI.navigateToUrl(webUrl)
		WebUI.click(findTestObject('Object Repository/KatOne/Page_Katalon One/Login/button_Sign In With Google'))
		WebUI.delay(1)
	}

	@Keyword
	def static void forgotPassword(String webUrl) {
		WebUI.openBrowser('')
		WebUI.maximizeWindow()
		WebUI.navigateToUrl(webUrl)
		WebUI.click(findTestObject('Object Repository/KatOne/Page_Katalon One/Login/a_Forgot your password'))
		WebUI.delay(1)
	}

	@Keyword
	def static void signUpSuccessfully(String webUrl, String fullname, String emailSU, String passwordSU) {
		WebUI.openBrowser('')
		WebUI.maximizeWindow()
		WebUI.navigateToUrl(webUrl)
		//WebUI.waitForPageLoad(GlobalVariable.waitPresentTimeout)
		WebUI.click(findTestObject('Object Repository/KatOne/Page_Katalon One/Login/a_Sign Up'))
		GlobalVariable.RD_NameOrg = WebUI.executeJavaScript('return [\'Đặng Tuấn Anh\', \'Mạc Trung Đức\', \'Nguyễn Thị Ngân Hà\',\'Đàm Yến Nhi\',\'Đinh Thùy Linh\',\'Ngô Gia Minh\'][Math.floor(Math.random() * 6)]',
				[])
		println(GlobalVariable.RD_NameOrg)
		fullname = GlobalVariable.RD_NameOrg.toString()
		WebUI.sendKeys(findTestObject('KatOne/Page_Katalon One/Page_Sign up/input_A valid email is required for verification before using Katalon._user_login'), fullname)
		GlobalVariable.RD_Num = WebUI.executeJavaScript('return Math.floor(Math.random()*100)+1', [])
		emailSU = "User" + GlobalVariable.RD_Num + "@gmail.com"
		WebUI.sendKeys(findTestObject('KatOne/Page_Katalon One/Page_Sign up/input_Fill in First - Last name_user_email'), emailSU)
		WebUI.sendKeys(findTestObject('KatOne/Page_Katalon One/Page_Sign up/input_Valid email is required to activate products_user_pass'), passwordSU)
		WebUI.click(findTestObject('KatOne/Page_Katalon One/Page_Sign up/input_Terms of Use_signup-btn'))
		WebUI.delay(1)
	}
}
