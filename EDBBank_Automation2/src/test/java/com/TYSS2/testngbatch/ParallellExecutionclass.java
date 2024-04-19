package com.TYSS2.testngbatch;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.Banking.EDBbank.CreditCustomerPage;
import com.Banking.EDBbank.CustLoginPage;
import com.Banking.EDBbank.Customer_registrationPage;
import com.Banking.EDBbank.Customerbankingpage;
import com.Banking.EDBbank.FuntransferPage;
import com.Banking.EDBbank.HomePage;
import com.Banking.EDBbank.StaffLoginPage;
import com.Banking.EDBbank.WebUtilityPage;
import com.Banking.EDBbank.cust_statementPage;
import com.Banking.EDBbank.staff_profilePage;
import com.GenericUtilities.BaseClass;

import com.GenericUtilities.ExcelUtility;

import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebDriverUtility;

public class ParallellExecutionclass extends BaseClass {
	@Test
	public void FundingAmount() throws Throwable {
		HomePage home = new HomePage(driver);
		FuntransferPage fund = new FuntransferPage(driver);
		CustLoginPage custlogin = new CustLoginPage(driver);
		WebUtilityPage webpage = new WebUtilityPage(driver);
		cust_statementPage statement = new cust_statementPage(driver);

		webpage.scrollTillElement(driver, home.getInternetBankingLink());

		WUtil.movetoElement(driver, home.getInternetBankingLink());

		home.getLoginLink().click();

		String Pageurl = driver.getCurrentUrl();
		if (Pageurl.contains("customer_profile.php")) {
			System.out.println("Customer is in Internet Banking Page");
		} else {
			System.out.println("Please redirect to Internet Login Form");
		}
		String Custid = EUtil.readdatafromexcelsheet("FundTransfer", 0, 1);
		String custpwd = EUtil.readdatafromexcelsheet("FundTransfer", 1, 1);

		custlogin.getCustid().sendKeys(Custid);
		custlogin.getCustpwd().sendKeys(custpwd);
		custlogin.getCustloginbutton().click();

		fund.getFundTransfer().click();
		fund.getaddbenef().click();

		String BName = EUtil.readdatafromexcelsheet("FundTransfer", 2, 1);
		String BAccount = EUtil.readdatafromexcelsheet("FundTransfer", 3, 1);
		String IFSC = EUtil.readdatafromexcelsheet("FundTransfer", 4, 1);

		fund.getBeneName().sendKeys(BName);
		fund.getBeneacnt().sendKeys(BAccount);
		fund.getIFSCcode().sendKeys(IFSC);

		WUtil.handledropdown("Saving", fund.getbenefacnttype());
		Thread.sleep(1000);
		fund.getaddbeneficiarybutton().click();
		Thread.sleep(3000);
		WUtil.getAlertText(driver);
		WUtil.acceptAlert(driver);
		fund.getFundTransfer().click();
		
//		fund.getSelectBenef().click();
		Thread.sleep(1000);
		webpage.selectclasstext(fund.getSelectBenef()," Test Titans-1011811011623 ");
		
		String amount = EUtil.readdatafromexcelsheet("FundTransfer", 5, 1);
		fund.getTransferamount().sendKeys(amount);
		fund.getRemarks().sendKeys("Funding");
		fund.getFundtransferbutton().click();

		WebElement OTPtext = driver.findElement(By.xpath("//label[@class='OTP_msg']"));
		System.out.println(OTPtext.getText());
		String[] Lines = OTPtext.getText().split("\\r?\\\n");

		String Otp = "";
		for (String line : Lines) {
			if (line.startsWith("*OTP :")) {
				String[] parts = line.split(":");
				Otp = parts[1].trim();
				break;
			}
		}

		fund.getOtptext().sendKeys(Otp);

		fund.getOTPverifybutton().click();

		WUtil.acceptAlert(driver);

		statement.getStatementlink().click();

		Robot robo = new Robot();
		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_F);
		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_F);
		String text1 = amount;
		StringSelection stringSelection1 = new StringSelection(text1);
		Clipboard clipboard1 = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard1.setContents(stringSelection1, stringSelection1);

		if (amount.equals(text1)) {
			System.out.println("Amount has been Transferred");
		} else {
			System.out.println("Amount not yet credited");
		}
		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_V);
		robo.keyRelease(KeyEvent.VK_V);
		robo.keyRelease(KeyEvent.VK_CONTROL);
		
		fund.getLogoutbutton().click();

		

		System.out.println(" Welcome to EDBBanking Home Page");
	}
@Test
	public void openaccount() throws IOException, InterruptedException {

		String Browser = FUtil.readdatafromproperyfile("browser");
		String URL = FUtil.readdatafromproperyfile("url");
		driver.get(URL);
		HomePage home = new HomePage(driver);
		Customer_registrationPage Accountregpage = new Customer_registrationPage(driver);
		WebUtilityPage WebUtils = new WebUtilityPage(driver);

		home.getOpenAccountlink().click();
		String titleText = driver.getTitle();
		String Actual = "Registration Form";
		if (titleText.equals(Actual)) {
			System.out.println("Dear Customer Please proceed with further Account Opening Process");
		} else {
			System.out.println("Please check the WebPage to be Tested");
		}
		FileInputStream EDB = new FileInputStream(".\\src\\test\\resources\\EDBTestdata.xlsx");
		Workbook book = WorkbookFactory.create(EDB);
		Sheet Cust = book.getSheet("EDB_Customer");

		String Name = Cust.getRow(0).getCell(1).getStringCellValue();
		String Mobile = Cust.getRow(2).getCell(1).getStringCellValue();
		String Email = Cust.getRow(3).getCell(1).getStringCellValue();
		String Landline = Cust.getRow(4).getCell(1).getStringCellValue();
		String Pan = Cust.getRow(6).getCell(1).getStringCellValue();
		String Citizen = Cust.getRow(7).getCell(1).getStringCellValue();
		String HomeAddress = Cust.getRow(8).getCell(1).getStringCellValue();
		String OfficeAddress = Cust.getRow(9).getCell(1).getStringCellValue();
		String State = Cust.getRow(10).getCell(3).getStringCellValue();
		String City = Cust.getRow(11).getCell(8).getStringCellValue();
		String Pincode = Cust.getRow(13).getCell(1).getStringCellValue();
		String Area = Cust.getRow(14).getCell(1).getStringCellValue();
		String NomineeName = Cust.getRow(15).getCell(1).getStringCellValue();
		String NomineeAccount = Cust.getRow(16).getCell(1).getStringCellValue();

		Accountregpage.getNametext().sendKeys(Name);
		Accountregpage.selectclass(Accountregpage.getGender(), "Male");

		Accountregpage.getMobiletext().sendKeys(Mobile);
		Accountregpage.getEmail().sendKeys(Email);
		Accountregpage.getLandlinetext().sendKeys(Landline);

		WebUtils.mouseHoveronDOB(driver, Accountregpage.getBirthfield(), "13", "01", "1999");
		Accountregpage.getPancard().sendKeys(Pan);
		Accountregpage.getCitizen().sendKeys(Citizen);
		Accountregpage.getHomeaddress().sendKeys(HomeAddress);
		Accountregpage.getOfficeaddress().sendKeys(OfficeAddress);

		Accountregpage.selectclass(Accountregpage.getState(), "Florida");

		Accountregpage.selectclass(Accountregpage.getCity(), "Miami");

		Accountregpage.getPincode().sendKeys(Pincode);
		Accountregpage.getArea().sendKeys(Area);
		Accountregpage.getNomineename().sendKeys(NomineeName);
		Accountregpage.getNomineeaccnt().sendKeys(NomineeAccount);

		Accountregpage.selectclass(Accountregpage.getAccountype(), "Saving");

		Accountregpage.getOpenAccountsubmit().click();

		Accountregpage.getAccntConfirm().click();

		Accountregpage.alertGetText(driver, "alerttext");

		System.out
				.println("Dear Customer Please make a Note of the Application Number. Thank You for Banking with us.");

	}@Test(groups="Integration", priority = -1)
	public void Credit_statement() throws Throwable {
		String Browser = FUtil.readdatafromproperyfile("browser");
		String URL = FUtil.readdatafromproperyfile("url");
		String StaffLogin = FUtil.readdatafromproperyfile("staffid");
		String Staffpwd = FUtil.readdatafromproperyfile("staffpassword");
		HomePage home = new HomePage(driver);
		StaffLoginPage staffloginpage = new StaffLoginPage(driver);
		staff_profilePage staffpro = new staff_profilePage(driver);
		CreditCustomerPage creditcust = new CreditCustomerPage(driver);
		WebUtilityPage webpage = new WebUtilityPage(driver);
		CustLoginPage custlogin = new CustLoginPage(driver);
		cust_statementPage statement = new cust_statementPage(driver);
		Customerbankingpage custpro = new Customerbankingpage(driver);
		Thread.sleep(2000);
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

		String Custacc = EUtil.readdatafromexcelsheet("CustomerCredentials", 1, 1);
		creditcust.getCustaccnt().sendKeys(Custacc);
		String amount1 = "8888";

		creditcust.getAmount().sendKeys(amount1);
		creditcust.getCreditbutton().click();

		WUtil.alertGetText(driver, "alerttext");
		staffpro.getStaffLogout().click();
		
	
		staffloginpage.getHomepagelink().click();
//		driver.get(URL);

		webpage.scrollTillElement(driver, home.getInternetBankingLink());

		WUtil.movetoElement(driver, home.getInternetBankingLink());

		home.getLoginLink().click();


		String Pagettitle = driver.getTitle();
		if (Pagettitle.contains("ebanking_reg_form")) {
			System.out.println("Customer is in Internet Login Page");
		} else {
			System.out.println("Please redirect to Internet Login Form");
		}
		
		String custid = EUtil.readdatafromexcelsheet("CustomerCredentials", 9, 1);
		String custpwd = EUtil.readdatafromexcelsheet("CustomerCredentials", 10, 1);

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
