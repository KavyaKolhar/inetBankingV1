package com.inetbanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig = new ReadConfig();
	
	public String baseURL = readconfig.getAplicationURL();
	public String username = readconfig.getUserName();
	public String password = readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
	    logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+readconfig.getFirefoxpath());
			driver = new FirefoxDriver();
		}
		else if (br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+readconfig.getChromePath());
			driver = new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);	
		
		
	}

	public void onStart(ITestContext iTestContext) {
		// TODO Auto-generated method stub
		
	}
	
	/*@AfterClass
	public void teardown()
	{
		driver.quit();
	}
*/
	
public void captureScreenshot(WebDriver driver,String tcname) throws IOException{
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "\\Screenshots\\" + tcname +".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	
		
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
