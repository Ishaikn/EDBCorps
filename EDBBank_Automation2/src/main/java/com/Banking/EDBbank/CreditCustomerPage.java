package com.Banking.EDBbank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreditCustomerPage {

	public CreditCustomerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	String amount1 = "9897";
	public WebElement getStaffhome() {
		return Staffhome;
	}
	public WebElement getStaffLogout() {
		return StaffLogout;
	}
	
	public WebElement getCustaccnt() {
		return custaccnt;
	}
	public WebElement getAmount() {
		return amount;
	}
	public WebElement getCreditbutton() {
		return Creditbutton;
	}
	@FindBy(xpath="//input[@placeholder='Amount']")private WebElement amount;
	@FindBy(name="credit_btn")private WebElement Creditbutton;
	@FindBy(name="home")private WebElement Staffhome;
	@FindBy(name="staff_logout")private WebElement StaffLogout;
	@FindBy(xpath="//input[@placeholder='Customer A/c No']")private WebElement custaccnt;
	
}
