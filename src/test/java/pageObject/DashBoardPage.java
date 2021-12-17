package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage {
	Actions act;
	public DashBoardPage(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
		act = new Actions(driver);
	}
	
	@FindBy(xpath="//h1[text()='Dashboard']")
	WebElement dashBoardTitle;
	@FindBy(xpath="//a[@id=\"welcome\"]")
	WebElement welComeMenu;
	@FindBy(xpath="//a[text()='Logout']")
	WebElement logout;
	@FindBy(xpath="//a[@id=\"menu_admin_viewAdminModule\"]")
	WebElement adminMenu;
	@FindBy(xpath="//a[@id=\"menu_admin_UserManagement\"]")
	WebElement userManagementMenu;
	@FindBy(xpath="//a[@id=\"menu_admin_viewSystemUsers\"]")
	WebElement userMenu;
    
	public boolean VerifyPageTitle() {
		boolean status=dashBoardTitle.isDisplayed();
		return status;
	}
	public String getDashBoardPageTitle() {
		String title=dashBoardTitle.getText();
		return title;
		
	}
	public boolean verifyWelcomeMenu() {
		boolean status=welComeMenu.isDisplayed();
		return status;
	}
	public void clickWelcomeMenu() {
		welComeMenu.click();
	}
	public void clickOnLogout() {
		logout.click();
	}
	public void clickUserMenu() {
		act.moveToElement(adminMenu).moveToElement(userManagementMenu).moveToElement(userMenu).click().build().perform();
	}
}
