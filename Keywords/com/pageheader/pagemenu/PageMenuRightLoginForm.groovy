package com.pageheader.pagemenu
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

import internal.GlobalVariable as GlobalVariable

public class PageMenuRightLoginForm {
	TestObject svgIconUser = findTestObject('UI/WEB SALEOR/Page Home/Header/Menu/Menu Right/svg_IconUser')
	TestObject inputEmail = findTestObject('UI/WEB SALEOR/Page Home/Header/Menu/Menu Right/Login Form/Input_Email')
	TestObject inputPassWord = findTestObject('UI/WEB SALEOR/Page Home/Header/Menu/Menu Right/Login Form/Input_Password')
	TestObject buttonSignIn = findTestObject('UI/WEB SALEOR/Page Home/Header/Menu/Menu Right/Login Form/btn_SignIn')
	TestObject iconUserButton = findTestObject('UI/WEB SALEOR/Page Home/Header/Menu/Menu Right/icon_User')
	TestObject menuOrderHistory = findTestObject('UI/WEB SALEOR/Page Home/Header/Menu/Menu Right/Menu Dropdown/main_MenuDropdown')

	//msgInvalidPassword for Verify LogIn Failed With PassWord Wrong
	TestObject msgInvalidPassword = findTestObject('UI/WEB SALEOR/Page Home/Header/Menu/Menu Right/Login Form/lbl_InvalidLogin')

	//msgLoginSuccessfull for verify Login succesfull
	TestObject msgLoginSuccessfull = findTestObject('UI/WEB SALEOR/Page Home/Header/Menu/Menu Right/Login Form/msg_SuccessfullLogIn')



	@Keyword
	public void loginToSaleor (String Email,String PassWord) {

		WebUI.waitForPageLoad(GlobalVariable.G_Timeout_Small)
		WebUI.click(svgIconUser)
		//WebUI.clearText(findTestObject('Object Repository/ObjectLogin/LoginSuccessfull/Input_UserName'), GlobalVariable.G_Timeout_Small)
		WebUI.waitForElementVisible(inputEmail, GlobalVariable.G_Timeout_Small)
		WebUI.setText(inputEmail,Email)
		//WebUI.clearText(findTestObject('Object Repository/ObjectLogin/LoginSuccessfull/Input_Password'), GlobalVariable.G_Timeout_Small)
		WebUI.setText(inputPassWord,PassWord)
		WebUI.click(buttonSignIn)
	}

	@Keyword
	public void selectMainMenu (String nameMenuOrderHistory) {

		//WebUI.waitForPageLoad(GlobalVariable.G_Timeout_Small)
		WebUI.waitForElementPresent(iconUserButton,GlobalVariable.G_Timeout_Small)
		WebUI.mouseOver(iconUserButton)
		//WebUI.delay(2)
		if(WebUI.waitForElementVisible(findTestObject('UI/WEB SALEOR/Page Home/Header/Menu/Menu Right/Menu Dropdown/main_MenuDropdown',['Name':nameMenuOrderHistory]), GlobalVariable.G_Timeout_Small).equals(true))
		{
			System.out.println("ElementClickable")
		}
		else
		{
			System.out.println("Failed")
		}
		//WebUI.waitForElementVisible(findTestObject('UI/WEB SALEOR/Page Home/Header/Menu/Menu Right/Menu Dropdown/main_MenuDropdown',['Name':nameMenuOrderHistory]), GlobalVariable.G_Timeout_Small)
		WebUI.click(findTestObject('UI/WEB SALEOR/Page Home/Header/Menu/Menu Right/Menu Dropdown/main_MenuDropdown',['Name':nameMenuOrderHistory]))

	}

	@Keyword
	public void validate_Successfull_Login_Msg () {
		WebUI.waitForElementVisible(msgLoginSuccessfull, GlobalVariable.G_Timeout_Small)
		String msgSuccessfullLogin = WebUI.getText(msgLoginSuccessfull)
		WebUI.verifyEqual("YOU ARE NOW LOGGED IN",msgSuccessfullLogin)
	}

	@Keyword
	public void validate_Fail_Login_Msg () {
		WebUI.waitForElementVisible(msgInvalidPassword, GlobalVariable.G_Timeout_Small)
		WebUI.verifyElementVisible(msgInvalidPassword)
	}

}
