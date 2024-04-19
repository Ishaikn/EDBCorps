package com.Banking.EDBbank;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Staff_ViewCustaccountpage {
	
	public Staff_ViewCustaccountpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getStaffhome() {
		return Staffhome;
	}
	public WebElement getStaffLogout() {
		return StaffLogout;
	}
	@FindBy(name="home")private WebElement Staffhome;
	@FindBy(name="staff_logout")private WebElement StaffLogout;

	
	public void clipboard(String Custaccno) throws AWTException {
		Robot robo = new Robot();
		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_F);
		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_F);
		String text1 = Custaccno;
		StringSelection stringSelection1 = new StringSelection(text1);
		Clipboard clipboard1 = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard1.setContents(stringSelection1, stringSelection1);
	}
}
