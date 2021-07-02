package com.saleor.pagebody.pagedetailproduct

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import com.saleor.utils.Product
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable


public class PageInformationProduct {
	TestObject buttonAddToBasket = findTestObject('UI/WEB SALEOR/Page Home/Body/Page Detail Product/Information Product/btn_AddToBasket')
	TestObject selectOptionSizeProduct = findTestObject('UI/WEB SALEOR/Page Home/Body/Page Detail Product/Information Product/select_OptionSizeProduct')
	TestObject labelNameProduct = findTestObject('UI/WEB SALEOR/Page Home/Body/Page Detail Product/Information Product/lbl_NameProduct')
	TestObject labelPriceProduct = findTestObject('UI/WEB SALEOR/Page Home/Body/Page Detail Product/Information Product/lbl_PriceProduct')
	TestObject inputQuantity = findTestObject('UI/WEB SALEOR/Page Home/Body/Page Detail Product/Information Product/Input_Quantity')
	TestObject labelNavInforProduct = findTestObject('UI/WEB SALEOR/Page Home/Body/Page Detail Product/Information Product/lbl_NavInfoProduct')


	
	String lblsizeProduct = "//input[@data-test='variantPicker']"
	String lblQuantityProduct = "//input[@data-test='addToCartQuantity']"
	String spanPriceProducts = "//p[@data-test='price']//span"
	String linkNameProducts = "//p[@data-test='name']"
	String spanSizeProducts = "//span[@class='cart__list__item__details__variant']/span[@data-test='quantity']/preceding-sibling::span"
	String spanQuantityProducts = "//span[@class='cart__list__item__details__variant']/span[@data-test='quantity']"

	WebDriver driver= DriverFactory.getWebDriver()
	WebDriverWait wait = new WebDriverWait(driver,GlobalVariable.G_Timeout_Small)



	//List information of product in Page_Info_Product
	Product InformationProduct

	//List information of product in Page_Checkout
	List<Product> lstInformationProductCheckout =  new ArrayList<>()

	//HashMap information of product in Page_Checkout
	HashMap<String,Product> hashMapInformationProductCheckout =  new HashMap<String,Product>()


	@Keyword
	public void clickOptionSize (int index)
	{
		WebUI.waitForElementClickable(selectOptionSizeProduct,GlobalVariable.G_Timeout_Small)
		WebUI.click(selectOptionSizeProduct)
		WebUI.waitForElementPresent(findTestObject('UI/WEB SALEOR/Page Home/Body/Page Detail Product/Information Product/Sub Size Product/option_Sizes',['index':index]), GlobalVariable.G_Timeout_Small)
		WebUI.click(findTestObject('UI/WEB SALEOR/Page Home/Body/Page Detail Product/Information Product/Sub Size Product/option_Sizes',['index':index]))
	}
	@Keyword
	public void clickButtonAddToBasket () {
		WebUI.click(buttonAddToBasket)

	}

	@Keyword
	public void setQuantity (String SetQuantity) {
		WebUI.waitForElementPresent(inputQuantity, GlobalVariable.G_Timeout_Small)
		WebUI.setText(inputQuantity,SetQuantity)
	}

	@Keyword
	public Product listInformationProduct (List<Product> lstInformationProduct)
	{
		int totalQuantity

		//List variable of Product
		String nameProduct = WebUI.getText(labelNameProduct)
		String priceProduct = WebUI.getText(labelPriceProduct)
		String sizeProduct
		String setQuantity
		//Varible save value for check if it is Alcohol
		String labelNavigateInforProduct = WebUI.getText(labelNavInforProduct)

		if(labelNavigateInforProduct.equalsIgnoreCase('Alcohol'))
		{
			for(int i=0;i<lstInformationProduct.size();i++)
			{
				if(lstInformationProduct[i].getNameProduct().equalsIgnoreCase(nameProduct))
				{
					setQuantity = getQuantity()
					totalQuantity = Integer.parseInt(lstInformationProduct[i].getQuantityProduct()) + Integer.parseInt(setQuantity)
					lstInformationProduct[i].setQuantityProduct(totalQuantity.toString())
					return InformationProduct
				}
			}
			setQuantity = getQuantity()
			InformationProduct = new Product(nameProduct,priceProduct,setQuantity)
			return InformationProduct
		}
		else
		{
			for(int i=0;i<lstInformationProduct.size();i++)
			{
				if(lstInformationProduct.get(i).getNameProduct().equalsIgnoreCase(nameProduct))
				{
					sizeProduct = getSize()
					setQuantity = getQuantity()
					totalQuantity = Integer.parseInt(lstInformationProduct[i].getQuantityProduct()) + Integer.parseInt(setQuantity)
					lstInformationProduct[i].setQuantityProduct(totalQuantity.toString())
					return InformationProduct
				}
			}
			sizeProduct = getSize()
			setQuantity = getQuantity()
			InformationProduct = new Product(nameProduct,priceProduct,sizeProduct,setQuantity)
			return InformationProduct
		}
	}
	public String getSize()
	{
		WebElement lblSizeProduct = driver.findElement(By.xpath(lblsizeProduct))
		return lblSizeProduct.getAttribute("value")

	}
	public String getQuantity ()
	{
		WebElement addToCartQuantity = driver.findElement(By.xpath(lblQuantityProduct))
		return addToCartQuantity.getAttribute("value")

	}


	//List information of products in cart include Name, Price, Size, Quantity
	@Keyword
	public List<Product> listInformationProductCheckout ()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(spanPriceProducts)))
		List<WebElement> lstPriceProductCheckout = driver.findElements(By.xpath(spanPriceProducts))
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(linkNameProducts)))
		List<WebElement> lstNameProductCheckout = driver.findElements(By.xpath(linkNameProducts))
		
		List<WebElement> lstSizeProductCheckout = driver.findElements(By.xpath(spanSizeProducts))

		List<WebElement> lstQuantityProductCheckout = driver.findElements(By.xpath(spanQuantityProducts))
		for(int i=0;lstPriceProductCheckout.size()>i;i++)
		{
			String nameProductCheckOut = lstNameProductCheckout[i].getText()
			String priceProductCheckOut = lstPriceProductCheckout[i].getText()
			String inputSizeProductCheckOut = lstSizeProductCheckout[i].getText()
			String setQuantityCheckOut = lstQuantityProductCheckout[i].getText().replaceAll('\\D', '')
			lstInformationProductCheckout.add(new Product(nameProductCheckOut,priceProductCheckOut,inputSizeProductCheckOut,setQuantityCheckOut))
		}
		return lstInformationProductCheckout
	}
	@Keyword
	public void verifyAddProductInCart (List<Product> lstInformationProduct,List<Product> lstInformationProductCheckout)
	{
		int flag= 0;
		for (int i=0; lstInformationProduct.size()>i; i++)
		{
			for (int j=0; lstInformationProductCheckout.size()>j; j++)
			{

				if(lstInformationProduct[i].getPriceProduct().equalsIgnoreCase(lstInformationProductCheckout[j].getPriceProduct()) &&
				lstInformationProduct[i].getNameProduct().equalsIgnoreCase(lstInformationProductCheckout[j].getNameProduct()) &&
				lstInformationProduct[i].getQuantityProduct().equalsIgnoreCase(lstInformationProductCheckout[j].getQuantityProduct()) )
				{
					flag =1;
					break;
				}
			}
		}
		WebUI.verifyEqual(1, flag)
	}

	@Keyword
	public void hshMapInformationProduct (HashMap<String,Product> hashInformationProduct)
	{
		
		int totalQuantity = 0
		String nameProduct = WebUI.getText(labelNameProduct)
		String priceProduct = WebUI.getText(labelPriceProduct)
		String sizeProduct
		String setQuantity
		String labelNavigateInforProduct = WebUI.getText(labelNavInforProduct)
		

		if(labelNavigateInforProduct.equalsIgnoreCase('Alcohol'))
		{
			for (String key : hashInformationProduct.keySet())
			{
				if(hashInformationProduct.get(key).getNameProduct().equalsIgnoreCase(nameProduct))
				{
					setQuantity = getQuantity()
					totalQuantity = Integer.parseInt(hashInformationProduct.get(key).getQuantityProduct()) + Integer.parseInt(setQuantity)
					hashInformationProduct.get(key).setQuantityProduct(totalQuantity.toString())
					return
				}
			}
			
			setQuantity = getQuantity()
			InformationProduct = new Product(nameProduct,priceProduct,setQuantity)
			hashInformationProduct.put(nameProduct,InformationProduct)
		}
		else
		{
			for (String key : hashInformationProduct.keySet())
			{
				if(hashInformationProduct.get(key).getNameProduct().equalsIgnoreCase(nameProduct))
				{
					
					sizeProduct = getSize()
					setQuantity = getQuantity()
					totalQuantity = Integer.parseInt(hashInformationProduct.get(key).getQuantityProduct()) + Integer.parseInt(setQuantity)
					hashInformationProduct.get(key).setQuantityProduct(totalQuantity.toString())
					return
				}
			}
			sizeProduct = getSize()
			setQuantity = getQuantity()
			InformationProduct = new Product(nameProduct,priceProduct,sizeProduct,setQuantity)
			hashInformationProduct.put(nameProduct,InformationProduct)
		}
	}

	@Keyword
	public void hshMapInformationProductCheckout (HashMap<String,Product> hashMaplstInformationProductCheckout)
	{
		List<WebElement> lstPriceProductCheckout = getListPriceProducts()
		List<WebElement> lstNameProductCheckout = getNamePriceProducts()
		List<WebElement> lstSizeProductCheckout = getSizePriceProducts()
		List<WebElement> lstQuantityProductCheckout = getQuantityPriceProducts()
		for(int i=0;lstPriceProductCheckout.size()>i;i++)
		{
			//Integer.parseInt(list_PriceProduct.get(i).getText().replaceAll("[^A-Za-z0-9()\\[\\]]", ""))
			String nameProductCheckOut = lstNameProductCheckout[i].getText()
			String priceProductCheckOut = lstPriceProductCheckout[i].getText()
			String inputSizeProductCheckOut = lstSizeProductCheckout[i].getText()
			String setQuantityCheckOut = lstQuantityProductCheckout[i].getText().replaceAll('\\D', '')
			InformationProduct = new Product(nameProductCheckOut,priceProductCheckOut,inputSizeProductCheckOut,setQuantityCheckOut)
			hashMaplstInformationProductCheckout.put(nameProductCheckOut,InformationProduct)
		}
	}
	public List<WebElement> getListPriceProducts()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(spanPriceProducts)))
		return driver.findElements(By.xpath(spanPriceProducts))
	}
	
	public List<WebElement> getNamePriceProducts()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(linkNameProducts)))
		return driver.findElements(By.xpath(linkNameProducts))
	}
	
	public List<WebElement> getSizePriceProducts()
	{
		return driver.findElements(By.xpath(spanSizeProducts))
	}
	
	public List<WebElement> getQuantityPriceProducts()
	{
		return driver.findElements(By.xpath(spanQuantityProducts))
	}
	

	@Keyword
	public void verifyhashMapAddProductInCart (HashMap<String,Product> hashInformationProduct,HashMap<String,Product> hashInformationProductCheckout)
	{
		int flag
		Set<Integer> keySet = hashInformationProduct.keySet();
		for (String key : keySet)
		{
			if(hashInformationProduct.get(key).getPriceProduct().equalsIgnoreCase(hashInformationProductCheckout.get(key).getPriceProduct()) &&
			hashInformationProduct.get(key).getNameProduct().equalsIgnoreCase(hashInformationProductCheckout.get(key).getNameProduct()) &&
			hashInformationProduct.get(key).getQuantityProduct().equalsIgnoreCase(hashInformationProductCheckout.get(key).getQuantityProduct()) )
			{
				flag =1;
				break;
			}
		}
		WebUI.verifyEqual(1, flag)
	}
}
