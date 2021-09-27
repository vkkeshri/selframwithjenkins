package com.qa.crm.test;

import org.testng.annotations.Test;

import com.qa.crm.base.BasePage;
import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;
import org.testng.annotations.BeforeTest;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class HomePageTest {

	WebDriver driver;
	Properties prop;
	HomePage homepage;
	BasePage basepage;
	LoginPage loginpage;
	
	@BeforeMethod
	  public void setUp() {
		  basepage = new BasePage();
		  prop = basepage.initialize_properties();
		  driver = basepage.initialize_driver(prop);
		  loginpage = new LoginPage(driver);
		  //homepage = new HomePage(driver);
		  homepage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	  }
	
	  @Test
	  public void verifyHomePageLogoName() {
		  //String actualText = homepage.getLogoName();
		  System.out.println("Vinod -");
		 // Assert.assertEquals(actualText, "CRMPRO");
	  }
	  
	  @AfterMethod
	  public void tearDown() {
		  driver.quit();
	  }

}
