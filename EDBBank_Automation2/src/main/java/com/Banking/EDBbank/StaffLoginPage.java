package com.Banking.EDBbank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StaffLoginPage {

	public StaffLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);	
	}
	

	public WebElement getStaffLoginlink() {
		return StaffLoginlink;
	}
	public WebElement getStaffid() {
		return staffid;
	}
	public WebElement getStaffpassword() {
		return Staffpassword;
	}
	public WebElement getLoginbutton() {
		return loginbutton;
	}
	public WebElement getHomepagelink() {
		return Homepagelink;
	}
	@FindBy(xpath="//a[text()='Staff Login']")private WebElement StaffLoginlink;
	@FindBy(xpath="//input[@name='staff_id']")private WebElement staffid;
	@FindBy(xpath="//input[@name='password']")private WebElement Staffpassword;
	@FindBy(xpath="//input[@name='staff_login-btn']")private WebElement loginbutton;
	@FindBy(xpath="//a[.='Home']")private WebElement Homepagelink;
	
}
