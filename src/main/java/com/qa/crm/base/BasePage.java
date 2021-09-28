package com.qa.crm.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.gson.JsonParser;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	public Properties prop;
	public WebDriver driver;
	
	public WebDriver initialize_driver(Properties prop){
		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if(browserName.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();			
		} else {
			System.out.println("Driver is not initialize please initialize the driver in property file.");
		}
		driver.get(prop.getProperty("url"));
		return driver;
	}
	
	public Properties initialize_properties(){
		prop = new Properties();
		try {
			//FileInputStream ip = new FileInputStream("C:/AerisAutomation/eclipse/workspace/selframwithjenkins/resource/config.properties");
			FileReader ip = new FileReader(System.getProperty("user.dir")+File.separator+"resource"+File.separator+"config"+".properties");
			//InputStream ip = getClass().getClassLoader().getResourceAsStream("config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

}
