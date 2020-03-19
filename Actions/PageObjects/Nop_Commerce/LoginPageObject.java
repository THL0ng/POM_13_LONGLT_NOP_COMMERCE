package PageObjects.Nop_Commerce;

import org.openqa.selenium.WebDriver;

import Commons.AbstractPages;
import Commons.PageGeneratorManager;
import PageUIs.Nop_Commerce.LoginPageUI;

// PAGEOBJECTS CHỨA C�?C PAGE OBJECTS, MỖI PAGE SẼ CHỨA C�?C SỰ KIỆN LIÊN QUAN �?ẾN TC �?ANG VIẾT CỦA PAGE �?Ó
public class LoginPageObject extends AbstractPages {
	private WebDriver driver;
	
	public LoginPageObject(WebDriver _driver) {
		driver = _driver;
		
	}

	public void inputToEmailTextbox(String emailValue) {
		waitToElementDisplayed(driver, LoginPageUI.EMAIL_TEXTBOX);
		senkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, emailValue);	
	}


	/*public HomePageObject clickToLoginButton() {
		waitToElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);	
		return new HomePageObject(driver);
	} */
	
	// DÙNG GENERATOR MANGAER
	public HomePageObject clickToLoginButton() {
		waitToElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);	
		return PageGeneratorManager.getHomePage(driver);
	}

	public void inputToPasswordTextBox(String passwordValue) {
		waitToElementDisplayed(driver, LoginPageUI.PASSWORD_TEXTBOX);
		senkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, passwordValue);		
	}

}
