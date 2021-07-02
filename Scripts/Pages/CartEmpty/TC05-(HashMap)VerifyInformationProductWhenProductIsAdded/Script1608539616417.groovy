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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import com.saleor.utils.Product

	WebUI.openBrowser(GlobalVariable.OpenBrowser_URL)

	//HashMap information of product in Page_Info_Product
	HashMap<String,Product> hashMapInformationProduct =  new HashMap<String, Product>()
	
	//List information of product in Page_Checkout
	HashMap<String,Product> hashMaplstInformationProductCheckout =  new HashMap<String, Product>()
	
	//Add The first product
	CustomKeywords.'com.pageheader.pagemenu.PageMenuLeft.hoverMouseToNavDropdown'('Groceries','Juices')
	CustomKeywords.'com.saleor.pagebody.pagecategoryproduct.PageListProduct.listProducts'('Apple Juice')
	CustomKeywords.'com.saleor.pagebody.pagedetailproduct.PageInformationProduct.clickOptionSize'(1)
	CustomKeywords.'com.saleor.pagebody.pagedetailproduct.PageInformationProduct.setQuantity'("2")
	CustomKeywords.'com.saleor.pagebody.pagedetailproduct.PageInformationProduct.clickButtonAddToBasket'()
	CustomKeywords.'com.saleor.pagebody.pagedetailproduct.PageInformationProduct.hshMapInformationProduct'(hashMapInformationProduct)
	
	//Add the second product
	CustomKeywords.'com.saleor.pagebody.pagedetailproduct.PageCheckout.clickIconCloseCart'()
	CustomKeywords.'com.pageheader.pagemenu.PageMenuLeft.hoverMouseToNavDropdown'('Groceries','Alcohol')
	CustomKeywords.'com.saleor.pagebody.pagecategoryproduct.PageListProduct.listProducts'('White Wine')
	CustomKeywords.'com.saleor.pagebody.pagedetailproduct.PageInformationProduct.setQuantity'("2")
	CustomKeywords.'com.saleor.pagebody.pagedetailproduct.PageInformationProduct.clickButtonAddToBasket'()
	CustomKeywords.'com.saleor.pagebody.pagedetailproduct.PageInformationProduct.hshMapInformationProduct'(hashMapInformationProduct)
	
	//Add the third product
	CustomKeywords.'com.saleor.pagebody.pagedetailproduct.PageCheckout.clickIconCloseCart'()
	CustomKeywords.'com.pageheader.pagemenu.PageMenuLeft.hoverMouseToNavDropdown'('Groceries','Juices')
	CustomKeywords.'com.saleor.pagebody.pagecategoryproduct.PageListProduct.listProducts'('Apple Juice')
	CustomKeywords.'com.saleor.pagebody.pagedetailproduct.PageInformationProduct.clickOptionSize'(1)
	CustomKeywords.'com.saleor.pagebody.pagedetailproduct.PageInformationProduct.setQuantity'("2")
	CustomKeywords.'com.saleor.pagebody.pagedetailproduct.PageInformationProduct.clickButtonAddToBasket'()
	CustomKeywords.'com.saleor.pagebody.pagedetailproduct.PageInformationProduct.hshMapInformationProduct'(hashMapInformationProduct)
	
	
	CustomKeywords.'com.saleor.pagebody.pagedetailproduct.PageInformationProduct.hshMapInformationProductCheckout'(hashMaplstInformationProductCheckout)
	
	CustomKeywords.'com.saleor.pagebody.pagedetailproduct.PageInformationProduct.verifyhashMapAddProductInCart'(hashMapInformationProduct, hashMaplstInformationProductCheckout)
	
	//CustomKeywords.'com.saleor.pagebody.pagedetailproduct.PageCheckout.verify_CartEmpty'()
	//WebUI.closeBrowser()