package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {

	public  WebDriver driver;
	public  Properties config;
	public  FileInputStream fis;
	
	
	public  Properties init_prop() {
		config=new Properties();
		try {
			fis=new FileInputStream("C:\\Users\\50024558\\eclipse-workspace\\MyFramework\\src\\main\\java\\com\\config\\config_qa.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			config.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return config;
	}
	
	public  WebDriver init_driver(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\50024558\\Desktop\\chromedriver.exe");
				driver=new ChromeDriver();
		}
		else if(browser.equals("")) {
			String name=config.getProperty("browser");
			  if(name.equalsIgnoreCase("chrome")) {
				  System.setProperty("webdriver.chrome.driver", "C:\\Users\\50024558\\Desktop\\chromedriver.exe");
					driver=new ChromeDriver();
			  }
			
		}
		else
			System.out.println("invalid name");
		
	return driver;
	}
	
public String getScreenshot(String testcasename,WebDriver driver) throws IOException {
		
		File source=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir")+"\\screenshot\\"+testcasename+".png";
		
		
		FileUtils.copyFile(source, new File(destination));
		return destination;
		
		
		}
		 
	}
	
	

