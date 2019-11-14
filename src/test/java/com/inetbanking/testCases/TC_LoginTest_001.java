package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;


public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void loginTest() throws IOException
	{
		
		logger.info("URL opened");
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(username);
		logger.info("Entered username");
		lp.setPassword(password);
		logger.info("Entered password");
		lp.clickSubmit();
		logger.info("Sybmitted login");
		
		if(driver.getTitle().equalsIgnoreCase("Guru99 Bank Manager Homepage"))
		{
			
			Assert.assertTrue(true);
			logger.info("Login passed");
		}
		else {
			captureScreenshot(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Login Failed");		
			}
		
		
	}
	
	
	

}
