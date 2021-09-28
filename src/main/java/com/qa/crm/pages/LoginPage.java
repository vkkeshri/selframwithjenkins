package com.qa.crm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.crm.base.BasePage;

public class LoginPage extends BasePage{

	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@class='btn btn-small']")
	WebElement login;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean getUserNameTextBox(){
		return username.isDisplayed();
	}
	
	public boolean getPasswordTextBox(){
		return password.isDisplayed();
	}
	
	public boolean getLoginButton(){
		return login.isDisplayed();
	}
	
	public HomePage doLogin(String user, String passwd){
		username.sendKeys(user);
		password.sendKeys(passwd);
		login.click();
		return new HomePage(driver);
	}
}
