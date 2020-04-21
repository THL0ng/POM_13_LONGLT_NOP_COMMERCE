package PageObjects.bankGuru;

import org.openqa.selenium.WebDriver;

import Commons.AbstractPages;
import PageUIs.bankGuru.RegisterPageUI;

public class RegisterPageObject extends AbstractPages {
	WebDriver driver;
	
	public RegisterPageObject(WebDriver _driver) {
		driver = _driver;
		
	}

	public void inputToEmailTextbox(String emailValue) {
		waitToElementClickable(driver, RegisterPageUI.EMAIL_ID_TXT);
		sendkeyToElement(driver, RegisterPageUI.EMAIL_ID_TXT, emailValue);
	}

	public void clickToSubmitButton() {
		waitToElementClickable(driver, RegisterPageUI.SUBMIT_BTN);
		clickToElement(driver, RegisterPageUI.SUBMIT_BTN);
		
	}

	public String getUserIDValue() {
		waitToElementInvisible(driver, RegisterPageUI.USER_ID_TEXT);
		return getTextlement(driver,  RegisterPageUI.USER_ID_TEXT);
	}

	public String getPasswordValue() {
		waitToElementInvisible(driver, RegisterPageUI.PASSWORD_ID_TEXT);
		return getTextlement(driver,  RegisterPageUI.PASSWORD_ID_TEXT);
	}

	public LoginPageObject openLoginPage(String loginPageUrl) {
		openUrl(driver,loginPageUrl);
		return PageGeneratorManager.getLoginPage(driver);
	}

}
