package com.saleor.pagebody.pagecategoryproduct

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

public class PageListProduct {

	TestObject btn_LoadmoreProducts = findTestObject('UI/WEB SALEOR/Page Home/Body/Page Category Product/List Product/btn_LoadMoreProducts')
	TestObject lst_NameProduct = findTestObject('UI/WEB SALEOR/Page Home/Body/Page Category Product/List Product/lst_NameProduct')
	TestObject span_productsFoundCounter = findTestObject('UI/WEB SALEOR/Page Home/Body/Page Category Product/Filter/span_AmountProducts')
	TestObject lst_Products = findTestObject('Object Repository/UI/WEB SALEOR/Page Home/Body/Page Category Product/List Product/lst_Products')

	String listNameProducts = "//div[@data-test='productList']//*[@data-test='productTile']"
	String listPriceProducts = "//div[@data-test='productList']//span"
	@Keyword
	public void clickButtonLoadmoreProducts () {
		while(WebUI.waitForElementPresent(btn_LoadmoreProducts, GlobalVariable.G_Timeout_Small)) {
			WebUI.click(btn_LoadmoreProducts)
			WebUI.delay(1)
		}
	}

	@Keyword
	public void verifySortByPriceLowHigh () {
		List<Integer> priceProduct = new ArrayList<>()
		WebDriver driver= DriverFactory.getWebDriver()
		List<WebElement> listPriceProduct = driver.findElements(By.xpath(listPriceProducts))
		for (int i =0;i<listPriceProduct.size();i++) {
			priceProduct.add(Integer.parseInt(listPriceProduct.get(i).getText().replaceAll("[^A-Za-z0-9()\\[\\]]", "")))
		}
		//IsGrow is assign true when the price of the product has been correctly arranged
		boolean isGrow = isGrow(priceProduct)
		System.out.println(isGrow)
		WebUI.verifyEqual(true, isGrow)
	}

	@Keyword
	public void verifyProductsFound (int amountProduct) {
		List<Integer> listPriceProduct = new ArrayList<>();
		WebDriver driver= DriverFactory.getWebDriver()
		int productsFoundCounter = Integer.parseInt(WebUI.getText(span_productsFoundCounter).substring(16))
		WebUI.verifyEqual(amountProduct,productsFoundCounter)
	}


	@Keyword
	public void verifySortByFlavor (String nameProduct) {
		int checkIfContainNameProduct = 0;
		WebDriver driver= DriverFactory.getWebDriver()
		WebUI.waitForElementVisible(lst_NameProduct, GlobalVariable.G_Timeout_Medium)
		List<WebElement> listNameProduct = driver.findElements(By.xpath(listNameProducts))
		for (int i =0;i<listNameProduct.size();i++) {

			if(listNameProduct.get(i).getText().contains(nameProduct)) {

				checkIfContainNameProduct = 1;
			}
			else
				checkIfContainNameProduct = 0;
		}
		WebUI.verifyEqual(1, checkIfContainNameProduct)
	}

	@Keyword
	public void verifySortByNameIncreasing () {
		List<String> listNameProduct = new ArrayList<>();
		WebDriver driver= DriverFactory.getWebDriver()
		List<WebElement> list_NameProduct = driver.findElements(By.xpath(listNameProducts))
		for (int i =0;i<list_NameProduct.size();i++) {
			listNameProduct.add(list_NameProduct.get(i).getText())
		}
		//IsSorted is assign true when the name of the products has been correctly arranged
		WebUI.verifyEqual(true, isSorted(listNameProduct))
	}

	@Keyword
	public boolean isGrow (List<Integer> listPriceProduct) {
		for(int i = 0; i < listPriceProduct.size()-1; i++) {
			if (listPriceProduct[i] <= listPriceProduct[i+1]) {
			}
			else {
				return false
			}
		}
		return true
	}

	@Keyword
	public boolean isSorted(List<String> listOfNameProduct) {
		if (listOfNameProduct.size() == 1) {
			return true;
		}
		Iterator<String> iter = listOfNameProduct.iterator();
		String current, previous = iter.next();
		while (iter.hasNext()) {
			current = iter.next();
			if (previous.compareTo(current) > 0) {
				//previous is larger
				return false;
			}
			else if (previous.compareTo(current) < 0) {
				//previous is smaller
				previous = current;
			}
			else {
				//previous is equal to current
				previous = current;
			}
		}
		return true;
	}

	@Keyword
	public void listProducts (String name) {
		WebDriver driver= DriverFactory.getWebDriver()
		//Example: it have 6 products, Select 1 product according to Name
		WebUI.waitForElementVisible(lst_Products, GlobalVariable.G_Timeout_Small)
		List<WebElement> list_NameProduct = driver.findElements(By.xpath(listNameProducts))
		for (int i =0;i<list_NameProduct.size();i++) {
			if(list_NameProduct.get(i).getText().equalsIgnoreCase(name)) {
				list_NameProduct.get(i).click()
				break
			}
		}
	}

	@Keyword
	public int getAmountProducts ()
	{
		WebDriver driver= DriverFactory.getWebDriver()
		List<WebElement> list_NameProduct = driver.findElements(By.xpath(listNameProducts))
		return list_NameProduct.size()
	}
}
