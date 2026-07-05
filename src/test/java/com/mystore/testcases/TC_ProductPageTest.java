package com.mystore.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.*;

import com.mystore.pageobject.CartPage;
import com.mystore.pageobject.CompletedPage;
import com.mystore.pageobject.OnePageCheckout;
import com.mystore.pageobject.ProductPage;
import com.mystore.pageobject.RegisteredUserAccount;
import com.mystore.pageobject.SearchResultPage;
import com.mystore.pageobject.indexPage;
import com.mystore.pageobject.myAccount;


public class TC_ProductPageTest extends BaseClass {
	
	@Test(enabled=false)
	public void verifySearchProduct() throws IOException {
		
		String searchKey = "Sneaker";
		logger.info("***********Test Case Search Product started************");
		
		//sign in
		indexPage pg = new indexPage(driver);
		pg.clickOnLogIn();
		
		myAccount myacc = new myAccount(driver); 
		myacc.enterEmailAddress(emailAddress);
		myacc.enterPassword(password);
		logger.info("user email and password entered");
		myacc.clickOnLogin();
		logger.info("login button clicked");
		
		//Enter search key in search box
		RegisteredUserAccount productPg = new RegisteredUserAccount(driver);
		productPg.enterDataInSearchBox(searchKey);
		productPg.clickOnSearchButton();
		
		//Get name of search product
		SearchResultPage resultPg = new SearchResultPage(driver);
		String searchresultProductName = resultPg.getSearchResultProductName();
		
		//Verify that correct product is displaying after search
		if(searchresultProductName.contains(searchKey)) {
			logger.info("Search Product Testcase - passed");
			Assert.assertTrue(true);
		//	productPg.clickOnLogOut();		
		}
		else {
			logger.info("verify SignOut - failed");
			captureScreenShot(driver, "verifySearchProduct");
			Assert.assertTrue(false);
		}
								
		logger.info("*******************Test case verify signout ends************");								
	}
	
	
	@Test(enabled = true)
	public void verifyBuyProduct() throws IOException {
		logger.info("**********TestCase buy product started****************");
		
		indexPage pg = new indexPage(driver);
		pg.clickOnLogIn();
		
		myAccount myacc = new myAccount(driver); 
		myacc.enterEmailAddress(emailAddress);
		myacc.enterPassword(password);
		logger.info("user email and password entered");
		myacc.clickOnLogin();
		logger.info("login button clicked");
		
		RegisteredUserAccount prodCatPg = new RegisteredUserAccount(driver);		
		prodCatPg.enterDataInSearchBox("Sneaker");
		logger.info("T-shirt entered in search box");
		prodCatPg.clickOnSearchButton();
		logger.info("clicked on search button");
		
		//Get name of search product
		SearchResultPage searchresultPg = new SearchResultPage(driver);
		searchresultPg.clickOnAddToCartLink();
		logger.info("clicked on add to cart button");
		
//		try {
//			Thread.sleep(4000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		ProductPage prodPg = new ProductPage(driver);
		prodPg.setQuantity("2");
		logger.info("quantity 2 entered");
		prodPg.setSize("9");
		logger.info("size 9 entered");
		prodPg.clickOnAddToCart();
		logger.info("clicked on add to cart");
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		prodPg.clickOnShoppingCart();
		logger.info("clicked on shopping cart");
		
		CartPage cartPg = new CartPage(driver);
		cartPg.clickOnTermsCheckBox();
		logger.info("Clicked on terms of service check box");
		cartPg.clickOnCheckout();
		logger.info("clicked on checkout on cart page ");
		
		
		OnePageCheckout checkoutPg = new OnePageCheckout(driver);
		checkoutPg.continueBillingAddress();
		logger.info("Continue to proceed on billing address");
		checkoutPg.continueShippingAddress();
		logger.info("Continue to proceed on shipping address");
		checkoutPg.continueShippingMethod();
		logger.info("Continue to proceed on shipping method");
		checkoutPg.continuePaymentMethod();
		logger.info("Continue to proceed on payment method");
		checkoutPg.continuePaymentInfo();
		logger.info("Continue to proceed on payment info");
		checkoutPg.clickOnConfirmOrder();
		logger.info("Continue to proceed on Confirm order");

		CompletedPage compPg = new CompletedPage(driver);
		String successMsg = compPg.getOrderSuccessMessage();
		if(successMsg.equals("Your order has been successfully processed!")) {
			logger.info("VerifyBuyProduct - Passed");
			Assert.assertTrue(true);
			
			
		} else {
			logger.info("VerifyBuyProduct - Failed");
			captureScreenShot(driver,"verifyBuyProduct");
			Assert.assertTrue(false);				
		}
		
//		registeredUserAccount regPg = new registeredUserAccount(driver);
//		regPg.clickOnLogOut();
		
		logger.info("*******************TestCase  BuyProduct Ends**************");		
		
	}
}
