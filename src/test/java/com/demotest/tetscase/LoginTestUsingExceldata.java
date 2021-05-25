package com.demotest.tetscase;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.demotest.pageobjects.LoginPage;
import com.google.common.io.Files;

public class LoginTestUsingExceldata extends BaseClass
{
	@Test(priority=4)
	public void loginTestExcel() throws IOException
	{
		driver.get(baseURL);
		String uname1= xlib.getExcelData("login", 1, 0);
		LoginPage lp = new LoginPage(driver);
		lp.enterUserName(uname1);
		String pwd1 = xlib.getExcelData("login", 1, 1);
		lp.enterUserPassword(pwd1);
		lp.clickOnLogin();
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(screenshot, new File("C:\\Users\\Dhulappa R N\\Project2\\demotest\\screenshot\\LoginSuccess.png"));
//		logger.info("Clicked on logib button");
		
		String title = driver.getTitle();
		System.out.println(title);
		if (title.equals("Users"))
		{
			Assert.assertTrue(true);
//			logger.info("Login Test Passed");
			System.out.println("Login test using excel data Passed");
		}
		else {
			Assert.assertTrue(false);
//			logger.info("Login Test Failed");
		}
	}

}
