package com.Banking.EDBbank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class cust_statementPage {

	public cust_statementPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getStatementlink() {
		return statementlink;
	}
	@FindBy(xpath="//li[text()='Statement']")private WebElement statementlink;

	
}
