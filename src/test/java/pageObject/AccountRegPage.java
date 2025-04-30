package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegPage extends BasePage {
	
	public AccountRegPage(WebDriver driver)
	{
		super(driver);
	}
@FindBy(xpath="//input[@id='input-firstname']")
WebElement Fname;
@FindBy(xpath="//input[@id='input-lastname']")
WebElement Lname;
@FindBy(xpath="//input[@id='input-email']")
WebElement email;
@FindBy(xpath="//input[@id='input-telephone']")
WebElement Phone;
@FindBy(xpath="//input[@id='input-password']")
WebElement pwd;
@FindBy(xpath="//input[@id='input-confirm']")
WebElement cpwd;
@FindBy(xpath="(//input[@value='Continue'])[1]")
WebElement Btn;
@FindBy(xpath="//input[@name='agree']")
WebElement con;
@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
WebElement msgconfirm;
public void firstname(String Firstname)
{
	Fname.sendKeys(Firstname);
}
public void lastname(String lastname)
{
	Lname.sendKeys(lastname);
}
public void Mail(String mailid)
{
	email.sendKeys(mailid);
}
public void Tele(String Phno)
{
	Phone.sendKeys(Phno);
}
public void Password(String Pass)
{
	pwd.sendKeys(Pass);
}
public void Cpassword(String Pass)
{
	cpwd.sendKeys(Pass);
}
public void Confirm()
{
	con.click();
}
public void Continue()
{
	Btn.click();
}
public String ConfirmMsg()
{
try{
	 return (msgconfirm.getText());
   }catch (Exception e) { 
	 return (e.getMessage());
   }
	
 
}
}

