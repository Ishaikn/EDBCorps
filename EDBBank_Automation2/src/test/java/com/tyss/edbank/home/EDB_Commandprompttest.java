package com.tyss.edbank.home;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class EDB_Commandprompttest {
	
	public static WebDriver driver=null;
@Test
	public void stafflogin() {
	String URL=System.getProperty("url");
	String Browser=System.getProperty("browser");
	String Custid=System.getProperty("custid");
	String Pwd=System.getProperty("password");
	if(Browser.equals("chrome")) {
		driver=new ChromeDriver();
		
	}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
	driver.get(URL);
	driver.findElement(By.xpath("//a[.='Staff Login']")).click();
	driver.findElement(By.className("customer_id")).sendKeys(Custid);
	driver.findElement(By.className("password")).sendKeys(Pwd);
	driver.findElement(By.className("login-btn")).click();
		
	}


}
