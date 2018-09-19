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
			System.out.println("Inside bef suite");
			configProperty = ConfigReader
					.readProperties("/Users/mangalakasturi/workspace/AmazonProject/config.properties");

		} catch (Exception e) {

			e.printStackTrace();
		}

	}


	@BeforeClass
	public void setup() {
		try {
			String browsertype = configProperty.getProperty("browserType");
			String url = configProperty.getProperty("baseURL");
			cmnDriver = new CommonDriver(browsertype);
			int pageloadTimeout = Integer.parseInt(configProperty.getProperty("pageLoadTimeout"));
			cmnDriver.setPageloadTimeout(pageloadTimeout);
			int elementDetectionTimeout = Integer.parseInt(configProperty.getProperty("elementDetectionTimeout"));
			cmnDriver.setElementDetectionTimeout(elementDetectionTimeout);
			System.out.println(url);
			cmnDriver.navigateToFirstUrl(url);
			//System.out.println("Inside setup");
			driver = cmnDriver.getDriver();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@AfterSuite
	public void cleanup() {
		try {
			cmnDriver.closeAllBrowsers();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
