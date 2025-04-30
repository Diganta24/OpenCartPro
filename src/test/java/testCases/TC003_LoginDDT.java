package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.Homepage;
import pageObject.LoginPage;
import pageObject.MyaccountPage;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass{

	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class,groups="Datadriven")
	public void verify_loginDDT(String email,String pswd,String res)
	{
		try
		{
		Homepage hp=new Homepage(driver);
		hp.clickMyAccount();
		hp.login();
		LoginPage lp=new LoginPage(driver);
		lp.setmail(email);
		lp.setpwd(pswd);
		lp.Log();
		MyaccountPage myp=new MyaccountPage(driver);
		boolean tp=myp.isMyaccountDispalyed();
		if(res.equalsIgnoreCase("Valid"))
		{
			if(tp==true)
			{
				Assert.assertTrue(true);
			    myp.logout();
			}
			else
			{
				Assert.assertTrue(false);
			}
			    			
		}
		if(res.equalsIgnoreCase("Invalid"))
		{
			if(tp==true)
			{
				Assert.assertTrue(false);
				myp.logout();
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
	}
}
