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

'Call test cases create org after login'
WebUI.callTestCase(findTestCase('KatOne/Happy Cases/Organization Managment/Create Org successfully after login successfully'), null, FailureHandling.STOP_ON_FAILURE)

'click menu Org management'
WebUI.click(findTestObject('Object Repository/KatOne/Page_Katalon One/Menu/a_Organization Management'))

'get Org Name current'
//OrgName = WebUI.getAttribute(findTestObject('KatOne/Page_Katalon One/Create New Organization (AL)/input_Organization Name_name'), "value")  
OrgName = WebUI.getText(findTestObject('KatOne/Page_Katalon One/Header/div_Org'))

'click button delete org on Org Managament screen'
WebUI.click(findTestObject('KatOne/Page_Katalon One/Organization Management/span_I understand the consequences, delete this organization'))

'input name org to delete org'
WebUI.sendKeys(findTestObject('KatOne/Page_Katalon One/Organization Management/input_Please type Org Name to delete'), OrgName)

'click button delete org on popup confirm'
WebUI.click(findTestObject('KatOne/Page_Katalon One/Organization Management/button_Delete this organization'))




