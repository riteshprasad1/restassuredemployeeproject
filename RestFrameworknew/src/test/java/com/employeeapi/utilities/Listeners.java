package com.employeeapi.utilities;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Listeners extends TestListenerAdapter{

	@SuppressWarnings("deprecation")
	public ExtentSparkReporter htmlreporter;
	public ExtentReports extent;
	public ExtentTest test;

	public void onStart(ITestContext testContext) 
	{
		htmlreporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/myReport.html");
		htmlreporter.config().setDocumentTitle("Automation Report");
		htmlreporter.config().setReportName("Rest Api execution report");

		extent= new ExtentReports();
		extent.attachReporter(htmlreporter);
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environment","QA");
	}

	public void onTestSuccess(ITestResult tr)
	{
		test=extent.createTest(tr.getName());
		test.log(Status.PASS, "Test Case passed is "+tr.getName());
	}
	
	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}
}
