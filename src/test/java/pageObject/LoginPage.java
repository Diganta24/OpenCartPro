package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
@FindBy(xpath="//input[@id='input-email']")
WebElement Lemail;
@FindBy(xpath="//input[@id='input-password']")
WebElement Lpswd;
@FindBy(xpath="//input[@value='Login']")
WebElement btnlog;
public void setmail(String ml)
{
	Lemail.sendKeys(ml);
}
public void setpwd(String pd)
{
	Lpswd.sendKeys(pd);
}
public void Log()
{
	btnlog.click();
}
}
