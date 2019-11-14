package com.inetbanking.utilities;
//Listener class to generate extent report
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.utils.FileUtil;



public class Reporting extends TestListenerAdapter{

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;

	@BeforeClass
	public void onStart(ITestContext testContext){

		//String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//timestamp
		//String repName = "Test-Report-"+timeStamp+".html";
		extent = new ExtentReports();
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/TESTREPORT.html");//location

		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"\\extent-config.xml");


		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name","localhost");
		extent.setSystemInfo("Environment","QA");
		extent.setSystemInfo("user","kavya");

		htmlReporter.config().setDocumentTitle("InetBanking Test Report");
		htmlReporter.config().setReportName("Functional Automation Test Report");

	}
	@Test
	public void onTestSuccess(ITestResult tr){


		logger=extent.createTest(tr.getName());//create new entry in report
		logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));

	}
	@Test
	public void onTestFailure(ITestResult tr){


		logger=extent.createTest(tr.getName());//create new entry in report
		logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));

		String screenshotpath = System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
		File f = new File(screenshotpath);
		if(f.exists())
			try {
				logger.fail("Screenshot is below:" +logger.addScreenCaptureFromPath(screenshotpath));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
	@Test
	public void onTestSkipped(ITestResult tr){
		logger=extent.createTest(tr.getName());//creare new entry in report
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));

	}
	@AfterTest
	public void onFinish(ITestResult tr){
		extent.flush();
	}

	
	
}
