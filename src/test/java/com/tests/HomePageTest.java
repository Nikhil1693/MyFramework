package com.tests;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.BaseTest;


public class HomePageTest extends BaseTest {
	

	
	@BeforeClass
	public void homePageSetup() {
		
		hp = lp.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyTitle() {
		String title=hp.titleofpage();
		System.out.println(title);
		Assert.assertEquals(title, "CRMPR");
	}
	
	@Test
	public void isheaderDisplayed() {
	
		Assert.assertTrue(hp.Headerofpage());
	}

}
