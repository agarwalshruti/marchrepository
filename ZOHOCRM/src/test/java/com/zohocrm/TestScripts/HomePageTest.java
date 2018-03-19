package com.zohocrm.TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.zohocrm.GenericLib.BaseClass;
import com.zohocrm.GenericLib.Excellib;
import com.zohocrm.GenericLib.ObjectClass;
import com.zohocrm.GenericLib.WebDriverCommonLibrary;

public class HomePageTest extends BaseClass
{
	Excellib excellib=new Excellib();
	WebDriverCommonLibrary webdrivercommonlib=new WebDriverCommonLibrary();
	ObjectClass objclass=new ObjectClass();
	@Test(priority=3)
	public void customizeHomePage() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		ExtentTest logger=extent.startTest("customizeHomePage");
		objclass.objects();
		Thread.sleep(3000);
		webdrivercommonlib.maximizeBrowserWindow();
		Thread.sleep(3000);
		logger.log(LogStatus.INFO,"Navigate to addcomponent popup");
		objclass.homepagetest.addComponentClick();
		objclass.homepagetest.customViewClick();
		objclass.homepagetest.popupLeadsClick();
		String leadsname=excellib.getExcelData("Sheet2",1,1);
		Thread.sleep(3000);
		objclass.homepagetest.popupLeadsSearch(leadsname);
		webdrivercommonlib.actionsKeyboardKeys(Keys.ENTER);
		Thread.sleep(2000);
		objclass.homepagetest.popUpSelect();
		objclass.homepagetest.popUpSelectAllInvoices();
		String componentname=excellib.getExcelData("Sheet2",1,2);
		objclass.homepagetest.componentName(componentname);
		objclass.homepagetest.popupSaveClick();
		String pagetitle=webdrivercommonlib.getTitle();
		String actualpagetitle=excellib.getExcelData("Sheet2",1,2);
		Assert.assertEquals(actualpagetitle, pagetitle);
		extent.endTest(logger);
		
	}
}
