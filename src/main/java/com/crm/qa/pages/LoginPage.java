package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase 
{
	//Decleration

	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//*[@id=\"loginForm\"]/div/div/input")
	WebElement loginBTN;

	@FindBy(xpath="//a[.='Sign Up']")
	WebElement signUpBTN;
	
	@FindBy(xpath="//img[@class='img-responsive']")
	WebElement crmLogo;
	
	//initialization
	
	public LoginPage() throws IOException
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//Utilization
	
	public String validateLoginTitle()
	{
	return	driver.getTitle();
	}
	
	
	public boolean validateCRMImage()
	{
	return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) throws InterruptedException
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		Thread.sleep(1000);
		loginBTN.click();
		
	return new HomePage();
	}
}


