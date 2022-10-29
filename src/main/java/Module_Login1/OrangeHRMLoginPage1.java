package Module_Login1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMLoginPage1 
{
	//POM I
	//1.Data members/Glabal variable should be declare with access level private by using @findby annotation 
	
	@FindBy(xpath="//input[@name='username']")  private WebElement UN;
	
	@FindBy(xpath="//input[@type='password']")  private WebElement PSW;
	
	@FindBy(xpath="//button[@type='submit']")   private WebElement Loginbtn;
	
	//2.Initialised within a constructors with access level public by using PageFactory

	public OrangeHRMLoginPage1(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//3. Utilise within a method with access level public
	public void EnterUsername(String Username)
	{
		UN.sendKeys(Username);
	}
	public void EnterPassword(String password)
	{
		PSW.sendKeys(password);
	}
	public void ClickOnlogin()
	{
		Loginbtn.click();
	}
	

}
