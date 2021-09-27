package com.qa.crm.test;

import org.testng.annotations.Test;
import com.qa.crm.base.BasePage;
import com.qa.crm.pages.LoginPage;
import org.testng.annotations.BeforeTest;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class LoginPageTest {
	
	WebDriver driver;
	Properties prop;
	LoginPage loginpage;
	BasePage basepage;
	
	  @BeforeTest
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
	  
	  @AfterTest
	  public void tearDown() {
		  driver.quit();
	  }	  
}