//package com.tyss.edbbank.staff;
//
//import java.awt.Robot;
//import java.awt.Toolkit;
//import java.awt.datatransfer.Clipboard;
//import java.awt.datatransfer.StringSelection;
//import java.awt.event.KeyEvent;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.time.Duration;
//import java.util.Properties;
//
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
//import org.openqa.selenium.Alert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import com.Banking.EDBbank.Staff_ViewCustaccountpage;
//import com.GenericUtilities.BaseClass;
//
//public class Viewcustomeracc_Deletetest extends BaseClass{
//
//
//	public static void main(String[] args) throws Exception {
//
//		Properties pobj = new Properties();
//		pobj.setProperty("browser", "chrome");
//		pobj.setProperty("url", "http://rmgtestingserver/domain/Online_Banking_System/index.php");
//		pobj.setProperty("staffid", "210001");
//		pobj.setProperty("Password", "password");
//		pobj.setProperty("reason", "Account is in Active status");
//		String StaffLogin = pobj.getProperty("staffid");
//		String Staffpwd = pobj.getProperty("Password");
//		String Reason = pobj.getProperty("reason");
//
//		FileOutputStream fous = new FileOutputStream(".\\src\\test\\resources\\OpenAccount.properties");
//		String Browser = pobj.getProperty("browser");
//		String URL = pobj.getProperty("url");
//
//		pobj.store(fous, "data");
//
//		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\EDBTestdata.xlsx");
//
//		Workbook book = WorkbookFactory.create(fis);
//		Sheet sht = book.getSheet("delete customer");
//		sht.createRow(0).createCell(0).setCellValue("1011541011751");
//		String custacc = sht.getRow(0).getCell(0).getStringCellValue();
//
//		FileOutputStream fout = new FileOutputStream(".\\src\\test\\resources\\EDBTestdata.xlsx");
//		book.write(fout);
//
//		if (Browser.equals("chrome")) {
//			driver = new ChromeDriver();
//		}
//		driver.get(URL);
//		
//		Staff_ViewCustaccountpage custaccnt=new Staff_ViewCustaccountpage(driver);
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
//		driver.findElement(By.xpath("//a[text()='Staff Login']")).click();
//		String title = driver.getTitle();
//
//		if (title.equals("Staff Page")) {
//			System.out.println("Dear Cutomer: You are now in Staff Login Page");
//
//		} else {
//			throw new Exception(
//					"Dear customer please check your WebPage once. Please use valid Internet Registration Page for Internet Banking Registration");
//		}
//		driver.findElement(By.xpath("//input[@name='staff_id']")).sendKeys(StaffLogin);
//		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Staffpwd);
//		driver.findElement(By.xpath("//input[@name='staff_login-btn']")).click();
//
//		driver.findElement(By.name("home")).click();
//
//		driver.findElement(By.name("view_cust_by_ac")).click();
//
//		WebElement custsearch = driver.findElement(By.xpath("//input[@placeholder='Customer Account No']"));
//		custsearch.sendKeys(custaccnumb);
//		driver.findElement(By.name("submit_view")).click();
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
//		String text = driver.getTitle();
//		System.out.println(text);
//
//		if (text.equals("Customer Details")) {
//			System.out.println("Customer details found");
//			WebElement Custid = driver.findElement(By.xpath("//label[contains(text(),'Customer Id')]"));
//			String id = Custid.getText().substring(14);
//			System.out.println(id);
//			driver.findElement(By.name("home")).click();
//
//			driver.findElement(By.name("del_cust")).click();
//
//			driver.findElement(By.xpath("//input[@placeholder='Customer Account No']")).sendKeys(custaccnt);
//
//			driver.findElement(By.xpath("//input[@placeholder='Customer ID']")).sendKeys(id);
//			driver.findElement(By.xpath("//input[@placeholder='Reason']")).sendKeys(Reason);
//			driver.findElement(By.name("delete")).click();
//
//			Alert alert = driver.switchTo().alert();
//			System.out.println(alert.getText());
//			alert.accept();
//			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
//			driver.findElement(By.name("home")).click();
//			driver.findElement(By.name("viewdet")).click();
//			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));
//			custaccnt.clipboard(custacc);
//			Robot robo = new Robot();
//			robo.keyPress(KeyEvent.VK_CONTROL);
//			robo.keyPress(KeyEvent.VK_F);
//			robo.keyPress(KeyEvent.VK_CONTROL);
//			robo.keyPress(KeyEvent.VK_F);
//			String text1 = "custaccnumb";
//			StringSelection stringSelection1 = new StringSelection(text1);
//			Clipboard clipboard1 = Toolkit.getDefaultToolkit().getSystemClipboard();
//			clipboard1.setContents(stringSelection1, stringSelection1);
//
//		} else {
//
//			Alert alert1 = driver.switchTo().alert();
//			System.out.println(alert1.getText());
//			alert1.accept();
//
//		}
//		driver.findElement(By.name("logout_btn")).click();
//		book.close();
//
//		driver.close();
//	}
//}
