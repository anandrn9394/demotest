package com.demotest.tetscase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demotest.pageobjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass
{
	@Test(priority=1)
	public void testLogin()
	{
		LoginPage lp = new LoginPage(driver);
		driver.get(baseURL);
		lp.enterUserName(username);
		lp.enterUserPassword(password);
		lp.clickOnLogin();
		String title = driver.getTitle();
		System.out.println(title);
		if (title.equals("Users"))
		{
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}

	}

}
