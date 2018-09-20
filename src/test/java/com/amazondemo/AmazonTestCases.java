package com.amazondemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.WaitUtility;

public class AmazonTestCases extends BaseScenarios {

	@Test(priority = 1)
	public void verifySearch() {

		try {
			// search for item fitbit on amazon website.
			String ExpectedSearchItem = "fitbit";

			// locate the web element search field
			WebElement searchbox = driver.findElement(By.id(configProperty.getProperty("search")));

			// send the input fitbit from propertyfile using sendkeys
			searchbox.sendKeys(configProperty.getProperty("searchItem"));

			// click on the search button
			driver.findElement(By.className(configProperty.getProperty("searchButton"))).click();

			// Get the actual search item text from the search results
			String actualsearhitem = driver.findElement(By.linkText(configProperty.getProperty("searchItem")))
					.getText();

			// Assertion to check if both the search items are equal
			Assert.assertEquals(actualsearhitem, ExpectedSearchItem);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Test(priority = 2)
	public void SelectItem() {
		try {

			// Expected search item
			String expectedSearchItem = "Fitbit Charge 2 Heart Rate + Fitness Wristband, Black, Large (US Version)";

			// Select the item
			driver.findElement(By.linkText(configProperty.getProperty("selectItem"))).click();

			// get the actual searchitem
			String actualSeachItem = driver.findElement(By.id("productTitle")).getText();

			// assertion to verify the actual search item and expected search item
			Assert.assertEquals(actualSeachItem, expectedSearchItem);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Test(priority = 3)
	public void addtocart() {
//		String ExpectedItemsincart="1";
		driver.findElement(By.id("add-to-cart-button")).click();
		WaitUtility.waitTillElementVisible(driver, By.xpath("//*[@id='nav-cart-count']"), 20);
//		String actualnumberofItemsin_addcart=driver.findElement(By.id("nav-cart-count")).getText();
//		System.out.println(actualnumberofItemsin_addcart);
//      Assert.assertEquals(actualnumberofItemsin_addcart, ExpectedItemsincart);
	}

	@Test(priority = 4)
	public void removeItem() {
		String Deletepath = "//*[@value='Delete']";
		driver.findElement(By.id("nav-cart-count")).click();
		WaitUtility.waitTillElementVisible(driver, By.xpath(Deletepath), 20);
		driver.findElement(By.xpath(Deletepath)).click();
	}
}
