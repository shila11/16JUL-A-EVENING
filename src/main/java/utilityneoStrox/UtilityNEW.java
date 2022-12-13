package utilityneoStrox;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class UtilityNEW {
//READ PROPERTYFILE
	public static String readDatafromPropertiesFile(String key) throws IOException
	{
		
		Properties prop=new Properties();
		
	    FileInputStream myfile=new  FileInputStream("C:\\Users\\Shree\\eclipse-workspace\\16JUL_A_EVEN\\UtilItyNew.properties");
	    
	      prop.load(myfile);
     	  String value = prop.getProperty(key);
	    Reporter.log("Reading " +key+ " from property file", true);
	     return value;
	}
// TAKE SCREENSHOT 	
	public static  void screenShot(WebDriver driver,String screenShotname ) throws IOException
	{     
		    wait(driver,500);
	     File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 File dest=new File("D:\\sellenium\\chromedriver_win32\\Screenshot"+screenShotname+".png");
		 FileHandler.copy(src, dest);
		 Reporter.log("TAKESCREENSHOT", true);
	}
	
//SCROLLINTO VIEW
	public static void scrollIntoView(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView",element);
		Reporter.log("SCROLLING METHOD", true);
	}
	
	
//IMPLICITWAIT  METHOD
	
	public static void wait(WebDriver driver,int waittime)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(waittime));
		
		Reporter.log("Waiting for "+waittime+"ms",true);
	}	
	
	
}



