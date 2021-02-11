package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BasePage;

public class ContactsPage extends BasePage {
	
	WebDriver driver;
	HomePage hp;
	
	
	@FindBy(xpath="//legend[contains(text(),'Contact Information')]")
	WebElement label;
	
	@FindBy(id="first_name")
	WebElement firstname;
	
	@FindBy(id="surname")
	WebElement lastname;
	
	@FindBy(xpath = "//input[@type='submit' and @value='Save']")
	WebElement svbtn;
	
	
	public ContactsPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		this.driver=driver;
		
	}
	
	public boolean verifyLabel() {
		return label.isDisplayed();
	}

	
	public void newContact(String fname,String lname) {
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		svbtn.click();
		
	}
}
