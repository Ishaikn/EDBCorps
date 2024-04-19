package com.TYSS2.testngbatch;

import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class Testclass extends BaseClass {
	@Test
	public void test1() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
	}
@Test
	public void test2() {
		System.out.println("--TestClass--->test2 Method Executed");
	}
@Test
	public void test3() {
		System.out.println("--TestClass--->test3 Method Executed");
	}
@Test
	public void test4() {
		System.out.println("--TestClass--->test4 Method Executed");
	}
@Test
	public void test5() {
		System.out.println("--TestClass--->test5 Method Executed");
	}

}
