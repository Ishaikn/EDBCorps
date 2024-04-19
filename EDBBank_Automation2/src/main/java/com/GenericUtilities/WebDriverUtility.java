package com.GenericUtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	/**
	 * this method will maximize the windows
	 * 
	 * @param driver
	 */
	public void maximizewindow(WebDriver driver) {

		driver.manage().window().maximize();
	}
	
	public String getapplicationnifromText(WebDriver driver) {
		String data=driver.switchTo().alert().getText();
		String Applicationno="";
		for(int i=0;i<data.length();i++) {
			if(Character.isDigit(data.charAt(i))) {
				Applicationno=Applicationno+data.charAt(i);
			}
		}return Applicationno;
	}

	
	
	public void getAlertText(WebDriver driver) {
		
	System.out.println(driver.switchTo().alert().getText());
		
	}
	/**
	 * this method will minimize the windows
	 * 
	 * @param driver
	 */
	public void miniimizewindow(WebDriver driver) {

		driver.manage().window().minimize();
	}

	/**
	 * this Method is used to Implement Explicit Wait
	 * 
	 * @param driver
	 * @param sec
	 * @return
	 */
	public WebDriverWait waitDriver(WebDriver driver, int sec) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		return wait;
	}

	/**
	 * this method waits for the correct url to be present
	 * 
	 * @author prityankur
	 * @param driver
	 * @param url
	 * @param sec
	 */
	public void waitUntilURL(WebDriver driver, String url, int sec) {
		waitDriver(driver, sec).until(ExpectedConditions.urlContains(url));
	}

	public void implicittime(WebDriver driver, int sec) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}

	public void pageloadingtime(WebDriver driver, int sec) {

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(sec));
	}

	/**
	 * this method creates the WebDriverWait object
	 * 
	 * @param driver
	 * @param sec
	 * @return
	 */

	public WebDriverWait webDriverwaitobj(WebDriver driver, int sec) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		return wait;
	}

	/**
	 * this is method waits until the element is visible
	 * 
	 * @param driver
	 * @param sec
	 * @param ele
	 */
	public void waitUntillEletobeVisible(WebDriver driver, int sec, WebElement ele) {
		webDriverwaitobj(driver, sec).until(ExpectedConditions.visibilityOf(ele));
	}

	/**
	 * this is method waits until the element is Clickable
	 * 
	 * @param driver
	 * @param sec
	 * @param ele
	 */
	public void waitUntilEletobeClickable(WebDriver driver, int sec, WebElement ele) {
		webDriverwaitobj(driver, sec).until(ExpectedConditions.elementToBeClickable(ele));
	}

	/**
	 * This Method is used to wait untill the Title of the Page loaded
	 * 
	 * @param driver
	 * @param sec
	 * @param Title
	 */
	public void waitUntillTogetTitle(WebDriver driver, int sec, String Title) {
		webDriverwaitobj(driver, sec).until(ExpectedConditions.titleIs(Title));
	}

	/**
	 * These below Methods are used to perform Mouse hover operations on the WebPage
	 * 
	 * @param driver
	 * @return
	 */
	public Actions performactionObject(WebDriver driver) {
		Actions action = new Actions(driver);
		return action;
	}

	/**
	 * this method performs move mouse till the the Element
	 * 
	 * @param driver
	 * @param ele
	 */
	public void movetoElement(WebDriver driver, WebElement ele) {
		performactionObject(driver).moveToElement(ele).perform();
	}

	/**
	 * this method performs double click action
	 * 
	 * @param driver
	 */
	public void doubleClick(WebDriver driver) {
		performactionObject(driver).doubleClick().perform();
	}

	/**
	 * this method performs double click action
	 * 
	 * @param driver
	 * @param ele
	 */
	public void doubleClick(WebDriver driver, WebElement ele) {
		performactionObject(driver).doubleClick(ele).perform();
	}

	/**
	 * This Method is used for right click
	 * 
	 * @param driver
	 */
	public void rightClick(WebDriver driver) {
		performactionObject(driver).contextClick().perform();
	}

	/**
	 * This Method is used for right click
	 * 
	 * @param driver
	 */
	public void rightClick(WebDriver driver, WebElement ele) {
		performactionObject(driver).contextClick(ele).perform();
	}

	/**
	 * This Method is used for Drag and Drop the Element from Source Element to
	 * Target Element
	 * 
	 * @param driver
	 */
	public void dragAndDrop(WebDriver driver, WebElement src, WebElement trg) {
		performactionObject(driver).dragAndDrop(src, trg);
	}

	/**
	 * This Method is used for Drag and Drop the Element to Source Element using X
	 * and Y co-ordinates
	 * 
	 * @param driver
	 * @param src
	 * @param x
	 * @param y
	 */
	public void dragAndDrop(WebDriver driver, WebElement src, int x, int y) {
		performactionObject(driver).dragAndDropBy(src, x, y);
	}

	/**
	 * This Method is used to perform Send Keys operations
	 * 
	 * @param driver
	 */
	public void sendKeys(WebDriver driver) {
		performactionObject(driver).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
	}

	/**
	 * This Method is used to create the Select Class Object
	 * 
	 * @param ele
	 * @return
	 */
	public Select dropDownObject(WebElement ele) {
		Select sel = new Select(ele);
		return sel;
	}

	/**
	 * this Method is used to select the element using Index
	 * 
	 * @param ele
	 * @param index
	 */
	public void handledropdown(WebElement ele, int index) {
		dropDownObject(ele).selectByIndex(index);
	}

	/**
	 * this Method is used to select the element using Value
	 * 
	 * @param ele
	 * @param index
	 */
	public void handledropdown(WebElement ele, String value) {
		dropDownObject(ele).selectByValue(value);
	}

	/**
	 * this Method is used to select the element using Text
	 * 
	 * @param ele
	 * @param index
	 */
	public void handledropdown(String text, WebElement ele) {
		dropDownObject(ele).selectByVisibleText(text);
	}

	/**
	 * This Method is used to switch to Particular window using with Title
	 * Verification
	 * 
	 * @param driver
	 * @param Expectwindow
	 */
	public void switchTowindow(WebDriver driver, String Expectwindow) {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iter = windows.iterator();

		while (iter.hasNext()) {
			String win = iter.next();
			String CurrentUrl = driver.switchTo().window(win).getTitle();

			if (CurrentUrl.contains(Expectwindow)) {
				break;
			}
		}
	}

	/**
	 * This Method is used to Capture the Required Screenshot of the Webpage
	 * 
	 * @param driver
	 * @param ScreenShotName
	 * @return
	 * @throws IOException
	 */
	public static String getScreenShot(WebDriver driver, String ScreenShotName) throws IOException {
		TakesScreenshot tss = (TakesScreenshot) driver;
		File src = tss.getScreenshotAs(OutputType.FILE);
		String Path = "./ScreenShot"+ScreenShotName+".png";
		File dest = new File(Path);
		String srcpath = dest.getAbsolutePath();
		FileUtils.copyFile(src, dest);
		return srcpath;

	}

	/**
	 * this method creates the object for the robot
	 * 
	 * @return
	 * @throws AWTException
	 */
	public Robot robotObj() throws AWTException {
		Robot robo = new Robot();
		return robo;
	}

	/**
	 * this method hits the robot class enter key
	 * 
	 * @author prityankur
	 * @throws AWTException
	 */
	public void enterKey() throws AWTException {
		robotObj().keyPress(KeyEvent.VK_ENTER);
	}

	/**
	 * this method is used to release the robot class enter key
	 * 
	 * @author prityankur
	 * @throws AWTException
	 */
	public void enterRelease() throws AWTException {
		robotObj().keyRelease(KeyEvent.VK_ENTER);
	}

	/**
	 * this method is used to switch to a frame using index
	 * 
	 * @author prityankur
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);

	}

	/**
	 * this method is used to switch to a frame using locator
	 * 
	 * @author prityankur
	 * @param driver
	 * @param nameOrID
	 */
	public void switchToFrame(WebDriver driver, String nameOrID) {
		driver.switchTo().frame(nameOrID);

	}

	/**
	 * this method is used to switch to a frame using the address
	 * 
	 * @param address
	 * @param driver
	 */
	public void switchToFrame(String address, WebDriver driver) {
		driver.switchTo().frame(address);
	}
	public void alertGetText(WebDriver driver,String alerttext) {
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
	}
	/**
	 * this method accepts alert pop up
	 * 
	 * @author prityankur
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * this method rejects alert pop up
	 * 
	 * @author prityankur
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * This method will perform random scroll 
	 * 
	 * @param driver
	 */
	public void scrollBarAction(WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,800)", "");
	}

	/**
	 * This method is used to scroll till last of the web page
	 * 
	 * @param driver
	 * @param ele
	 */

	public void scrollBarAction(WebDriver driver, WebElement ele) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		int y = ele.getLocation().getY();
		jse.executeScript("window.scrollBy(0," + y + ")", ele);
	}

	/**
	 * This method is used to click on the element using javaScript executor
	 * 
	 * @param driver
	 * @param ele
	 */

	public void clickOnElement(WebDriver driver, WebElement ele) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", ele);
	}

	/**
	 * This method is used to scroll till the element using javaScript executor
	 * 
	 * @param driver
	 * @param ele
	 */
	public void scrollTillElement(WebDriver driver, WebElement ele) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", ele);
	}

	/**
	 * This method is used to send data to the element using javaScript executor
	 * @param driver
	 * @param ele
	 * @param data
	 */
	public void sendDataThroughJSExecutor(WebDriver driver, WebElement ele, String data) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].value=argument[1]",ele,data);
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void scrollUpTillElementToBeVisisble(WebDriver driver, WebElement element)
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		Point loc = element.getLocation();
		int x = loc.getX();
		int y = loc.getY();
		jse.executeScript("window.scrollBy("+x+","+y+")");
	}
}