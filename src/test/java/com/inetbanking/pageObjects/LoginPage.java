package com.inetbanking.pageObjects;

import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {


	WebDriver ldriver;

	public LoginPage(WebDriver rdriver){

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(name="uid")
	WebElement txtUserName;

	@FindBy(name="password")
	@CacheLookup
	WebElement txtPassword;

	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	@CacheLookup
	WebElement logoutLink;

	
	

	public void setUserName(String username)
	{

		txtUserName.sendKeys(username);	
	}

	public void setPassword(String pwd)
	{

		txtPassword.sendKeys(pwd);
	}

	public void setBtnLogin(String btnlogin)
	{

		btnLogin.sendKeys(btnlogin);
	}

	public void clickSubmit()
	{
		btnLogin.click();
	}

	public void clickLogout()
	{

		logoutLink.click();
	}
}















