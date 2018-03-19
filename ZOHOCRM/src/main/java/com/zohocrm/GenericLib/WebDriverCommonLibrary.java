package com.zohocrm.GenericLib;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverCommonLibrary {
	/** To wait for page to load using implicitly wait **/
	public void waitForPageToLoad(int time) {
		BaseClass.driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	/**
	 * Wait for element to appear in User Interface using ExplicitlyWait for
	 * PresenceOfElementLocated .
	 **/
	public void waitForElementToLoadForPresenceOfElementLocated(String locatortype, String locatorvalue) {
		WebDriverWait wait = new WebDriverWait(BaseClass.driver, 30);
		if (locatortype.equals("id")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locatorvalue)));
		} else if (locatortype.equals("xpath")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locatorvalue)));
		} else if (locatortype.equals("name")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.name(locatorvalue)));
		} else if (locatortype.equals("linktext")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(locatorvalue)));
		} else if (locatortype.equals("partialLinktext")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(locatorvalue)));
		} else if (locatortype.equals("className")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.className(locatorvalue)));
		} else if (locatortype.equals("cssSelector")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locatorvalue)));
		} else {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName(locatorvalue)));
		}

	}

	/**
	 * Wait for element to appear in User Interface using ExplicitlyWait for
	 * Title is Present.
	 **/
	public void waitForElementToLoadForTitleIsPresent(String title) {
		WebDriverWait wait = new WebDriverWait(BaseClass.driver, 30);

		wait.until(ExpectedConditions.titleIs(title));

	}

	/** To scroll down the page using javascript executor **/
	public void windowScrollBar(int horizontalvalue, int verticalvalue) {
		JavascriptExecutor javascriptexecutor = (JavascriptExecutor) BaseClass.driver;
		javascriptexecutor.executeScript("window.scrollBy(horizontalvalue,verticalvalue)");
	}

	/** To maximize the browser window **/
	public void maximizeBrowserWindow() {
		BaseClass.driver.manage().window().maximize();
	}

	/** To set the size of browser window **/
	public void setSizeBrowserWindow(int horizontalvalue, int verticalvalue) {
		Dimension dimension = new Dimension(horizontalvalue, verticalvalue);
		BaseClass.driver.manage().window().setSize(dimension);
	}

	/** To click on OK button on alert popup **/
	public void alertAccept() {
		Alert alert = BaseClass.driver.switchTo().alert();
		alert.accept();
	}

	/** To click on Cancel button on alert popup **/
	public void alertCancel() {
		Alert alert = BaseClass.driver.switchTo().alert();
		alert.dismiss();
	}

	/** To get the text from alert popup **/
	public String alertGetText() {
		Alert alert = BaseClass.driver.switchTo().alert();
		return alert.getText();
	}

	/** To select by using visible text in select dropdown menu **/
	public void selectByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	/** To select by using index in select dropdown menu **/
	public void selectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	/** To select by using value in selectdropdown menu **/
	public void selectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	/** Move to particular element using actions class **/
	public void actionsMoveToElement(WebElement element) {
		Actions action = new Actions(BaseClass.driver);
		action.moveToElement(element).perform();
	}

	/**
	 * Move to particular element by finding an element near to it using actions
	 * class
	 **/
	public void actionsMoveToElement(WebElement element, int xaxisvalue, int yaxisvalue) {
		Actions action = new Actions(BaseClass.driver);
		action.moveToElement(element, xaxisvalue, yaxisvalue).perform();
	}

	/** Perform right click operations using actions class **/

	public void actionsContextClick(WebElement element) {
		Actions action = new Actions(BaseClass.driver);
		action.contextClick(element).perform();
	}

	/** Perform double click operation using actions class **/
	public void actionsDoubleClick(WebElement element) {
		Actions action = new Actions(BaseClass.driver);
		action.doubleClick(element).perform();
	}

	/** Perform drag and drop operation using actions class **/
	public void actionsDragAndDrop(WebElement element1, WebElement element2) {
		Actions action = new Actions(BaseClass.driver);
		action.dragAndDrop(element1, element2).perform();
	}

	/** Holding a particular element using actions class **/
	public void actionsClickAndHold(WebElement element) {
		Actions action = new Actions(BaseClass.driver);
		action.clickAndHold(element).perform();
	}

	/** Pressing a keyboard key using actions class **/
	public void actionsKeyboardKeys(Keys functionalkey) {
		Actions action = new Actions(BaseClass.driver);
		action.sendKeys(functionalkey).perform();
		;
	}

	/** Pressing two keyboard keys one after the other using actions class **/
	public void actionsKeyboardKeys(Keys functionalkey1, Keys functionalkey2) {
		Actions action = new Actions(BaseClass.driver);
		action.sendKeys(functionalkey1, functionalkey2).perform();
		;
	}

	/** Pressing two keyboard keys concurrently using actions class **/
	public void actionsKeyboardKeysChord(Keys functionalkey1, Keys functionalkey2) {
		Actions action = new Actions(BaseClass.driver);
		action.sendKeys(Keys.chord(functionalkey1, functionalkey2)).perform();
		;
	}

	/** To get the window id when multiple windows are opened **/
	public String getWindowId() {
		String windowid = null;
		Set<String> windowids = BaseClass.driver.getWindowHandles();
		Iterator<String> iterator = windowids.iterator();
		if (windowids.size() == 2) {
			String parentid = iterator.next();
			String childid = iterator.next();
			windowid = parentid + " " + childid;
		} else if (windowids.size() == 2) {
			String parentid = iterator.next();
			String childid = iterator.next();
			String subchildid = iterator.next();
			windowid = parentid + " " + childid + " " + subchildid;
		}
		return windowid;
	}

	/** To switch to particular window **/
	public void switchToWindow(String windowid) {
		BaseClass.driver.switchTo().window(windowid);
	}

	public String getTitle() {
		return BaseClass.driver.getTitle();
	}

	public void navigateBack() {
		BaseClass.driver.navigate().back();

	}

}
