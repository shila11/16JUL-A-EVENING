package neoStroxBase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import utilityneoStrox.UtilityNEW;

public class BaseNew {
	protected  static WebDriver driver;
	public void launchBrowser() throws InterruptedException, IOException
	{
	System.setProperty("webdriver.chrome.driver", "D:\\sellenium\\chromedriver_win32\\chromedriver.exe");
	 driver=new ChromeDriver();
	 
	 driver.manage().window().maximize();
	 driver.get(UtilityNEW.readDatafromPropertiesFile("url"));
	// driver.get("https://neostox.com/sign-in");
	 Reporter.log("Launching browser", true);
	 Thread.sleep(1000);
	}
	
	public void closingBrowser(WebDriver driver) throws InterruptedException
	{
		Reporter.log("closing browser", true);
		Thread.sleep(1000);
		driver.close();
	}

}
