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

'Login user load until open Profile screen'
katOne.Login.loginUsersWithGlobalVariable()

'Navigate to Url Org List'
WebUI.navigateToUrl(GlobalVariable.webUrl.toString() + '/organizations')

'Click any org in list Org'
WebUI.click(findTestObject('KatOne/Page_Katalon One/Organization List/ul_AllOrganizations',[('IDX'): katOne.Random.RandomNum10(10)]))


'Click org dropdownlist on top left conner'
WebUI.click(findTestObject('KatOne/Page_Katalon One/Header/div_Org'))

'Click button Create Org button on dropdownlist'
WebUI.click(findTestObject('KatOne/Page_Katalon One/Header/span_Create Org on Dropdownlist'))

'Input Organization Name'
katOne.Random.RandomOrgName('Object Repository/KatOne/Page_Katalon One/input_Organization Name_name')

'click button create organization'
WebUI.click(findTestObject('KatOne/Page_Katalon One/Create New Organization (AL)/button_Create'))