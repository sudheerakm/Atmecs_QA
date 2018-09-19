package com.amazon;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CommonDriver {
	public WebDriver driver;
	private int pageloadTimeout;
	private int elementDetectionTimeout;

	public void setPageloadTimeout(int pageloadTimeout) {
		this.pageloadTimeout = pageloadTimeout;
	}

	public void setElementDetectionTimeout(int elementDetectionTimeout) {
		this.elementDetectionTimeout = elementDetectionTimeout;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public CommonDriver(String browserType)  {

		browserType = browserType.trim();

		pageloadTimeout = 30;
		elementDetectionTimeout = 5;

		if (browserType.toLowerCase().equals("chrome") ) {

			driver = new ChromeDriver();
			
		}

	}

	public void navigateToFirstUrl(String url) throws Exception {

		url = url.trim();
		
		driver.manage().deleteAllCookies();

		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(pageloadTimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(elementDetectionTimeout, TimeUnit.SECONDS);

		driver.get(url);
	}

	public String getTitle() throws Exception {

		return driver.getTitle();
	}

	public void closeBrowser() throws Exception {
		if (driver != null) {
			driver.close();
		}

	}
	public void closeAllBrowsers() throws Exception {
		if(driver != null){
			driver.quit();
		}
		
	}
}
