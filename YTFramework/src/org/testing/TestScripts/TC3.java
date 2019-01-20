package org.testing.TestScripts;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testing.Base.Base;
import org.testing.pages.Login;
import org.testing.pages.VideoPlay;
import org.testng.annotations.Test;

public class TC3 extends Base{
	
	@Test
	public void thirdTestCase(){
		
		Login login = new Login(driver, prop);
		login.signin("shubhamcert@gmail.com","Skv@2580");
			
		VideoPlay vidPlay = new VideoPlay(driver, prop);
		vidPlay.playVideo();
		
		List<WebElement> likeDislike = driver.findElements(By.xpath(prop.getProperty("likeDislike")));		
		likeDislike.get(0).click();
	}
}
