package com.demotest.tetscase;

import java.io.File;
import java.io.IOException;

import org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.demotest.extentreport.ExtentReport;
import com.demotest.pageobjects.LoginPage;
import com.google.common.io.Files;

public class TC_LoginTest_001 extends BaseClass
{
	@Test(priority=1)
	public void testLogin() throws IOException
	{
		LoginPage lp = new LoginPage(driver);

		driver.get(baseURL);
		logger.info("Opened WebApplication url");
		
		lp.enterUserName(username);
		logger.info("Entered User Name");
		
		lp.enterUserPassword(password);
		logger.info("Entered Password");
		
		lp.clickOnLogin();
		logger.info("Clicked On Login");
	
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(screenshot, new File("C:\\Users\\Dhulappa R N\\Project2\\demotest\\screenshot\\LoginSuccess.png"));
		logger.info("Login Page Screenshot Taken");
		
        String title = driver.getTitle();
        logger.info("Captured the Login page Title");
		
		System.out.println(title);
		logger.info("Printed the Title on console");
		
		if (title.equals("Users"))
		{
			Assert.assertTrue(true);
			logger.info("Login Test passed");
			
		}
		else {
			Assert.assertTrue(false);
			logger.info("Login Test Failed");
			
		}

	}

}
