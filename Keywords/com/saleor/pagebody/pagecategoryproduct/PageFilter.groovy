package com.saleor.pagebody.pagecategoryproduct

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

public class PageFilter {
	TestObject sortingDropdown = findTestObject('UI/WEB SALEOR/Page Home/Body/Page Category Product/Filter/Sorting_Dropdown')
	TestObject buttonLoadmoreProducts = findTestObject('UI/WEB SALEOR/Page Home/Body/Page Category Product/List Product/btn_LoadMoreProducts')
	TestObject btn_Filter = findTestObject('UI/WEB SALEOR/Page Home/Body/Page Category Product/Filter/btn_Filter')



	@Keyword
	public void clickSortingDropdown () {
		WebUI.waitForElementVisible(sortingDropdown, GlobalVariable.G_Timeout_Small)
		WebUI.click(sortingDropdown)
	}

	@Keyword
	public void clickMenuListFilter (int index) {
		WebUI.click(findTestObject('UI/WEB SALEOR/Page Home/Body/Page Category Product/Filter/Sub Sorting Dropdown/menu_ListFilter',['index':index]))
	}

	@Keyword
	public void clickFilter () {
		WebUI.waitForElementVisible(btn_Filter, GlobalVariable.G_Timeout_Medium)
		WebUI.click(btn_Filter)
	}
}
