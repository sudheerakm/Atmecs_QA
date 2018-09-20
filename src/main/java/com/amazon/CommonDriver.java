package com.amazon;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CommonDriver {
	public WebDriver driver;
	private int pageloadTimeout;
	private int elementDetectionTimeout;

	//Methods to set pageload timeout and element detection timeout
	
	public void setPageloadTimeout(int pageloadTimeout) {
		this.pageloadTimeout = pageloadTimeout;
	}

	public void setElementDetectionTimeout(int elementDetectionTimeout) {
		this.elementDetectionTimeout = elementDetectionTimeout;
	}

	//To return the WebDriver instance
	public WebDriver getDriver() {
		return driver;
	}

	// Invoke CommonDriver constructor
	public CommonDriver(String browserType)  {

		browserType = browserType.trim();

		pageloadTimeout = 30;
		elementDetectionTimeout = 5;

		if (browserType.toLowerCase().equals("chrome") ) {

			driver = new ChromeDriver();
			
		}

	}

	//Method to delete all cookies , maximize and invoke the browser
	public void navigateToFirstUrl(String url) throws Exception {

		url = url.trim();
		
		driver.manage().deleteAllCookies();

		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(pageloadTimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(elementDetectionTimeout, TimeUnit.SECONDS);

		driver.get(url);
	}

	//Method to get title of the page
	public String getTitle() throws Exception {

		return driver.getTitle();
	}

	//Method to close the current browser
	public void closeBrowser() throws Exception {
		if (driver != null) {
			driver.close();
		}

	}
	//Method to close all browsers
	public void closeAllBrowsers() throws Exception {
		if(driver != null){
			driver.quit();
		}
		
	}
}
