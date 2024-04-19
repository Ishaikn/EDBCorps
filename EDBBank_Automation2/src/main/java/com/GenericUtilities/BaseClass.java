package com.GenericUtilities;

import org.testng.annotations.BeforeClass;

import com.Banking.EDBbank.HomePage;
import com.Banking.EDBbank.StaffLoginPage;

import java.io.IOException;
import java.sql.SQLException;

import org.checkerframework.common.util.report.qual.ReportCall;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.*;

public class BaseClass {
	public WebDriver driver;
	public DatabaseUtillity DUtil = new DatabaseUtillity();
	public ExcelUtility EUtil = new ExcelUtility();
	public FileUtility FUtil = new FileUtility();
	public JavaUtility JUtil = new JavaUtility();
	public WebDriverUtility WUtil = new WebDriverUtility();
	public static WebDriver sdriver;

	@BeforeSuite(alwaysRun = true)
	public void connectToDB() throws SQLException {
//		DUtil.connectoDB();
		Reporter.log("-- DB connected--", true);
	}

	@BeforeClass(alwaysRun = true)
	public void launchBrowser() throws IOException {
		String Browser = FUtil.readdatafromproperyfile("browser");
		if (Browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (Browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (Browser.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			System.out.println(" Please choose valid Browser to Luanch tne Application");
		}Reporter.log("-- Browser Launched--", true);
		sdriver =driver;
		WUtil.maximizewindow(driver);
		WUtil.implicittime(driver, 4);
	}

	@BeforeMethod(alwaysRun = true)
	public void logintoApp() throws IOException, InterruptedException {
		
		String url = FUtil.readdatafromproperyfile("url");
		driver.get(url);
		WUtil.maximizewindow(driver);
		WUtil.implicittime(driver, 4);
		Reporter.log("-- Banking Application Home Page Displayed--", true);
		
	}@AfterClass(alwaysRun = true)
	public void closebrowser() {
		driver.quit();
	}
	@AfterSuite(alwaysRun = true)
	public void databaseclose() {
		
	}
}
//Stafflogin.getStaffLoginlink().click();
//String Staffid = FUtil.readdatafromproperyfile(("staffid"));
//String staffpwd = FUtil.readdatafromproperyfile("staffpassword");
//Stafflogin.getStaffid().sendKeys(Staffid);
//Stafflogin.getStaffpassword().sendKeys(staffpwd);
//Stafflogin.getLoginbutton().click();
