package org.testing.TestScripts;

import org.openqa.selenium.By;
import org.testing.Base.Base;
import org.testing.pages.Login;
import org.testng.annotations.Test;

public class TC1 extends Base {

	@Test
	public void firstTestCase(){		
			
		Login login=new Login(driver, prop);
		login.signin("shubhamcert@gmail.com", "Skv@2580");
		driver.findElement(By.xpath(prop.getProperty("Trending"))).click();
	}
}
