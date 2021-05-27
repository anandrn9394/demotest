package com.demotest.extentreport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentReport 
{
	public WebDriver driver;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	@BeforeTest
	public void setExtent()
	{
		htmlReporter=new ExtentHtmlReporter("C:\\Users\\Dhulappa R N\\Project2\\demotest\\Reports");
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Functional Test Report");
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("HostName", "Local Host");
		extent.setSystemInfo("OS", "Windows10");
		extent.setSystemInfo("Tester Name", "Dhulappa RN");
		extent.setSystemInfo("Browser", "Chrome");
		
	}
	@AfterTest
	public void endReport()
	{
		extent.flush();
	}
	
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dhulappa R N\\Project2\\demotest\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://devpuma.bizomdev.in/");
	}
	@Test
	public void loginTest()
	{
		test=extent.createTest("loginTest");
		String title= driver.getTitle();
		System.out.println(title);
	}
	
	@AfterMethod
	public void Result(ITestResult result)
	{
		if (result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL, "Test Case Failed Is" +result.getName());
			test.log(Status.FAIL, "Test Case Failed Is" +result.getThrowable());
			
		}
		else if (result.getStatus()==ITestResult.SKIP)
		{
			test.log(Status.SKIP, "Test Case Skipped is" +result.getName());
			
		}
		else if (result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, "Test Case Passed is" +result.getName());
			
		}
	}

}
