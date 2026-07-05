package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {
	
	WebDriver localdriver;
	
	//constructor
	public SearchResultPage(WebDriver remotedriver) {
		localdriver = remotedriver;
		PageFactory.initElements(remotedriver, this);
	}

	//idenify webelements
	@FindBy(xpath ="//div/div/div/div/h2/a[text()='Blue and green Sneaker']") WebElement searchResultProduct;
	
	@FindBy(xpath = "//input[@value='Add to cart']") WebElement addToCartLink;
	
	//action methods on web elements of search result page 
	public String getSearchResultProductName() {
		return(searchResultProduct.getText());
	}
	
	public void clickOnAddToCartLink() {
		addToCartLink.click();
	}
}
