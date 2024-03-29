package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	WebDriver driver;
	public Properties prob;
	public Properties prob1;
	
	public Base()
	{
		prob=new Properties();
		File probFile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\config\\config.properties");
		try {
		FileInputStream fis1=new FileInputStream(probFile);
		prob.load(fis1);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
		
		prob1=new Properties();
		File probFile1=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\testdata\\TestData.properties");
		try {
		FileInputStream fis2=new FileInputStream(probFile1);
		prob1.load(fis2);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	public WebDriver initializeAndOpenUrl(String browser)
	{
		if(browser.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		if(browser.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		if(browser.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		return driver;
	}
	
}
