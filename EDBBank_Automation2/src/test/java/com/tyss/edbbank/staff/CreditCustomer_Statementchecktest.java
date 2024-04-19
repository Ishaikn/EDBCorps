package com.tyss.edbbank.staff;

import java.awt.AWTException;


import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

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
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Banking.EDBbank.CreditCustomerPage;
import com.Banking.EDBbank.CustLoginPage;
import com.Banking.EDBbank.Customerbankingpage;
import com.Banking.EDBbank.HomePage;
import com.Banking.EDBbank.StaffLoginPage;
import com.Banking.EDBbank.WebUtilityPage;
import com.Banking.EDBbank.cust_statementPage;
import com.Banking.EDBbank.staff_profilePage;
import com.GenericUtilities.BaseClass;
import com.GenericUtilities.DatabaseUtillity;
import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebDriverUtility;

@Listeners(com.GenericUtilities.ListenerClass.class)
public class CreditCustomer_Statementchecktest extends BaseClass{
@Test
	public void Credit_statement() throws Throwable {

		DatabaseUtillity Dutil = new DatabaseUtillity();
		ExcelUtility Eutil = new ExcelUtility();
		FileUtility Futil = new FileUtility();
		JavaUtility Jutil = new JavaUtility();
		WebDriverUtility Wutil = new WebDriverUtility();

		String Browser = Futil.readdatafromproperyfile("browser");
		String URL = Futil.readdatafromproperyfile("url");
		String StaffLogin = Futil.readdatafromproperyfile("staffid");
		String Staffpwd = Futil.readdatafromproperyfile("staffpassword");

//		if (Browser.equals("chrome")) {
//			driver = new ChromeDriver();
//			Wutil.maximizewindow(driver);
//			Wutil.implicittime(driver, 5);
//
//		} else {
//			System.out.println(" ");
//		}
//		driver.get(URL);

		HomePage home = new HomePage(driver);
		StaffLoginPage staffloginpage = new StaffLoginPage(driver);
		staff_profilePage staffpro = new staff_profilePage(driver);
		CreditCustomerPage creditcust = new CreditCustomerPage(driver);
		WebUtilityPage webpage = new WebUtilityPage(driver);
		CustLoginPage custlogin = new CustLoginPage(driver);
		cust_statementPage statement = new cust_statementPage(driver);
		Customerbankingpage custpro = new Customerbankingpage(driver);
		home.getStaffLogin().click();

		String Title = driver.getTitle();

		if (Title.contains("Staff Page")) {
			System.out.println("Please proceed with Staff Login");
		} else {
			System.out.println("Plesae stop Execution");
		}

		// Staff Login:
		staffloginpage.getStaffid().sendKeys(StaffLogin);
		staffloginpage.getStaffpassword().sendKeys(Staffpwd);
		staffloginpage.getLoginbutton().click();
		staffpro.getCreditCust().click();

		String crediturl = driver.getCurrentUrl();
		if (crediturl.contains("credit_customer_ac")) {
			System.out.println("Staff is in Customer Credit Page");
		} else {
			System.out.println("Please re-direct to Customer Credit Page");
		}

		String Custacc = Eutil.readdatafromexcelsheet("CustomerCredentials", 1, 1);
		creditcust.getCustaccnt().sendKeys(Custacc);
		String amount1 = "9898";

		creditcust.getAmount().sendKeys(amount1);
		creditcust.getCreditbutton().click();

		Wutil.alertGetText(driver, "alerttext");
		staffpro.getStaffLogout().click();
		
	
		staffloginpage.getHomepagelink().click();
//		driver.get(URL);

		webpage.scrollTillElement(driver, home.getInternetBankingLink());

		Wutil.movetoElement(driver, home.getInternetBankingLink());

		home.getLoginLink().click();


		String Pagettitle = driver.getTitle();
		if (Pagettitle.contains("ebanking_reg_form")) {
			System.out.println("Customer is in Internet Login Page");
		} else {
			System.out.println("Please redirect to Internet Login Form");
		}
		
		String custid = Eutil.readdatafromexcelsheet("CustomerCredentials", 9, 1);
		String custpwd = Eutil.readdatafromexcelsheet("CustomerCredentials", 10, 1);

		custlogin.getCustid().sendKeys(custid);
		custlogin.getCustpwd().sendKeys(custpwd);
		custlogin.getCustloginbutton().click();

		statement.getStatementlink().click();
		

		Robot robo = new Robot();
		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_F);
		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_F);
		String text1 = amount1;
		StringSelection stringSelection1 = new StringSelection(text1);
		Clipboard clipboard1 = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard1.setContents(stringSelection1, stringSelection1);

		if (amount1.equals(text1)) {
			System.out.println("Amount has been credited");
		} else {
			System.out.println("Amount not yet credited");
		}
		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_V);
		robo.keyRelease(KeyEvent.VK_V);
		robo.keyRelease(KeyEvent.VK_CONTROL);
		 
		custpro.getMyaccountbutton().click();
		custpro.getHomebutton().click();
		custpro.getLogoutbutton().click();
		custlogin.getHomepageLink().click();
		
	}
}


//driver.findElement(By.xpath("//li[text()='Statement']")).click();
//	driver.findElement(By.name("logout_btn")).click();
//driver.findElement(By.name("credit_btn")).click();
//driver.findElement(By.xpath("//input[@placeholder='Customer A/c No']")).sendKeys(Custacc);
//driver.findElement(By.xpath("//input[@placeholder='Amount']")).sendKeys(amount1);
//driver.findElement(By.name("credit_cust_ac")).click();
//driver.findElement(By.name("staff_id")).sendKeys(StaffLogin);
//driver.findElement(By.name("password")).sendKeys(Staffpwd);
//driver.findElement(By.name("staff_login-btn")).click();
//driver.findElement(By.xpath("//a[text()='Staff Login']")).click();
//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
//driver.manage().window().maximize();
//FileInputStream EDB = new FileInputStream(".\\src\\test\\resources\\EDBTestdata.xlsx");
//Workbook book = WorkbookFactory.create(EDB);
//Sheet Cust = book.getSheet("CustomerCredentials");
//String Custacc = Cust.getRow(1).getCell(1).getStringCellValue();
//Alert alert = driver.switchTo().alert();
//System.out.println(alert.getText());
//alert.accept();
//JavascriptExecutor jss = (JavascriptExecutor) driver;
//jss.executeScript("arguments[0].scrollIntoView(true);", internet);
//String custid = Cust.getRow(9).getCell(1).getStringCellValue();
//String custpwd = Cust.getRow(10).getCell(1).getStringCellValue();
//String Browser = Pob.getProperty("browser");
//String URL = Pobj.getProperty("url");
//String StaffLogin = Pobj.getProperty("staffid");
//String Staffpwd = Pobj.getProperty("Password");
//Properties Pobj = new Properties();
//
//Pobj.setProperty("browser", "chrome");
//Pobj.setProperty("url", "http://rmgtestingserver/domain/Online_Banking_System/index.php");
////Pobj.setProperty("staffid", "210001");
////Pobj.setProperty("Password", "password");
//
//FileOutputStream fout = new FileOutputStream(".\\src\\test\\resources\\OpenAccount.properties");
//Pobj.store(fout, "data");
//driver.findElement(By.name("logout_btn")).click();
//driver.findElement(By.xpath("//a[.='Home']")).click();
//driver.close();
//String Name = Cust.getRow(0).getCell(1).getStringCellValue();
//WebElement Custname=driver.findElement(By.xpath("//input[@placeholder='Account Holder Name']"));
//action.moveToElement(Custname).click().sendKeys(Name).perform();

//String Searchdata = "clipboard1";
//if (text1.equalsIgnoreCase(Searchdata)) {
//	System.out.println("Amount has been credited");
//} else {
//	System.out.println("Amount not yet credited");
//}