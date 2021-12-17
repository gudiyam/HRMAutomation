package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.log4testng.Logger;

import pageObject.DashBoardPage;
import pageObject.LoginPage;
import pageObject.SystemUser;
import utils.ConfigReader;

public class TestBase {
	 static protected WebDriver driver;	
	 protected ConfigReader config;
	 protected DashBoardPage dp;
	 protected SystemUser sp;
	 protected LoginPage lp;
	 protected Logger log;
	 @Parameters({"browser","appUrl"})
	 @BeforeMethod(alwaysRun = true)
	 public void login(String brOption,String url) {
		
		log = Logger.getLogger(TestBase.class);
		log.info("******************Initialization**************");
		log.info("Initializing properties file ");
		
         config = new ConfigReader();
        System.out.println(brOption);
		System.out.println(url);
		
		
		System.out.println("****************Setting up the browser**************");
		if(brOption.equals("chrome")) {
			System.setProperty(config.getchromeDriverKey(), config.getchromeDriverPath());
			driver=new ChromeDriver();
			
		}
		else if(brOption.equals("firefox")) {
			System.setProperty(config.getfirefoxDriverKey(), config.getfirefoxDriverPath());
		    driver = new FirefoxDriver();
			
		}
		System.out.println("***********Maximizing the browser************");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		System.out.println("**************Navigating to the webpage***********");
		driver.get(url);
		
	    lp=new LoginPage(driver);
    	Assert.assertTrue(lp.VerifyPresenceOfUserName(), "UserName input box is not present");
		lp.SetUserName(config.getuserName());
		Assert.assertTrue(lp.VerifyPresenceOfPassword(), "password input box is not present");
		lp.SetPassword(config.getpassword());
		Assert.assertTrue(lp.VerifyLoginBtn(), "LoginBtn Disabled");
		lp.clicklogin();
	    
		 dp=new DashBoardPage(driver);
		 sp = new SystemUser(driver);
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void closeBrowser() {
		dp.clickWelcomeMenu();
		dp.clickOnLogout();
		driver.close();
		System.out.println("*******************Closing the browser******************");
	}
	
}
