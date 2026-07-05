package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompletedPage {
	
	WebDriver localdriver;

	public CompletedPage(WebDriver remotedriver) {
		localdriver = remotedriver;
		PageFactory.initElements(remotedriver, this);
	}
	
	@FindBy(xpath = "//input[@value='Continue']") WebElement confirmOrder;
	
	@FindBy(xpath = "//div[@class='title']/strong[text()='Your order has been successfully processed!']") WebElement successAlert;
	
	
	public void clickOnConfirmOrder() {
		confirmOrder.click();
	}
			
	public String getOrderSuccessMessage() {
		return(successAlert.getText());
	}
	
}
