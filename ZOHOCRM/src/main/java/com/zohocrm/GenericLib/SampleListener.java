package com.zohocrm.GenericLib;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;
import com.zohocrm.TestScripts.CampaignTest;

public class SampleListener extends BaseClass implements ITestListener {
	String endtime;
	String starttime;
	Excellib excellib = new Excellib();
	
//On TestFailure Method will be called when a test gets failed.
	    public void onTestFailure(ITestResult result) {
		failedtestname = result.getMethod().getMethodName();
		screenshotfilename = "./Screenshots/" + failedtestname + ".png";
		EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.driver);
		File srcFile = edriver.getScreenshotAs(OutputType.FILE);
		File destFile = new File(screenshotfilename);
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			System.out.println(e);
		}
		try {
			excellib.setExcelData(testpassfailurecount, 5, "Fail");
		} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		endtime = formatter.format(date);
		try {
			excellib.setExcelData(methodcount, 3, endtime);
		} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		methodcount++;
		testpassfailurecount++;
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		try {
			Date date1 = format.parse(starttime);
			Date date2 = format.parse(endtime);
			long hourdifference = date2.getHours() - date1.getHours();
			long minutedifference = date2.getMinutes() - date1.getMinutes();
			long secondsdifference = date2.getSeconds() - date1.getSeconds();
			String totaldurationvalue = hourdifference + ":" + minutedifference + ":" + secondsdifference;
			excellib.setExcelData(totaldurationrow, 4, totaldurationvalue);
			totaldurationrow++;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	    }

//On TestStart Method will be called when a test execution starts.
	      public void onTestStart(ITestResult result) {
		    try {
			excellib.settExcelData("CampaignsTest", 5, 0, "123");
			excellib.settExcelData("CampaignsTest", 6, 0, "123");
			String firstnumber = excellib.getExcelData("CampaignsTest", 5, 0);
			String secondnumber = excellib.getExcelData("CampaignsTest", 6, 0);
			int firstintnumber = Integer.parseInt(firstnumber);
			int secondintnumber = Integer.parseInt(secondnumber);
			System.out.println(firstintnumber + secondintnumber);
			String methodname = result.getMethod().getMethodName();
			excellib.setExcelData(methodcount, 0, methodname);
			SimpleDateFormat formatterr = new SimpleDateFormat("dd/MM/yyyy");
			Date date = new Date();
			String startdate = formatterr.format(date);
			excellib.setExcelData(methodcount, 1, startdate);
			SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
			Date hourdate = new Date();
			starttime = formatter.format(hourdate);
			excellib.setExcelData(methodcount, 2, starttime);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result.getMethod().getMethodName());
		// TODO Auto-generated method stub
	      }
//On TestSuccess Method will be called when a test is passed..
	    public void onTestSuccess(ITestResult result) {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		endtime = formatter.format(date);
		try {
			excellib.setExcelData(methodcount, 3, endtime);
		} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			excellib.setExcelData(testpassfailurecount, 5, "Pass");
		} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		testpassfailurecount++;
		methodcount++;
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		try {
			Date date1 = format.parse(starttime);
			Date date2 = format.parse(endtime);
			long hourdifference = date2.getHours() - date1.getHours();
			long minutedifference = date2.getMinutes() - date1.getMinutes();
			long secondsdifference = date2.getSeconds() - date1.getSeconds();
			String totaldurationvalue = hourdifference + ":" + minutedifference + ":" + secondsdifference;
			excellib.setExcelData(totaldurationrow, 4, totaldurationvalue);
			totaldurationrow++;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// TODO Auto-generated method stub
	    }
//On TestSkipped Method will be called when a test gets skipped.
	   public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	   }
	   public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	   }
//On TestStart Method will be called when the execution starts.
	   public void onStart(ITestContext context) {
		
		// TODO Auto-generated method stub

	   }
//On TestFinish Method will be called when a test script execution is finished..
	   public void onFinish(ITestContext context) {

		// TODO Auto-generated method stub

	   }

}
