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

'Login until open profile screen'
katOne.Login.loginUsersWithGlobalVariable()

'Number of org exits in on my profile section yours org list screen'
String js = """ var countA = [...document.getElementsByClassName("MuiGrid-root MuiGrid-container MuiGrid-justify-xs-space-between")[0].children].filter(item=>item.nodeName === 'DIV').length; return countA; """
countNumOrg = WebUI.executeJavaScript(js, null)
println(countNumOrg)

switch(countNumOrg)
{
	case 0:
	'Nav url to create org screen'
	WebUI.navigateToUrl('https://my2.staging.katalon.com/create-organizaiton')
	
	'Input Organization Name'
	katOne.Random.RandomOrgName('Object Repository/KatOne/Page_Katalon One/Create New Organization (AL)/input_Organization Name_name')
	
	'click button create organization'
	WebUI.click(findTestObject('KatOne/Page_Katalon One/Create New Organization (AL)/button_Create'))
	
	'click menu organization management screen'
	WebUI.click(findTestObject('Object Repository/KatOne/Page_Katalon One/Menu/a_Organization Management'))
	break
	
	default:
	'click yours organizaiton list on profile screen'
	lineRow = katOne.Random.RandomNum10(countNumOrg)
	WebUI.click(findTestObject('KatOne/Page_Katalon One/My profile/a_Your organizations', [('RD') : lineRow]))
	
}

'click link Upload file and fetch url on computer file'
katOne.ExtendFunc.uploadFile(findTestObject('KatOne/Page_Katalon One/Organization Management/a_Upload Image'), 'D:\\Project\\Test Common Doc\\Image Định dạnh\\ABC.jpg')

'click Save Update button'
WebUI.click(findTestObject('Object Repository/KatOne/Page_Katalon One/Organization Management/button_Save Update (Info)'))

WebUI.delay(5)
WebUI.closeBrowser()