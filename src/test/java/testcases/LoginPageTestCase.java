package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import base.TestBase;

public class LoginPageTestCase extends TestBase{
    @Test(groups = {"Smoke"})
	public void HRM_LoginPage_VerifyWithValidCredentials() {
    	log.info("user is on dashboard page");
		String expectedTitle="Dashboard";
		String actualTitle=dp.getDashBoardPageTitle();
		Assert.assertEquals(actualTitle, expectedTitle,"Login Failed...!");
	}
    
    @Test
    public void HRM_LoginPage_VerifyWithInvalidCredentials() {
    	
    	Logger log = Logger.getLogger(LoginPageTestCase.class);
    	log.info("user is on login page and trying to access with invalid credetials");
    	
    	Assert.assertTrue(lp.VerifyPresenceOfUserName(), "UserName input box is not present");
		lp.SetUserName("Admin");
		
		log.info("Enetred user name");
		
		Assert.assertTrue(lp.VerifyPresenceOfPassword(), "password input box is not present");
		lp.SetPassword("xzsaw");
		
		log.info("Enetred invalid password");
		
		Assert.assertTrue(lp.VerifyLoginBtn(), "LoginBtn Disabled");
		lp.clicklogin();
		
		log.info("click on login button");
		String expectedValue="Invalid credentials";
		String atcualValue=lp.getInvalidLoginErrorMessage();
		Assert.assertEquals(atcualValue, expectedValue,"Login success....and test failed");
    }
}
