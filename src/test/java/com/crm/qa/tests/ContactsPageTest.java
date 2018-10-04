package com.crm.qa.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	String sheetName = "contacts";
	public ContactsPageTest()
	{
		super();	
	}
	
	
	//Before Method
	//--initialize
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException
	{
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();	
	}
	
	
	
	
	//Test Methods
	
	// -- verify contact page label
	@Test
	public void verifyContactsPageLabelTest()
	{
		
	boolean flag =contactsPage.verifyContactsLabel();
	Assert.assertTrue(flag,"contacts label is missing on the page");
		
	}
	
	//--select single contacts name
	@Test
	public void selectSingleContactsNameTest()
	{
		contactsPage.selectContactsByName("Tome Peter");
	}

	// - select multiple contacts name
	
	@Test
	public void selectMultipleContactsNameTest()
	{
		contactsPage.selectContactsByName("Mohammed Suhail");
		contactsPage.selectContactsByName("uiu s");
	}
	
	@DataProvider
	public Object[][] getCRMTestData()
	{
	Object data[][] = testUtil.getTestData(sheetName);
	return data;	
	}
	
	// - Test - validateCreateNewContact
	@Test(dataProvider ="getCRMTestData")
	public void validateCreateNewContactTest(String title, String firstName, String lastName, String company)
	{
		homePage.clickOnNewContactsLink();
		//contactsPage.createNewContact("Mr.","Tom", "Peter", "Google");
		contactsPage.createNewContact(title, firstName, lastName, company);
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
	driver.quit();
	}
}
