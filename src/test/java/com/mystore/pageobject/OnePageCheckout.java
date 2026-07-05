package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OnePageCheckout {
	WebDriver localdriver;
	
	 public OnePageCheckout(WebDriver remotedriver) {
		localdriver = remotedriver;
		PageFactory.initElements(remotedriver, this);		
	}
	
	//finding webelements 
	@FindBy(xpath = "//div[@id='billing-buttons-container']/input[@class='button-1 new-address-next-step-button']") WebElement billingAddress;
	
	@FindBy(xpath = "//input[@onclick='Shipping.save()']") WebElement shippingAddress;
	
	@FindBy(xpath = "//input[@onclick='ShippingMethod.save()']") WebElement shippingMethod;
	
	@FindBy(xpath = "//input[@onclick='PaymentMethod.save()']") WebElement paymentMethod;
	
	@FindBy(xpath = "//input[@onclick='PaymentInfo.save()']") WebElement paymentInfo;
	
	@FindBy(xpath = "//input[@onclick='ConfirmOrder.save()']") WebElement confirmOrder;
	
	//action on webelements
	public void continueBillingAddress() {
		billingAddress.click();
	}
	
	public void continueShippingAddress() {
		shippingAddress.click();
	}
	
	public void continueShippingMethod() {
		shippingMethod.click();
	}
	
	public void continuePaymentMethod() {
		paymentMethod.click();
	}
	
	public void continuePaymentInfo() {
		paymentInfo.click();
	}
	
	public void clickOnConfirmOrder() {
		confirmOrder.click();
	}
}
