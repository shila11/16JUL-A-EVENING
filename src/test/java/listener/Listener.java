package listener;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;


import neoStroxBase.BaseNew;
import utilityneoStrox.UtilityNEW;

public class Listener extends BaseNew implements ITestListener {
	
	public void onTestFailure(ITestResult result)
	{
		     String methodName = result.getName();
			Reporter.log("TC"+methodName+ "is fail..try again ", true);
			try {
				UtilityNEW.screenShot(driver,result.getName());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		
	public void onTestSucess(ITestResult result)
	{
		Reporter.log("TC"+result.getName()+" is pass", true);
	}

		
	public void onTestSkipped(ITestResult result)
	{
		Reporter.log("TC"+result+ "is skipped", true);
	}

}
