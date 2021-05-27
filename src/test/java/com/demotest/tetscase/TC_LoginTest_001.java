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
		lp.enterUserName(username);
		lp.enterUserPassword(password);
		lp.clickOnLogin();
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(screenshot, new File("C:\\Users\\Dhulappa R N\\Project2\\demotest\\screenshot\\LoginSuccess.png"));


		String title = driver.getTitle();
		System.out.println(title);
		if (title.equals("Users"))
		{
			Assert.assertTrue(true);
			
			System.out.println("Login Test Pass");
		}
		else {
			Assert.assertTrue(false);
			
		}

	}

}
