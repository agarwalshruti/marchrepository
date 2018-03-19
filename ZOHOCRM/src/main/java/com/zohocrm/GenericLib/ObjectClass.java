package com.zohocrm.GenericLib;

import org.openqa.selenium.support.PageFactory;

import com.zohocrm.PageObjectRepository.CampaignsDetailsTest;
import com.zohocrm.PageObjectRepository.CampaignsTest;
import com.zohocrm.PageObjectRepository.HomePageTest;
import com.zohocrm.PageObjectRepository.SignOutTest;
import com.zohocrm.PageObjectRepository.ZohoAccountsTest;
import com.zohocrm.PageObjectRepository.ZohoCRMTest;

public class ObjectClass 
{
	public ZohoCRMTest zohocrmtest=null;
	public ZohoAccountsTest zohoaccountstest=null;
	public HomePageTest homepagetest=null;
	public CampaignsTest campaignstest=null;
	public CampaignsDetailsTest campaignsdetailstest=null;
	public SignOutTest signouttest=null;
	
	public void objects()
	{
	zohocrmtest=PageFactory.initElements(BaseClass.driver, ZohoCRMTest.class);
    zohoaccountstest=PageFactory.initElements(BaseClass.driver, ZohoAccountsTest.class);
	homepagetest=PageFactory.initElements(BaseClass.driver,HomePageTest.class);
	campaignstest=PageFactory.initElements(BaseClass.driver,CampaignsTest.class);
	campaignsdetailstest=PageFactory.initElements(BaseClass.driver,CampaignsDetailsTest.class);
	signouttest=PageFactory.initElements(BaseClass.driver,SignOutTest.class);

	}
}
