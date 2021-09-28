package com.qa.crm.test;

import org.testng.annotations.Test;
import com.qa.crm.base.BasePage;
import com.qa.crm.pages.LoginPage;
import org.testng.annotations.BeforeTest;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class LoginPageTest {
	
	public WebDriver driver;
	public Properties prop;
	public LoginPage loginpage;
	public BasePage basepage;
	
	  @BeforeTest
	  public void setUp() {
		  basepage = new BasePage();
		  prop = basepage.initialize_properties();
		  driver = basepage.initialize_driver(prop);
		  loginpage = new LoginPage(driver);
	  }
	
	  @Test(description="Username textbox on login screen")
	  public void verifyUserNameTextBox(){
		  boolean user = loginpage.getUserNameTextBox();
		  Assert.assertEquals(user, true);
	  }
	  
	  @Test(dependsOnMethods = {"verifyUserNameTextBox"}, description="Password textbox on login screen")
	  public void verifyPasswordTextBox(){
		  boolean pass = loginpage.getPasswordTextBox();
		  Assert.assertEquals(pass, true);
	  }
	  
	  @Test(dependsOnMethods = {"verifyPasswordTextBox"}, description="Login button on login screen")
	  public void verifyLognButton(){
		  boolean login = loginpage.getLoginButton();
		  Assert.assertEquals(login, true);
	  }
	  @Test(dependsOnMethods = {"verifyLognButton"}, description="Login and navigate to home screen")
	  public void loginIntoApplication() {
		  loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	  }
	  
	  @AfterTest
	  public void tearDown() {
		  driver.quit();
	  }	  
}