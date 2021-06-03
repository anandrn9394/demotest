package com.demotest.tetscase;

import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.demotest.exceldata.ExcelLibrary;
import com.demotest.utilities.ReadConfig;


public class BaseClass 
{
	ReadConfig readconfig = new ReadConfig();	
	public String baseURL=readconfig.getApplicationUrl();
	public String username=readconfig.setuserName();
	public String password=readconfig.setuserPassWord();

	public String oldpassword=readconfig.getOldPassword();
	public String newpassword=readconfig.getNewPassword();
	public String confirmpassword=readconfig.getConfirmPassword();
  
    public String validusername=readconfig.getvalidUserName();
    public String invalidpassword=readconfig.getInvalidPasword();
//    public String schemeindex=readconfig.getSchemeIndex();
	public static WebDriver driver;
	public ExcelLibrary xlib;
	
	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void openBrowser(String br)
	{
		logger=Logger.getLogger("demotest");
		PropertyConfigurator.configure("log4j.properties");
		
		xlib= new ExcelLibrary();
		if (br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			logger.info("Opened Chrome Browser");
			
		}else if (br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", readconfig.getFireFoxPath());
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			logger.info("Opened FireFox Browser");
			

		}
	}
/*	public static String decodePassword(String password)
	{
		byte[] decodedPwd = Base64.decodeBase64(password);
		return(new String(decodedPwd));
		
	}*/

	@AfterClass
	public void closeBrowser()
	{
		driver.close();
	}

}
