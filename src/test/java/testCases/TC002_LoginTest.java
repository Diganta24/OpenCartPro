package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.Homepage;
import pageObject.LoginPage;
import pageObject.MyaccountPage;

public class TC002_LoginTest extends BaseClass {

	@Test(groups= {"Sanity","Master"})
	public void ChcekLogin()
	{
		try {
		Homepage hp=new Homepage(driver);
		hp.clickMyAccount();
		hp.login();
		LoginPage lp=new LoginPage(driver);
		lp.setmail(p.getProperty("email"));
		lp.setpwd(p.getProperty("password"));
		lp.Log();
		MyaccountPage macp=new MyaccountPage(driver);
		boolean answer=macp.isMyaccountDispalyed(); 
		Assert.assertEquals(answer, true,"Login Fail");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
	}
	
}
