package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyaccountPage extends BasePage {

	public MyaccountPage(WebDriver driver) {
		super(driver);
		
	}
@FindBy(xpath="//h2[normalize-space()='My Account']")
WebElement Heading;
@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
WebElement logout;
public boolean isMyaccountDispalyed()
{
	try
	{
	   return (Heading.isDisplayed());
	}
	catch(Exception e)
	{
		return false;
	}
}
public void logout()
{
	logout.click();
}
}


