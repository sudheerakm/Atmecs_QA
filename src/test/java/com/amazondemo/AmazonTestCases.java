package com.amazondemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.WaitUtility;

public class AmazonTestCases extends BaseScenarios {
	
	@Test(priority = 1)
	public void verifySearch() {
		String ExpectedSearchItem = "fitbit";
		WebElement searchbox = driver.findElement(By.id(configProperty.getProperty("search")));

		searchbox.sendKeys(configProperty.getProperty("searchItem"));
		driver.findElement(By.className("nav-input")).click();

		String actualsearhitem = driver.findElement(By.linkText("fitbit")).getText();
		Assert.assertEquals(actualsearhitem, ExpectedSearchItem);
	}

	@Test(priority = 2)
	public void SelectItem() {
		try {
			String expectedSearchItem = "Fitbit Charge 2 Heart Rate + Fitness Wristband, Black, Large (US Version)";
			driver.findElement(By.linkText("Fitbit Charge 2 Heart Rate + Fitness Wristband, Black, Large (US Version)"))
					.click();
			String actualSeachItem = driver.findElement(By.id("productTitle")).getText();
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
//        Assert.assertEquals(actualnumberofItemsin_addcart, ExpectedItemsincart);
	}

	@Test(priority = 4)
	public void removeItem() {
		String Deletepath = "//*[@value='Delete']";
		driver.findElement(By.id("nav-cart-count")).click();
		WaitUtility.waitTillElementVisible(driver, By.xpath(Deletepath), 20);
		driver.findElement(By.xpath(Deletepath)).click();
	}
}
