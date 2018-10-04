package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath="//td[contains(text(),'User: Abdulla Suhail')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[contains(.,'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(.,'Deals')]")
	WebElement dealsLink;
	
	
	@FindBy(xpath="//a[contains(.,'Tasks')]")
	WebElement tasksLink;
	
	@FindBy(xpath="//a[contains(text(),'Logout ')]")
	WebElement logoutLink;
	
	// - xpath for new Contact Link
	
	@FindBy(xpath="//a[.='New Contact']")
	WebElement newContactLink;
	
	//initialization
	
	 public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	 public String verifyHomePageTitle()
	 {
		 return driver.getTitle();
	 }
	 
	 public ContactsPage clickOnContactsLink()
	 {
		 contactsLink.click();
		 return new ContactsPage();
	 }
	 
	 public DealsPage clickOnDealsLink()
	 {
		 dealsLink.click();
		 return new DealsPage();
	 }
	 
	 public TasksPage clickOnTasksLink()
	 {
		 tasksLink.click();
		 return new TasksPage();
		 
	 }
	 
	 public boolean verifyCorrectUserName()
	 {
		 
		 return	userNameLabel.isDisplayed();
	 
	 }
	 
	 public LoginPage clickOnLogout() throws IOException
	 {
		 logoutLink.click();
		 return new LoginPage();
	 }
	 
	 // - method clickOnNewContactsLink
	 
	 public void clickOnNewContactsLink()
	 {
		 Actions action = new Actions(driver);
		 action.moveToElement(contactsLink).perform();
		 newContactLink.click();
	 }
	 
	 
	 
}
