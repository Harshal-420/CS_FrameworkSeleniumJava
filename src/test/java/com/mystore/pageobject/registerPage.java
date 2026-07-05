package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class registerPage {
	
	 WebDriver localdriver;  // Create object of webdriver
	 
	 //constructor
	 public registerPage(WebDriver remotedriver) {
		 localdriver = remotedriver;
		 
		 PageFactory.initElements(remotedriver, this);			 
	 }
	 
	 //identify webelements
	 @FindBy(id="gender-male")  WebElement maleRadioBtn ;
	 
	 @FindBy(id="gender-female") WebElement femaleRadioBtn;
	 
	 @FindBy(id="FirstName") WebElement firstNameTxt;
	 
	 @FindBy(id="LastName") WebElement lastNameTxt;
	 
	 @FindBy(id="Email") WebElement emailTxt;
	 
	 @FindBy(id="Password") WebElement pswdTxt;
	 
	 @FindBy(id="ConfirmPassword") WebElement cnfmpswdTxt;
	 
	 @FindBy(id="register-button") WebElement registerbtn;
	 
	 
	 //identify action on webelement
	 public void selectMale() {
		 maleRadioBtn.click();
	 }
	 
	 public void selectFemale() {
		 femaleRadioBtn.click();
	 }

	 public void enterFirstName(String firstName) {
		 firstNameTxt.sendKeys(firstName);
	 }
	 
	 public void enterLastName(String lastName) {
		 lastNameTxt.sendKeys(lastName);;
	 }
	 
	 public void enterEmail(String email) {
		 emailTxt.sendKeys(email);
	 }
	 
	 public void enterPassword(String pswd) {
		 pswdTxt.sendKeys(pswd);
	 }
	 
	 public void enterConfirmPassword(String cnfmpswd) {
		 cnfmpswdTxt.sendKeys(cnfmpswd);
	 }
	 
	 public void clickRegister() {
		 registerbtn.click();
	 }
	 
}
