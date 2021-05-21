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
	WebElement oldPwd;
	
	@FindBy(xpath="//input[@id='changepwd']")
	WebElement newPwd;
	
	@FindBy(xpath="//input[@id='changepwdcnf']")
	WebElement cnfrmPwd;
	
	@FindBy(xpath="//button[text()='Change Password']")
	WebElement changePwdBtn;
	

	public void clickOnPersonI()
	{
		logoutButton.click();
	}
	public void logOut()
	{
		logOut.click();
	}
	public void enterOldPassword(String oldPword)
	{
		
		oldPwd.sendKeys(oldPword);
	}
	public void enterNewPassword(String newPword)
	{
		newPwd.sendKeys(newPword);
	}
	public void enterConfirmPassword(String confirmPword)
	{
		cnfrmPwd.sendKeys(confirmPword);
	}
	public void clickOnChangePwdButton()
	{
		changePwdBtn.click();
	}
}
