package com.demotest.tetscase;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.demotest.pageobjects.LoginPage;
import com.demotest.pageobjects.SchemeCreatePage;
import com.google.common.io.Files;

public class TC_SchemeAdd_Test_001 extends BaseClass
{
	@Test(priority=5)
	public void testSchemeAdd() throws InterruptedException, IOException
	{
		LoginPage lp = new LoginPage(driver);
		driver.get(baseURL);
		lp.enterUserName(username);
		lp.enterUserPassword(password);
		lp.clickOnLogin();
		SchemeCreatePage scp=new SchemeCreatePage(driver);
		scp.clickOnMainMenu();
		scp.clickOnDiscountMenu();
		scp.clickOnNewScheme();
		scp.clickOnApplyTypeButton();
		Thread.sleep(3000);
		scp.selectApplyTypeSlab();
		Thread.sleep(3000);
		String schemeName = xlib.getExcelData("CreateScheme", 1, 0);
		scp.enterSchemeName(schemeName);
		scp.clickOnSelProductButton();
		Thread.sleep(3000);
		scp.clickOnEnterProductSearchField();
		String skuName = xlib.getExcelData("CreateScheme", 1, 1);
		scp.enterSkuName(skuName);
		Thread.sleep(3000);
		String sku = xlib.getExcelData("CreateScheme", 1, 1);
		String forsku=sku;
		WebElement schemeSku= driver.findElement(By.xpath("//tbody/tr[@id='schemeRow0']/td[3]/span[1]/div[1]/ul/li/a/label[1][contains(text, "+sku+" )]"));
		schemeSku.click();
	
		//scp.selectSku();
		Thread.sleep(3000);
		String forSchemeQuantities = xlib.getExcelData("CreateScheme", 1, 2);
		scp.enterSchemeForQty(forSchemeQuantities);
		Thread.sleep(2000);
		String schemeSaveCash = xlib.getExcelData("CreateScheme", 1, 3);
		scp.enterSchemeSaveCash(schemeSaveCash);
		String maxSchemeSaveCash =xlib.getExcelData("CreateScheme", 1, 4);
		scp.enterSchemeMaxSaveCash(maxSchemeSaveCash);
		String schemeDiscountPer=xlib.getExcelData("CreateScheme", 1, 5);
		scp.enterSchemeDiscountPercent(schemeDiscountPer);
		
		scp.clickOnStartDateField();
		String schemeStartMonth = xlib.getExcelData("CreateScheme", 1, 6);
		scp.selectSchemeStartMonth(schemeStartMonth);
		Thread.sleep(3000);
		
		String schemeStartDate = xlib.getExcelData("CreateScheme", 1, 8);
		String startDay=schemeStartDate;
		driver.findElement(By.xpath("//body[1]/div[11]/div[2]/div[1]/table[1]/tbody[1]/tr/td[contains(text(), "+startDay+")]")).click();
		
		scp.clickOnEndDateField();
		String schemeEndMonth = xlib.getExcelData("CreateScheme", 1, 7);
		scp.selectSchemeEndMonth(schemeEndMonth);
		
		String schemeEndDate = xlib.getExcelData("CreateScheme", 1, 9);
		String endDay=schemeEndDate;
		driver.findElement(By.xpath("//body[1]/div[12]/div[2]/div[1]/table[1]/tbody[1]/tr/td[contains(text(), "+endDay+")]")).click();
		
		scp.clickOnSaveAllButton();
		
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(screenshot, new File("C:\\Users\\Dhulappa R N\\Project2\\demotest\\screenshot\\SchemeAddSuccess.png"));
		
		String actualSuccessMessage = driver.findElement(By.xpath("//div[@id='flashMessage']")).getText();
		String expectedSuccessMessage="Schemes saved successfully.";
		if (actualSuccessMessage.equals(expectedSuccessMessage)) 
		{
			Assert.assertTrue(true);
			System.out.println("Scheme Add Test Passed");
			
		}
		else 
		{
			Assert.assertTrue(false);
		}
		
		
   }

}
