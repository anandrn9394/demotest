package com.demotest.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SchemeCreatePage 
{
	WebDriver ldriver;
	public SchemeCreatePage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath="//div[text()=' Main Menu']")
	WebElement mainMenu;
	
	@FindBy(xpath="(//a[@title='Discounts'])[1]")
	WebElement discountslink;
	
	@FindBy(xpath="(//a[@title='New Scheme'])[2]")
	WebElement newScheme;

	@FindBy(xpath="//span[text()='Slab']")
	WebElement clickApplyType;

	@FindBy(xpath="//label[@title='Slab']")
	WebElement selectApplyTypeSlb;

	@FindBy(xpath="//label[@title='Prorated']")
	WebElement selectApplyTypePro;

	@FindBy(xpath="//input[@id='schemeName0']")
	WebElement textSchemeName;

	@FindBy(xpath="(//button[@title='None selected'])[2]")
	WebElement clickOnSelProduct;

	@FindBy(xpath="(//input[@placeholder='Search'])[3]")
	WebElement skuSearchField;

//	@FindBy(xpath="(//label[@title='- product2 upc:5'])[2]")
//	WebElement selSearchedSku;

	@FindBy(xpath="//input[@id='forQuantity0']")
	WebElement schmeQtys;

	@FindBy(xpath="//input[@id='freecashschemeSaverupee0']")
	WebElement saveCash;

	@FindBy(xpath="//input[@id='freecashschemeMaxsavecash0']")
	WebElement maxSaveCash;

	@FindBy(xpath="//input[@id='schemediscountpercent0']")
	WebElement schemeDiscount;

	@FindBy(xpath="//input[@id='startdate0']")
	WebElement schemeStartDatePicker;

	@FindBy(xpath="//input[@id='enddate0']")
	WebElement schemeEnddatePicker;

	@FindBy(xpath="(//select[@class='monthselect'])[1]")
	WebElement selectStartMonth;

	@FindBy(xpath="(//select[@class='monthselect'])[3]")
	WebElement selectEndMonth;

	@FindBy(xpath="//button[text()='Save all']")
	WebElement saveAllButton;


	public void clickOnMainMenu()
	{
		mainMenu.click();
	}
	
	public void clickOnDiscountMenu()
	{
		discountslink.click();
	}

	public void clickOnNewScheme()
	{
		newScheme.click();
	}

	public void clickOnApplyTypeButton()
	{
		clickApplyType.click();
	}

	public void selectApplyTypeSlab()
	{

		Actions act= new Actions(ldriver);
		act.moveToElement(selectApplyTypeSlb).perform();
		act.click(selectApplyTypeSlb).perform();

	}

	public void selectApplyTypeProrated()
	{

		Actions act= new Actions(ldriver);
		act.moveToElement(selectApplyTypePro).perform();
		act.click(selectApplyTypePro).perform();

	}

	public void enterSchemeName(String schemename)
	{
		textSchemeName.sendKeys(schemename);

	}

	public void clickOnSelProductButton()
	{
		clickOnSelProduct.click();
	}

	public void clickOnEnterProductSearchField()
	{
		skuSearchField.click();

	}

	public void enterSkuName(String nameOfSku)
	{
		skuSearchField.sendKeys(nameOfSku);

	}

//	public void selectSku()
//	{
//		Actions act= new Actions(ldriver);
//		act.moveToElement(selSearchedSku).perform();
//		act.click(selSearchedSku).perform();
//	}

	public void enterSchemeForQty(String forqty)
	{
		schmeQtys.sendKeys(forqty);
	}

	public void enterSchemeSaveCash(String savecash)
	{
		saveCash.sendKeys(savecash);
	}

	public void enterSchemeMaxSaveCash(String maxsavecash)
	{
		maxSaveCash.sendKeys(maxsavecash);
	}

	public void enterSchemeDiscountPercent(String discpercent)
	{
		schemeDiscount.sendKeys(discpercent);
	}

	public void clickOnStartDateField()
	{
		schemeStartDatePicker.click();
	}

	public void clickOnEndDateField()
	{
		schemeEnddatePicker.click();
	}

	public void selectSchemeStartMonth(String startMonth)
	{
		Select sel= new Select(selectStartMonth);
		sel.selectByVisibleText(startMonth);
	}

	public void selectSchemeEndMonth(String endMonth)
	{
		Select sel= new Select(selectEndMonth);
		sel.selectByVisibleText(endMonth);
	}

	public void clickOnSaveAllButton()
	{
		saveAllButton.click();
	}
}
