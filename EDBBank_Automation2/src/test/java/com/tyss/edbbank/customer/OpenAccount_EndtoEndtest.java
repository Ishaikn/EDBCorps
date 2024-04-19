package com.tyss.edbbank.customer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.Banking.EDBbank.Customer_registrationPage;
import com.Banking.EDBbank.HomePage;
import com.Banking.EDBbank.WebUtilityPage;
import com.GenericUtilities.BaseClass;
import com.GenericUtilities.DatabaseUtillity;
import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebDriverUtility;

public class OpenAccount_EndtoEndtest extends BaseClass {

	@Test
	public void openaccount() throws Throwable {

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
		String Name = EUtil.readdatafromexcelsheet("EDB_Customer", 0, 1);
		String Mobile = EUtil.readdatafromexcelsheet("EDB_Customer", 2, 1);
		String Email = EUtil.readdatafromexcelsheet("EDB_Customer", 3, 1);
		String Landline = EUtil.readdatafromexcelsheet("EDB_Customer", 4, 1);
		String Pan = EUtil.readdatafromexcelsheet("EDB_Customer", 6, 1);
		String Citizen = EUtil.readdatafromexcelsheet("EDB_Customer", 7, 1);
		String HomeAddress = EUtil.readdatafromexcelsheet("EDB_Customer", 8, 1);
		String OfficeAddress = EUtil.readdatafromexcelsheet("EDB_Customer", 9, 1);
		String State = EUtil.readdatafromexcelsheet("EDB_Customer", 10, 1);
		String City = EUtil.readdatafromexcelsheet("EDB_Customer", 11, 1);
		String Pincode = EUtil.readdatafromexcelsheet("EDB_Customer", 13, 1);
		String Area = EUtil.readdatafromexcelsheet("EDB_Customer", 14, 1);
		String NomineeName = EUtil.readdatafromexcelsheet("EDB_Customer", 15, 1);
		String NomineeAccount = EUtil.readdatafromexcelsheet("EDB_Customer", 16, 1);

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

	}
}

//String Name = Cust.getRow(0).getCell(1).getStringCellValue();
//String Mobile = Cust.getRow(2).getCell(1).getStringCellValue();
//String Email = Cust.getRow(3).getCell(1).getStringCellValue();
//String Landline = Cust.getRow(4).getCell(1).getStringCellValue();
//String Pan = Cust.getRow(6).getCell(1).getStringCellValue();
//String Citizen = Cust.getRow(7).getCell(1).getStringCellValue();
//String HomeAddress = Cust.getRow(8).getCell(1).getStringCellValue();
//String OfficeAddress = Cust.getRow(9).getCell(1).getStringCellValue();
//String State = Cust.getRow(10).getCell(3).getStringCellValue();
//String City = Cust.getRow(11).getCell(8).getStringCellValue();
//String Pincode = Cust.getRow(13).getCell(1).getStringCellValue();
//String Area = Cust.getRow(14).getCell(1).getStringCellValue();
//String NomineeName = Cust.getRow(15).getCell(1).getStringCellValue();
//String NomineeAccount = Cust.getRow(16).getCell(1).getStringCellValue();
//driver.findElement(By.xpath("//li[text()='Open Account']")).click();
//WebUtils.selectclass(WebUtils.getGender(), "Male");
//Wutil.handledropdown("Male", Accountregpage.getGender());
//Wutil.alertGetText(driver, "alerttext");
//Wutil.maximizewindow(driver);
//Wutil.implicittime(driver, 5);
//Wutil.handledropdown("Miami", Accountregpage.getCity());
//Wutil.handledropdown("Florida", Accountregpage.getState());
//Alert alert = driver.switchTo().alert();
//System.out.println(alert.getText());
//alert.accept();
//WebElement type = driver.findElement(By.xpath("//select[@name='acctype']"));
//Select sel3 = new Select(type);
//sel3.selectByVisibleText("Saving");

//WebElement Cities = driver.findElement(By.xpath("//select[@name='city']"));
//WebElement states = driver.findElement(By.xpath("//option[text()='State']/parent::select[@name='state']"));
//WebElement Birth = driver.findElement(By.xpath("//input[@placeholder='Date of Birth']"));
//WebElement Gender = driver.findElement(By.xpath("//option[text()='Gender']/parent::select[@name='gender']"));
//driver.findElement(By.xpath("//input[@placeholder='Landline no']")).sendKeys(Landline);
//driver.findElement(By.xpath("//input[@placeholder='Email id']")).sendKeys(Email);
//driver.findElement(By.xpath("//input[@placeholder='Mobile no']")).sendKeys(Mobile);
//		driver.findElement(By.xpath("//li[text()='Open Account']")).click();
//		String custpwd = Eutil.readdatafromexcelsheet("EDB_Customer", 1, 1);
//		Select sel = new Select(Gender);
//		sel.selectByVisibleText("Male");
//		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys(Name);
//		
//
//		System.out.println(alert.getText());
//		alert.accept();
//		driver.findElement(By.name("submit")).click();

//		driver.findElement(By.xpath("//input[@name='cnfrm-submit']")).click();
//		Select sel1 = new Select(states);
//		sel1.selectByVisibleText("Florida");
//		Select sel1 = new Select(states);
//		sel1.selectByVisibleText("Florida");
//		Select sel2 = new Select(Cities);
//		sel2.selectByVisibleText("Miami");
//		ChromeOptions option = new ChromeOptions();

//		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\OpenAccount.properties");

//431462416

// Pobj.setProperty("staffid", "210001");

//	FileInputStream Excel = new FileInputStream(".\\src\\test\\resources\\Testdata.xlsx");
//	Workbook wrk = WorkbookFactory.create(Excel);
//	Sheet sht1 = wrk.getSheet("EDB");
//	
//	sht1.createRow(1).createCell(0).setCellValue("irshad");
//	sht1.getRow(1).createCell(1).setCellValue("Aairah");
//	sht1.getRow(1).createCell(2).setCellValue("India");
//	sht1.getRow(1).createCell(3).setCellValue("Punganur");
//	sht1.getRow(1).createCell(4).setCellValue("Andhra");
//
//	FileOutputStream fout1 = new FileOutputStream(".\\src\\test\\resources\\Testdata.xlsx");
//	wrk.write(fout1);
//
//	wrk.close()

//Gender
//		List<WebElement> Gender = driver
//				.findElements(By.xpath("//option[text()='Gender']/parent::select[@name='gender']"));
//		for (WebElement Gen : Gender) {
//			System.out.println(Gen.getText());
//		}
//		// State
//
//		List<WebElement> States = driver
//				.findElements(By.xpath("//option[text()='State']/parent::select[@name='state']"));
//		for (WebElement state : States) {
//			System.out.println(state.getText());
//			// City
//			WebElement Ele = driver.findElement(By.xpath("//select[@name='city']"));
//			Select Sel = new Select(Ele);
//			List<WebElement> cities = driver
//					.findElements(By.xpath("//option[text()='City']/parent::select[@name='city']"));
//			for (WebElement City : cities) {
//				System.out.println(City.getText());
//List<WebElement> States = driver
//.findElements(By.xpath("//option[text()='Account Type']/parent::select[@name='acctype']"));
//for (WebElement state : States) {
//System.out.println(state.getText());
//}
