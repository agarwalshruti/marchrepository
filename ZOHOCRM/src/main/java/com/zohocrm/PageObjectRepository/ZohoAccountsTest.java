package com.zohocrm.PageObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ZohoAccountsTest 
{
	@FindBy(id="lid")
	private WebElement emailtextbox;
	@FindBy(id="pwd")
	private WebElement passwordtextbox;
	@FindBy(id="signin_submit")
    private WebElement signinbutton;
	public void signIn(String username,String password) throws InterruptedException
	{
		emailtextbox.sendKeys(username);
		passwordtextbox.sendKeys(password);
		signinbutton.click();
		Thread.sleep(4000);
		
		
	}


}
