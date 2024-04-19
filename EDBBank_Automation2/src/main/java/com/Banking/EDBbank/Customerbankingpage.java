package com.Banking.EDBbank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Customerbankingpage {
	 
	public Customerbankingpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getMyaccountbutton() {
		return Myaccountbutton;
	}
	public WebElement getMyprofile() {
		return Myprofile;
	}
	public WebElement getChangepwd() {
		return changepwd;
	}
	public WebElement getFundTransfer() {
		return FundTransfer;
	}
	public WebElement getStatement() {
		return Statement;
	}
	public WebElement getHomebutton() {
		return homebutton;
	}
	public WebElement getLogoutbutton() {
		return Logoutbutton;
	}
	@FindBy(xpath="//li[text()='My Account']")private WebElement Myaccountbutton;
	@FindBy(xpath="//li[text()='My Profile']")private WebElement Myprofile;
	@FindBy(xpath="//li[text()='Change Password']")private WebElement changepwd;
	@FindBy(xpath="//li[text()='Fund Transfer']")private WebElement FundTransfer;
	@FindBy(xpath="//li[text()='Statement']")private WebElement Statement;
	@FindBy(name="home")private WebElement homebutton;
	@FindBy(name="logout_btn")private WebElement Logoutbutton;
}
