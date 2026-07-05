package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	WebDriver localdriver;
	
	//constructor
	public CartPage(WebDriver remotedriver) {
		localdriver = remotedriver;
		PageFactory.initElements(remotedriver, this);
	}
	
	//identify WebElements
	@FindBy(id="termsofservice") WebElement termsCheckBox;
	
	@FindBy(id="checkout") WebElement checkout;
	
	//action on webelements
	public void clickOnTermsCheckBox() {
		termsCheckBox.click();
	}
	
	public void clickOnCheckout() {
		checkout.click();
	}
	
}
