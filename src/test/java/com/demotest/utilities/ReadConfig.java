package com.demotest.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig 
{
	Properties pro;
	public ReadConfig()
	{
		File src = new File("./configuration\\config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
			
		} catch (Exception e) 
		{
			System.out.println("Message info " +e.getMessage());
		}
	}
	public String getApplicationUrl()
	{
		String url = pro.getProperty("baseURL");
		return url;
	}
	public String setuserName()
	{
		String username = pro.getProperty("username");
		return username;
	}
	public String setuserPassWord()
	{
		String password = pro.getProperty("password");
		return password;
	}
	public String getChromePath()
	{
		String chromepath = pro.getProperty("chromepath");
		return chromepath;
	}
	public String getFireFoxPath()
	{
		String firefoxpath = pro.getProperty("firefoxpath");
		return firefoxpath;
	}
	
	public String getOldPassword()
	{
		String oldpassword = pro.getProperty("oldpassword");
		return oldpassword;
	}
	public String getNewPassword()
	{
		String newpassword= pro.getProperty("newpassword");
		return newpassword;
	}
	public String getConfirmPassword()
	{
		String confirmpassword = pro.getProperty("confirmpassword");
		return confirmpassword;
	}
	
	public String getvalidUserName()
	{
		String validusername = pro.getProperty("validusername");
		return validusername;
	}
	public String getInvalidPasword()
	{
		String invalidpassword = pro.getProperty("invalidpassword");
		return invalidpassword;
	}
	
}
