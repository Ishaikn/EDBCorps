package com.Banking.EDBbank;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.GenericUtilities.IpathConstant;

public class Customer_registrationPage {

	public Customer_registrationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@placeholder='Name']")private WebElement Nametext;
	@FindBy(xpath="//option[text()='Gender']/parent::select[@name='gender']")private WebElement Gender;
	@FindBy(xpath="//input[@placeholder='Mobile no']")private WebElement Mobiletext;
	@FindBy(xpath="//input[@placeholder='Email id']")private WebElement Email;
	@FindBy(xpath="//input[@placeholder='Landline no']")private WebElement Landlinetext;
	@FindBy(xpath="//input[@placeholder='Date of Birth']")private WebElement Birthfield;
	@FindBy(xpath="//option[text()='State']/parent::select[@name='state']")private WebElement State;
	@FindBy(xpath="//select[@name='city']")private WebElement City;
	@FindBy(xpath="//select[@name='acctype']")private WebElement Accountype;
	@FindBy(name="submit")private WebElement OpenAccountsubmit;
	@FindBy(name="cnfrm-submit")private WebElement AccntConfirm;
	@FindBy(xpath="//input[@class=cnfrm-submit-btn']")private WebElement Gobackbutton;
	public WebElement getPincode() {
		return Pincode;
	}

	public WebElement getArea() {
		return Area;
	}

	public WebElement getNomineename() {
		return Nomineename;
	}

	public WebElement getNomineeaccnt() {
		return Nomineeaccnt;
	}
	@FindBy(xpath="//input[@placeholder='Pin Code']")private WebElement Pincode;
	@FindBy(xpath="//input[@placeholder='Area/Locality']")private WebElement Area;
	@FindBy(xpath="//input[@placeholder='Nominee Name (If any)']")private WebElement Nomineename;
	@FindBy(xpath="//input[@placeholder='Nominee Account no']")private WebElement Nomineeaccnt;
	
	
	public WebElement getPancard() {
		return Pancard;
	}

	public WebElement getCitizen() {
		return citizen;
	}

	public WebElement getHomeaddress() {
		return homeaddress;
	}

	public WebElement getOfficeaddress() {
		return Officeaddress;
	}
	@FindBy(xpath="//input[@placeholder='PAN Number']")private WebElement Pancard;
	@FindBy(xpath="//input[@placeholder='Citizenship Number']")private WebElement citizen;
	@FindBy(xpath="//input[@placeholder='Home Address']")private WebElement homeaddress;
	@FindBy(xpath="//input[@placeholder='Office Address']")private WebElement Officeaddress;
	
	public WebElement getOpenAccountsubmit() {
		return OpenAccountsubmit;
	}
	
	public WebElement getNametext() {
		return Nametext;
	}
	public WebElement getGender() {
		return Gender;
	}
	public WebElement getMobiletext() {
		return Mobiletext;
	}
	public WebElement getEmail() {
		return Email;
	}
	public WebElement getLandlinetext() {
		return Landlinetext;
	}
	public WebElement getAccntConfirm() {
		return AccntConfirm;
	}
	public WebElement getGobackbutton() {
		return Gobackbutton;
	}
	public WebElement getBirthfield() {
		return Birthfield;
	}
	public WebElement getState() {
		return State;
	}
	public WebElement getCity() {
		return City;
	}
	public WebElement getAccountype() {
		return Accountype;
	}
	
	
	//Business Libraries
	
	public void selectclass(WebElement Ele, String Value) {
		Select sel = new Select(Ele);
		sel.selectByValue(Value);
	}
	public void alertGetText(WebDriver driver,String alerttext) {
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
	}
	public void maximizewindow(WebDriver driver) {

		driver.manage().window().maximize();
	}
	public void miniimizewindow(WebDriver driver) {

		driver.manage().window().minimize();
	}
	public void implicittime(WebDriver driver, int sec) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}
	public String readdatafromproperyfile(String key) throws IOException {

		FileInputStream fis = new FileInputStream(IpathConstant.Filepath);
		Properties pob = new Properties();
		pob.load(fis);
		String value = pob.getProperty(key);
		return value;
	}
}
