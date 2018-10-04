package com.crm.qa.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	public LoginPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void setUp()
	{
		initialization();
		try {
			loginPage = new LoginPage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void loginPageTitleTest()
	{
		
		String title=loginPage.validateLoginTitle();
		Assert.assertEquals(title,"#1 Free CRM software in the cloud for sales and service");
				
	}
	
	@Test
	public void crmLogoImageTest()
	{
	boolean flag=loginPage.validateCRMImage();
	Assert.assertTrue(flag);
		
	}
	
	@Test
	public void loginTest() throws InterruptedException
	{
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDow()
	{
		driver.quit();
	}
	
}
