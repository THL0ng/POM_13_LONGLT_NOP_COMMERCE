package Com.bankguru.payment;

import org.testng.annotations.Test;

import Commons.AbstractTest;
import Commons.PageGeneratorManager;
import PageObjects.bankGuru.EditCustomerPageObject;
import PageObjects.bankGuru.HomePageObject;
import PageObjects.bankGuru.LoginPageObject;
import PageObjects.bankGuru.NewCustomerPageObject;
import PageObjects.bankGuru.RegisterPageObject;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class Payment_01_PaymentWorkflow extends AbstractTest {
	WebDriver driver;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	HomePageObject homePage;
	NewCustomerPageObject newCustomerPage;
	EditCustomerPageObject editCustomerPage;

	String email, customerName, gender, dateOfBirth, address, city, state, pin, phone, password, customerID;
	String editAddress, editCity, editState, editPin, editPhone, editEmail;

	@Parameters({ "browser", "url" })
	@BeforeTest
	public void beforeTest(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);

		email = "shenlong" + randowmNumber() + "@gmail.com";

		customerName = "shenlong";
		gender = "male";
		dateOfBirth = "2020-05-06";
		address = "123 DLC";
		city = "TPHCM";
		state = "Paris";
		pin = "999888";
		phone = "0906999888";

		editAddress = "456 AAA";
		editCity = "NEWYORK";
		editState = "LONDON";
		editPin = "555666";
		editPhone = "0906888777";
		editEmail = "shenlong" + randowmNumber() + "@gmail.com";

		loginPage = PageObjects.bankGuru.PageGeneratorManager.getLoginPage(driver);

		String loginPageUrl = loginPage.getLoginPageUrl();

		// pre-condition
		registerPage = loginPage.clickToHereLink();

		registerPage.inputToEmailTextbox(email);

		registerPage.clickToSubmitButton();

		String userID = registerPage.getUserIDValue();
		password = registerPage.getPasswordValue();

		loginPage = registerPage.openLoginPage(loginPageUrl);

		loginPage.inputToUserIDTextbox(userID);
		loginPage.inputToPasswordTextbox(password);
		homePage = loginPage.clickToLoginButton();
		verifyTrue(homePage.isWelcomeMessageDisplayed());

	}

	@Test(description = "Create new customer and get customer ID")
	public void Payment_01_CreateNewCustomer() {
		homePage.openBankGuruPage(driver, "New Customer");
		newCustomerPage = PageObjects.bankGuru.PageGeneratorManager.getNewCustomerPage(driver);

		// Create new Customer
		newCustomerPage.inputToBankGuruTextboxByName(driver, "name", customerName);
		newCustomerPage.clickToBankGuruRadioButtonByValue(driver, "m");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "dob", dateOfBirth);
		newCustomerPage.inputToBankGuruTextAreaByName(driver, "addr", address);
		newCustomerPage.inputToBankGuruTextboxByName(driver, "city", city);
		newCustomerPage.inputToBankGuruTextboxByName(driver, "state", state);
		newCustomerPage.inputToBankGuruTextboxByName(driver, "pinno", pin);
		newCustomerPage.inputToBankGuruTextboxByName(driver, "telephoneno", phone);
		newCustomerPage.inputToBankGuruTextboxByName(driver, "emailid", email);
		newCustomerPage.inputToBankGuruTextboxByName(driver, "password", password);
		newCustomerPage.clickToBankGuruButtonByValue(driver, "Submit");

		// Verify Customer created sucess
		verifyEquals(newCustomerPage.getBankGuruHeaderText(driver), "Customer Registered Successfully!!!");

		verifyEquals(newCustomerPage.getBankGuruRowValueByRowName(driver, "Customer Name"), customerName);
		verifyEquals(newCustomerPage.getBankGuruRowValueByRowName(driver, "Gender"), gender);
		verifyEquals(newCustomerPage.getBankGuruRowValueByRowName(driver, "Birthdate"), dateOfBirth);
		verifyEquals(newCustomerPage.getBankGuruRowValueByRowName(driver, "Address"), address);
		verifyEquals(newCustomerPage.getBankGuruRowValueByRowName(driver, "City"), city);
		verifyEquals(newCustomerPage.getBankGuruRowValueByRowName(driver, "State"), state);
		verifyEquals(newCustomerPage.getBankGuruRowValueByRowName(driver, "Pin"), pin);
		verifyEquals(newCustomerPage.getBankGuruRowValueByRowName(driver, "Mobile No."), phone);
		verifyEquals(newCustomerPage.getBankGuruRowValueByRowName(driver, "Email"), email);

		// GET CUSTOMER ID
		customerID = newCustomerPage.getBankGuruRowValueByRowName(driver, "Customer ID");

	}

	@Test
	public void Payment_02_EditCustomer() {
		newCustomerPage.openBankGuruPage(driver, "Edit Customer");
		editCustomerPage = PageObjects.bankGuru.PageGeneratorManager.getEditCustomerPage(driver);

		editCustomerPage.inputToBankGuruTextboxByName(driver, "cusid", customerID);
		editCustomerPage.clickToBankGuruButtonByValue(driver, "Submit");

		// VERIFY THE FIELDS DISABLED
		verifyFalse(editCustomerPage.isBankGuruTextboxEnabled(driver, "name"));
		verifyFalse(editCustomerPage.isBankGuruTextboxEnabled(driver, "gender"));
		verifyFalse(editCustomerPage.isBankGuruTextboxEnabled(driver, "dob"));

		// VERIFY THE FIELDS ENABLED
		verifyTrue(editCustomerPage.isBankGuruTextboxEnabled(driver, "city"));
		verifyTrue(editCustomerPage.isBankGuruTextboxEnabled(driver, "state"));

		// EDIT CUSTOMER
		editCustomerPage.inputToBankGuruTextAreaByName(driver, "addr", editAddress);
		editCustomerPage.inputToBankGuruTextboxByName(driver, "city", editCity);
		editCustomerPage.inputToBankGuruTextboxByName(driver, "state", editState);
		editCustomerPage.inputToBankGuruTextboxByName(driver, "pinno", editPin);
		editCustomerPage.inputToBankGuruTextboxByName(driver, "telephoneno", editPhone);
		editCustomerPage.inputToBankGuruTextboxByName(driver, "emailid", editEmail);

		editCustomerPage.clickToBankGuruButtonByValue(driver, "Submit");
		
		// Verify Customer edited sucess
		verifyEquals(editCustomerPage.getBankGuruHeaderText(driver), "Customer details updated Successfully!!!");

		
		// CREATE CUSTOMER (DISABLED)
		verifyEquals(editCustomerPage.getBankGuruRowValueByRowName(driver, "Customer ID"), customerID);
		verifyEquals(editCustomerPage.getBankGuruRowValueByRowName(driver, "Customer Name"), customerName);
		verifyEquals(editCustomerPage.getBankGuruRowValueByRowName(driver, "Gender"), gender);
		verifyEquals(editCustomerPage.getBankGuruRowValueByRowName(driver, "Birthdate"), dateOfBirth);
		
		// EDIT CUSTOMER
		verifyEquals(editCustomerPage.getBankGuruRowValueByRowName(driver, "Address"), editAddress);
		verifyEquals(editCustomerPage.getBankGuruRowValueByRowName(driver, "City"), editCity);
		verifyEquals(editCustomerPage.getBankGuruRowValueByRowName(driver, "State"), editState);
		verifyEquals(editCustomerPage.getBankGuruRowValueByRowName(driver, "Pin"), editPin);
		verifyEquals(editCustomerPage.getBankGuruRowValueByRowName(driver, "Mobile No."), editPhone);
		verifyEquals(editCustomerPage.getBankGuruRowValueByRowName(driver, "Email"), editEmail);
		
	}

	@Test
	public void Payment_03_AddNewAccount() {

	}

	@Test
	public void Payment_04_EditAccount() {

	}

	@Test
	public void Payment_05_DepositToCurrentAccount() {

	}

	@Test
	public void Payment_06_WithdrawFromCurrentAccount() {

	}

	@Test
	public void Payment_07_TransferToAnotherAccount() {

	}

	@Test
	public void Payment_08_CheckAccountBalance() {

	}

	@Test
	public void Payment_09_DeleteAllAccount() {

	}

	@Test
	public void Payment_10_DeleteCustomer() {

	}

	@AfterTest
	public void afterTest() {
		// closeBrowserAndDriver(driver);
	}

}
