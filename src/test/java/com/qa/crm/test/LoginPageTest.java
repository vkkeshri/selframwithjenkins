package com.qa.crm.test;

import org.testng.annotations.Test;
import com.qa.crm.base.BasePage;
import com.qa.crm.pages.LoginPage;
import org.testng.annotations.BeforeTest;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class LoginPageTest {
	
	WebDriver driver;
	Properties prop;
	LoginPage loginpage;
	BasePage basepage;
	
	  @BeforeMethod
	  public void setUp() {
		  basepage = new BasePage();
		  prop = basepage.initialize_properties();
		  driver = basepage.initialize_driver(prop);
		  loginpage = new LoginPage(driver);
	  }
	
	  @Test
	  public void loginIntoApplication() {
		  loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	  }
	  
	  @AfterMethod
	  public void tearDown() {
		  driver.quit();
	  }	  
}