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

public class PageMenuLeft {


	@Keyword
	public void clickNavDropdown (String navDropdownMainmenu)
	{
		WebUI.waitForElementPresent(findTestObject('UI/WEB SALEOR/Page Home/Header/Menu/Menu Left/Subnav Dropdown/SubNav_Dropdown',['Name':navDropdownMainmenu]), GlobalVariable.G_Timeout_Small)
		WebUI.click(findTestObject('UI/WEB SALEOR/Page Home/Header/Menu/Menu Left/Nav_Dropdown',['Name':navDropdownMainmenu]))
	}

	@Keyword
	public void hoverMouseToNavDropdown (String navDropdownMainmenu,String subNavDropdownMainmenu)
	{
		WebUI.waitForPageLoad(GlobalVariable.G_Timeout_Small)
		WebUI.waitForElementPresent(findTestObject('UI/WEB SALEOR/Page Home/Header/Menu/Menu Left/Nav_Dropdown',['Name':navDropdownMainmenu]), GlobalVariable.G_Timeout_Small)
		WebUI.mouseOver(findTestObject('UI/WEB SALEOR/Page Home/Header/Menu/Menu Left/Nav_Dropdown',['Name':navDropdownMainmenu]))
		WebUI.waitForElementClickable(findTestObject('UI/WEB SALEOR/Page Home/Header/Menu/Menu Left/Subnav Dropdown/SubNav_Dropdown',['Name':subNavDropdownMainmenu]), GlobalVariable.G_Timeout_Small)
		WebUI.click(findTestObject('UI/WEB SALEOR/Page Home/Header/Menu/Menu Left/Subnav Dropdown/SubNav_Dropdown',['Name':subNavDropdownMainmenu]))
	}
}
