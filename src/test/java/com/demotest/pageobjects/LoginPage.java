package com.demotest.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demotest.tetscase.BaseClass;

public class LoginPage 
{
	WebDriver ldriver;
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(xpath="//input[@id='UserUsername']")
	WebElement textUsername;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement textPassword;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginButton;
	
	public void enterUserName(String uname)
	{
		textUsername.sendKeys(uname);
	}
	public void enterUserPassword(String pwd)
	{
		textPassword.sendKeys(pwd);
	}
	public void clickOnLogin()
	{
		loginButton.click();
	}
	
	

}
