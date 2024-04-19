package com.Banking.EDBbank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class staff_profilePage {
	public staff_profilePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getStaffhome() {
		return Staffhome;
	}
	public WebElement getStaffLogout() {
		return StaffLogout;
	}
	public WebElement getViewCustaccnt() {
		return ViewCustaccnt;
	}
	public WebElement getViewVustaccntbyNo() {
		return ViewVustaccntbyNo;
	}
	public WebElement getApproveaccnt() {
		return approveaccnt;
	}
	public WebElement getDeletCust() {
		return DeletCust;
	}
	public WebElement getCreditCust() {
		return CreditCust;
	}
	@FindBy(name="home")private WebElement Staffhome;
	@FindBy(name="logout_btn")private WebElement StaffLogout;
	@FindBy(name="viewdet")private WebElement ViewCustaccnt;
	@FindBy(name="view_cust_by_ac")private WebElement ViewVustaccntbyNo;
	@FindBy(name="apprvac")private WebElement approveaccnt;
	@FindBy(name="del_cust")private WebElement DeletCust;
	@FindBy(name="credit_cust_ac")private WebElement CreditCust;
}
