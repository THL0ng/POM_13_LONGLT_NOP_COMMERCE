package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Commons.AbstractPages;
import PageUIs.Nop_Commerce.RegisterPageUI;

public class RegisterPageObject extends AbstractPageFactory {
	private WebDriver driver;
	
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

		
	}
	
	@FindBy(id = "gender-male")
	private WebElement genderMaleRadio;
	
	@FindBy(id = "FirstName")
	private WebElement firstNameTextbox;
	
	@FindBy(id = "LastName")
	private WebElement lastNameTextbox;
	
	@FindBy(name = "DateOfBirthDay")
	private WebElement dateDropdownList;
	
	@FindBy(name = "DateOfBirthMonth")
	private WebElement monthDropdownList;
	
	@FindBy(name = "DateOfBirthYear")
	private WebElement yearDropdownList;
	
	@FindBy(id = "Email")
	private WebElement emailTextbox;
	
	@FindBy(id = "Company")
	private WebElement CompanyTextbox;
	
	@FindBy(id = "Password")
	private WebElement PasswordTextbox;
	
	@FindBy(id = "ConfirmPassword")
	private WebElement ConfirmPasswordTextbox;
	
	@FindBy(id = "register-button")
	private WebElement registerButton;
	
	@FindBy(className = "result")
	private WebElement registerSuccessText;
	
	@FindBy(xpath = "//div[@class='header-links']//a[text()='Log out']")
	private WebElement logoutLink;
	
	

	public void clickToMaleRadio() {
		waitToElementClickable(driver, genderMaleRadio);
		clickToElement(driver, genderMaleRadio);
		
	}

	public void inputToFirstNameTextbox(String firstNameValue) {
		waitToElementDisplayed(driver, firstNameTextbox);
		senkeyToElement(driver, firstNameTextbox,firstNameValue);
		
	}

	public void inputToLastNameTextbox(String lastNameValue) {
		waitToElementDisplayed(driver, lastNameTextbox);
		senkeyToElement(driver, lastNameTextbox,lastNameValue);
		
	}

	public void selectDayDropdown(String expectedItem) {
		waitToElementClickable(driver, dateDropdownList);
		selectItemInDropdown(driver, dateDropdownList, expectedItem);
	
	}

	public void selectMonthDropdown(String expectedItem) {
		waitToElementClickable(driver, monthDropdownList);
		selectItemInDropdown(driver, monthDropdownList, expectedItem);
	
		
	}

	public void selectYearDropdown(String expectedItem) {
		waitToElementClickable(driver, yearDropdownList);
		selectItemInDropdown(driver, yearDropdownList, expectedItem);
	
		
	}

	public void inputToEmailTextbox(String emailValue) {
		waitToElementDisplayed(driver, emailTextbox);
		senkeyToElement(driver, emailTextbox,emailValue);
		
	}

	public void inputToCompanyextbox(String companyValue) {
		waitToElementDisplayed(driver, CompanyTextbox);
		senkeyToElement(driver, CompanyTextbox,companyValue);
		
	}

	public void inputToPasswordTextbox(String passwordValue) {
		waitToElementDisplayed(driver, PasswordTextbox);
		senkeyToElement(driver, PasswordTextbox,passwordValue);
		
	}

	public void inputToConfirmPasswordTextbox(String confirmPasswordValue) {
		waitToElementDisplayed(driver, ConfirmPasswordTextbox);
		senkeyToElement(driver, ConfirmPasswordTextbox,confirmPasswordValue);
		
	}

	public void clickToRegisterButton() {
		waitToElementClickable(driver, registerButton);
		clickToElement(driver, registerButton);
		
	}

	public String getRegisterSuccessMessage() {
		waitToElementDisplayed(driver, registerSuccessText);
		return getTextlement(driver, registerSuccessText);	
	}

	public HomePageObject clickToLogoutLink() {
		waitToElementClickable(driver, logoutLink);
		clickToElement(driver, logoutLink);
		return new HomePageObject(driver) ;
	}

}
