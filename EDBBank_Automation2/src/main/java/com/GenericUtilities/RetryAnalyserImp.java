package com.GenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
//we will use ths class to check any script getting failed due to synchronization issue

public class RetryAnalyserImp implements IRetryAnalyzer {
	int lowercount=0;
	int uppercount=3;

	public boolean retry(ITestResult result) {
		if(lowercount<uppercount) {
			lowercount++;
			return true;
			}
		
		return false;
	}

	
	
}
