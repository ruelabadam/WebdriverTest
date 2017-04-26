package example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.*;
import org.testng.Assert;		
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;

public class NewTest {
	
	
//	public final String user = System.getProperty("sUSERNAME") ;
//	public final String key = System.getProperty("sACCESS_KEY") ;
	
	public final String URL = "https://" + System.getProperty("sUSERNAME") + ":" + System.getProperty("sACCESS_KEY") + "@ondemand.saucelabs.com:443/wd/hub";
	
	private WebDriver driver;

	@BeforeTest
	public void beforeTest() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromium-browser");
		// Initialize browser
		driver=new ChromeDriver();
		
//		DesiredCapabilities caps = DesiredCapabilities.chrome();
//  		  caps.setCapability("platform", "Linux");
//  		  caps.setCapability("version", "47.0");
//		  driver = new RemoteWebDriver(new URL(URL), caps);
	}
		
	@AfterTest
	public void afterTest() {
			driver.quit();			
	}	
	
	@Test
	public void testEasy() {
		driver.get("http://www.Ruelsrunning.com");  
		String title = driver.getTitle();				 
		Assert.assertTrue(title.contains("Ru El's Running - In here...everyone's a runner!"));
	}
	

}
