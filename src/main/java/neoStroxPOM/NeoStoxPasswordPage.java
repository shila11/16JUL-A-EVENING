package neoStroxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import utilityneoStrox.UtilityNEW;



public class NeoStoxPasswordPage {
//METHOD DECLARATION
	
	@FindBy(xpath="//input[@id=\"txt_accesspin\"]") private WebElement passWordField;
	@FindBy(xpath = "//a[text()='Submit']") private WebElement submitButton;

//METHOD INITIALISATION
	public NeoStoxPasswordPage(WebDriver driver)
	{
	
		PageFactory.initElements(driver, this);
	}

//METHOD USAGES
	public void enterPassword(WebDriver driver,String pass ) throws InterruptedException
	{
		UtilityNEW.wait(driver, 500);
		passWordField.sendKeys(pass);
		Reporter.log("entering the password", true);
		Thread.sleep(1000);
	}
	
	public void clickOnSubmitButton(WebDriver driver)
	{
		UtilityNEW.wait(driver, 500);
		submitButton.click();
		Reporter.log("clicking on submitButton", true);
		
	}
}
