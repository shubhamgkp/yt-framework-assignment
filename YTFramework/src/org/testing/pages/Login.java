package org.testing.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {

	WebDriver driver;
	Properties prop;
	public Login(WebDriver driver, Properties prop){
		this.driver=driver;
		this.prop=prop;
	}
	public void signin(String emailid, String pass){

		driver.findElement(By.xpath(prop.getProperty("ClickSignin"))).click();
		driver.findElement(By.xpath(prop.getProperty("EnterEmail"))).sendKeys(emailid);
		driver.findElement(By.xpath(prop.getProperty("SigninNext"))).click();
		try {			
			driver.findElement(By.xpath(prop.getProperty("EnterPass"))).sendKeys(pass);
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
			driver.findElement(By.xpath(prop.getProperty("EnterPass"))).sendKeys(pass);
		}		
		driver.findElement(By.xpath(prop.getProperty("PassNext"))).click();	
	}
}
