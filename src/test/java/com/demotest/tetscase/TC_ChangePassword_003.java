package com.demotest.tetscase;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.demotest.pageobjects.LoginPage;
import com.demotest.pageobjects.LogoutPage;	
import com.google.common.io.Files;
import com.graphbuilder.math.func.LgFunction;

public class TC_ChangePassword_003 extends BaseClass
{
	@Test(priority=6)
	public void testChangePassword() throws InterruptedException, IOException
	{
		driver.get(baseURL);
		LoginPage lp = new LoginPage(driver);
		lp.enterUserName(username);
		lp.enterUserPassword(password);
		lp.clickOnLogin();
		LogoutPage lop = new LogoutPage(driver);
		lop.clickOnPersonI();
		WebElement changepwd = driver.findElement(By.id("changeownpwd"));
		Actions act = new Actions(driver);
		act.moveToElement(changepwd).perform();
		act.click(changepwd).perform();
		Thread.sleep(3000);
		lop.enterOldPassword(oldpassword);
		lop.enterNewPassword(newpassword);
		lop.enterConfirmPassword(confirmpassword);
		lop.clickOnChangePwdButton();
		
		Thread.sleep(3000);
		//Take screenshot of pwd changed msg
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(screenshot, new File("C:\\Users\\Dhulappa R N\\Project2\\demotest\\screenshot\\ChangePwdSuccess.png"));
		
				
		String successMessage = driver.findElement(By.xpath("//div[text()='Successfully changed password']")).getText();
		if (successMessage.equals("Successfully changed password"))
		{
			Assert.assertTrue(true);
			System.out.println("Change password test pass");
			
		}
		else {
			Assert.assertTrue(false);
		}
		

	}
	

}
