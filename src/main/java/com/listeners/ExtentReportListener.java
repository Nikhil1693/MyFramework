package com.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class ExtentReportListener {
	
	static ExtentReports extent;
	
	public static ExtentReports getReportObject() {
		
		String path=System.getProperty("user.dir")+"\\screenshot\\index.html";
		ExtentHtmlReporter reporter=new ExtentHtmlReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Nikhil"); 
		return extent;
	}
	
	

}
