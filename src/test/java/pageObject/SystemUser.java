package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SystemUser {
	public  SystemUser(WebDriver driver) {
		PageFactory.initElements(driver,this);
		}
	   @FindBy(xpath="//a[@class=\"toggle tiptip\"]")
		WebElement pageTitle;
	   public boolean verifySystemUserPageTitle() {
		   boolean status = pageTitle.isDisplayed();
		   return status;
	   }

}
