package org.testing.TestScripts;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testing.Base.Base;
import org.testing.pages.Login;
import org.testing.pages.VideoPlay;
import org.testng.annotations.Test;

public class TC4 extends Base{

	@Test
	public void fourthTestCase() throws InterruptedException{

		Login login = new Login(driver, prop);
		login.signin("shubhamcert@gmail.com","Skv@2580");

		VideoPlay vidPlay = new VideoPlay(driver, prop);
		vidPlay.playVideo();

		Thread.sleep(5000);
		List<WebElement> channelSubscribe =driver.findElements(By.xpath("//yt-formatted-string[text()='Subscribe ']"));		
		int n=channelSubscribe.size()-1;		
		VideoPlay.wait.until(ExpectedConditions.elementToBeClickable(channelSubscribe.get(n)));	
		channelSubscribe.get(n).click();
	}
}
