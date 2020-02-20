package PageObjects;

import org.openqa.selenium.WebDriver;

import Commons.AbstractPages;
import PageUIs.RegisterPageUI;

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
		senkeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX,firstNameValue);
		
	}

	public void inputToLastNameTextbox(String lastNameValue) {
		waitToElementDisplayed(driver, RegisterPageUI.LAST_NAME_TEXTBOX);
		senkeyToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX,lastNameValue);
		
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
		senkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX,emailValue);
		
	}

	public void inputToCompanyextbox(String companyValue) {
		waitToElementDisplayed(driver, RegisterPageUI.COMPANY_TEXTBOX);
		senkeyToElement(driver, RegisterPageUI.COMPANY_TEXTBOX,companyValue);
		
	}

	public void inputToPasswordTextbox(String passwordValue) {
		waitToElementDisplayed(driver, RegisterPageUI.PASSWORD_TEXTOBX);
		senkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTOBX,passwordValue);
		
	}

	public void inputToConfirmPasswordTextbox(String confirmPasswordValue) {
		waitToElementDisplayed(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		senkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX,confirmPasswordValue);
		
	}

	public void clickToRegisterButton() {
		waitToElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
		
	}

	public String getRegisterSuccessMessage() {
		waitToElementDisplayed(driver, RegisterPageUI.REGISTER_SUCCESS_TEXT);
		return getTextlement(driver, RegisterPageUI.REGISTER_SUCCESS_TEXT);	
	}

	public HomePageObject clickToLogoutLink() {
		waitToElementClickable(driver, RegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
		return new HomePageObject(driver) ;
	}

}
