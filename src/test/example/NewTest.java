package example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.*;
import org.testng.Assert;		
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;

public class NewTest {
	
	
//	public final String user = System.getProperty("sUSERNAME") ;
//	public final String key = System.getProperty("sACCESS_KEY") ;
	
	public final String scURL = "https://" + System.getProperty("sUSERNAME") + ":" + System.getProperty("sACCESS_KEY") + "@ondemand.saucelabs.com:443/wd/hub";
	
	public RemoteWebDriver driver;

	
	public void setup() throws Throwable {
		
		//codeship Chrome
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		
		// Initialize browser
//		driver=new ChromeDriver();
		
		@SuppressWarnings("static-access")
		DesiredCapabilities caps = new DesiredCapabilities().chrome();
//  		  caps.setCapability("platform", "Linux");
//  		  caps.setCapability("version", "47.0");
  		 driver = new RemoteWebDriver(new URL(scURL), caps);
  		 
  		 System.out.println("connection should be done.");
	}
		
//	@AfterMethod
//	public void afterTest() {
//			driver.quit();			
//	}	
	
	@Test
	public void testEasy() throws InterruptedException {
		driver.get("http://www.Ruelsrunning.com");  
		Thread.sleep(5000);
	}
}
