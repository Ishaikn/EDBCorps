package com.Banking.EDBbank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class View_customer_by_acc_noPage {

	public View_customer_by_acc_noPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getStaffhome() {
		return Staffhome;
	}

	public WebElement getStaffLogout() {
		return StaffLogout;
	}

	public WebElement getCustaccSearch() {
		return CustaccSearch;
	}

	public WebElement getSubmitbutton() {
		return Submitbutton;
	}

	@FindBy(name = "submit_view")
	private WebElement Submitbutton;
	@FindBy(name = "home")
	private WebElement Staffhome;
	@FindBy(name = "staff_logout")
	private WebElement StaffLogout;
	@FindBy(xpath = "//input[@placeholder='Customer Account No']")
	private WebElement CustaccSearch;

}
