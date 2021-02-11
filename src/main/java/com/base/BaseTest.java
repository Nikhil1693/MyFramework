package com.base;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.pages.ContactsPage;
import com.pages.HomePage;
import com.pages.LoginPage;

public class BaseTest extends BasePage {
	
	public WebDriver driver;
	public Properties prop;
	public LoginPage lp;
	public HomePage hp;
	public ContactsPage cp;

	
@BeforeTest
public void setup() {
	BasePage bp=new BasePage();
	prop=bp.init_prop();
	driver=bp.init_driver("");
	driver.manage().window().maximize();
	driver.get(prop.getProperty("URL"));
	driver.manage().timeouts().implicitlyWait(7,TimeUnit.SECONDS);
	lp=new LoginPage(driver);
}
	

	


@AfterTest(alwaysRun=true)
public void tearDown() {
	driver.quit();
}

}
