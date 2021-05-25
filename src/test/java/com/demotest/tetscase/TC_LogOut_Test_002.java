package com.demotest.tetscase;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.demotest.pageobjects.LoginPage;
import com.demotest.pageobjects.LogoutPage;
import com.google.common.io.Files;

public class TC_LogOut_Test_002 extends BaseClass
{
	@Test(priority=2)
	public void testLogOut() throws InterruptedException, IOException
	{
		LoginPage lp = new LoginPage(driver);
		driver.get(baseURL);
		lp.enterUserName(username);
		lp.enterUserPassword(password);
		lp.clickOnLogin();
		Thread.sleep(2000);
		LogoutPage lop= new LogoutPage(driver);
		lop.clickOnPersonI();
		WebElement logoutclick = driver.findElement(By.xpath("//a[text()='Logout']"));
		Actions act = new Actions(driver);
		act.moveToElement(logoutclick).perform();
		lop.logOut();
		
		File screenshot=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(screenshot, new File("C:\\Users\\Dhulappa R N\\Project2\\demotest\\screenshot\\LogOutSuccess.png"));
		
		String actualLoginPageTitle = driver.findElement(By.xpath("//h6[text()='Login To Your Account']")).getText();
		String expectedLoginPageTitle= "Login To Your Account";
		if (actualLoginPageTitle.equals(expectedLoginPageTitle))
		{
			Assert.assertTrue(true);
			System.out.println("Logout Test Passed");
			
		}
		else {
			Assert.assertTrue(false);
		}
				
		
	}

}
