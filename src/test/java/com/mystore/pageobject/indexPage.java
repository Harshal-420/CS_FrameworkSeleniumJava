package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class indexPage {

	
		 WebDriver localdriver;  // Create object of webdriver
		 
		 public indexPage(WebDriver remotedriver) {
			 localdriver = remotedriver;
			 
			 PageFactory.initElements(remotedriver, this);			 
		 }
		 
		 //identify webelements
		 @FindBy(linkText = "Log in") WebElement logIn;
		 
		
		 
		 //identify action on webelement
		 public void clickOnLogIn() {
			 logIn.click();
		 }
		
		
		

	

}
