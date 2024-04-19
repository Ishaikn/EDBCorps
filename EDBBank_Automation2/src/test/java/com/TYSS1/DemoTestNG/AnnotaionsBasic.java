package com.TYSS1.DemoTestNG;

import org.testng.annotations.Test;
import org.testng.annotations.*;

public class AnnotaionsBasic {
	@BeforeMethod
	public void BeforeMethod() {
		System.out.println("<----Loginto the Application ---->");
	}

	@BeforeSuite
	public void BeforeSuite() {
		System.out.println("<----Database Connectivity---->");
	}

	@BeforeClass
	public void BeforeClass() {
		System.out.println("<----Luanch The browser---->");
	}
	@Test(retryAnalyzer = com.GenericUtilities.RetryAnalyserImp.class)
	public void Onetest() {
		System.out.println("<----Test Script Execution---->");
	}
	@AfterMethod
	public void AfterMethod() {
		System.out.println("<----Logout from the Application---->");
	}

	@AfterClass
	public void AfterClass() {
		System.out.println("<----Close the Browser---->");
	}

	@AfterTest
	public void aftersuite() {
		System.out.println("<----Close the Databse Connection---->");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("<---Test Configuration---->");
	}
	@BeforeClass
	public void BeforeClass1() {
		System.out.println("<----Luanch The browser---->");
	}
	@Test
	public void Secondtest1() {
		System.out.println("<----Test Script Execution---->");
	}
	@AfterClass
	public void AfterClass1() {
		System.out.println("<----Close the Browser---->");
	}
	public void AfterClass2() {
		System.out.println("<----Close the Browser---->");
	}
	public void After() {
		System.out.println("<----check the Browser---->");
	}
}
