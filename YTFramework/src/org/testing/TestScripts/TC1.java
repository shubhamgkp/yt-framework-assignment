package org.testing.TestScripts;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.Map;

public class TC1 {

	WebDriver driver;
	@BeforeMethod
	public void browserInitiate(){
		
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
	}
	
	@Test
	public void firstTestCase(){		
		driver.findElement(By.xpath("//yt-formatted-string[text()='Sign in']")).click();
		driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("shubhamcert@gmail.com");
		driver.findElement(By.xpath("//div[@id='identifierNext']")).click();
		try {			
			driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Skv@2580");
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
			driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Skv@2580");
		}		
		driver.findElement(By.xpath("//div[@id='passwordNext']")).click();		
		driver.findElement(By.xpath("//span[text()='Trending']")).click();
	}
	
	@AfterMethod
	public void browserClose(){
		
		driver.close();
	}
}
