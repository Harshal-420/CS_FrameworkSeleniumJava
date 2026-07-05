package com.mystore.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.*;

import com.mystore.utilities.Readconfig;



public class BaseClass {
	
	Readconfig readConfig =new Readconfig();
	
	String url = readConfig.getBaseUrl();
	String browser = readConfig.getBrowser();
	public String emailAddress = readConfig.getEmail();
	String password = readConfig.getPassword();
	
	public static WebDriver driver;
	public static Logger logger;
	
	@BeforeClass
	public void setup() {
		
		switch(browser.toLowerCase()) {
		
		case "chrome":
//			ChromeOptions chromeOptions = new ChromeOptions();
//			chromeOptions.addArguments("--remote-allow-origins=*");
//			chromeOptions.addArguments("--no-sandbox");
//			chromeOptions.addArguments("--disable-dev-shm-usage");
			driver = new ChromeDriver();
			break;
			
		case "msedge":
//			EdgeOptions edgeOptions = new EdgeOptions();
//			edgeOptions.addArguments("--remote-allow-origins=*");
//			edgeOptions.addArguments("--no-sandbox");
//			edgeOptions.addArguments("--disable-dev-shm-usage");
			driver = new EdgeDriver();
			break;
			
		case "firefox":
//			FirefoxOptions firefoxOptions = new FirefoxOptions();
//			firefoxOptions.addArguments("--remote-allow-origins=*");
//			firefoxOptions.addArguments("--no-sandbox");
//			firefoxOptions.addArguments("--disable-dev-shm-usage");
			driver = new FirefoxDriver();
			break;
		default:
			driver = null;
			break;			
		}	
		
		//implicitly wait of 10 secs
//		if(driver != null) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//for logging
		logger = LogManager.getLogger("MyStoreV1");		
		
		driver.get(url);
		logger.info("url opened");

	}
	
	@AfterClass
	public void tearDown() {
//		if(driver!=null) {
	//	driver.close();
		driver.quit();
		}
	
	public void captureScreenShot(WebDriver driver,String testName) throws IOException {

	//step1: convert webdriver object to TakesScreenshot interface
	TakesScreenshot screenshot = ((TakesScreenshot)driver);

	//step2: call getScreenshotAs method to create image file
	File src = screenshot.getScreenshotAs(OutputType.FILE);

	File dest = new File(System.getProperty("user.dir") + "\\Screenshots\\" + testName + ".png");
	//step3: copy image file to destination
	FileUtils.copyFile(src, dest);
	
	}
	
	
	}

