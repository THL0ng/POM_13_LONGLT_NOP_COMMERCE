package PageObjects.bankGuru;

import org.openqa.selenium.WebDriver;

import Commons.AbstractPages;
import PageUIs.bankGuru.LoginPageUI;

public class LoginPageObject extends AbstractPages {
	WebDriver driver;
	
	public LoginPageObject(WebDriver _driver) {
		driver = _driver;
		
	}

	public String getLoginPageUrl() {
		return getCurrentPageUrl(driver) ;
	}

	public RegisterPageObject clickToHereLink() {
		waitToElementClickable(driver, LoginPageUI.HERE_LINK);
		clickToElement(driver, LoginPageUI.HERE_LINK);
		return PageGeneratorManager.getRegisterPage(driver);
	}

	public void inputToUserIDTextbox(String userID) {
		waitToElementClickable(driver, LoginPageUI.USER_NAME_TXT);
		sendkeyToElement(driver, LoginPageUI.USER_NAME_TXT, userID);
	}

	public void inputToPasswordTextbox(String password) {
		waitToElementClickable(driver, LoginPageUI.PASSWORD_TXT);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TXT, password);		
	}

	public HomePageObject clickToLoginButton() {
		waitToElementClickable(driver, LoginPageUI.LOGIN_BTN);
		clickToElement(driver, LoginPageUI.LOGIN_BTN);
		return PageGeneratorManager.getHomePage(driver);
	}

	public HomePageObject loginAsUser(String userID, String password) {
		inputToUserIDTextbox(userID);
		inputToPasswordTextbox(password);
		return clickToLoginButton();
	}

}
