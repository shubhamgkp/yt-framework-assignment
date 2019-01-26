package org.testing.TestScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testing.Base.Base;
import org.testing.pages.Login;
import org.testing.utilities.Logs;
import org.testing.utilities.ScreenShot;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC1 extends Base {

	@Test
	public void firstTestCase() throws IOException{		

		try{
			String expectedURL="https://www.youtube.com/feed/trendng";
			
			Login login=new Login(driver, prop);
			login.signin("shubhamcert@gmail.com", "Skv@2580");
			Logs.takeLog("TC1", "Login successfully!");						
			driver.findElement(By.xpath(prop.getProperty("Trending"))).click();
			Assert.assertEquals(driver.getCurrentUrl(), expectedURL, "Actual URL not matched!");
			Logs.takeLog("TC1", "Clicking on Trending successfully!");
			ScreenShot.takeSceenShot(driver, "E:/screenshot1.jpg");
			Logs.takeLog("TC1", "Test case 1 passed successfully!");	
		}
		catch(Exception e){
			ScreenShot.takeSceenShot(driver, "E:/failscreenshot1.jpg");
		}

	}
}
