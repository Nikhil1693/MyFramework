package com.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Utils.ExcelReader;
import com.base.BaseTest;
import com.pages.HomePage;

public class ContactsPageTest extends BaseTest{
	

	
	@BeforeClass
	public void homePageSetup() {
		
		hp=lp.login(prop.getProperty("username"), prop.getProperty("password"));
		cp=hp.clickonContactLink();
		}

	@Test(priority=1)
	public void verifyLabelTest() {
		boolean actual=cp.verifyLabel();
		System.out.println(actual);
		Assert.assertTrue(actual);
	}
	
  @DataProvider(name="ContactsTestData")
  public Object[][] getContactsTestData(){
	  Object data[][]=ExcelReader.getTestData("contacts");
	  return data;
  }
  
  @Test(dataProvider="ContactsTestData",priority=2)
  public void createnewcontacttest(String ftname,String ltname) {
	
	 
	 cp.newContact(ftname, ltname);
	 
	
  }
	
}
