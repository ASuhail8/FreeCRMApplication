package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	//FInd the Contacts label xpath
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	// -- pageFactory for firstname, lastname,company, Save
	
	@FindBy(name="title")
	WebElement TitleLink;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(xpath="//input[@type='text' and @name='client_lookup']")
	WebElement company;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement saveBTN;
	
	
	
	//initialize pageFactory using contructor
	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Method - verifyContactsLabel
	
	public boolean verifyContactsLabel()
	{
	return	contactsLabel.isDisplayed();
	}
	
	
	
	//method - selectContacts
	
	public void selectContactsByName(String name)
	{
		
		driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]/../../td[1]")).click();
		
	}
	
	// --- method - createNewContact
	
	public void createNewContact(String title,String firstName, String lastName, String company)
	{
		Select select = new Select(TitleLink);
		select.selectByVisibleText(title);
		
		this.firstName.sendKeys(firstName);
		this.lastName.sendKeys(lastName);
		this.company.sendKeys(company);
		saveBTN.click();
	}
	
	
}
