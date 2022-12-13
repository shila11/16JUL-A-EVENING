package neoStroxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import utilityneoStrox.UtilityNEW;



public class NeoStoxLoginPage {
//METHOD DECLARATION
	
	@FindBy(id="MainContent_signinsignup_txt_mobilenumber") private WebElement mobileNumField;
	@FindBy(xpath = "(//a[text()='Sign In'])[2]") private WebElement signInButton;

//METHOD INITIALISATION	
	public NeoStoxLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

//METHOD USAGES
	public void sendmobNo(WebDriver driver,String mobno)
	{
	     UtilityNEW.wait(driver, 500);
		mobileNumField.sendKeys(mobno);
		Reporter.log("entering the mob no", true);
	}
	
	public void clickonSignbutton(WebDriver driver) throws InterruptedException
	{
		UtilityNEW.wait(driver, 500);
		signInButton.click();
		Reporter.log("cliking on signINButton ", true);
		Thread.sleep(1000);
	}
	
	
	
	
	
}
