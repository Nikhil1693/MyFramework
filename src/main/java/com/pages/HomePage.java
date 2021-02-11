package com.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BasePage;

public class HomePage extends BasePage {
	
	public WebDriver driver;
	
	@FindBy(xpath="//td[contains(text(),'User: Demo User')]")
	WebElement header;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contacts;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContact;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
		
	}
	
	public String titleofpage() {
		return driver.getTitle();
	}
	
	public boolean Headerofpage() {
		driver.switchTo().frame("mainpanel");
		return header.isDisplayed();}

	public ContactsPage clickonContactLink() {
		clickoncontact();
		return new ContactsPage(driver);
	}
	
	public void clickoncontact() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().frame("mainpanel");
		Actions a=new Actions(driver);
		a.moveToElement(contacts).build().perform();
		newContact.click();
	}
	
}
