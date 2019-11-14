package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {


	WebDriver ldriver;

	public AddCustomerPage(WebDriver rdriver){

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(how=How.XPATH, using ="/html/body/div[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement lnkNewAddCustomer;

	@FindBy(how=How.NAME, using ="name")
	@CacheLookup
	WebElement txtCustomerName;

	@FindBy(how=How.XPATH, using ="/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[2]")
	@CacheLookup
	WebElement rdGender;

	@FindBy(how=How.XPATH, using ="//*[@id='dob']")
	@CacheLookup
	WebElement txtDob;

	@FindBy(how=How.NAME, using ="addr")
	@CacheLookup
	WebElement txtAddress;

	@FindBy(how=How.NAME, using ="city")
	@CacheLookup
	WebElement txtCity;

	@FindBy(how=How.NAME, using ="state")
	@CacheLookup
	WebElement txtState;

	@FindBy(how=How.NAME, using ="pinno")
	@CacheLookup
	WebElement txtpin;

	@FindBy(how=How.NAME, using ="telephoneno")
	@CacheLookup
	WebElement txtTelephoneno;

	@FindBy(how=How.NAME, using ="emailid")
	@CacheLookup
	WebElement txtEmail;

	@FindBy(how=How.NAME, using ="password")
	@CacheLookup
	WebElement txtpassword;

	@FindBy(how=How.NAME, using ="sub")
	@CacheLookup
	WebElement btnSubmit;


	public void clickAddNewCustomer(){
		lnkNewAddCustomer.click();

	}

	public void custName(String cname){
		txtCustomerName.sendKeys(cname);
	}

	public void custGender(){
		rdGender.click();

	}

	public void custdob(String mmddyy){
		txtDob.sendKeys(mmddyy);
		//txtDob.sendKeys(dd);
		//txtDob.sendKeys(yy);
	}

	public void custaddress(String caddress){
		txtAddress.sendKeys(caddress);

	}


	public void custcity(String ccity){
		txtCity.sendKeys(ccity);

	}


	public void custstate(String cstate){
		txtState.sendKeys(cstate);

	}

	public void custpinno(String pinno){
		txtpin.sendKeys(String.valueOf(pinno));
	}
	
	public void custtelephoneno(String ctelephoneno){
		txtTelephoneno.sendKeys(ctelephoneno);
	}


	public void custemail(String cemail){
		txtEmail.sendKeys(cemail);
	}
	
	public void custpassword(String custpwd){
		txtpassword.sendKeys(custpwd);
	}

	public void submit() {
		btnSubmit.click();
		
	}






}
