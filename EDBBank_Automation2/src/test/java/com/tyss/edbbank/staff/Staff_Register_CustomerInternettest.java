package com.tyss.edbbank.staff;

import static org.testng.Assert.fail;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.Banking.EDBbank.CustLoginPage;
import com.Banking.EDBbank.FuntransferPage;
import com.Banking.EDBbank.HomePage;
import com.Banking.EDBbank.InternetRagistrationPage;
import com.Banking.EDBbank.WebUtilityPage;
import com.Banking.EDBbank.cust_statementPage;
import com.GenericUtilities.BaseClass;
import com.GenericUtilities.DatabaseUtillity;
import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebDriverUtility;

public class Staff_Register_CustomerInternettest extends BaseClass {
	@Test
	public void StaffRegister_Customer() throws Throwable {

		String Browser = FUtil.readdatafromproperyfile("browser");
		String URL = FUtil.readdatafromproperyfile("url");
		String StaffLogin = FUtil.readdatafromproperyfile("staffid");
		String Staffpwd = FUtil.readdatafromproperyfile("staffpassword");

		driver.get(URL);

		HomePage home = new HomePage(driver);
		FuntransferPage fund = new FuntransferPage(driver);
		CustLoginPage custlogin = new CustLoginPage(driver);
		WebUtilityPage webpage = new WebUtilityPage(driver);
		cust_statementPage statement = new cust_statementPage(driver);
		InternetRagistrationPage internReg = new InternetRagistrationPage(driver);

		webpage.scrollTillElement(driver, home.getInternetBankingLink());

		WUtil.movetoElement(driver, home.getInternetBankingLink());
		home.getInternetRegistration().click();
		String Pagetitle = driver.getTitle();

		if (Pagetitle.contains("")) {
			System.out.println("Internet Baking Registration Page Luanched");
		} else {
			System.out.println("Please relogin");
		}
		String Name = EUtil.readdatafromexcelsheet("InternetRegister-Staff", 0, 1);
		String AccountNumber = EUtil.readdatafromexcelsheet("InternetRegister-Staff", 1, 1);
		String Debitcard = EUtil.readdatafromexcelsheet("InternetRegister-Staff", 2, 1);
		String Pin = EUtil.readdatafromexcelsheet("InternetRegister-Staff", 3, 1);
		String Mobile = EUtil.readdatafromexcelsheet("InternetRegister-Staff", 4, 1);
		String Pancard = EUtil.readdatafromexcelsheet("InternetRegister-Staff", 5, 1);
		String Lsttrasaction = EUtil.readdatafromexcelsheet("InternetRegister-Staff", 6, 11);
		String Pwd = EUtil.readdatafromexcelsheet("InternetRegister-Staff", 7, 1);
		String Cpwd = EUtil.readdatafromexcelsheet("InternetRegister-Staff", 8, 1);

		internReg.getCustname().sendKeys(Name);
		internReg.getCustaccno().sendKeys(AccountNumber);
		internReg.getDebitcardno().sendKeys(Debitcard);
		internReg.getDebitpin().sendKeys(Pin);
		internReg.getMobile().sendKeys(Mobile);
		internReg.getPancard().sendKeys(Pancard);
		internReg.getBirth().click();

		internReg.getLasttransac().sendKeys(Lsttrasaction);
		internReg.getPassword().sendKeys(Pwd);
		internReg.getConfipassword().sendKeys(Cpwd);
		internReg.getSubmitbutton().click();

		Alert alert = driver.switchTo().alert();
		String POPup = alert.getText();
		System.out.println(POPup);
		alert.accept();
		driver.get(URL);
	}
}

















//FileInputStream EDB = new FileInputStream(".\\src\\test\\resources\\EDBTestdata.xlsx");
//Workbook book = WorkbookFactory.create(EDB);
//Sheet Cust = book.getSheet("InternetRegister-Staff");
//		Actions action1 = new Actions(driver).click();
//		action1.moveToElement(Cname).click().sendKeys(Name).sendKeys(Keys.TAB).sendKeys(AccountNumber).sendKeys(Keys.TAB)
//				.sendKeys(Debitcard).sendKeys(Keys.TAB).sendKeys(Pin).sendKeys(Keys.TAB).sendKeys(Mobile)
//				.sendKeys(Keys.TAB).sendKeys(Pancard).sendKeys(Keys.TAB).sendKeys("01").sendKeys("01").sendKeys("2001")
//				.sendKeys(Keys.TAB).sendKeys(Lsttrasaction).sendKeys(Keys.TAB).sendKeys(Pwd).sendKeys(Keys.TAB)
//				.sendKeys(Pwd).sendKeys(Keys.TAB).sendKeys(Keys.ENTER);

//driver.findElement(By.xpath("//input[@placeholder='Account Number']")).sendKeys(AccountNumber);
//driver.findElement(By.xpath("//input[@placeholder='Debit Card Number']")).sendKeys(Debitcard);
//driver.findElement(By.xpath("//input[@placeholder='Debit Card Pin']")).sendKeys(Pin);
//driver.findElement(By.xpath("//input[@placeholder='Registered Mobile (10 Digit)']")).sendKeys(Mobile);
//driver.findElement(By.xpath("//input[@placeholder='PAN Number']")).sendKeys(Pancard);
//WebElement Birth = driver.findElement(By.xpath("//input[@placeholder='Date of Birth']"));
//Birth.click();

//driver.findElement(By.xpath("//input[@placeholder='Last Transaction ($)']")).sendKeys(Lsttrasaction);
//driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(Pwd);
//driver.findElement(By.xpath("//input[@placeholder='Confirm Password']")).sendKeys(Cpwd);
//
//driver.findElement(By.name("submit")).click()

//	WebElement Cname = driver.findElement(By.xpath("//input[@placeholder='Account Holder Name']"));
//Cname.sendKeys(Name);

//WebElement internet = driver.findElement(By.xpath("//a[contains(text(),'Internet Bank')]"));
//JavascriptExecutor jss = (JavascriptExecutor) driver;
//jss.executeScript("arguments[0].scrollIntoView(true);", internet);
//Actions action = new Actions(driver);
//action.moveToElement(internet).perform();
//driver.findElement(By.xpath("//li[text()='Register']")).click();
