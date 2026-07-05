package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class myAccount {
	
	WebDriver localdriver;  // Create object of webdriver
	 
	 public myAccount(WebDriver remotedriver) {
		 localdriver = remotedriver;
		 
		 PageFactory.initElements(remotedriver, this);			 
	 }
	 
	 //identify webelements
	 @FindBy(xpath="//input[@value='Register']") WebElement register;
	 
	 @FindBy(id="Email") WebElement registeredUserEmail;
	 
	 @FindBy(id="Password") WebElement registeredUserPswd;
	 
	 @FindBy(xpath = "//input[@class='button-1 login-button']")WebElement loginBtn;
	 
	//identify action on webelement
	 public void clickOnRegister() {
	     register.click();
	 }
	     
	 public void enterEmailAddress (String emailAdd) {
		 registeredUserEmail.sendKeys(emailAdd);
	 }
	 
	 public void enterPassword(String pswd) {
		 registeredUserPswd.sendKeys(pswd);
	 }
	 
	 public void clickOnLogin() {
		 loginBtn.click();
	 }
	 
	 

}
