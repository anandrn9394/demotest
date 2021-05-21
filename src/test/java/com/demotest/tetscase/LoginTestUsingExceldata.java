package com.demotest.tetscase;

import org.testng.annotations.Test;

import com.demotest.pageobjects.LoginPage;

public class LoginTestUsingExceldata extends BaseClass
{
	@Test
	public void loginTestExcel()
	{
		driver.get(baseURL);
		String uname1= xlib.getExcelData("login", 1, 0);
		LoginPage lp = new LoginPage(driver);
		lp.enterUserName(uname1);
		String pwd1 = xlib.getExcelData("login", 1, 1);
		lp.enterUserPassword(pwd1);
		lp.clickOnLogin();
	}

}
