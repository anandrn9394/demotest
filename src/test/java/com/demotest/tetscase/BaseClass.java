package com.demotest.tetscase;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.demotest.exceldata.ExcelLibrary;
import com.demotest.extentreport.ExtentReport;
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
	public static WebDriver driver;
	public ExcelLibrary xlib;
	public ExtentReport extrep;
	

	@Parameters("browser")
	@BeforeClass
	public void openBrowser(String br)
	{
		extrep=new ExtentReport();
		xlib= new ExcelLibrary();
		if (br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            

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
