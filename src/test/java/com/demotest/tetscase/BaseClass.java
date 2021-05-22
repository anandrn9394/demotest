package com.demotest.tetscase;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.demotest.exceldata.ExcelLibrary;
import com.demotest.utilities.ReadConfig;
import com.google.common.io.Files;

public class BaseClass 
{
	ReadConfig readconfig = new ReadConfig();
	
	public String baseURL=readconfig.getApplicationUrl();
	public String username=readconfig.setuserName();
	public String password=readconfig.setuserPassWord();
    public String oldpassword=readconfig.getOldPwd();
    public String newpassword=readconfig.getNewPwd();
    public String confirmpassword=readconfig.getConfirmPwd();
	public static WebDriver driver;
	public ExcelLibrary xlib;
	

	@Parameters("browser")
	@BeforeClass
	public void openBrowser(String br)
	{
		xlib= new ExcelLibrary();
		if (br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			Logger logger=Logger.getLogger("BaseClass");
			PropertyConfigurator.configure("log4j.properties");

		}else if (br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", readconfig.getFireFoxPath());
			driver = new FirefoxDriver();
			driver.manage().window().maximize();


		}
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
	}

}
