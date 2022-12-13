package neoStroxTest;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import neoStroxBase.BaseNew;
import neoStroxPOM.NeoStoxHomePage;
import neoStroxPOM.NeoStoxLoginPage;
import neoStroxPOM.NeoStoxPasswordPage;
import neoStroxPOM.NeoStoxSignInPage;
import utilityneoStrox.UtilityNEW;


@Listeners(listener.Listener.class)
public class ValidateNeoStoxUserName2 extends BaseNew {
	NeoStoxLoginPage  login;
	NeoStoxPasswordPage password;
	NeoStoxHomePage home;
	NeoStoxSignInPage signIn;
	
	@BeforeClass
public void launchNeostrox () throws InterruptedException, IOException
{
	//launchBrowser();
	launchBrowser();
	login=new NeoStoxLoginPage(driver);
	password=new NeoStoxPasswordPage(driver);
	home=new NeoStoxHomePage (driver);
	signIn= new NeoStoxSignInPage(driver);
	
}
	
@BeforeMethod
public void logintoNeoStox() throws EncryptedDocumentException, IOException, InterruptedException
{
	signIn.clickOnSignInButton(driver);
	
	Thread.sleep(5000);
	Reporter.log("hii login page testNG", true);
	login.sendmobNo(driver, UtilityNEW.readDatafromPropertiesFile("mobnum"));
	login.clickonSignbutton(driver);
	UtilityNEW.wait(driver, 5000);
	password.enterPassword(driver, UtilityNEW.readDatafromPropertiesFile("Pass"));
	Thread.sleep(5000);
	password.clickOnSubmitButton(driver);
	Thread.sleep(5000);
	home.handlePopup(driver);
	
}

 @Test
  public void validateUserName() throws EncryptedDocumentException, IOException {
	Assert.assertEquals(home.getActualUserName(driver),UtilityNEW.readDatafromPropertiesFile("username"));
	//Utility.screenShot(driver, home.getActualUserName(driver));
	UtilityNEW.screenShot(driver, home.getActualUserName(driver)); 
  }
 
 @Test(priority=-1)
 public void validateaccBalance() throws IOException
 {
	 Assert.assertNotNull(home.getaccBalance(driver), "Unable to fetch your balance");
	 UtilityNEW.screenShot(driver, home.getaccBalance(driver));
	 Assert.fail();
 }
 
 @AfterMethod
 public void logout()
 {
	 home.logout(driver);
 }
 @AfterClass
 public void closeBrowser()
 {
	 driver.close();
	 Reporter.log("browser closing ", true);
 }
 
 
}
