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

import static com.kms.katalon.core.testdata.TestDataFactory.findTestData

//def setUp() {
//	WebUI.openBrowser(GlobalVariable.webUrl)
//	WebUI.maximizeWindow()
//}

'Call test cases Login and show profile screen'
WebUI.callTestCase(findTestCase('Test Cases/KatOne/Login-Logout-SingUp One User/KatOne Users Login'), null)

'Number of org exits in on my profile section yours org list screen'
String js = """ var countA = [...document.getElementsByClassName("MuiGrid-root MuiGrid-container MuiGrid-justify-xs-space-between")[0].children].filter(item=>item.nodeName === 'DIV').length; return countA; """
countNumOrg = WebUI.executeJavaScript(js, null)
println(countNumOrg)

'click yours organizaiton list on profile screen'
WebUI.click(findTestObject('KatOne/Page_Katalon One/My profile/a_Your organizations', [('RD') : katOne.Random.RandomNum5(countNumOrg)]))


'Click link menu Billing Management'
WebUI.click(findTestObject('Object Repository/KatOne/Page_Katalon One/Menu/a_Billing Management'))

TestData data = findTestData('DataBillManagementExcelFile')

for(def index : (0..data.getRowNumbers() - 1)) {

'Call test cases Billing Information'
//WebUI.callTestCase(findTestCase('Test Cases/KatOne/Common Test Cases/Billing Information'), [('var_name') : var_name, ('var_email') : var_email
//        , ('var_country') : var_country, ('var_state') : var_state, ('var_city') : var_city, ('var_address1') : var_address1
//        , ('var_address2') : var_address2, ('var_postalcode') : var_postalcode, ('var_vatgsc') : var_vatgsc], FailureHandling.STOP_ON_FAILURE)
println(index)
index = index + 1
WebUI.callTestCase(findTestCase('Test Cases/KatOne/Common Test Cases/Billing Information'), [('var_stt') : data.getObjectValue('STT', index),('var_name') : data.getObjectValue('fullBusinessName', index), ('var_email') : data.getObjectValue('CCEmail', index)
	, ('var_country') : data.getObjectValue('Country', index), ('var_state') : data.getObjectValue('State', index), ('var_city') : data.getObjectValue('City', index), ('var_address1') : data.getObjectValue('Address Line 1', index)
	, ('var_address2') : data.getObjectValue('Address Line 2', index), ('var_postalcode') : data.getObjectValue('Postal Code', index), ('var_vatgsc') : data.getObjectValue('VAT/GSC ID', index)])


'Get status expected test case result'
switch (data.getObjectValue('expectedResultTC', index)) {
	
	case 'updated_successful':
	'Verify when expected test case with updated is successful'
	break
	
    case 'missingfield_fullname':
        'Verify when expected test case with fullname is empty'
		def errorMess = WebUI.getText(findTestObject('Object Repository/KatOne/Page_Katalon One/Billing Management/Error Field/p_Full Business Name is required'),FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyEqual(errorMess.contains('Full Business Name is required'), true, FailureHandling.CONTINUE_ON_FAILURE)
        break
		
	case 'missingfield_email':
		'Verify when expected test case with email is empty'
		def errorMess = WebUI.getText(findTestObject('Object Repository/KatOne/Page_Katalon One/Billing Management/Error Field/p_Email is required'),FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyEqual(errorMess.contains('Email is required'), true, FailureHandling.CONTINUE_ON_FAILURE)
		break
		
	case 'missingfield_country':
		'Verify when expected test case with country is empty'
		def errorMess = WebUI.getText(findTestObject('Object Repository/KatOne/Page_Katalon One/Billing Management/Error Field/p_Country is required'),FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyEqual(errorMess.contains('Country is required'), true, FailureHandling.CONTINUE_ON_FAILURE)
		break
		
	case 'missingfield_state':
		'Verify when expected test case with state is empty'
		def errorMess = WebUI.getText(findTestObject('Object Repository/KatOne/Page_Katalon One/Billing Management/Error Field/p_State is required'),FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyEqual(errorMess.contains('State is required'), true, FailureHandling.CONTINUE_ON_FAILURE)
		break
		
	case 'missingfield_city':
		'Verify when expected test case with city is empty'
		def errorMess = WebUI.getText(findTestObject('Object Repository/KatOne/Page_Katalon One/Billing Management/Error Field/p_City is required'),FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyEqual(errorMess.contains('City is required'), true, FailureHandling.CONTINUE_ON_FAILURE)
		break
		
	case 'missingfield_address1':
		'Verify when expected test case with address1 is empty'
		def errorMess = WebUI.getText(findTestObject('Object Repository/KatOne/Page_Katalon One/Billing Management/Error Field/p_Address Line 1 is required'),FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyEqual(errorMess.contains('Address Line 1 is required'), true, FailureHandling.CONTINUE_ON_FAILURE)
		break
		
	case 'missingfield_postalcode':
		'Verify when expected test case with postal code is empty'
		def errorMess = WebUI.getText(findTestObject('Object Repository/KatOne/Page_Katalon One/Billing Management/Error Field/p_Postal Code is required'),FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyEqual(errorMess.contains('Postal Code is required'), true, FailureHandling.CONTINUE_ON_FAILURE)
		break
		
	case 'missingfield_vat/gsc':
		'Verify when expected test case with vat/gsc id is empty'
		def errorMess = WebUI.getText(findTestObject('Object Repository/KatOne/Page_Katalon One/Billing Management/Error Field/p_VATGSC ID is required'),FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyEqual(errorMess.contains('VAT/GSC ID is required'), true, FailureHandling.CONTINUE_ON_FAILURE)
		break
		
	case 'error_formatcountry':
		'Verify when expected test case login fail with country is not correct format'
		def errorMess = WebUI.getText(findTestObject('Object Repository/KatOne/Page_Katalon One/Billing Management/Error Field/p_Country must be letters, space, or ,'),FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyEqual(errorMess.contains('Country must be letters, space, or'), true, FailureHandling.CONTINUE_ON_FAILURE)
		break
		
	case 'error_formatstate':
		'Verify when expected test case login fail with state is not correct format'
		def errorMess = WebUI.getText(findTestObject('Object Repository/KatOne/Page_Katalon One/Billing Management/Error Field/p_State must be letters, space, or ,.()-'),FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyEqual(errorMess.contains('State must be letters, space, or'), true, FailureHandling.CONTINUE_ON_FAILURE)
		break
		
	case 'error_formatcity':
		'Verify when expected test case login fail with city is not correct format'
		def errorMess = WebUI.getText(findTestObject('Object Repository/KatOne/Page_Katalon One/Billing Management/Error Field/p_City must be letters, space, or ,.()-'),FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyEqual(errorMess.contains('City must be letters, space, or'), true, FailureHandling.CONTINUE_ON_FAILURE)
		break
		
	case 'error_formataddress1':
		'Verify when expected test case login fail with address1 is not correct format'
		def errorMess = WebUI.getText(findTestObject('Object Repository/KatOne/Page_Katalon One/Billing Management/Error Field/p_Address1 line must be letters, numbers, space, or .,'),FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyEqual(errorMess.contains('Address line must be letters, numbers, space, or'), true, FailureHandling.CONTINUE_ON_FAILURE)
		break
		
	case 'error_formataddress2':
		'Verify when expected test case login fail with address2 is not correct format'
		def errorMess = WebUI.getText(findTestObject('Object Repository/KatOne/Page_Katalon One/Billing Management/Error Field/p_Address2 line must be letters, numbers, space, or .,'),FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyEqual(errorMess.contains('Address line must be letters, numbers, space, or'), true, FailureHandling.CONTINUE_ON_FAILURE)
		break
		
	case 'error_formatpostalcode':
		'Verify when expected test case login fail with postal code is not correct format'
		def errorMess = WebUI.getText(findTestObject('Object Repository/KatOne/Page_Katalon One/Billing Management/Error Field/p_Postal code must be letters, numbers, space'), FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyEqual(errorMess.contains('Postal code must be letters, numbers, space'), true, FailureHandling.CONTINUE_ON_FAILURE)
		break
		
	case 'error_formatvat/gsc':
		'Verify when expected test case login fail with vat/gsc id is not correct format'
		def errorMess = WebUI.getText(findTestObject('Object Repository/KatOne/Page_Katalon One/Billing Management/Error Field/p_VATGSC ID must be letters, numbers, space, or ,-'), FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyEqual(errorMess.contains('VAT/GSC ID must be letters, numbers, space, or'), true, FailureHandling.CONTINUE_ON_FAILURE)
		break
	
    case 'incorrect_emailformat':
        'Verify when expected test case login fail with password is not correct'
        def errorMess = WebUI.getText(findTestObject('Object Repository/KatOne/Page_Katalon One/Billing Management/Error Field/p_Email is invalid'), FailureHandling.CONTINUE_ON_FAILURE)
        WebUI.verifyEqual(errorMess.contains('Email is invalid'), true, FailureHandling.CONTINUE_ON_FAILURE)
        break
		
	}

	'Close if var_stt = row number - 1'
	if(index == 54)
		{
			WebUI.closeBrowser()
		}
	else { WebUI.refresh()}
}



