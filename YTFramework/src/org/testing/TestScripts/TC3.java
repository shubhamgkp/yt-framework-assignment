package org.testing.TestScripts;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testing.Base.Base;
import org.testing.pages.Login;
import org.testing.pages.VideoPlay;
import org.testing.utilities.Logs;
import org.testing.utilities.ScreenShot;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC3 extends Base{

	@Test
	public void thirdTestCase() throws IOException{

		try{

			Login login = new Login(driver, prop);
			login.signin("shubhamcert@gmail.com","Skv@2580");
			Logs.takeLog("TC3", "Login successfully!");
			driver.findElement(By.xpath("//button[@id='avatar-btn']")).click();
			
			String verifyEmail=driver.findElement(By.xpath("//yt-formatted-string[text()='shubhamcert@gmail.com']")).getText();
			Assert.assertEquals(verifyEmail, "shubhamcert@gmail.com");
			
			VideoPlay vidPlay = new VideoPlay(driver, prop);
			vidPlay.playVideo();
			Logs.takeLog("TC3", "Clicking on video play successfully!");

			List<WebElement> likeDislike = driver.findElements(By.xpath(prop.getProperty("likeDislike")));		
			likeDislike.get(0).click();
			ScreenShot.takeSceenShot(driver, "E:/screenshot3.jpg");
			Logs.takeLog("TC3", "Test case 3 passed successfully!");
		}
		catch(Exception e){
			ScreenShot.takeSceenShot(driver, "E:/failscreenshot3.jpg");
		}

	}
}
