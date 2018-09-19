package com.amazon;

import org.testng.annotations.Test;

import com.utils.WaitUtility;

import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class UITestScenarios {
	
	public static WebDriver driver;
	CommonDriver cmndriver = new CommonDriver("chrome");

	@Test(priority = 1)
	public void SearchItem() {

		try {
			String ExpectedSearchItem = "fitbit";
			WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));

			searchbox.sendKeys("fitbit");
			driver.findElement(By.className("nav-input")).click();

			String actualsearhitem = driver.findElement(By.linkText("fitbit")).getText();
			Assert.assertEquals(actualsearhitem, ExpectedSearchItem);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority = 2)
	public void selectItem() {
		try {
			String expectedSearchItem = "Fitbit Charge 2 Heart Rate + Fitness Wristband, Black, Large (US Version)";
			driver.findElement(By.linkText("Fitbit Charge 2 Heart Rate + Fitness Wristband, Black, Large (US Version)"))
					.click();
			String actualSeachItem = driver.findElement(By.id("productTitle")).getText();
			Assert.assertEquals(actualSeachItem, expectedSearchItem);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority = 3)
	public void addtocart() {
//	  String ExpectedItemsincart="1";
		driver.findElement(By.id("add-to-cart-button")).click();
//	  String actualnumberofItemsin_addcart=driver.findElement(By.id("nav-cart-count")).getText();
//	  Assert.assertEquals(actualnumberofItemsin_addcart, ExpectedItemsincart);
	}

	@Test(priority = 4)
	public void removeItem() {
		String Deletepath = "//*[@value='Delete']";
		driver.findElement(By.id("nav-cart-count")).click();
		WaitUtility.waitTillElementVisible(driver, By.xpath(Deletepath), 10);
		driver.findElement(By.xpath(Deletepath)).click();
	}

	@BeforeClass
	public void invokeBrowser() throws Exception {

		
		// Using properties to create object
		Properties property = new Properties();

		// Call the property file using file input stream
		FileInputStream objFile = new FileInputStream(
				"/Users/mangalakasturi/workspace/AmazonProject/config.properties");

		try {
			property.load(objFile);
		} catch (IOException e) {
			e.getMessage();
			e.printStackTrace();
		}
		// open URL
		cmndriver.navigateToFirstUrl(property.getProperty("baseURL"));

	}

	@AfterClass
	public void closeBrowser() throws Exception {
		// close the browser
		cmndriver.closeAllBrowsers();
	}

}
