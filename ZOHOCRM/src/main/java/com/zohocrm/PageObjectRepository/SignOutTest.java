package com.zohocrm.PageObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.zohocrm.GenericLib.WebDriverCommonLibrary;

public class SignOutTest 
{
	WebDriverCommonLibrary webdrivercommonlib =new WebDriverCommonLibrary();
	@FindBy(id="topdivuserphoto_3113219000000147013")
	private WebElement toproundlogo;
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signoutbutton;
	public void signOut()
	{
		webdrivercommonlib.waitForElementToLoadForPresenceOfElementLocated("id","topdivuserphoto_3113219000000147013");
		toproundlogo.click();
		signoutbutton.click();
	}

}

