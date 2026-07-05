package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {
	
	//create object of webdriver
		WebDriver localdriver;
		
	//constructor 
	 public ProductPage(WebDriver remotedriver) {
		localdriver = remotedriver;
		PageFactory.initElements(remotedriver, this);
	}
	
	

	//Identify the elements 
	@FindBy(id="addtocart_28_EnteredQuantity") WebElement quantityWanted;
	
	@FindBy(id="product_attribute_28_7_10") WebElement size;
	
	@FindBy(id="add-to-cart-button-28") WebElement addToCart;
	
	@FindBy(xpath = "//a[@class='ico-cart']/descendant::span[@class='cart-qty']") WebElement shoppingCart;
	
	//action methods on webelements
	public void setQuantity(String qty) {
		quantityWanted.clear();
		quantityWanted.sendKeys(qty);
	}
	
	public void setSize(String sizeType) {
		Select select = new Select(size);
		select.selectByVisibleText(sizeType);
	}
	
	public void clickOnAddToCart() {
		addToCart.click();
	}
	
	public void clickOnShoppingCart() {
		shoppingCart.click();
	}
	
}
