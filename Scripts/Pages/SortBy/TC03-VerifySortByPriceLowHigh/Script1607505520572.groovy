import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser(GlobalVariable.OpenBrowser_URL)

CustomKeywords.'com.pageheader.pagemenu.PageMenuLeft.clickNavDropdown'('Accessories')

CustomKeywords.'com.saleor.pagebody.pagecategoryproduct.PageFilter.clickSortingDropdown'()

CustomKeywords.'com.saleor.pagebody.pagecategoryproduct.PageFilter.clickMenuListFilter'(2)

CustomKeywords.'com.saleor.pagebody.pagecategoryproduct.PageListProduct.clickButtonLoadmoreProducts'()

CustomKeywords.'com.saleor.pagebody.pagecategoryproduct.PageListProduct.verifySortByPriceLowHigh'()

WebUI.closeBrowser()