package com.mystore.testcases;

import java.io.IOException;

import org.testng.annotations.*;

import com.mystore.pageobject.RegisteredUserAccount;
import com.mystore.pageobject.indexPage;
import com.mystore.pageobject.myAccount;
import com.mystore.pageobject.registerPage;

import junit.framework.Assert;

public class TC_MyAccountPage extends BaseClass {
	
	@Test(enabled=false)
	public void verifyRegistrationAndLogin() {
				
		indexPage pg = new indexPage(driver);
		pg.clickOnLogIn();
		logger.info("Clicked on login link");
		
		myAccount myacc = new myAccount(driver);
		myacc.clickOnRegister();
		logger.info("Clicked on register button");
		
		registerPage pg1 = new registerPage(driver);
		pg1.selectMale();
		logger.info("select male radio button");
		pg1.enterFirstName("User");
		logger.info("first name entered in register user section ");
		pg1.enterLastName("test");
		logger.info("last name entered in register user section ");
		pg1.enterEmail("namankhaman1@gmail.com");
		logger.info("email address entered in register user section");
		pg1.enterPassword("Test@420");
		logger.info("password entered in register user section");
		pg1.enterConfirmPassword("Test@420");
		logger.info("confirm password eneteredn in register user section");
		pg1.clickRegister();
		logger.info("register button clicked");
		
		RegisteredUserAccount regUser = new RegisteredUserAccount(driver);
		String userName = regUser.getUserName();
		
		Assert.assertEquals("namankhaman1@gmail.com", userName);
	}
	
	@Test
	public void verifyLogin() throws IOException {
		
		logger.info("verifylogin test execution started...");
		
		indexPage pg = new indexPage(driver);
		
		pg.clickOnLogIn();
		logger.info("Clicked on login link");
		
		myAccount myacc = new myAccount(driver);
		
		myacc.enterEmailAddress("namankhaman@gmail.com");
		logger.info("Entered email adrress");
		
		myacc.enterPassword("Test@420");
		logger.info("Entered password");
		
		myacc.clickOnLogin();
		logger.info("Clicked on login button");
		
		RegisteredUserAccount regUser = new RegisteredUserAccount(driver);
		String userName = regUser.getUserName();
		
		if(userName.equals("namankhaman@gmail.com")) {
			logger.info("VerifyLogin - Passed");			
			Assert.assertTrue(true);
		} else {
			logger.info("verifyLogin - Failed");
			captureScreenShot(driver, "verifyLogin");
			Assert.assertTrue(false);
		}
		
	}
	

}
