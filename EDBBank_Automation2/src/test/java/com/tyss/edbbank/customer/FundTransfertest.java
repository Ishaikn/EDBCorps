package com.tyss.edbbank.customer;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Banking.EDBbank.CustLoginPage;
import com.Banking.EDBbank.FuntransferPage;
import com.Banking.EDBbank.HomePage;
import com.Banking.EDBbank.WebUtilityPage;
import com.Banking.EDBbank.cust_statementPage;
import com.GenericUtilities.BaseClass;
import com.GenericUtilities.DatabaseUtillity;
import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebDriverUtility;
@Listeners(com.GenericUtilities.ListenerClass.class)
public class FundTransfertest extends BaseClass{

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
}
//String Browser = Futil.readdatafromproperyfile("browser");
//String URL = Futil.readdatafromproperyfile("url");
//
//String Custacc = Eutil.readdatafromexcelsheet("FundTransfer", 1, 1);
//if (Browser.equals("chrome")) {
//	driver = new ChromeDriver();
//
//	Wutil.maximizewindow(driver);
//	Wutil.implicittime(driver, 5);
//} else {
//	System.out.println(" ");
//}
//driver.get(URL);

//driver.findElement(By.name("logout_btn")).click();
//Read Data from the Property File

//Futil.setdataintoproperyfile("staffid", "210001");
//Futil.setdataintoproperyfile("Password", "password");
//Properties Pobj = new Properties();

//Pobj.setProperty("browser", "chrome");
//Pobj.setProperty("url", "http://rmgtestingserver/domain/Online_Banking_System/index.php");
//driver.findElement(By.xpath("//li[text()='Login ']")).click();
//FileOutputStream fout = new FileOutputStream(".\\src\\test\\resources\\OpenAccount.properties");
//Pobj.store(fout, "data");

//home.getInternetBankingLink().click();
//action.moveToElement(internet).perform();
//Wutil.scrollTillElement(driver, home.getInternetBankingLink());
//driver.findElement(By.name("fnd_trns_btn")).click();
//fund.getSelectBenef()
////WebElement Benef = driver.findElement(By.name("beneficiary"));
//Alert alert = driver.switchTo().alert();
//driver.findElement(By.xpath("//li[text()='Statement']")).click();
//driver.findElement(By.name("verify-btn")).click();
//driver.findElement(By.xpath("//input[@placeholder='OTP Code']")).sendKeys(Otp);
//driver.findElement(By.xpath("//li[text()='Fund Transfer']")).click();
//String Browser = Pobj.getProperty("browser");
//String URL = Pobj.getProperty("url");

//Eutil.readdatafromexcelsheet("Cust", 1, 1);
//FileInputStream EDB = new FileInputStream(".\\src\\test\\resources\\EDBTestdata.xlsx");
//Workbook book = WorkbookFactory.create(EDB);
//Sheet Cust = book.getSheet("FundTransfer");
//driver.findElement(By.xpath("//input[@name='add_beneficiary_btn']")).click();
//WebElement Accounttype = driver.findElement(By.name("beneficiary_acc_type"));
//driver.findElement(By.xpath("//input[@placeholder='Beneficiary Name']")).sendKeys(BName);
//driver.findElement(By.xpath("//input[@placeholder='Beneficiary A/c no']")).sendKeys(BAccount);
//driver.findElement(By.xpath("//input[@placeholder='IFSC Code']")).sendKeys(IFSC);
//driver.findElement(By.name("add_beneficiary")).click();
//driver.findElement(By.xpath("//li[text()='Fund Transfer']")).click();
//String custid = Cust.getRow(0).getCell(1).getStringCellValue();
//String custpwd = Cust.getRow(1).getCell(1).getStringCellValue();
//driver.findElement(By.name("customer_id")).sendKeys(Custid);
//driver.findElement(By.name("password")).sendKeys(custpwd);
//driver.findElement(By.className("login-btn")).click();
//WebElement internet = driver.findElement(By.xpath("//a[contains(text(),'Internet Bank')]"));
//Select sel = new Select(Accounttype);
//sel.selectByVisibleText("Saving");
//Select sel1 = new Select(Benef);
//sel1.selectByVisibleText(" Test Titans-1011811011623 ");
//JavascriptExecutor jss = (JavascriptExecutor) driver;
//jss.executeScript("arguments[0].scrollIntoView(true);", internet);

//Actions action = new Actions(driver);
//	List<WebElement> beneficiarys=driver.findElements(By.name("beneficiary"));
//	
//	for(WebElement list:beneficiarys) {
//		list.getText().equalsIgnoreCase(" Test Titans-1011811011623 ");
//		list.click();