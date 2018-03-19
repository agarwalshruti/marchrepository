package com.zohocrm.GenericLib;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sun.media.jfxmedia.logging.Logger;

public class BaseClass {
	public int methodcount = 1;
	public int testpassfailurecount = 1;
	public int totaldurationrow=1;
	public int testnumber;
	Excellib excellib = new Excellib();
	WebDriverCommonLibrary webdrivercommonlib = new WebDriverCommonLibrary();
	ObjectClass objclass = new ObjectClass();
	public static WebDriver driver;
	public ExtentReports extent;
	public ExtentTest logger;
	public String failedtestname;
	public String screenshotfilename;

	@BeforeMethod
	public void configBeforeMethod()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		String email = excellib.getExcelData("Configuration", 1, 0);
		String password = excellib.getExcelData("Configuration", 1, 1);
		String url = excellib.getExcelData("Configuration", 1, 2);
		driver.get(url);
		webdrivercommonlib.waitForPageToLoad(20);
		objclass.objects();
		String title = webdrivercommonlib.getTitle();
		String actualtitle = excellib.getExcelData("CampaignsTest", 1, 5);
		Assert.assertEquals(actualtitle, title);
		objclass.zohocrmtest.login();
		String signinpagetitle = webdrivercommonlib.getTitle();
		String actualsignintitle = excellib.getExcelData("CampaignsTest", 1, 6);
		Assert.assertEquals(actualsignintitle, signinpagetitle);
		objclass.zohoaccountstest.signIn(email, password);
		String homepagetitle = webdrivercommonlib.getTitle();
		String actualhomepagetitle = excellib.getExcelData("CampaignsTest", 1, 7);
		Assert.assertEquals(actualhomepagetitle, homepagetitle);
	}

	@AfterMethod
	public void configAfterMethod(ITestResult testresult)
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
	/**	if (testresult.getStatus() == ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL, "Test case failed is" + testresult.getName());

			logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotfilename));

		}**/
		//Thread.sleep(3000);
		objclass.signouttest.signOut();
		String zohocrmoverviewtitle = webdrivercommonlib.getTitle();
		String actualzohocrmoverviewtitle = excellib.getExcelData("CampaignsTest", 1, 10);
		Assert.assertEquals(actualzohocrmoverviewtitle, zohocrmoverviewtitle);
		extent.endTest(logger);
	}

	@BeforeClass
	public void configBeforeClass() throws EncryptedDocumentException, InvalidFormatException, IOException {
		String browser = excellib.getExcelData("Configuration", 1, 3);
		String operatingsystem = excellib.getExcelData("Configuration", 1, 4);
		//For Windows Operating System.
		if (operatingsystem.equals("Windows")) {
			if (browser.equals("Ie")) {
				System.setProperty("webdriver.ie.driver", "./Resources/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			} else if (browser.equals("Chrome")) {
				System.setProperty("webdriver.chrome.driver", "./Resources/chromedriver.exe");
				driver = new ChromeDriver();
			} else {
				driver = new FirefoxDriver();
			}
		} 
		//For Linux Operating System.
		else if (operatingsystem.equals("linux")) {
			if (browser.equals("Ie")) {
				System.setProperty("webdriver.ie.driver", "./Resources/IEDriver");
				driver = new InternetExplorerDriver();
			} else if (browser.equals("Chrome")) {
				System.setProperty("webdriver.chrome.driver", "./Resources/chromedriver");
				driver = new ChromeDriver();
			} else {
				driver = new FirefoxDriver();
			}

		}
		// For Mac Operating System, copy all the drivers in a directory(/usr/local/bin).
		else {

			if (browser.equals("Chrome")) {

				driver = new ChromeDriver();
			} else if (browser.equals("Ie")) {

				driver = new InternetExplorerDriver();
			} else {
				driver = new FirefoxDriver();
			}
		}
	}

	@AfterClass
	public void configAfterClass() {
		driver.quit();
	}

	@BeforeSuite
	public void configBeforeSuite() {
		extent = new ExtentReports("./test-output/advancedreport.html");
		
	}

	@AfterSuite
	public void configAfterSuite() throws Exception {
		extent.flush();

	}

}
