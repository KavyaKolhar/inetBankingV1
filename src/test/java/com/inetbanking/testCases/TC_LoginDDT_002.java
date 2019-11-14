package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {

	@Test(dataProvider="LoginData")
	public void LoginDDT(String user, String pwdd) throws Exception{

		//read the dataprovider data in excel and execute

		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		logger.info("username provided");
		lp.setPassword(pwdd);
		logger.info("pwd provided");
		System.out.println("Latest Method");
		lp.clickSubmit();
		Thread.sleep(3000);
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();//alert closes on invalid login cred
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("logintc002 failed");
			System.out.println("login failll");
		}
		else
		{
			
			Assert.assertTrue(true);
			logger.info("login success!!");
			System.out.println("login successs");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();//closes logout alert
			driver.switchTo().defaultContent();
			logger.info("login success!!");
			
		}
		
	
	}
	//user defined method to check alert present or not
	public boolean isAlertPresent(){
		
		try{
		driver.switchTo().alert();
		return true;
		}catch(NoAlertPresentException e){
			return false;
		}
		
		
		
	}

	@DataProvider(name="LoginData")
	String[][] getData() throws IOException{

		String path = System.getProperty("user.dir")+ "/src/test/java/com/inetbanking/testData/LoginData.xlsx";
		//to read data count row and column
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getColcount(path, "Sheet1",1);
		String logindata[][] = new String [rownum][colcount];

		for(int i=1;i<=rownum;i++){

			for(int j=0;j<colcount;j++){

				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);//1 0

			}
		}
		return logindata;
	}

}
