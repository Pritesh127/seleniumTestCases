package com.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.Base;
import com.pages.LoginPage;

public class LoginTest extends Base {
	
	public WebDriver driver;
	
	public LoginTest()
	{
		super();
		
	}
	
	@BeforeMethod
	public void setup()
	{
		driver=initializeAndOpenUrl(prob.getProperty("browserName"));
		LoginPage login=new LoginPage(driver);
		driver.manage().window().maximize();
		driver.get(prob.getProperty("url"));
		login.OnAccountClick();
		login.OnLoginClick();
		
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test(priority=1)
	public void verifyLoginWithValidCredentials()
	{
		LoginPage login=new LoginPage(driver);
		login.enterEmail(prob.getProperty("validEmail"));
		login.enterPassword(prob.getProperty("validPassword"));
		login.OnSubmitLogin();
	}
	@Test(priority=2)
	public void verifyLoginWithInValidCredentials()
	{
		
		LoginPage login=new LoginPage(driver);
		login.enterEmail(prob1.getProperty("invalidEmail"));
		login.enterPassword(prob1.getProperty("invalidPassword"));
		login.OnSubmitLogin();

	}
	@Test(priority=3)
	public void verifyLoginWithNoInput() 
	{
	
		LoginPage login=new LoginPage(driver);
		login.OnSubmitLogin();
		
	}
}
