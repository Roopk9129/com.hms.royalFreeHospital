package com.hms.genericUtils;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplimentationClass implements ITestListener {
	ExtentReports report;
	ExtentTest Test;
	@Override
	public void onTestStart(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		Test =report.createTest(MethodName);
		Reporter.log(MethodName+" ----Excecution starts");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		Test.log(Status.PASS, MethodName+" ---->Passed");
		Reporter.log(MethodName+" ----Testscript Execueted Successfully");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		String Methodname = result.getMethod().getMethodName();
		try {
			String faildscript = WebDriver_Utils.takeScreenShot(BaseClass.IDriver, Methodname);
			Test.addScreenCaptureFromPath(faildscript);
		} catch (Throwable e) {
			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		Test.log(Status.SKIP, result.getThrowable());
		Test.log(Status.SKIP, MethodName+" ---->Skipped");
		Reporter.log(MethodName+" ---->Skippeed");

	}

	@Override
	public void onStart(ITestContext context) {
		//create HTML report
		ITestResult result=null;
		ExtentSparkReporter htmlreport = new ExtentSparkReporter("./ExtentReport/"+result.getMethod().getMethodName()+new Java_Utils().systemDateInFormat()+".html");
		htmlreport.config().setDocumentTitle("HMS");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("Royal Free Hospitals");
		
		report = new ExtentReports();
		report.attachReporter(htmlreport);
		
		report.setSystemInfo("OS", System.getProperty("os.name"));
		report.setSystemInfo("OS-Version", System.getProperty("os.version"));
		report.setSystemInfo("Base Browser", BaseClass.bName);
		report.setSystemInfo("Base Url","http://rmgtestingserver/domain/Hospital_Management_System/");
		report.setSystemInfo("Reporter Nmae", "S Roop Kumar");
		
		
		
		

	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();

	}

}
