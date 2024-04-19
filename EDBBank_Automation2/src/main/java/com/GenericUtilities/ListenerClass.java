package com.GenericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Report;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ListenerClass implements ITestListener {
	
	ExtentReports Reports;
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test = Reports.createTest(MethodName);
		Reporter.log("Execution start from here", true);
	}

	public void onTestSuccess(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.PASS, MethodName);
		Reporter.log(MethodName + "Executed Successfully");

	}

	public void onTestFailure(ITestResult result) {
		try {
			String MethodName = result.getMethod().getMethodName();
			String screen = WebDriverUtility.getScreenShot(BaseClass.sdriver, MethodName);
			test.log(Status.FAIL, MethodName + "Test is Failed");
			test.log(Status.FAIL, result.getThrowable());
			test.addScreenCaptureFromPath(screen);
			Reporter.log(MethodName + "test Failed");

		} catch (IOException E) {
			E.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, MethodName + "===> Skipped");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log(MethodName + "===> Skipped");

	}

	public void onStart(ITestContext context) {
		ExtentSparkReporter htmlreport = new ExtentSparkReporter("./ExtentReport/Reports.html");
		htmlreport.config().setDocumentTitle("EDB Banking");
		htmlreport.config().setReportName("SDET-55EDB");
		htmlreport.config().setTheme(Theme.DARK);

		Reports = new ExtentReports();
		Reports.attachReporter(htmlreport);
		Reports.setSystemInfo("Base-Platform", "windows");
		Reports.setSystemInfo("Base-Browser", "chrome");
		Reports.setSystemInfo("Base-URL", "http://localhost:8888");
		Reports.setSystemInfo("Reporter Name", "Irshad shaik");
	}

	public void onFinish(ITestContext context) {
		Reports.flush();
	}
}
