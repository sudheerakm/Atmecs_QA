package com.amazondemo;


import com.amazon.CommonDriver;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterSuite;

import com.amazon.ConfigReader;

public class BaseScenarios {

	CommonDriver cmnDriver;
	WebDriver driver;
	public Properties configProperty;

	@BeforeSuite
	public void executeBeforeASuite() {

		try {
			System.out.println("Inside before suite");
			//Read the property file
			configProperty = ConfigReader
					.readProperties("/Users/mangalakasturi/workspace/AmazonProject/config.properties");

		} catch (Exception e) {

			e.printStackTrace();
		}

	}


	@BeforeClass
	public void setup() {
		try {
			//Get the browser type from property file
			String browsertype = configProperty.getProperty("browserType");
			
			//Get the base URL from property file
			String url = configProperty.getProperty("baseURL");
			
			//Initialize the common driver parameterized constructor
			cmnDriver = new CommonDriver(browsertype);
			
			//Set pageload timeout
			int pageloadTimeout = Integer.parseInt(configProperty.getProperty("pageLoadTimeout"));
			cmnDriver.setPageloadTimeout(pageloadTimeout);
			
			//Set element detection timeout
			int elementDetectionTimeout = Integer.parseInt(configProperty.getProperty("elementDetectionTimeout"));
			cmnDriver.setElementDetectionTimeout(elementDetectionTimeout);
			
			System.out.println(url);
			
			// Navigate to the amazon url
			cmnDriver.navigateToFirstUrl(url);
			
			
			//get the commonDriver instance
			driver = cmnDriver.getDriver();
		} catch (Exception e) {
			
			e.getMessage();
			e.printStackTrace();
		}

	}

	@AfterSuite
	public void cleanup() {
		try {
			//Close all the browsers
			cmnDriver.closeAllBrowsers();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
