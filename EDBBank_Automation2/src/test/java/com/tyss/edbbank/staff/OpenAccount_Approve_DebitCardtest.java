package com.tyss.edbbank.staff;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.Banking.EDBbank.ApplyDebitcardpage;
import com.Banking.EDBbank.Customer_registrationPage;
import com.Banking.EDBbank.HomePage;
import com.Banking.EDBbank.Pending_customersPage;
import com.Banking.EDBbank.StaffLoginPage;
import com.Banking.EDBbank.WebUtilityPage;
import com.Banking.EDBbank.staff_profilePage;
import com.GenericUtilities.BaseClass;
import com.GenericUtilities.DatabaseUtillity;
import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebDriverUtility;

public class OpenAccount_Approve_DebitCardtest extends BaseClass{

@Test
	public void openaccounts() throws Throwable {
	
		//DatabaseUtillity Dutil = new DatabaseUtillity();
		ExcelUtility Eutil = new ExcelUtility();
		FileUtility Futil = new FileUtility();
		//JavaUtility Jutil = new JavaUtility();
		WebDriverUtility Wutil = new WebDriverUtility();
		String StaffLoginid = Futil.readdatafromproperyfile("staffid");
		String Staffpwd = Futil.readdatafromproperyfile("staffpassword");
		ApplyDebitcardpage Applycard = new ApplyDebitcardpage(driver);
		HomePage home = new HomePage(driver);
		Customer_registrationPage Accountregpage = new Customer_registrationPage(driver);
		StaffLoginPage SLoginpage = new StaffLoginPage(driver);
		staff_profilePage staffpro = new staff_profilePage(driver);
		Pending_customersPage approveaccnt = new Pending_customersPage(driver);
		WebUtilityPage webpage = new WebUtilityPage(driver);

		home.getOpenAccountlink().click();
		Thread.sleep(2000);
		String titleText = driver.getTitle();
		System.out.println(titleText);
		String Actual = "Registration Form";
		if (titleText.equals(Actual)) {
			System.out.println("Dear Customer Please proceed with further Account Opening Process");
		} else {
			System.out.println("Please check the WebPage to be Tested");
		}
	
		String Name = Eutil.readdatafromexcelsheet("EDB_Customer_Staffapprove2", 0, 1);
		String Mobile = Eutil.readdatafromexcelsheet("EDB_Customer_Staffapprove2", 2, 1);
		String Email = Eutil.readdatafromexcelsheet("EDB_Customer_Staffapprove2", 3, 1);
		String Landline = Eutil.readdatafromexcelsheet("EDB_Customer_Staffapprove2", 4, 1);
		String Pan = Eutil.readdatafromexcelsheet("EDB_Customer_Staffapprove2", 6, 1);
		String Citizen = Eutil.readdatafromexcelsheet("EDB_Customer_Staffapprove2", 7, 1);
		String HomeAddress = Eutil.readdatafromexcelsheet("EDB_Customer_Staffapprove2", 8, 1);
		String OfficeAddress = Eutil.readdatafromexcelsheet("EDB_Customer_Staffapprove2", 9, 1);
		String State = Eutil.readdatafromexcelsheet("EDB_Customer_Staffapprove2", 10, 1);
		String City = Eutil.readdatafromexcelsheet("EDB_Customer_Staffapprove2", 11, 1);
		String Pincode = Eutil.readdatafromexcelsheet("EDB_Customer_Staffapprove2", 13, 1);
		String Area = Eutil.readdatafromexcelsheet("EDB_Customer_Staffapprove2", 14, 1);
		String NomineeName = Eutil.readdatafromexcelsheet("EDB_Customer_Staffapprove2", 15, 1);
		String NomineeAccount = Eutil.readdatafromexcelsheet("EDB_Customer_Staffapprove2", 16, 1);

		Accountregpage.getNametext().sendKeys(Name);
		Accountregpage.selectclass(Accountregpage.getGender(), "Male");
		Accountregpage.getMobiletext().sendKeys(Mobile);
		Accountregpage.getEmail().sendKeys(Email);
		Accountregpage.getLandlinetext().sendKeys(Landline);
		webpage.mouseHoveronDOB(driver, Accountregpage.getBirthfield(), "13", "01", "1999");
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

		String Applicationno = Wutil.getapplicationnifromText(driver);
		System.out.println(Applicationno);
		Wutil.acceptAlert(driver);

//		driver.get("url");

		home.getStaffLogin().click();
//		driver.findElement(By.xpath("//a[text()='Staff Login']")).click();

		String Stafftitle = driver.getTitle();
		if (Stafftitle.contains("Staff Page")) {
			System.out.println("Please proceed with your Login");
		} else {

			System.out.println("Dear Staff: Please check your login page ");
		}

		SLoginpage.getStaffid().sendKeys(StaffLoginid);
		SLoginpage.getStaffpassword().sendKeys(Staffpwd);
		SLoginpage.getLoginbutton().click();
		staffpro.getApproveaccnt().click();

		approveaccnt.getAccntSearchfield().sendKeys("" + Applicationno);

		Thread.sleep(4000);
		approveaccnt.getSearchlink().click();
		approveaccnt.getApprovebuttn().click();
//		driver.findElement(By.xpath("//input[@name='approve_cust']")).click();
		Thread.sleep(3000);

		Wutil.acceptAlert(driver);
//		Alert alert1 = driver.switchTo().alert();
//		System.out.println(alert1.getText());
//		alert1.accept();
		System.out.println(" ");

		/// Apply for Debit Card//
		
		staffpro.getStaffLogout().click();
		SLoginpage.getHomepagelink().click();
	

		home.getApplyDebitCardLink().click();

		String AccountHolderName = Eutil.readdatafromexcelsheet("Apply Debit Card", 0, 1);
		String Pancard = Eutil.readdatafromexcelsheet("Apply Debit Card", 1, 1);
		String Phone = Eutil.readdatafromexcelsheet("Apply Debit Card", 2, 1);
		String AccountNumber = Eutil.readdatafromexcelsheet("Apply Debit Card", 3, 1);

		Applycard.getCustname().sendKeys(AccountHolderName);
		webpage.mouseHoveronDOB(driver, Accountregpage.getBirthfield(), "13", "01", "1999");
		Accountregpage.getPancard().sendKeys(Pancard);
		Accountregpage.getMobiletext().sendKeys(Mobile);
		Applycard.getAccountnumber().sendKeys(AccountNumber);

		Applycard.getDebitsubmit().click();
		Alert alert2 = driver.switchTo().alert();
		System.out.println(alert2.getText());
		Thread.sleep(4000);
		alert2.accept();
		System.out.println(" ");
		Applycard.getHomelink();

	}

}
//// Open Account///////
//String Browser = Futil.readdatafromproperyfile("browser");
//String URL = Futil.readdatafromproperyfile("url");
//
//if (Browser.equals("chrome")) {
//	driver = new ChromeDriver();
//
//	Wutil.maximizewindow(driver);
//	Wutil.implicittime(driver, 4);
//} else {
//	System.out.println(" ");
//}
//driver.get(URL);
//action.moveToElement(Applycard.getBirthdate()).click().sendKeys("25").sendKeys("04").sendKeys("1989").sendKeys(Keys.TAB)
//.sendKeys(Pancard).sendKeys(Keys.TAB).sendKeys(Phone).sendKeys(Keys.TAB).sendKeys(AccountNumber).build()
//.perform();
//Alert alert = driver.switchTo().alert();
//
//String ConfirmationPopup = alert.getText();
//System.out.println(ConfirmationPopup);
//alert.accept();
//System.out.println(" ");
//
//System.out
//		.println("Dear Customer Please make a Note of the Application Number. Thank You for Banking with us.");
//
//String[] lines = ConfirmationPopup.split("\\r?\\n");
//System.out.println(Arrays.toString(lines));
//int Application = 0;
//for (String line : lines) {
//	if (line.startsWith("Application number :")) {
//		String[] parts = line.split(":");
//		String applicationnoStr = parts[1].trim();
//		Application = Integer.parseInt(applicationnoStr);
//		break;
//	}return Application;
//}
//// Approve Pending Account////
///		driver.findElement(By.xpath("//input[@name='apprvac']")).click();
//WebElement Search = driver.findElement(By.xpath("//input[@placeholder='Application number']"));
//Search.sendKeys("" + Application);

//driver.findElement(By.xpath("//input[@name='search_application']")).click();
//driver.findElement(By.xpath("//input[@name='staff_id']")).sendKeys(StaffLogin);
//driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Staffpwd);
//driver.findElement(By.xpath("//input[@name='staff_login-btn']")).click();

//driver.findElement(By.xpath("//input[@placeholder='Mobile no']")).sendKeys(Mobile);
//driver.findElement(By.xpath("//input[@placeholder='Email id']")).sendKeys(Email);
//driver.findElement(By.xpath("//input[@placeholder='Landline no']")).sendKeys(Landline);
//WebElement Birth = driver.findElement(By.xpath("//input[@placeholder='Date of Birth']"));
//WebElement states = driver.findElement(By.xpath("//option[text()='State']/parent::select[@name='state']"));
//Select sel1 = new Select(states);
//sel1.selectByVisibleText("Florida");
//WebElement Cities = driver.findElement(By.xpath("//select[@name='city']"));
//Wutil.handledropdown("Miami", Cities);
//
//action.sendKeys(Keys.TAB).sendKeys(Pincode).sendKeys(Keys.TAB).sendKeys(Area).sendKeys(Keys.TAB)
//		.sendKeys(NomineeName).sendKeys(Keys.TAB).sendKeys(NomineeAccount).build().perform();
//
//WebElement type = driver.findElement(By.xpath("//select[@name='acctype']"));
//Wutil.handledropdown("Saving", type);

//driver.findElement(By.name("submit")).click();
//
//driver.findElement(By.xpath("//input[@name='cnfrm-submit']")).click();
//
//driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys(Name);
//WebElement Gender = driver.findElement(By.xpath("//option[text()='Gender']/parent::select[@name='gender']"));
//Wutil.handledropdown("Female", Gender);
//Select sel2 = new Select(Cities);
//sel2.selectByVisibleText("Miami");
//Select sel3 = new Select(type);
//sel3.selectByVisibleText("Saving");
//Select sel = new Select(Gender);
//sel.selectByVisibleText("Female");
//driver.findElement(By.xpath("//li[text()='Open Account']")).click();
///		Properties Pobj = new Properties();

//Pobj.setProperty("browser", "chrome");
//Pobj.setProperty("url", "http://rmgtestingserver/domain/Online_Banking_System/index.php");
//Pobj.setProperty("staffid", "210001");
//Pobj.setProperty("Password", "password");
//
//FileOutputStream fout = new FileOutputStream(".\\src\\test\\resources\\OpenAccount.properties");
//Pobj.store(fout, "data");
//);
//Sheet Cust1 = book.getSheet("Apply Debit Card");
//String AccountHolderName = Cust1.getRow(0).getCell(1).getStringCellValue();
//String Pancard = Cust1.getRow(1).getCell(1).getStringCellValue();
//String Phone = Cust1.getRow(2).getCell(1).getStringCellValue();
//String AccountNumber = Cust1.getRow(3).getCell(1).getStringCellValue();
//driver.findElement(By.xpath("//input[@name='dbt_crd_submit']")).click();
//driver.findElement(By.xpath("///input[@placeholder='PAN']")).sendKeys(Pancard);
//driver.findElement(By.xpath("//input[@placeholder='Registered Mobile (10 Digit)']")).sendKeys(Phone);
//driver.findElement(By.xpath("//input[@placeholder='Account No']")).sendKeys(AccountNumber);

//driver.findElement(By.xpath("//input[@placeholder='Account Holder Name']")).sendKeys(AccountHolderName);

//WebElement DOB = driver.findElement(By.xpath("//input[@placeholder='Date of Birth']"));

//String Name = Cust.getRow(0).getCell(1).getStringCellValue();
//String Mobile = Cust.getRow(2).getCell(1).getStringCellValue();
//String Email = Cust.getRow(3).getCell(1).getStringCellValue();
//String Landline = Cust.getRow(4).getCell(1).getStringCellValue();
//String Pan = Cust.getRow(6).getCell(1).getStringCellValue();
//String Citizen = Cust.getRow(7).getCell(1).getStringCellValue();
//String HomeAddress = Cust.getRow(8).getCell(1).getStringCellValue();
//String OfficeAddress = Cust.getRow(9).getCell(1).getStringCellValue();
//String State = Cust.getRow(10).getCell(2).getStringCellValue();
//String City = Cust.getRow(11).getCell(11).getStringCellValue();
//String Pincode = Cust.getRow(13).getCell(1).getStringCellValue();
//String Area = Cust.getRow(14).getCell(1).getStringCellValue();
//String NomineeName = Cust.getRow(15).getCell(1).getStringCellValue();
//

//FileInputStream EDB = new FileInputStream(".\\src\\test\\resources\\EDBTestdata.xlsx");
//Workbook book = WorkbookFactory.create(EDB);
//Sheet Cust = book.getSheet("EDB_Customer_Staffapprove2");
//Jutil.getRandomNo();
//HashMap<String, String> map = Eutil.readMultipleData("EDB_Customer_Staffapprove2", 0);
//
//for ( Entry<String, String> m : map.entrySet()) 
//{
//	if (m.getKey().equalsIgnoreCase("EDB_Customer_Staffapprove2")) 
//	{
//		driver.findElement(By.name(m.getKey())).sendKeys(m.getValue()+Jutil.getRandomNo());
//
//	}
//	else {
//		driver.findElement(By.name(m.getKey())).sendKeys(m.getValue());
//	}
//	
//}
//643127908
//Account no :1011421011111
//578181499
//1011191011211
//792365002
