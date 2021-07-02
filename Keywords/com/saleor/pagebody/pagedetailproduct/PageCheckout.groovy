package com.saleor.pagebody.pagedetailproduct

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.support.ui.ExpectedConditions
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable


public class PageCheckout {
	TestObject gridCart = findTestObject('UI/WEB SALEOR/Page Home/Body/Page Detail Product/Checkout/grid_Cart')
	TestObject iconCloseCart = findTestObject('UI/WEB SALEOR/Page Home/Body/Page Detail Product/Checkout/icon_CloseCart')
	TestObject iconRubishBin = findTestObject('UI/WEB SALEOR/Page Home/Body/Page Detail Product/Checkout/Icon_RubishBin')
	TestObject msgCartEmpty = findTestObject('UI/WEB SALEOR/Page Home/Body/Page Detail Product/Checkout/msg_CartEmpty')

	String listRubishBin = "//div[@class='cart__list__item__details__delete-icon']"

	@Keyword
	public void clickIconCloseCart () {
		//WebUI.waitForElementVisible(gridCart,GlobalVariable.G_Timeout_Small)
		WebUI.waitForElementVisible(iconCloseCart,GlobalVariable.G_Timeout_Small)
		WebUI.click(iconCloseCart)
	}

	@Keyword
	public void verifyCartEmpty () {
		WebDriver driver= DriverFactory.getWebDriver()
		WebDriverWait wait = new WebDriverWait(driver,GlobalVariable.G_Timeout_Small)
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='cart__list__item__details__delete-icon']")))
		List<WebElement> listRubishBin = driver.findElements(By.xpath(listRubishBin))
		for (int i=listRubishBin.size()-1;i>=0;i--) {
			listRubishBin.get(i).click()
		}
		String messageCartEmpty = WebUI.getText(msgCartEmpty)
		WebUI.verifyEqual('YOUR BAG IS EMPTY', messageCartEmpty)
	}
}
