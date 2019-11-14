package com.inetbanking.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException{
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		addcust.clickAddNewCustomer();
		addcust.custName("Kavya");
		addcust.custGender();
		Thread.sleep(3000);
		addcust.custdob("1990-10-10");
		Thread.sleep(3000);
		addcust.custaddress("INDIA");
		addcust.custcity("Belgaum");
		addcust.custstate("Karnataka");
		addcust.custpinno("590001");
		addcust.custtelephoneno("9874563210");
		String email = randomstring()+"@gmail"+".com";
		addcust.custemail(email);		
		addcust.custpassword("abcdef");
		addcust.submit();
		Thread.sleep(3000);
		
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(res==true){
			Assert.assertTrue(true);
		}
		else{
			captureScreenshot(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
		
		
	}
	//generate random email id
	public String randomstring(){
	String generatedstring = RandomStringUtils.randomAlphabetic(8);
	return generatedstring;
	
}
	//
	public String randomNum(){
	String generatedstring2 = RandomStringUtils.randomNumeric(4);
	return generatedstring2;
	
}
	
}
