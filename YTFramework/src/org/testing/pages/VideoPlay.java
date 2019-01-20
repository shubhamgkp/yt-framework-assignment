package org.testing.pages;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VideoPlay {

	WebDriver driver;
	Properties prop;
	public static WebDriverWait wait;
	public static int num=10;
	
	public VideoPlay(WebDriver driver, Properties prop) {
		this.driver=driver;
		this.prop=prop;				
	}
	
	public void playVideo(){
		
		List<WebElement> elements = driver.findElements(By.id("video-title"));		
		wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(elements.get(0)));
		elements.get(0).click();
	}
}
