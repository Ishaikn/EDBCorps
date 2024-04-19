package com.TYSS1.DemoTestNG;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.Banking.EDBbank.StaffLoginPage;

public class DataImplementationClass {
	@Test(dataProviderClass=DataProvider_Loginpage.class, dataProvider="logindata")
public void login(String Username, String Password) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://rmgtestingserver/domain/Online_Banking_System/staff_login.php");
		StaffLoginPage Loginpage=new StaffLoginPage(driver);
		Loginpage.getStaffid().sendKeys(Username);
		Loginpage.getStaffpassword().sendKeys(Password);
		Loginpage.getLoginbutton().click();
}
}