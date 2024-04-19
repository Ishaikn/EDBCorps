//package com.tyss.edbbank.customer;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.time.Duration;
//import java.util.Properties;
//
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.interactions.Actions;
//
//import com.GenericUtilities.BaseClass;
//
//public class InternetLogin_Changepwdtest extends BaseClass {
//
//
//	public static void main(String[] args) throws Exception {
//
//		Properties pobj = new Properties();
//		pobj.setProperty("browser", "chrome");
//		pobj.setProperty("url", "http://rmgtestingserver/domain/Online_Banking_System/index.php");
//
//		FileOutputStream fous = new FileOutputStream(".\\src\\test\\resources\\OpenAccount.properties");
//
//		String Browser = pobj.getProperty("browser");
//		String URL = pobj.getProperty("url");
//
//		pobj.store(fous, "data");
//
//		if (Browser.equals("chrome")) {
//			driver = new FirefoxDriver();
//		}
//		driver.get(URL);
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
//		WebElement internet = driver.findElement(By.xpath("//a[contains(text(),'Internet Banking')]"));
//
//		JavascriptExecutor jss = (JavascriptExecutor) driver;
//		jss.executeScript("window.scrollBy(0,100)");
//
//		Actions action = new Actions(driver);
//		action.moveToElement(internet).perform();
//
//		driver.findElement(By.xpath("//li[.='Register']")).click();
//
//		String title = driver.getTitle();
//		if (title.equals("Internet Banking Registration")) {
//			System.out.println("Dear Cutomer: You are now in Internet Registration Page");
//
//		} else {
//			throw new Exception(
//					"Dear customer please check your WebPage once. Please use valid Internet Registration Page for Internet Banking Registration");
//		}
//		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\EDBTestdata.xlsx");
//		Workbook book = WorkbookFactory.create(fis);
//		book.createSheet("IRegistration");
//
//		FileOutputStream fout = new FileOutputStream(".\\src\\test\\resources\\EDBTestdata.xlsx");
//		book.write(fout);
//		
//		
//	}
//}
