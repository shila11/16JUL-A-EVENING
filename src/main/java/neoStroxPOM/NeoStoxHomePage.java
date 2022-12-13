package neoStroxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import utilityneoStrox.UtilityNEW;




public class NeoStoxHomePage {
//METHOD DECLARATION
	@FindBy(xpath = "(//a[text()='OK'])[2]") private WebElement okButton;
	@FindBy(xpath = "(//a[text()='Close'])[5]") private WebElement closeButton;
	@FindBy(id="lbl_username")private WebElement userName;
	//@FindBy(id="lbl_username") private WebElement userName;
	//@FindBy(id="//span[@id=\"lbl_curbalancetop\"]") private WebElement acBalance;
	@FindBy(id = "lbl_curbalancetop") private WebElement acBalance;
	@FindBy(xpath = "//span[text()='Logout']") private WebElement logOutButton;
	

//METHOD INITILISATION
	public NeoStoxHomePage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
//method usages
	public void handlePopup(WebDriver driver) throws InterruptedException
	{
		if(okButton.isDisplayed())
		{
		UtilityNEW.wait(driver, 500);
		okButton.click();
		Reporter.log("clicking on ok button", true);
		UtilityNEW.wait(driver, 500);
		closeButton.click();
		Reporter.log("clicking on close button", true);
	}
		
		else
		{
			Reporter.log("there is no popup", true);
			Thread.sleep(1000);
	
		}
	}
		
		public String getActualUserName(WebDriver driver)	
		{
			UtilityNEW.wait(driver, 1000);
			String actulaUserName = userName.getText();
			Reporter.log("the actual string is", true);
			String realUserName = actulaUserName.substring(3);
			Reporter.log("Actual username is"+realUserName,true);
		   return actulaUserName; 
		   
		  
		} 
		
		
		public String getaccBalance(WebDriver driver)
		{
			UtilityNEW.wait(driver, 500);
			String  accBalance=acBalance.getText();
			Reporter.log("getting accBalance ", true);
			Reporter.log("Account Balance is "+accBalance,true);
			return accBalance;
		}
		
	public void logout(WebDriver driver)
	{
		UtilityNEW.wait(driver, 500);
		userName.click();
		UtilityNEW.wait(driver, 500);
		logOutButton.click();
		Reporter.log("Logging out", true);
		
		
		
		
		
		
		
	}
}