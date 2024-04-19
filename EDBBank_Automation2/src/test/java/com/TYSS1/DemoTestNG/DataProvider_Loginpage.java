package com.TYSS1.DemoTestNG;

import org.testng.annotations.DataProvider;

public class DataProvider_Loginpage {
	@DataProvider
	public Object [][] logindata(){
		
		Object[][] obj=new Object [1][2];
		obj [0][0]="210001";
		obj [0][1]="password";
		
		
		return obj;
		
	}
}
