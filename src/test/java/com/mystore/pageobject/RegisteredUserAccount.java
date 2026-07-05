package com.mystore.pageobject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisteredUserAccount {
	
	//create object of webdriver
	WebDriver localdriver;
	
	//constructor 
	public RegisteredUserAccount(WebDriver remotedriver) {
		localdriver = remotedriver;
		PageFactory.initElements(remotedriver, this);
	}
	
	//identify webelements
	@FindBy(xpath = "//div[@class='header-links']/ul/li/a[@href='/customer/info']") WebElement userName;
	
	@FindBy(xpath = "//a[@class=\"ico-logout\" and text()='Log out']") WebElement logOut;
	
	@FindBy(xpath ="//input[@name='q']") WebElement searchBox;
	
	@FindBy(xpath = "//input[@type='submit']") WebElement submitSearch;
	
	//action methods on web elements
	public String getUserName() {
		String text = userName.getText();
		return text; 
	}
	
	public void clickOnLogOut() {
//		WebDriverWait wait = new WebDriverWait(localdriver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.elementToBeClickable(logOut)).click();
		logOut.click();
	}
	
	public void enterDataInSearchBox(String searchKey) {
		searchBox.sendKeys(searchKey);
	}

	public void clickOnSearchButton() {
		submitSearch.click();
	}
}
