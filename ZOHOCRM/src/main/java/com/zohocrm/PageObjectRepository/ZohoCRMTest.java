package com.zohocrm.PageObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ZohoCRMTest 
{
	@FindBy(xpath="//div[@class='header']/div/a[2]")
	private WebElement loginbutton;
	public void login()
	{
		loginbutton.click();
	}

}
