package com.zohocrm.PageObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.zohocrm.GenericLib.WebDriverCommonLibrary;

public class HomePageTest 
{
	WebDriverCommonLibrary w=new WebDriverCommonLibrary();
	@FindBy(id="menu_more")//e
	private WebElement menuwrapper;
	@FindBy(xpath="//a[@id='tab_Campaigns']")
	private WebElement menuwrapcampaigns;
	@FindBy(id="srch")
	private WebElement searchmenuwrapper;
	@FindBy(xpath="//ul[@id='moreMenuLi']//li/a[contains(text(),'Campaigns')]")
	private WebElement menuwrappercampaigns;
	@FindBy(xpath="//div[@id='addNewComponent']")
	private WebElement addcomponent;
	@FindBy(xpath="//label[contains(text(),'Custom View')]/input")
	private WebElement customview;
	@FindBy(xpath="//span[@id='select2-module-container']")
	private WebElement popupleads;
	@FindBy(xpath="//input[@type='search']")
	private WebElement popupleadssearch;
	@FindBy(xpath="//span[text()='Select']")
	private WebElement popupselect;
	@FindBy(xpath="//span[text()=' All Invoices']")
	private WebElement popupselectallinvoices;
	@FindBy(xpath="//input[@id='layoutName']")
	private WebElement componentname;
	@FindBy(xpath="//button[@id='saveEditComponentDiv']")
	private WebElement popupsave;
	@FindBy(xpath="//li[@id='select2-module-result-8wsr-Invoices']")
	private WebElement popupleadsfirstsearch;
	public void campaignsClick() throws InterruptedException
	{
		menuwrapper.click();
		//searchmenuwrapper.sendKeys("Campaigns");
		//menuwrappercampaigns.click();
		menuwrapcampaigns.click();
		Thread.sleep(3000);
	}
	public void addComponentClick()
	{
		addcomponent.click();
	}
	public void customViewClick()
	{
		customview.click();
	}
	public void popupLeadsClick()
	{
		popupleads.click();
	}
	public void popupLeadsSearch(String name)
	{
		popupleadssearch.sendKeys(name);	
		
	}
	public void popUpSelect()
	{
		popupselect.click();
		
	}
	public void popUpSelectAllInvoices()
	{
		popupselectallinvoices.click();
		
	}
	public void componentName(String name)
	{
		componentname.sendKeys(name);
	}
	public void popupSaveClick()
	{
		popupsave.click();
	}


}
