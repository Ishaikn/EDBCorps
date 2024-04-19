package com.Banking.EDBbank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InternetRagistrationPage {
	public InternetRagistrationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getInternetbanking() {
		return Internetbanking;
	}
	public WebElement getRegistrationlink() {
		return Registrationlink;
	}
	public WebElement getCustname() {
		return custname;
	}
	public WebElement getCustaccno() {
		return Custaccno;
	}
	public WebElement getDebitcardno() {
		return debitcardno;
	}
	public WebElement getDebitpin() {
		return debitpin;
	}
	public WebElement getMobile() {
		return mobile;
	}
	public WebElement getLasttransac() {
		return Lasttransac;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getConfipassword() {
		return confipassword;
	}
	public WebElement getSubmitbutton() {
		return Submitbutton;
	}
	public WebElement getBirth() {
		return birth;
	}
	public WebElement getPancard() {
		return Pancard;
	}
	@FindBy(xpath="//li[text()='Register']")private WebElement Registrationlink;
	@FindBy(xpath="//input[@placeholder='Account Holder Name']")private WebElement custname;
	@FindBy(xpath="//input[@placeholder='Account Number']")private WebElement Custaccno;
	@FindBy(xpath="//input[@placeholder='Debit Card Number']")private WebElement debitcardno;
	@FindBy(xpath="//input[@placeholder='Debit Card Pin']")private WebElement debitpin;
	@FindBy(xpath="//input[@placeholder='Registered Mobile (10 Digit)']")private WebElement mobile;
	@FindBy(xpath="//input[@placeholder='PAN Number']")private WebElement Pancard;
	@FindBy(xpath="//input[@placeholder='Date of Birth']")private WebElement birth;
	@FindBy(xpath="//input[@placeholder='Last Transaction ($)']")private WebElement Lasttransac;
	@FindBy(xpath="//input[@placeholder='Password']")private WebElement password;
	@FindBy(xpath="//input[@placeholder='Confirm Password']")private WebElement confipassword;
	@FindBy(name="submit")private WebElement Submitbutton;
	@FindBy(id="//a[contains(text(),'Internet Bank')]")private WebElement Internetbanking;
}
