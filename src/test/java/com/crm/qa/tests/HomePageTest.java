package com.crm.qa.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.SignUpPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {

	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	SignUpPage signUpPage;
	
	public HomePageTest()
	{
		super();
	}
	
	//navigation steps
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException
	{
		initialization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void verifyHomepageTitleTest()
	{
	String homePageTitle=homePage.verifyHomePageTitle();
	Assert.assertEquals(homePageTitle, "CRMPRO","Title is not matching");
	}
	
	@Test
	public void verifyUserNameTest()
	{
		testUtil.switchToFrame();
		boolean flag=homePage.verifyCorrectUserName();
		Assert.assertTrue(flag);
	}
	
	@Test
	public void verifyContactsLinkTest()
	{
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}
	
	@Test
	public void clickOnLogout() throws IOException
	{	
		testUtil.switchToFrame();
		loginPage=homePage.clickOnLogout();
		String title =	loginPage.validateLoginTitle();
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service","Title is not matching");
		
	}
		
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
