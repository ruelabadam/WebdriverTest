package example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.*;
import org.testng.Assert;		
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteTest {
	
	
	public final String scURL = "https://" + System.getProperty("sUSERNAME") + ":" + System.getProperty("sACCESS_KEY") + "@ondemand.saucelabs.com:443/wd/hub";
	
	public RemoteWebDriver driver;
	
	@BeforeTest
	public void beforeTest() throws Throwable{
	new DesiredCapabilities();
	DesiredCapabilities caps = DesiredCapabilities.chrome();
	  caps.setCapability("platform", "Linux");
	  caps.setCapability("version", "56.0");
	driver = new RemoteWebDriver(new URL(scURL), caps);
	}
	

	
	@Test
	public void testEasy() throws InterruptedException {
		driver.get("http://www.ruelsrunning.com");  
		Thread.sleep(5000);
		String title = driver.getTitle();	
		Thread.sleep(5000);
		Assert.assertEquals(title, "Ru El's Running - In here...everyone's a runner!");
		Thread.sleep(5000);
		System.out.println("test should be done.");
	}
	

}
