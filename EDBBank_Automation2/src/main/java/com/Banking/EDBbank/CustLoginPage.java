package com.Banking.EDBbank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustLoginPage {
	public CustLoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	public WebElement getCustid() {
		return Custid;
	}
	public WebElement getCustpwd() {
		return custpwd;
	}
	public WebElement getCustloginbutton() {
		return custloginbutton;
	}
	public WebElement getHomepageLink() {
		return HomepageLink;
	}
	@FindBy(name="customer_id")private WebElement Custid;
	@FindBy(name="password")private WebElement custpwd;
	@FindBy(xpath="//input[@class='login-btn']")private WebElement custloginbutton;
	@FindBy(xpath="//a[.='Home']")private WebElement HomepageLink;
}
