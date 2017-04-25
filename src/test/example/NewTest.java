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

import java.net.MalformedURLException;
import java.net.URL;

public class NewTest {
	
	String user = System.getProperty("sUSERNAME") ;
	String key = System.getProperty("sACCESS_KEY") ;
	
	public final String URL = "https://" + user + ":" + key + "@ondemand.saucelabs.com:443/wd/hub";
	
	private WebDriver driver;

	@BeforeTest
	public void beforeTest() throws MalformedURLException {
		  DesiredCapabilities caps = DesiredCapabilities.chrome();
		  caps.setCapability("platform", "Linux");
		  caps.setCapability("version", "47.0");
		  driver = new RemoteWebDriver(new URL(URL), caps);
//	 driver = new ChromeDriver();
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
