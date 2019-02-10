package org.testing.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;

public class Base {
	
	public WebDriver driver;
	public Properties prop; 
	@BeforeMethod
	public void browserInitiate() throws IOException{
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Driver/chromedriver.exe");
		
		//Code to Switch off the browser notification
		//Create prefs map to store all preferences
		HashMap<String, Object> prefs = new HashMap<String, Object>();		
		//Put this into prefs map to switch off browser notification
		prefs.put("profile.default_content_setting_values.notifications", 2);	
		//Create chrome options to set this prefs
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		
		driver = new ChromeDriver(options);
		driver.navigate().to("https://www.youtube.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);	
		
		File file = new File(System.getProperty("user.dir")+"/src/or.properties");
		FileInputStream fs = new FileInputStream(file);
		prop = new Properties();
		prop.load(fs);
	}
	
	/*@AfterMethod
	public void browserClose(){
		
		driver.close();
	}*/
}
