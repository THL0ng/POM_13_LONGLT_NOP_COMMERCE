package PageObjects;

import org.openqa.selenium.WebDriver;

import Commons.AbstractPages;
import PageUIs.HomePageUI;

public class HomePageObject extends AbstractPages{
	private WebDriver driver;
	
	public HomePageObject(WebDriver _driver) {
		driver = _driver;
		
	}

	public RegisterPageObject clickToRegisterLink() {
		waitToElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);		
		return new RegisterPageObject(driver);
	}

	public LoginPageObject clickToLoginlink() {
		waitToElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);		
		return new LoginPageObject(driver);
	}

	public boolean isMyAccountLinkDisplayed() {
		waitToElementDisplayed(driver,HomePageUI.MY_ACCOUNT_LINK);
		isElementDisplayed(driver,HomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver,HomePageUI.MY_ACCOUNT_LINK);
	}

	

}
