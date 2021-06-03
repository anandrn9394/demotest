package com.demotest.tetscase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.demotest.pageobjects.AssignSchemeToWarehousePage;
import com.demotest.pageobjects.LoginPage;
import com.demotest.pageobjects.SchemeCreatePage;

public class AssignSchemeToWarehouse extends BaseClass
{
	@Test
	public void testAssignSchemeToWarehouse() throws InterruptedException
	{
		driver.get(baseURL);
		SchemeCreatePage scp = new SchemeCreatePage(driver);
		LoginPage lp = new LoginPage(driver);
		lp.enterUserName(username);
		lp.enterUserPassword(password);
		lp.clickOnLogin();
		AssignSchemeToWarehousePage assignschemetowar=new AssignSchemeToWarehousePage(driver);
		scp.clickOnMainMenu();
		scp.clickOnDiscountMenu();
		assignschemetowar.clickOnAssignScheme();
		assignschemetowar.clickOnHolderType();
		assignschemetowar.clickOnHolderTypeSearchField();
		Thread.sleep(2000);
		String holderTypeName = xlib.getExcelData("AssignScheme", 1, 0);
		Thread.sleep(2000);
		assignschemetowar.schemeHoldertype(holderTypeName);
		Thread.sleep(2000);
		WebElement holderType= driver.findElement(By.xpath("//body/div[@id='container']/div[3]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]/div[1]/ul[1]/li[4]/a[1]/label[1][contains(text(), "+holderTypeName+")]"));
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.moveToElement(holderType).perform();
		act.click(holderType).perform();
		
		Thread.sleep(3000);
		
		
		
	}

}
