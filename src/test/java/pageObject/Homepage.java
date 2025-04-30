package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends BasePage {
	public Homepage(WebDriver driver)
	{
		super(driver);
	}
@FindBy(xpath="//span[normalize-space()='My Account']")
WebElement Myaccount;
@FindBy(xpath="(//a[normalize-space()='Register'])[1]")
WebElement Register;
@FindBy(xpath="//a[normalize-space()='Login']")
WebElement Login;
public void clickMyAccount()
{
	Myaccount.click();
}
public void clickRegister()
{
	Register.click();
}
public void login()
{
	Login.click();
}
}
