package PageObjects.Nop_Commerce;

import org.openqa.selenium.WebDriver;

import Commons.AbstractPages;
import PageUIs.Nop_Commerce.RegisterPageUI;

public class RegisterPageObject extends AbstractPages {
	private WebDriver driver;
	
	public RegisterPageObject(WebDriver _driver) {
		driver = _driver;
		
	}

	public void clickToMaleRadio() {
		waitToElementClickable(driver, RegisterPageUI.GENDER_MALE_RADIO);
		clickToElement(driver, RegisterPageUI.GENDER_MALE_RADIO);
		
	}

	public void inputToFirstNameTextbox(String firstNameValue) {
		waitToElementDisplayed(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX,firstNameValue);
		
	}

	public void inputToLastNameTextbox(String lastNameValue) {
		waitToElementDisplayed(driver, RegisterPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX,lastNameValue);
		
	}

	public void selectDayDropdown(String expectedItem) {
		waitToElementClickable(driver, RegisterPageUI.DATE_DROPDOWN);
		selectItemInDropdown(driver, RegisterPageUI.DATE_DROPDOWN, expectedItem);
	
	}

	public void selectMonthDropdown(String expectedItem) {
		waitToElementClickable(driver, RegisterPageUI.MONTH_DROPDOWN);
		selectItemInDropdown(driver, RegisterPageUI.MONTH_DROPDOWN, expectedItem);
	
		
	}

	public void selectYearDropdown(String expectedItem) {
		waitToElementClickable(driver, RegisterPageUI.YEAR_DROPDOWN);
		selectItemInDropdown(driver, RegisterPageUI.YEAR_DROPDOWN, expectedItem);
	
		
	}

	public void inputToEmailTextbox(String emailValue) {
		waitToElementDisplayed(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX,emailValue);
		
	}

	public void inputToCompanyextbox(String companyValue) {
		waitToElementDisplayed(driver, RegisterPageUI.COMPANY_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.COMPANY_TEXTBOX,companyValue);
		
	}

	public void inputToPasswordTextbox(String passwordValue) {
		waitToElementDisplayed(driver, RegisterPageUI.PASSWORD_TEXTOBX);
		sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTOBX,passwordValue);
		
	}

	public void inputToConfirmPasswordTextbox(String confirmPasswordValue) {
		waitToElementDisplayed(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX,confirmPasswordValue);
		
	}

	public void clickToRegisterButton() {
		waitToElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
		
	}

	public String getRegisterSuccessMessage() {
		waitToElementDisplayed(driver, RegisterPageUI.REGISTER_SUCCESS_TEXT);
		return getTextlement(driver, RegisterPageUI.REGISTER_SUCCESS_TEXT);	
	}

	/*public HomePageObject clickToLogoutLink() {
		waitToElementClickable(driver, RegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
		return new HomePageObject(driver) ;
	} */
	
	
	// DÙNG VỚI GENERATOR MANGAGER
	public HomePageObject clickToLogoutLink() {
	waitToElementClickable(driver, RegisterPageUI.LOGOUT_LINK);
	clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
	return PageGeneratorManager.getHomePage(driver);
	}

	public boolean isFirstnameTextboxDisplayed() {
		waitToElementVisible(driver, "//input[@id='FirstName']");
		return isElementDisplayed(driver,"//input[@id='FirstName']");
		
	}

	public boolean isRequestVerifyTokenTextboxUndisplayed() {
		waitToElementInvisible(driver, "//input[@name='__RequestVerificationToken']");
		return isElementUndisplayed(driver,"//input[@name='__RequestVerificationToken']");
	}
	
	public boolean isRequestVerifyTokenTextboxdisplayed() {
		return isElementDisplayed(driver,"//input[@name='__RequestVerificationToken']");
	}

	public boolean isRegisterButtonUndisplayed() {
		waitToElementInvisible(driver, "//input[@class='button-1 register-button']");
		return isElementUndisplayed(driver, "//input[@name='__RequestVerificationToken']");
	}
	

}
