package PageObjects.Nop_Commerce;

import org.openqa.selenium.WebDriver;

import Commons.AbstractPages;
import Commons.PageGeneratorManager;
import PageUIs.Nop_Commerce.HomePageUI;

public class HomePageObject extends AbstractPages{
	private WebDriver driver;
	
	public HomePageObject(WebDriver _driver) {
		driver = _driver;
		
	}

	/*public RegisterPageObject clickToRegisterLink() {
		waitToElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);		
		return new RegisterPageObject(driver);
	} */
	
	
	// DÙNG VỚI PAGE GENERATOR
	public RegisterPageObject clickToRegisterLink() {
		waitToElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);		
		return PageGeneratorManager.getRegisterPage(driver);
	}

	/*public LoginPageObject clickToLoginlink() {
		waitToElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);		
		return new LoginPageObject(driver);
	} */
	
	public LoginPageObject clickToLoginlink() {
		waitToElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);		
		return PageGeneratorManager.getLoginPage(driver);
	}

	public boolean isMyAccountLinkDisplayed() {
		waitToElementDisplayed(driver,HomePageUI.MY_ACCOUNT_LINK);
		isElementDisplayed(driver,HomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver,HomePageUI.MY_ACCOUNT_LINK);
	}

	

}
