package com.zohocrm.PageObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.zohocrm.GenericLib.WebDriverCommonLibrary;

public class CampaignsDetailsTest 
{
	WebDriverCommonLibrary webdrivercommonlib =new WebDriverCommonLibrary();
	@FindBy(xpath="//table[@id='tableId']/tbody/tr[1]/td[2]/span[2]")
	private WebElement campaignownername;
	@FindBy(xpath="//tr[@id='detailViewButtonLayerMainTableRow']/td[2]/div/span[contains(@class,'dvTitle dIB')]/span[3]/span")
	private WebElement campaignname;
	@FindBy(xpath="//table[@id='tableId']/tbody/tr[2]/td[2]/span[2]")
	private WebElement campaigntype;
	@FindBy(xpath="//table[@id='tableId']/tbody/tr[3]/td[2]/span[2]")
	private WebElement campaignstatus;
	@FindBy(xpath="//span[@id='CustomizeTools']")
	private WebElement threedotscorner;
	@FindBy(xpath="//div[@id='customizedd']/ul/li[2]/a")
	private WebElement delete;
	@FindBy(xpath="//input[@id='deleteButton']")
	private WebElement popupdelete;
	
	public String campaignOwnerValue()
	{
		return campaignownername.getText();
	}
	public String campaignNameValue()
	{
		return campaignname.getText();
	}
	public String campaignTypeValue()
	{
		return campaigntype.getText();
	}
	public String campaignStatusValue()
	{
		return campaignstatus.getText();
	}
	public void threeCornerDotsClick()
	{
		webdrivercommonlib.waitForElementToLoadForPresenceOfElementLocated("xpath", "//span[@id='CustomizeTools']");
		threedotscorner.click();
		
	}
	public void deleteClick()
	{
		delete.click();	
	}
	public void popUpDeleteClick()
	{
		//webdrivercommonlib.waitForElementToLoadForPresenceOfElementLocated("xpath","//input[@id='deleteButton']");
		popupdelete.click();
	}
	
}
