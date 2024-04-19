package com.Banking.EDBbank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver){

		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	//HOme Page Link
	
	public WebElement getHomebutton() {
		return Homebutton;
	}
	public WebElement getStaffLogin() {
		return StaffLogin;
	}
	public WebElement getOpenAccountlink() {
		return OpenAccountlink;
	}
	public WebElement getApplyDebitCardLink() {
		return ApplyDebitCardLink;
	}
	public WebElement getInternetBankingLink() {
		return InternetBankingLink;
	}
	public WebElement getFundTransferLink() {
		return FundTransferLink;
	}
	public WebElement getLoginLink() {
		return LoginLink;
	}
	@FindBy(xpath="//a[.='Home']")private WebElement Homebutton;

	@FindBy(xpath="//a[.='Staff Login']") private WebElement StaffLogin;
	@FindBy(xpath="//li[text()='Open Account']") private WebElement OpenAccountlink;
	@FindBy(xpath="//li[.='Apply Debit Card']") private WebElement ApplyDebitCardLink;
	@FindBy(xpath="//a[contains(text(),'Internet Banki')]") private WebElement InternetBankingLink;
	@FindBy(xpath="//li[.='Fund Transfer']") private WebElement FundTransferLink;
	@FindBy(xpath="//li[contains(text(),'Logi')]")private WebElement LoginLink;
	public WebElement getInternetRegistration() {
		return InternetRegistration;
	}
	@FindBy(xpath="//li[text()='Register']")private WebElement InternetRegistration;
	}
