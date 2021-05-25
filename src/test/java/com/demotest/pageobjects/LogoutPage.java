package com.demotest.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage 
{
	WebDriver ldriver;
	public LogoutPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(xpath="//i[text()='person']")
	WebElement logoutButton;
	
	@FindBy(xpath="//a[text()='Logout']")
	WebElement logOut;
	
	@FindBy(xpath="//input[@id='oldpwd']")
	WebElement oldpassword;
	
	@FindBy(xpath="//input[@id='changepwd']")
	WebElement newpassword;
	
	@FindBy(xpath="//input[@id='changepwdcnf']")
	WebElement confirmpassword;
	
	@FindBy(xpath="//button[text()='Change Password']")
	WebElement changePasswordbutton;
	

	public void clickOnPersonI()
	{
		logoutButton.click();
	}
	public void logOut()
	{
		logOut.click();
	}
	
	public void enterOldPassword(String oldpwd)
	{
		oldpassword.sendKeys(oldpwd);
	}
	
	public void enterNewPassword(String newpwd)
	{
		newpassword.sendKeys(newpwd);
	}
	
	public void enterConfirmPassword(String confrmpwd)
	{
		confirmpassword.sendKeys(confrmpwd);
	}
	
	public void clickOnChangePwdButton()
	{
		changePasswordbutton.click();
	}
}
