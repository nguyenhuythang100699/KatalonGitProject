package com.pagebody.pageorderhistory

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
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import com.saleor.utils.Product
import com.saleor.utils.Order
import com.saleor.utils.ProductsDetail


public class PageOrderHistory {
	TestObject buttonLoadMore = findTestObject('UI/WEB SALEOR/Page Home/Body/Page Order History/List Order History/btn_LoadMore')
	TestObject divIndexNumber = findTestObject('UI/WEB SALEOR/Page Home/Body/Page Order History/List Order History/div_IndexNumber')

	WebDriver driver= DriverFactory.getWebDriver()
	WebDriverWait wait = new WebDriverWait(driver,GlobalVariable.G_Timeout_Small)

	By lst_IndexNumber = By.xpath("//div[contains(@data-test,'orderEntry')]/*[1]");
	By lst_NameProducts = By.xpath("//a[img]//following-sibling::a");
	By lst_PriceProducts = By.xpath("//td[@class='cart-table__thumbnail']/following-sibling::td[1]//span");
	By lst_QuantityProducts = By.xpath("//td[@class='cart-table__thumbnail']/following-sibling::td[contains(@class,'cart-table__quantity-cell')]//*");
	By lst_TotalPriceOfProducts = By.xpath("//tbody//td[last()]//*");

	List<Product> listProduct = new ArrayList<>()

	@Keyword
	public Order findProductsOrderedGreaterThanTwo () {
		Order inforOrder;
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(lst_IndexNumber));
		List<WebElement> lstIndexNumber = driver.findElements(lst_IndexNumber);
		for (int i=0;i<lstIndexNumber.size();i++) {
			String indexNumber = lstIndexNumber.get(i).getText();
			//Concat string when parameter "indexNumber"
			String elementOfProductsOrdered = "//div[@data-test-id='";
			elementOfProductsOrdered = elementOfProductsOrdered.concat(indexNumber);
			elementOfProductsOrdered = elementOfProductsOrdered.concat("']//img");
			List<WebElement> lstAmountProductOrdered = driver.findElements(By.xpath(elementOfProductsOrdered));

			if(lstAmountProductOrdered.size()>1)
			{
				//Get date of order
				String elementOfDateOfOrder = "//div[@data-test-id='";
				elementOfDateOfOrder = elementOfDateOfOrder.concat(indexNumber);
				elementOfDateOfOrder = elementOfDateOfOrder.concat("']//*[span[img]]/following-sibling::div[1]");
				String dateOfOrder  = driver.findElement(By.xpath(elementOfDateOfOrder)).getText();


				//Click Index Number for more details such as Name
				String elementOfIndexNumber = "//div[@data-test-id='";
				elementOfIndexNumber = elementOfIndexNumber.concat(indexNumber);
				elementOfIndexNumber = elementOfIndexNumber.concat("']//div[span[img]]/preceding-sibling::div");
				driver.findElement(By.xpath(elementOfIndexNumber)).click();
				inforOrder = new Order(indexNumber,dateOfOrder);
				return inforOrder;
			}
		}
		return null;
	}

	@Keyword
	public HashMap<String,ProductsDetail> getInforProductsInOrder (HashMap<String,ProductsDetail> informationProducts)
	{
		ProductsDetail lstProduct;
		wait.until(ExpectedConditions.visibilityOfElementLocated(lst_NameProducts));
		List<WebElement> lstNameProducts = driver.findElements(lst_NameProducts);
		List<WebElement> lstPriceProducts = driver.findElements(lst_PriceProducts);
		List<WebElement> lstQuantityProducts = driver.findElements(lst_QuantityProducts);
		List<WebElement> lstTotalPriceOfProducts = driver.findElements(lst_TotalPriceOfProducts);

		for (int i=0;i<lstNameProducts.size();i++)
		{
			String nameProduct = lstNameProducts.get(i).getText();
			String priceProduct = lstPriceProducts.get(i).getText();
			String quantityProduct = lstQuantityProducts.get(i).getText();
			String totalPriceOfProducts = lstTotalPriceOfProducts.get(i).getText();
			lstProduct = new ProductsDetail(nameProduct,priceProduct,quantityProduct,totalPriceOfProducts);
			informationProducts.put(nameProduct,lstProduct);
		}
		return informationProducts;
	}
}
