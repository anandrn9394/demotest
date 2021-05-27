package com.demotest.tetscase;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.demotest.pageobjects.LoginPage;
import com.google.common.io.Files;

public class TC_LoginTest_With_Invalid_Credentials_004 extends BaseClass
{
	@Test(priority=3)
	public void testLoginWithInvalidCred() throws IOException, InterruptedException
	{
		
		LoginPage lp= new LoginPage(driver);
		driver.get(baseURL);
		lp.enterUserName(validusername);
		lp.enterUserPassword(invalidpassword);
		Thread.sleep(2000);
		lp.clickOnLogin();
		
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(screenshot, new File("C:\\Users\\Dhulappa R N\\Project2\\demotest\\screenshot\\LoginFailedErrorMessage.png"));
		
		String actualErrorMessage = driver.findElement(By.xpath("//div[@id='flashMessage']")).getText();
		String expectedErrorMessage="Invalid / inactive account specified";
		
		if (actualErrorMessage.equals(expectedErrorMessage))
		{
			Assert.assertTrue(true);
			
			
		}
		else {
			Assert.assertTrue(false);
		}
		
	}

}
