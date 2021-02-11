package com.listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.base.BasePage;
import com.base.BaseTest;


public class ScreenshotListener extends BasePage implements ITestListener{

	ExtentTest test;
	ExtentReports extent=ExtentReportListener.getReportObject();
	ThreadLocal<ExtentTest> extenttest=new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result) {
		
		test=extent.createTest(result.getMethod().getMethodName());
		extenttest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extenttest.get().log(Status.PASS, "Test Passed");
		
		}

	@Override
	public void onTestFailure(ITestResult result) {
		extenttest.get().fail(result.getThrowable());
		WebDriver driver=null;
	
		
		String methodname=result.getMethod().getMethodName();
		
		try {
			
			driver=(WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			extenttest.get().addScreenCaptureFromPath(getScreenshot(methodname,driver), result.getMethod().getMethodName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			getScreenshot(methodname,driver);
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
		
		
	

	@Override
	public void onTestSkipped(ITestResult result) {
		
		
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		extent.flush();
		
	}
	
	
}
