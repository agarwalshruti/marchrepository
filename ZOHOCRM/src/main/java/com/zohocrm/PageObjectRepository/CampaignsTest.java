package com.zohocrm.PageObjectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class CampaignsTest 
{
	//@FindBy(xpath="//input[@class='greenbtn btn_big floatL' and @value='Create Campaign']")
	//private WebElement createcampaignbutton;
	@FindBy(xpath="//div[@id='topRightIcons']/span[1]/input")
	private WebElement pluscreatebutton;
	@FindBy(id="Crm_Campaigns_CAMPAIGNNAME")
	private WebElement campaignname;
	@FindBy(xpath="//div[@id='Campaigns_fldRow_TYPE']/div[2]/div/span/span/span")
	private WebElement typedropdown;
	@FindBy(xpath="//div[@id='Campaigns_fldRow_STATUS']/div[2]/div/span/span/span")
	private WebElement statusdropdown;
	@FindBy(xpath="//ul[@id='select2-Crm_Campaigns_TYPE-results']//li/span[text()='Advertisement']")
    private WebElement typeadvertisement;
	@FindBy(xpath="//ul[@id='select2-Crm_Campaigns_STATUS-results']//li/span[text()='Complete']")
	private WebElement statuscomplete;
	@FindBy(id="saveCampaignsBtn_Bottom")
	private WebElement pageendsavebutton;
	@FindBys({@FindBy(xpath="//tbody[@id='lvTred']/tr[*]/td[3]/a")})
	private List<WebElement> lst;
	public void createCampaign(String campname) throws InterruptedException 
	{
		pluscreatebutton.click();
		//createcampaignbutton.click();
		Thread.sleep(3000);
		campaignname.sendKeys(campname);
		typedropdown.click();
		typeadvertisement.click();
		statusdropdown.click();
		statuscomplete.click();
		pageendsavebutton.click();	
	}
	public boolean verifyCampaignName(String campaignname)
	{
		boolean result=lst.contains(campaignname);
		return result;
		
	}
}
