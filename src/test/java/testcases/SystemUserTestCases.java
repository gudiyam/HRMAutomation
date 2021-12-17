package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;

public class SystemUserTestCases extends TestBase{
  @Test(groups = {"Smoke"})
	public void verifySystemUserPage() {
		dp.clickUserMenu();
		log.info("User on Systemuser page");
		Assert.assertTrue(sp.verifySystemUserPageTitle(), "Systemuser page is not loaded...");
	}
   
}
