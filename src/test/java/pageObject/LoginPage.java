package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		
	}
	By userNameInputBox=By.xpath("//input[@id=\"txtUsername\"]");
	By password=By.xpath("//input[@id=\"txtPassword\"]");
	By loginBtn=By.xpath("//input[@value=\"LOGIN\"]");
	By errorMsg=By.xpath("//span[text()='Invalid credentials']");
	
	public boolean VerifyPresenceOfUserName() {
		
		boolean status=driver.findElement(userNameInputBox).isDisplayed();
		return status;
	}
	public void SetUserName(String uname) {
		driver.findElement(userNameInputBox).clear();
		driver.findElement(userNameInputBox).sendKeys(uname);
	}
	
    public boolean VerifyPresenceOfPassword() {
		driver.findElement(password).clear();
		boolean status=driver.findElement(password).isDisplayed();
		return status;
	}
	public void SetPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	 public boolean VerifyLoginBtn() {
			boolean status=driver.findElement(loginBtn).isEnabled();
			return status;
		}
		public void clicklogin() {
			driver.findElement(loginBtn).click();
		}
		
		public String getInvalidLoginErrorMessage() {
			String errormsge=driver.findElement(errorMsg).getText();
			return errormsge;
		}
		
}
