package com.qa.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.crm.base.BasePage;

public class HomePage extends BasePage{

	@FindBy(xpath="//td[@class='headertext']//a")
	WebElement logoname;
	
	public HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getLogoName(){
		System.out.println(driver.findElement(By.cssSelector("//td[@class='headertext']//a")));
		return logoname.getText();
	}
}
