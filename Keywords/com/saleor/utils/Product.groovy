package com.saleor.utils

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

public class Product {

	private String priceProduct
	private String nameProduct
	private String sizeProduct
	private String quantityProduct


	public String getPriceProduct() {
		return priceProduct;
	}

	public void setPriceProduct(String priceProduct) {
		this.priceProduct = priceProduct;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public String getSizeProduct() {
		return sizeProduct;
	}

	public void setSizeProduct(String sizeProduct) {
		this.sizeProduct = sizeProduct;
	}

	public String getQuantityProduct() {
		return quantityProduct;
	}

	public void setQuantityProduct(String quantityProduct) {
		this.quantityProduct = quantityProduct;
	}

	//Set constructor of product with name, price, size, quantity
	public Product (String nameProduct,String priceProduct,String sizeProduct,String quantityProduct) {
		this.priceProduct=priceProduct
		this.nameProduct=nameProduct
		this.sizeProduct=sizeProduct
		this.quantityProduct=quantityProduct
	}


	//Set constructor of Alcohol without size product
	public Product (String nameProduct,String priceProduct,String quantityProduct) {
		this.priceProduct=priceProduct
		this.nameProduct=nameProduct
		this.quantityProduct=quantityProduct
	}
}


