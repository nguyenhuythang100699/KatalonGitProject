package com.pagebody.pageadmin

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

public class LoginPage {
	TestObject inputEmail = findTestObject('UI/WEB SALEOR/Page Home/Body/Page Admin Login/input_Email')
	TestObject inputPassWord = findTestObject('UI/WEB SALEOR/Page Home/Body/Page Admin Login/input_Password')
	TestObject buttonSignIn = findTestObject('UI/WEB SALEOR/Page Home/Body/Page Admin Login/btn_Login')


	@Keyword
	public void loginToAdmin (String Email,String PassWord) {
		WebUI.delay(5)
		//WebUI.waitForPageLoad(GlobalVariable.G_Timeout_Small)
		//WebUI.click(svgIconUser)
		//		WebUI.clearText(inputEmail)
		//		//WebUI.waitForElementVisible(inputEmail, GlobalVariable.G_Timeout_Small)
		//		WebUI.setText(inputEmail,Email)
		//		WebUI.clearText(inputPassWord)
		//		WebUI.setText(inputPassWord,PassWord)
		//WebUI.waitForElementPresent(buttonSignIn,GlobalVariable.G_Timeout_Small)
		WebUI.click(buttonSignIn)
	}
}
