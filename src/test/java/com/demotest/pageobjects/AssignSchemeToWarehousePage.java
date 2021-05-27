package com.demotest.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AssignSchemeToWarehousePage 
{
	WebDriver ldriver;
	public AssignSchemeToWarehousePage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(xpath="//a[@title='Assign Schemes']")
	WebElement assignSchemeLink;
	
	@FindBy(xpath="//button[@title='Select Holder type']")
    WebElement holdertype;
	
	@FindBy(xpath="(//input[@placeholder='Search'])[1]")
    WebElement holdertypesearchfield;
	
	@FindBy(xpath="(//button[@title='None selected'])[1]")
	WebElement zoneholder;
	
	@FindBy(xpath="(//input[@placeholder='Search'])[2]")
	WebElement zonesearchfield;
	
	@FindBy(xpath="(//button[@title='None selected'])[3]")
	WebElement subzoneholder;
	
	@FindBy(xpath="(//input[@placeholder='Search'])[5]")
	WebElement subzonesearchfield;
	
	@FindBy(xpath="(//button[@title='None selected'])[4]")
	WebElement warehouseschemeholder;
	
	@FindBy(xpath="(//input[@placeholder='Search'])[7]")
	WebElement schemeholdersearchfield;
	
	@FindBy(xpath="(//button[@title='None selected'])[13]")
	WebElement selectscheme;
	
	@FindBy(xpath="(//input[@placeholder='Search'])[14]")
    WebElement selectschemesearchfield;
	
	@FindBy(xpath="//button[text()='Assign Scheme']")
	WebElement assignschemebutton;
}
