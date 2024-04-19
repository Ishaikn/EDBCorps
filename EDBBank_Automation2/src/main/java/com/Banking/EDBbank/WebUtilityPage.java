package com.Banking.EDBbank;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class WebUtilityPage {

public WebUtilityPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
public void selectclass(WebElement Ele, String Value) {
	Select sel = new Select(Ele);
	sel.selectByValue(Value);
}
public void selectclasstext(WebElement Ele, String text) {
	Select sel = new Select(Ele);
	sel.selectByVisibleText(text);
}
public void scrollTillElement(WebDriver driver, WebElement ele) {
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	jse.executeScript("arguments[0].scrollIntoView(true);", ele);
}
public void Maximize(WebDriver driver) {
	driver.manage().window().maximize();
}
public void  implicitwait(WebDriver driver, int sec) {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
}

public Actions performActions(WebDriver driver) {
	Actions action=new Actions(driver);
	return action;
}
public void mouseHoveronDOB(WebDriver driver, WebElement element, String text1, String text2, String text3) {
	performActions(driver).click(element).sendKeys(text1).sendKeys(text2).sendKeys(text3).perform();
}
public void Robotclass() throws AWTException {
	Robot robo=new Robot();
	robo.keyPress(KeyEvent.VK_0);
	robo.keyPress(KeyEvent.VK_1);
	robo.keyPress(KeyEvent.VK_0);
	robo.keyPress(KeyEvent.VK_1);
	robo.keyPress(KeyEvent.VK_2);
	robo.keyPress(KeyEvent.VK_0);
	robo.keyRelease(KeyEvent.VK_0);
	robo.keyPress(KeyEvent.VK_0);
	robo.keyPress(KeyEvent.VK_1);
}

public WebElement getGender() {
	return Gender;
}
@FindBy(xpath="//option[text()='Gender']/parent::select[@name='gender']")private WebElement Gender;
}
