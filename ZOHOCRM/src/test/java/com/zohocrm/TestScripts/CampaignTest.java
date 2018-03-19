package com.zohocrm.TestScripts;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.zohocrm.GenericLib.BaseClass;
import com.zohocrm.GenericLib.Excellib;
import com.zohocrm.GenericLib.ObjectClass;
import com.zohocrm.GenericLib.WebDriverCommonLibrary;
@Listeners(com.zohocrm.GenericLib.SampleListener.class)
public class CampaignTest  extends BaseClass
{
	
	Excellib excellib=new Excellib();
	WebDriverCommonLibrary webdrivercommonlib =new WebDriverCommonLibrary();
	ObjectClass objclass=new ObjectClass();

	@Test(priority=1)
	public void createCampaignTest() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		Logger logresult=Logger.getLogger("TestLog");
		PropertyConfigurator.configure("log4j.properties");
		logger=extent.startTest("CreateCampaign Test");
		objclass.objects();
		logresult.info("Campaigns Link Click");
		objclass.homepagetest.campaignsClick();
		logresult.info("Navigating to Campaigns page");
		logger.log(LogStatus.INFO,"Navigate to Campaigns page");
		String campignname=excellib.getExcelData("CampaignsTest",1,1);
		objclass.campaignstest.createCampaign(campignname);
		String campaignowner=excellib.getExcelData("CampaignsTest",1,2);
		String status=excellib.getExcelData("CampaignsTest",1,3);
		String type=excellib.getExcelData("CampaignsTest",1,4);
		webdrivercommonlib.maximizeBrowserWindow();
		logresult.info("CampaignsCreated");
		logger.log(LogStatus.INFO,"Navigating to Campaigns Details page");
		logresult.info("Navigating to Campaigns Details page");
		String actualcampaigndetitle=excellib.getExcelData("CampaignsTest",1,10);//9
		webdrivercommonlib.waitForElementToLoadForTitleIsPresent(actualcampaigndetitle);
		
		String campaigndetailspagetitle=webdrivercommonlib.getTitle();
		
		System.out.println(actualcampaigndetitle);
		System.out.println(campaigndetailspagetitle);
		
		Assert.assertEquals(actualcampaigndetitle, campaigndetailspagetitle);
		String campname=objclass.campaignsdetailstest.campaignNameValue();
		String campowner=objclass.campaignsdetailstest.campaignOwnerValue();
		String camptype=objclass.campaignsdetailstest.campaignTypeValue();
		String campstatus=objclass.campaignsdetailstest.campaignStatusValue();
		Assert.assertEquals(campname,campignname);
		Assert.assertEquals(campowner,campaignowner);
		Assert.assertEquals(campstatus,status);
		Assert.assertEquals(camptype,type);
		logger.log(LogStatus.INFO,"Verify Campaigns Details page");
		
	}
@Test(priority=2)
	public void createAndDeleteCampaignTest() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		logger=extent.startTest("createAndDeletecampaignTest");
		objclass.objects();
		objclass.homepagetest.campaignsClick();
		logger.log(LogStatus.INFO,"Navigate to Campaigns Page");
		String campignname=excellib.getExcelData("CampaignsTest",4,1);
		objclass.campaignstest.createCampaign(campignname);
		webdrivercommonlib.maximizeBrowserWindow();
		//Thread.sleep(3000);
		
		logger.log(LogStatus.INFO,"Navigate to Campaigns Details Page");
		String actualcampaigndetitle=excellib.getExcelData("CampaignsTest",4,2);
		webdrivercommonlib.waitForElementToLoadForTitleIsPresent(actualcampaigndetitle);
		String campaigndetailspagetitle=webdrivercommonlib.getTitle();
		Assert.assertEquals(actualcampaigndetitle, campaigndetailspagetitle);
		objclass.campaignsdetailstest.threeCornerDotsClick();
		objclass.campaignsdetailstest.deleteClick();
		objclass.campaignsdetailstest.popUpDeleteClick();
		logger.log(LogStatus.INFO,"Navigate to Campaigns page");
		String actualcampaignspagetitle=excellib.getExcelData("CampaignsTest",4,3);
		webdrivercommonlib.waitForElementToLoadForTitleIsPresent(actualcampaignspagetitle);
		String campaignspagetitle=webdrivercommonlib.getTitle();
		System.out.println(campaignspagetitle);
		
		System.out.println(actualcampaignspagetitle);
		
		Assert.assertEquals(actualcampaignspagetitle,campaignspagetitle);
		boolean result=objclass.campaignstest.verifyCampaignName(campignname);
		Assert.assertFalse(result);
	
		
		}
	

}
