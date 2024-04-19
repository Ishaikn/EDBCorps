package com.Banking.EDBbank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApplyDebitcardpage {

	public ApplyDebitcardpage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}
	public WebElement getCustname() {
		return Custname;
	}

	public WebElement getBirthdate() {
		return Birthdate;
	}

	public WebElement getDebitsubmit() {
		return debitsubmit;
	}
	public WebElement getHomelink() {
		return homelink;
	}
	@FindBy(xpath = "//input[@placeholder='Account Holder Name']")
	private WebElement Custname;
	@FindBy(xpath = "//input[@placeholder='Date of Birth']")
	private WebElement Birthdate;
	@FindBy(xpath="//input[@name='dbt_crd_submit']")private WebElement debitsubmit;
	@FindBy(xpath="//a[.='Home']")private WebElement homelink;
	@FindBy(xpath="//input[@placeholder='Account No']")private WebElement Accountnumber;
	public WebElement getAccountnumber() {
		return Accountnumber;
	}
}
