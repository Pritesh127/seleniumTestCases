package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement accountClick;
	
	@FindBy(linkText="Login")
	private WebElement LoginClick;
	
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement emailAddressField;
	
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement passwordAddressField;

	@FindBy(xpath="//input[@value='Login']")
	private WebElement Submit;
	

	public void OnSubmitLogin()
	{
		Submit.click();
	}
	public void OnAccountClick()
	{
		accountClick.click();
	}
	
	public void OnLoginClick()
	{
		LoginClick.click();
	}
	
	public void enterEmail(String email)
	{
		emailAddressField.sendKeys(email);
	}
	
	public void enterPassword(String password)
	{
		emailAddressField.sendKeys(password);
	}
}
