package com.demotest.tetscase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.demotest.pageobjects.LoginPage;
import com.demotest.pageobjects.LogoutPage;

public class TC_LogOut_Test_002 extends BaseClass
{
	@Test(priority=2)
	public void testLogOut() throws InterruptedException
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
				
		
	}

}
