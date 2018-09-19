package com.amazondemo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class UITestScenario {
	private WebDriver driver;
	

  @Test(priority=1)
  public void SearchItem() {
	  
	  try {
		  String ExpectedSearchItem="fitbit";
		WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));

		  searchbox.sendKeys("fitbit");
		  driver.findElement(By.className("nav-input")).click();
		  
		String actualsearhitem= driver.findElement(By.linkText("fitbit")).getText();
		Assert.assertEquals(actualsearhitem, ExpectedSearchItem);
		  
//	  String SelectItemXpath=String.format("//div[@id='atfResults']//ul[@id='s-results-list-atf']/li[%d]", 3);
//  
//	  WebElement selectItem=driver.findElement(By.xpath(SelectItemXpath));
//	  selectItem.click();
//	  driver.findElement(By.linkText("Fitbit Charge 2 Heart Rate + Fitness Wristband, Black, Large (US Version)")).click();
//	  driver.findElement(By.id("add-to-cart-button")).click();
//	  driver.findElement(By.id("nav-cart-count")).click();
//	  driver.findElement(By.xpath("//*[@value='Delete']")).click();
//	  
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  @Test(priority=2)
  public void selectItem() {
	  try {
		String expectedSearchItem="Fitbit Charge 2 Heart Rate + Fitness Wristband, Black, Large (US Version)";
		  driver.findElement(By.linkText("Fitbit Charge 2 Heart Rate + Fitness Wristband, Black, Large (US Version)")).click();
		  String actualSeachItem=driver.findElement(By.id("productTitle")).getText();
		  Assert.assertEquals(actualSeachItem, expectedSearchItem);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  
  @Test(priority=3)
  public void addtocart() {
	  String ExpectedItemsincart="1";
	  driver.findElement(By.id("add-to-cart-button")).click();
	  String actualnumberofItemsin_addcart=driver.findElement(By.id("nav-cart-count")).getText();
	  Assert.assertEquals(actualnumberofItemsin_addcart, ExpectedItemsincart);
  }
  @Test(priority=4)
  public void removeItem() {
	  driver.findElement(By.id("nav-cart-count")).click();
	  driver.findElement(By.xpath("//*[@value='Delete']")).click();
  }
	  
  
  @BeforeClass
  public void beforeClass() {
	  driver = new ChromeDriver();
	  driver.get("http://www.amazon.com");
	  driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @AfterClass
  public void afterClass() {
//	  driver.quit();
  }

}
