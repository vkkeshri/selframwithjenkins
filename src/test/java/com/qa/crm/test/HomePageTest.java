package com.qa.crm.test;

import org.testng.annotations.Test;

import com.qa.crm.base.BasePage;
import com.qa.crm.pages.HomePage;

import org.testng.annotations.BeforeMethod;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class HomePageTest {

	WebDriver driver;
	Properties prop;
	HomePage homepage;
	BasePage basepage;
	
	@BeforeMethod
	  public void setUp() {
		  basepage = new BasePage();
		  prop = basepage.initialize_properties();
		  driver = basepage.initialize_driver(prop);
		  homepage = new HomePage(driver);
	  }
	
	  @Test
	  public void verifyHomePageLogoName() {
		  String actualText = homepage.getLogoName();
		  Assert.assertEquals(actualText, "CRMPRO");
	  }
	  
	  @AfterMethod
	  public void tearDown() {
		  driver.quit();
	  }

}
