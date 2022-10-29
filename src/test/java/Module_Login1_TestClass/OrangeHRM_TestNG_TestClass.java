package Module_Login1_TestClass;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Library_files.Base_Class;
import Library_files.Utility_Class;
import Module_Login1.OrangeHRMLoginPage1;
import Module_Login1.OrangeHRMPIMPage1;

public class OrangeHRM_TestNG_TestClass extends Base_Class
{
	OrangeHRMLoginPage1 login;
	 OrangeHRMPIMPage1 PIM1;
	 
	 int TestCaseID;
	
	@BeforeClass
	public void OpenBrowser() throws InterruptedException
	{
		initialiseBrowser();
		
		 login=new OrangeHRMLoginPage1(driver);
		 PIM1=new OrangeHRMPIMPage1(driver);
	}
	
	@BeforeMethod
	public void Login() throws IOException
	{
		login.EnterUsername(Utility_Class.getdatafromPF("UN"));
		
		login.EnterPassword(Utility_Class.getdatafromPF("PSW"));
		
		login.ClickOnlogin();
	}
	
	@Test(priority=1)
	public void VerifyUsername() throws EncryptedDocumentException, IOException
	{
		TestCaseID=001;
		
		String ActualUsername=PIM1.getUsername();
		
		String ExpectedUsername=Utility_Class.getdatafromExcel(0,0);
		
		Assert.assertEquals(ActualUsername, ExpectedUsername);
		
	}
	
	@Test(priority=2)
	public void VerifyTitle() throws EncryptedDocumentException, IOException
	{
		TestCaseID=002;
				
		String ActualTitle=driver.getTitle();
		
		String ExpectedTitle=Utility_Class.getdatafromExcel(0, 1);
		
		Assert.assertEquals(ActualTitle, ExpectedTitle);
		
	}
	
	@AfterMethod
	public void Logout(ITestResult Result) throws IOException
	{
		if(Result.getStatus()==ITestResult.FAILURE)
		{
			Utility_Class.CaptureScreenshot(driver,TestCaseID);
		}
		
		PIM1.ClickOnUsername();
		
		PIM1.clickOnLogout();
	}
	
	@AfterClass
	public void CloseBrowser()
	{
		driver.close();
	}

}
