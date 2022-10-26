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

public class Random {

	def static void RandomFullName(String TestObject) {

		GlobalVariable.RD_Ho = WebUI.executeJavaScript('return [\'Đặng\', \'Mạc\', \'Nguyễn\', \'Đàm\', \'Đinh\', \'Ngô\', \'Trương\', \'Trần\', \'Bùi\', \'Đỗ\', \'Hồ\', \'Dương\', \'Lý\', \'Vũ\', \'Võ\', \'Phan\'][Math.floor(Math.random() * 15)]',
				[])
		GlobalVariable.RD_Dem = WebUI.executeJavaScript('return [\'Quốc\', \'Đăng\', \'Phúc\', \'Đức\', \'Ngọc\', \'Văn\', \'Phong\', \'Hữu\', \'Thị\', \'Bảo\', \'Nhược\', \'Diễm\', \'Lý\', \'Đình\', \'Trường\', \'Hồng\'][Math.floor(Math.random() * 15)]',
				[])
		GlobalVariable.RD_Ten = WebUI.executeJavaScript('return [\'Quyền\', \'Quang Phục\', \'Bộ Lĩnh\', \'Hoàn\', \'Công Uẩn\', \'Thủ Độ\', \'Cảnh\', \'Tuấn\', \'Toản\', \'Quý Ly\', \'Nguyên Trừng\', \'Lợi\', \'Tư Thành\', \'Dung\', \'Doanh\', \'Vĩnh San\', \'Thuyết\', \'Tùng\', \'Thắng\', \'Trắc\', \'Trinh\', \'Thiên Hinh\', \'Ngọc Bảo\', \'Xuân Hương\', \'Cẩm Vân\', \'Ánh Viên\', \'Diễm Phúc\', \'Thụy\'][Math.floor(Math.random() * 28)]',
				[])
		GlobalVariable.fullname = GlobalVariable.RD_Ho.toString() + " " + GlobalVariable.RD_Dem.toString() + " " + GlobalVariable.RD_Ten.toString()
		println(GlobalVariable.fullname)
		WebUI.sendKeys(findTestObject(TestObject), GlobalVariable.fullname)
	}

	def static void RandomOrgName(String TestObject) {

		GlobalVariable.RD_Num = WebUI.executeJavaScript('return Math.floor(Math.random()*100)+1', [])
		GlobalVariable.RD_NameOrg = "AutoCNO" + GlobalVariable.RD_Num.toString()
		println(GlobalVariable.RD_NameOrg)
		WebUI.sendKeys(findTestObject(TestObject), GlobalVariable.RD_NameOrg)
	}

	def static int RandomNum100(maxNum) {

		GlobalVariable.RD_Num = WebUI.executeJavaScript('return Math.floor(Math.random()*100)+1', [])
		println(GlobalVariable.RD_Num)
		if (GlobalVariable.RD_Num > maxNum)
		{
			GlobalVariable.RD_Num = maxNum
			return GlobalVariable.RD_Num
		}
		else
			return GlobalVariable.RD_Num 
	}

	def static void RandomDate(String TestObject) {

		GlobalVariable.RD_Date = WebUI.executeJavaScript('return  (Math.floor(Math.random()*17)+11).toString() +"0"+(Math.floor(Math.random()*9)+1).toString() + (Math.floor(Math.random()*20)+1990).toString()',
				[])
		println(GlobalVariable.RD_Date)
		WebUI.sendKeys(findTestObject(TestObject), GlobalVariable.RD_Date)
	}

	def static int RandomNum10(maxNum) {

		GlobalVariable.RD_Num = WebUI.executeJavaScript('return Math.floor(Math.random()*10)+1', [])
		println(GlobalVariable.RD_Num)
		if (GlobalVariable.RD_Num > maxNum)
		{
			GlobalVariable.RD_Num = maxNum
			return GlobalVariable.RD_Num
		}
		else
			return GlobalVariable.RD_Num 
	}

	def static int RandomNum5(maxNum) {

		GlobalVariable.RD_Num = WebUI.executeJavaScript('return Math.floor(Math.random()*5)+1', [])
		println(GlobalVariable.RD_Num)
		if (GlobalVariable.RD_Num > maxNum)
		{
			GlobalVariable.RD_Num = maxNum
			return GlobalVariable.RD_Num
		}
		else
			return GlobalVariable.RD_Num 
	}
	
	def static int RandomNumAll(maxNum) {
		
		GlobalVariable.RD_Num = WebUI.executeJavaScript('return Math.floor(Math.random()*10)+1', [])
		println(GlobalVariable.RD_Num)
		if (GlobalVariable.RD_Num > maxNum)
		{
			String js = """ return Math.floor(Math.random()*'${maxNum-1}')+1 """
			GlobalVariable.RD_Num = WebUI.executeJavaScript(js, [])
			return GlobalVariable.RD_Num
		}
		else
			return GlobalVariable.RD_Num 
	}

}
