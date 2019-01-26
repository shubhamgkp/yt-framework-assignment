package org.testing.TestScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testing.Assertions.CheckAssertion;
import org.testing.Base.Base;
import org.testing.pages.Login;
import org.testing.utilities.Logs;
import org.testing.utilities.ScreenShot;
import org.testng.annotations.Test;

public class TC2 extends Base {

	@Test
	public void secondTestCase() throws IOException{

		try{
		
			Login login = new Login(driver, prop);
			login.signin("shubhamcert@gmail.com", "Skv@2580");
			Logs.takeLog("TC2", "Login successfully!");
			driver.findElement(By.xpath(prop.getProperty("subscriptions"))).click();			
			Logs.takeLog("TC2", "Clicking on subscriptions successfully!");
			Thread.sleep(10000);			
			CheckAssertion.compare("(440) Subscriptions - YouTube", driver.getTitle());
			ScreenShot.takeSceenShot(driver, "E:/screenshot2.jpg");
			Logs.takeLog("TC2", "Test case 2 passed successfully!");
		}
		catch(Exception e){
			ScreenShot.takeSceenShot(driver, "E:/failscreenshot2.jpg");
		}
		
	}

}
