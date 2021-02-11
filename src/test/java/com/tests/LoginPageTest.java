package com.tests;

import org.testng.Assert;
//import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.BaseTest;


public class LoginPageTest extends BaseTest {
	
	
	

@Test(priority=0)
public void verifyTitle() {
	String title=lp.gettitle();
	System.out.println("Title is: " +title);
	Assert.assertEquals(title, "CRMPRO Log In Screen");
}

@Test
public void dologin() {
	lp.login(prop.getProperty("username"),prop.getProperty("password"));
}
	
/*
 * @DataProvider(name="getdata") public Object[][] getdata(){ Object[][] ob=new
 * Object[2][2];
 * 
 * ob[0][0]="abc123"; ob[0][1]="1234";
 * 
 * ob[1][0]="batchautomation"; ob[1][1]="Test@12345";
 * 
 * return ob; }
 */
	
}
