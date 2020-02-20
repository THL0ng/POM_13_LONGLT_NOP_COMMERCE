package PageObjects;

import org.openqa.selenium.WebDriver;

import Commons.AbstractPages;
import PageUIs.LoginPageUI;

// PAGEOBJECTS CHỨA CÁC PAGE OBJECTS, MỖI PAGE SẼ CHỨA CÁC SỰ KIỆN LIÊN QUAN ĐẾN TC ĐANG VIẾT CỦA PAGE ĐÓ
public class LoginPageObject extends AbstractPages {
	private WebDriver driver;
	
	public LoginPageObject(WebDriver _driver) {
		driver = _driver;
		
	}

	public void inputToEmailTextbox(String emailValue) {
		waitToElementDisplayed(driver, LoginPageUI.EMAIL_TEXTBOX);
		senkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, emailValue);	
	}


	public HomePageObject clickToLoginButton() {
		waitToElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);	
		return new HomePageObject(driver);
	}

	public void inputToPasswordTextBox(String passwordValue) {
		waitToElementDisplayed(driver, LoginPageUI.PASSWORD_TEXTBOX);
		senkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, passwordValue);		
	}

}
