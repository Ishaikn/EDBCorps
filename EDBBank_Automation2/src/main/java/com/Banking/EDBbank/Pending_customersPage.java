package com.Banking.EDBbank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pending_customersPage{
	public Pending_customersPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
public WebElement getStaffhome() {
	return Staffhome;
}
public WebElement getStaffLogout() {
	return StaffLogout;
}


public WebElement getAccntSearchfield() {
	return AccntSearchfield;
}
public WebElement getSearchlink() {
	return Searchlink;
}
public WebElement getApprovebuttn() {
	return Approvebuttn;
}

@FindBy(name="search_application")private WebElement Searchlink;
@FindBy(name="approve_cust")private WebElement Approvebuttn;
@FindBy(name="home")private WebElement Staffhome;
@FindBy(name="staff_logout")private WebElement StaffLogout;
@FindBy(xpath="//input[@placeholder='Application number']")private WebElement AccntSearchfield;

}
