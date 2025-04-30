package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObject.AccountRegPage;
import pageObject.Homepage;

public class TC001_AccountRegistrationTest extends BaseClass {
	
		
	@Test(groups={"Regression","Master"})
	public void checkregistration()
	{
		Homepage hp=new Homepage(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		AccountRegPage arp=new AccountRegPage(driver);
		arp.firstname(randomeString().toUpperCase());
		arp.lastname(randomeString().toUpperCase());
		arp.Mail(randomeString()+"@gmail.com");
		arp.Tele(randomeNumber());
		String pw=randomeAlphanumaric();
		arp.Password(pw+"#");
		arp.Cpassword(pw+"#");
		arp.Confirm();
		arp.Continue();
		String confirmsg=arp.ConfirmMsg();
		Assert.assertEquals(confirmsg,"Your Account Has Been Created!" );
	}
		
}
