package com.EcommerceSuite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Configuration {
	
	WebDriver driver;
	
	public WebDriver openBrowser(String browserName){
		
		String path = System.getProperty("user.dir");
		
		if(browserName.equalsIgnoreCase("chrome")){			
			System.setProperty("webdriver.chrome.driver", path+"\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.gecko.driver", path+"geckodriver-v0.21.0-win32\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		return driver;
	}

}
