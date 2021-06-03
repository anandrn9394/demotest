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

	@FindBy(xpath="(//a[@title='Assign Schemes'])[2]")
	WebElement assignSchemeLink;

	@FindBy(xpath="//button[@title='Select Holder type']")
	WebElement holdertype;

	@FindBy(xpath="(//input[@placeholder='Search'])[1]")
	WebElement holdertypesearchfield;

	@FindBy(xpath="(//button[@title='None selected'])[1]")
	WebElement selzone;

	@FindBy(xpath="(//input[@placeholder='Search'])[2]")
	WebElement zonesearchfield;

	@FindBy(xpath="(//button[@title='None selected'])[3]")
	WebElement subzone;

	@FindBy(xpath="(//input[@placeholder='Search'])[5]")
	WebElement subzonesearchfield;

	@FindBy(xpath="(//button[@title='None selected'])[4]")
	WebElement warehouseschemeholder;

	@FindBy(xpath="(//input[@placeholder='Search'])[7]")
	WebElement selwarehousesearchfield;

	@FindBy(xpath="(//button[@title='None selected'])[13]")
	WebElement selectscheme;

	@FindBy(xpath="(//input[@placeholder='Search'])[14]")
	WebElement selectschemesearchfield;

	@FindBy(xpath="//button[text()='Assign Scheme']")
	WebElement assignschemebutton;

	public void clickOnAssignScheme()
	{
		assignSchemeLink.click();
	}
	
	public void clickOnHolderType()
	{
		holdertype.click();
	}
	
	public void clickOnHolderTypeSearchField()
	{
		holdertypesearchfield.click();
	}
	public void schemeHoldertype(String holdertype)
	{
		holdertypesearchfield.sendKeys(holdertype);
	}
	
	public void clickOnselzone()
	{
		selzone.click();
	}
	
	public void clickOnzoneSearchField()
	{
		zonesearchfield.click();
	}
	public void enterZoneName(String zoneName)
	{
		zonesearchfield.sendKeys(zoneName);
	}
	
	public void clickOnSubZone()
	{
		subzone.click();
	}
	
	public void clickOnSubZoneSearchField()
	{
		subzonesearchfield.click();
	}
	public void enterSubZoneName(String subzoneName)
	{
		subzonesearchfield.sendKeys(subzoneName);
	}
	
	public void clickOnSelWarehousedistributor()
	{
		warehouseschemeholder.click();
	}
	
	public void clickOnSelWarehouseDistributor()
	{
		selwarehousesearchfield.click();
	}
	public void enterHolderName(String holderName)
	{
		selwarehousesearchfield.sendKeys(holderName);
	}
	
	public void clickOnSelScheme()
	{
		selectscheme.click();
	}
	
	public void clickOnSelSchemeSearchField()
	{
		selectschemesearchfield.click();
	}
	public void enterSchemeNameToSelect(String schemename)
	{
		selectschemesearchfield.sendKeys(schemename);
	}
	
	
	public void clickOnAssignSchemeButton()
	{
		assignschemebutton.click();
	}

}
