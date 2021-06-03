package com.demotest.tetscase;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
	@Test
	public void testSchemeAdd() throws InterruptedException, IOException, SQLException
	{
		
		LoginPage lp = new LoginPage(driver);
		driver.get(baseURL);
		logger.info("Opened WebApplication Url");
		lp.enterUserName(username);
		logger.info("Entered User Name");
		lp.enterUserPassword(password);
		logger.info("Entered Password");
		lp.clickOnLogin();
		logger.info("Clicked on Login");
		SchemeCreatePage scp=new SchemeCreatePage(driver);
		scp.clickOnMainMenu();
		logger.info("Clicked on Main Menu");
		scp.clickOnDiscountMenu();
		logger.info("Clicked on Discounts Menu");
		scp.clickOnNewScheme();
		logger.info("Clicked on New Scheme Menu");
		scp.clickOnApplyTypeButton();
		logger.info("Clicked on Apply Type drop down");
		Thread.sleep(3000);
		scp.selectApplyTypeSlab();
		logger.info("Selected Apply Type");
		Thread.sleep(3000);
		String schemeName = xlib.getExcelData("CreateScheme", 1, 0);
		scp.enterSchemeName(schemeName);
		logger.info("Entered scheme Name in scheme Name field");
		scp.clickOnSelProductButton();
		logger.info("Clicked on Select Product button");
		Thread.sleep(3000);
		scp.clickOnEnterProductSearchField();
		logger.info("Clicked on search field under sel product");
		String skuName = xlib.getExcelData("CreateScheme", 1, 1);
		scp.enterSkuName(skuName);
		logger.info("Entered the For Sku Name");
		Thread.sleep(3000);
		String sku = xlib.getExcelData("CreateScheme", 1, 1);
		String forsku=sku;
		WebElement schemeSku= driver.findElement(By.xpath("//tbody/tr[@id='schemeRow0']/td[3]/span[1]/div[1]/ul/li/a/label[1][contains(text, "+sku+" )]"));
		schemeSku.click();
		logger.info("Clicked on Searched for skunit");
	
		//scp.selectSku(); 
		Thread.sleep(3000);
		String forSchemeQuantities = xlib.getExcelData("CreateScheme", 1, 2);
		scp.enterSchemeForQty(forSchemeQuantities);
		logger.info("Entered scheme For quantities");
		Thread.sleep(2000);
		String schemeSaveCash = xlib.getExcelData("CreateScheme", 1, 3);
		scp.enterSchemeSaveCash(schemeSaveCash);
		logger.info("Entered save cash");
		String maxSchemeSaveCash =xlib.getExcelData("CreateScheme", 1, 4);
		scp.enterSchemeMaxSaveCash(maxSchemeSaveCash);
		logger.info("Entered Max save cash");
		String schemeDiscountPer=xlib.getExcelData("CreateScheme", 1, 5);
		scp.enterSchemeDiscountPercent(schemeDiscountPer);
		logger.info("Entered scheme discount %");
		
		scp.clickOnStartDateField();
		logger.info("Clicked on Start date field");
		String schemeStartMonth = xlib.getExcelData("CreateScheme", 1, 6);
		scp.selectSchemeStartMonth(schemeStartMonth);
		logger.info("Selected scheme start month from date picker");
		Thread.sleep(3000);
		
		String schemeStartDate = xlib.getExcelData("CreateScheme", 1, 8);
		String startDay=schemeStartDate;
		driver.findElement(By.xpath("//body[1]/div[11]/div[2]/div[1]/table[1]/tbody[1]/tr/td[contains(text(), "+startDay+")]")).click();
		logger.info("Selected scheme start day/date from date picker");
		scp.clickOnEndDateField();
		logger.info("Clicked on End date field from date picker");
		String schemeEndMonth = xlib.getExcelData("CreateScheme", 1, 7);
		scp.selectSchemeEndMonth(schemeEndMonth);
		logger.info("Selected scheme end month from date picker");
		
		String schemeEndDate = xlib.getExcelData("CreateScheme", 1, 9);
		String endDay=schemeEndDate;
		driver.findElement(By.xpath("//body[1]/div[12]/div[2]/div[1]/table[1]/tbody[1]/tr/td[contains(text(), "+endDay+")]")).click();
		logger.info("Selected scheme end day/date from date picker");
		scp.clickOnSaveAllButton();
		logger.info("Clicked on save all button");
		
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(screenshot, new File("C:\\Users\\Dhulappa R N\\Project2\\demotest\\screenshot\\SchemeAddSuccess.png"));
		logger.info("After adding scheme, captured screenshot and stored in screenshot folder");
		
		String actualSuccessMessage = driver.findElement(By.xpath("//div[@id='flashMessage']")).getText();
		String expectedSuccessMessage="Schemes saved successfully.";
		if (actualSuccessMessage.equals(expectedSuccessMessage)) 
		{
			Assert.assertTrue(true);
			logger.info("compared expected success message and actual: Both Matched");
			
		}
		else 
		{
			Assert.assertTrue(false);
			logger.info("compared expected success message and actual: Both Not Matched");
		}
		
		
   }

}
