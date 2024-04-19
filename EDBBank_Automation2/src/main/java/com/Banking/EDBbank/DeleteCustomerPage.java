package com.Banking.EDBbank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteCustomerPage {

	public DeleteCustomerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getStaffhome() {
		return Staffhome;
	}
	public WebElement getStaffLogout() {
		return StaffLogout;
	}
	
	public WebElement getCustacctext() {
		return Custacctext;
	}
	public WebElement getCustIdtext() {
		return CustIdtext;
	}
	public WebElement getReason() {
		return reason;
	}
	public WebElement getDeletebutton() {
		return deletebutton;
	}
	@FindBy(xpath="//input[@placeholder='Customer ID']")private WebElement CustIdtext;
	@FindBy(xpath="//input[@placeholder='Reason']")private WebElement reason;
	@FindBy(name="delete")private WebElement deletebutton;
	@FindBy(name="home")private WebElement Staffhome;
	@FindBy(name="staff_logout")private WebElement StaffLogout;
	@FindBy(xpath="//input[@placeholder='Customer Account No']")private WebElement Custacctext;
}
