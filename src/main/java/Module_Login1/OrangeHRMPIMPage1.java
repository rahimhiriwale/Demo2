package Module_Login1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMPIMPage1 
{
	//POM II
	//1.Data members/Global variable should be declare with access level private by using @findby annotation
	
	@FindBy(xpath="//span[@class='oxd-userdropdown-tab']") private WebElement Username;
	
	@FindBy(xpath="//a[text()='Logout']") private WebElement Logoutbtn;
	
	
	
	//2.Initialise within a constructor with access level public using PageFactory
	public OrangeHRMPIMPage1(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//3. Utilise within method with access level public
	
	public String getUsername()
	{
		String ActualResult=Username.getText();
		
		return ActualResult;
	}
	public void ClickOnUsername()
	{
		Username.click();
	}
	public void clickOnLogout()
	{
		Logoutbtn.click();
	}

}
