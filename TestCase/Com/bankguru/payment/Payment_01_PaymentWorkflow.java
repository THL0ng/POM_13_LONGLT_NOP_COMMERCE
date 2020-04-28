package Com.bankguru.payment;

import org.testng.annotations.Test;

import Commons.AbstractTest;
import PageObjects.Nop_Commerce.PageGeneratorManager;
import PageObjects.bankGuru.BalanceEnquiryPageObject;
import PageObjects.bankGuru.DeleteAccountPageObject;
import PageObjects.bankGuru.DeleteCustomerPageObject;
import PageObjects.bankGuru.DepositPageObject;
import PageObjects.bankGuru.EditAccountPageObject;
import PageObjects.bankGuru.EditCustomerPageObject;
import PageObjects.bankGuru.FundTransferPageObject;
import PageObjects.bankGuru.HomePageObject;
import PageObjects.bankGuru.LoginPageObject;
import PageObjects.bankGuru.NewAccountPageObject;
import PageObjects.bankGuru.NewCustomerPageObject;
import PageObjects.bankGuru.RegisterPageObject;
import PageObjects.bankGuru.WithdrawalPageObject;

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
	NewAccountPageObject newAccountPage;
	EditAccountPageObject editAccountPage;
	DepositPageObject depositPage;
	WithdrawalPageObject withdrawPage;
	FundTransferPageObject fundTranferPage;
	BalanceEnquiryPageObject balanceEnquiryPage;
	DeleteAccountPageObject deleteAccountPage;
	DeleteCustomerPageObject deleteCustomerPage;

	String email, customerName, gender, dateOfBirth, address, city, state, pin, phone, password, customerID;
	String editAddress, editCity, editState, editPin, editPhone, editEmail;
	String accountTypeSaving, accountTypeCurrent,firstAccountID,secondAccountID;

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
		
		accountTypeSaving = "Savings";
		accountTypeCurrent = "Current";

		loginPage = PageObjects.bankGuru.PageGeneratorManager.getLoginPage(driver);

		String loginPageUrl = loginPage.getLoginPageUrl();

		// pre-condition
		registerPage = loginPage.clickToHereLink();

		registerPage.inputToEmailTextbox(email);

		registerPage.clickToSubmitButton();

		String userID = registerPage.getUserIDValue();
		password = registerPage.getPasswordValue();

		loginPage = registerPage.openLoginPage(loginPageUrl);
	
		homePage = loginPage.loginAsUser(userID,password);
		verifyTrue(homePage.isWelcomeMessageDisplayed());

	}

	@Test(description = "Create new customer and get customer ID")
	public void Payment_01_CreateNewCustomer() {
		log.info("NewCustomer_01 - Step 01: Open 'New Customer' page");
		homePage.openBankGuruPage(driver, "New Customer");
		newCustomerPage = PageObjects.bankGuru.PageGeneratorManager.getNewCustomerPage(driver);

		log.info("NewCustomer_01 - Step 02: Input to 'Customer Name' fields");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "name", customerName);
		
		log.info("NewCustomer_01 - Step 03: Click to 'Male' radio button");
		newCustomerPage.clickToBankGuruRadioButtonByValue(driver, "m");
		
		log.info("NewCustomer_01 - Step 04: Input to 'dateOfBirth' fields");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "dob", dateOfBirth);
			
		log.info("NewCustomer_01 - Step 05: Input to 'Address' textarea");
		newCustomerPage.inputToBankGuruTextAreaByName(driver, "addr", address);
		
		log.info("NewCustomer_01 - Step 06: Input to 'City' textbox");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "city", city);
		
		log.info("NewCustomer_01 - Step 06: Input to 'City' textbox");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "state", state);
		
		log.info("NewCustomer_01 - Step 07: Input to 'Pin' textbox");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "pinno", pin);
		
		log.info("NewCustomer_01 - Step 08: Input to 'Phone' textbox");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "telephoneno", phone);
		
		log.info("NewCustomer_01 - Step 09: Input to 'Email' textbox");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "emailid", email);
		
		log.info("NewCustomer_01 - Step 10: Input to 'Password' textbox");
		newCustomerPage.inputToBankGuruTextboxByName(driver, "password", password);
		
		log.info("NewCustomer_01 - Step 11: Click to 'Submit' button");
		newCustomerPage.clickToBankGuruButtonByValue(driver, "Submit");

		log.info("NewCustomer_01 - Step 12: Verify 'Customer Registered Successfully!!!' text displayed");
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

		
		// CREATE CUSTOMER (READ-ONLY)
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
		
		// CREATE FIRST ACCOUNT
		editCustomerPage.openBankGuruPage(driver, "New Account");
		newAccountPage = PageObjects.bankGuru.PageGeneratorManager.getNewAccountrPage(driver);
		
		newAccountPage.inputToBankGuruTextboxByName(driver, "cusid", customerID);
		newAccountPage.selectBankGuruDropdownItemByName(driver, "selaccount", accountTypeSaving);
		newAccountPage.inputToBankGuruTextboxByName(driver, "inideposit", "5000");
		newAccountPage.clickToBankGuruButtonByValue(driver, "submit");
		
		// Verify New Account Created success
		verifyEquals(newAccountPage.getBankGuruHeaderText(driver), "Account Generated Successfully!!!");
		verifyEquals(newAccountPage.getBankGuruRowValueByRowName(driver, "Customer ID"), customerID);
		verifyEquals(newAccountPage.getBankGuruRowValueByRowName(driver, "Customer Name"), customerName);
		verifyEquals(newAccountPage.getBankGuruRowValueByRowName(driver, "Email"), editEmail);
		verifyEquals(newAccountPage.getBankGuruRowValueByRowName(driver, "Account Type"), accountTypeSaving);
		verifyEquals(newAccountPage.getBankGuruRowValueByRowName(driver, "Date of Opening"), getBankGuruToday());
		verifyEquals(newAccountPage.getBankGuruRowValueByRowName(driver, "Current Amount"), "5000");

		firstAccountID = newAccountPage.getBankGuruRowValueByRowName(driver,"Account ID");
		
		// CREATE SECOND ACCOUNT
		newAccountPage.openBankGuruPage(driver, "New Account");
		
		newAccountPage.inputToBankGuruTextboxByName(driver, "cusid", customerID);
		newAccountPage.selectBankGuruDropdownItemByName(driver, "selaccount", accountTypeSaving);
		newAccountPage.inputToBankGuruTextboxByName(driver, "inideposit", "1000");
		newAccountPage.clickToBankGuruButtonByValue(driver, "submit");

		// Verify New Account Created success
		verifyEquals(newAccountPage.getBankGuruHeaderText(driver), "Account Generated Successfully!!!");
		verifyEquals(newAccountPage.getBankGuruRowValueByRowName(driver, "Customer ID"), customerID);
		verifyEquals(newAccountPage.getBankGuruRowValueByRowName(driver, "Customer Name"), customerName);
		verifyEquals(newAccountPage.getBankGuruRowValueByRowName(driver, "Email"), editEmail);
		verifyEquals(newAccountPage.getBankGuruRowValueByRowName(driver, "Account Type"), accountTypeSaving);
		verifyEquals(newAccountPage.getBankGuruRowValueByRowName(driver, "Date of Opening"), getBankGuruToday());
		verifyEquals(newAccountPage.getBankGuruRowValueByRowName(driver, "Current Amount"), "1000");

		secondAccountID = newAccountPage.getBankGuruRowValueByRowName(driver,"Account ID");
		

	}

	@Test
	public void Payment_04_EditAccount() {
		newAccountPage.openBankGuruPage(driver, "Edit Account");
		editAccountPage = PageObjects.bankGuru.PageGeneratorManager.getEditAccountPage(driver);
		
		//Edit SECOND ACCOUNT
		editAccountPage.inputToBankGuruTextboxByName(driver, "accountno", secondAccountID);
		editAccountPage.clickToBankGuruButtonByValue(driver, "Submit");
		
		verifyFalse(editAccountPage.isBankGuruTextboxEnabled(driver, "txtcid"));
		verifyFalse(editAccountPage.isBankGuruTextboxEnabled(driver, "txtinitdep"));
		
		editAccountPage.selectBankGuruDropdownItemByName(driver, "a_type", accountTypeCurrent);
		editAccountPage.clickToBankGuruButtonByValue(driver, "Submit");
		
		verifyEquals(editAccountPage.getBankGuruHeaderText(driver), "Account details updated Successfully!!!");
		verifyEquals(editAccountPage.getBankGuruRowValueByRowName(driver, "Account ID"), secondAccountID);
		verifyEquals(editAccountPage.getBankGuruRowValueByRowName(driver, "Customer ID"), customerID);
		verifyEquals(editAccountPage.getBankGuruRowValueByRowName(driver, "Customer Name"), customerName);
		verifyEquals(editAccountPage.getBankGuruRowValueByRowName(driver, "Email"), editEmail);
		verifyEquals(editAccountPage.getBankGuruRowValueByRowName(driver, "Account Type"), accountTypeCurrent);
		verifyEquals(editAccountPage.getBankGuruRowValueByRowName(driver, "Date of Opening"), getBankGuruToday());
		verifyEquals(editAccountPage.getBankGuruRowValueByRowName(driver, "Current Amount"), "1000");


	}

	@Test
	public void Payment_05_DepositToCurrentAccount() {
		editAccountPage.openBankGuruPage(driver, "Deposit");
		depositPage = PageObjects.bankGuru.PageGeneratorManager.getDepositPage(driver);
		
		depositPage.inputToBankGuruTextboxByName(driver, "accountno", secondAccountID);
		depositPage.inputToBankGuruTextboxByName(driver, "ammount", "1000");
		depositPage.inputToBankGuruTextboxByName(driver, "desc", "Deposit");
		depositPage.clickToBankGuruButtonByValue(driver, "Submit");
		
		verifyEquals(depositPage.getBankGuruHeaderText(driver), "Transaction details of Deposit for Account " + secondAccountID);
		verifyEquals(depositPage.getBankGuruRowValueByRowName(driver, "Account No"), secondAccountID);
		verifyEquals(depositPage.getBankGuruRowValueByRowName(driver, "Amount Credited"), "1000");
		verifyEquals(depositPage.getBankGuruRowValueByRowName(driver, "Type of Transaction"), "Deposit");
		verifyEquals(depositPage.getBankGuruRowValueByRowName(driver, "Description"), "Deposit");
		verifyEquals(depositPage.getBankGuruRowValueByRowName(driver, "Current Balance"), "2000");

	}

	@Test
	public void Payment_06_WithdrawFromCurrentAccount() {
		depositPage.openBankGuruPage(driver, "Withdrawal");
		withdrawPage = PageObjects.bankGuru.PageGeneratorManager.getWithdrawalPage(driver);
		
		withdrawPage.inputToBankGuruTextboxByName(driver, "accountno", firstAccountID);
		withdrawPage.inputToBankGuruTextboxByName(driver, "ammount", "2000");
		withdrawPage.inputToBankGuruTextboxByName(driver, "desc", "Withdraw");
		withdrawPage.clickToBankGuruButtonByValue(driver, "Submit");
		
		verifyEquals(withdrawPage.getBankGuruHeaderText(driver), "Transaction details of Withdrawal for Account " + firstAccountID);
		verifyEquals(withdrawPage.getBankGuruRowValueByRowName(driver, "Account No"), firstAccountID);
		verifyEquals(withdrawPage.getBankGuruRowValueByRowName(driver, "Amount Debited"), "2000");
		verifyEquals(withdrawPage.getBankGuruRowValueByRowName(driver, "Type of Transaction"), "Withdrawal");
		verifyEquals(withdrawPage.getBankGuruRowValueByRowName(driver, "Description"), "Withdraw");
		verifyEquals(withdrawPage.getBankGuruRowValueByRowName(driver, "Current Balance"), "3000");

	}

	@Test
	public void Payment_07_TransferToAnotherAccount() {
		withdrawPage.openBankGuruPage(driver, "Fund Transfer");
		fundTranferPage = PageObjects.bankGuru.PageGeneratorManager.getFunTransferPage(driver);
		
		fundTranferPage.inputToBankGuruTextboxByName(driver, "payersaccount", firstAccountID);
		fundTranferPage.inputToBankGuruTextboxByName(driver, "payeeaccount", secondAccountID);
		fundTranferPage.inputToBankGuruTextboxByName(driver, "ammount", "1500");
		fundTranferPage.inputToBankGuruTextboxByName(driver, "desc", "Transfer");
		fundTranferPage.clickToBankGuruButtonByValue(driver, "Submit");
		
		verifyEquals(fundTranferPage.getBankGuruHeaderText(driver), "Fund Transfer Details");
		verifyEquals(fundTranferPage.getBankGuruRowValueByRowName(driver, "From Account Number"), firstAccountID);
		verifyEquals(fundTranferPage.getBankGuruRowValueByRowName(driver, "To Account Number"), secondAccountID);
		verifyEquals(fundTranferPage.getBankGuruRowValueByRowName(driver, "Amount"), "1500");
		verifyEquals(fundTranferPage.getBankGuruRowValueByRowName(driver, "Description"), "Transfer");

	}

	@Test
	public void Payment_08_CheckAccountBalance() {
		fundTranferPage.openBankGuruPage(driver, "Balance Enquiry");
		balanceEnquiryPage = PageObjects.bankGuru.PageGeneratorManager.getBalancePage(driver);
		
		// CHECK FIRST ACCOUNT
		balanceEnquiryPage.inputToBankGuruTextboxByName(driver, "accountno", firstAccountID);
		balanceEnquiryPage.clickToBankGuruButtonByValue(driver, "Submit");
		
		
		verifyEquals(balanceEnquiryPage.getBankGuruHeaderText(driver), "Balance Details for Account " + firstAccountID );
		verifyEquals(balanceEnquiryPage.getBankGuruRowValueByRowName(driver, "Account No"), firstAccountID);
		verifyEquals(balanceEnquiryPage.getBankGuruRowValueByRowName(driver, "Type of Account"), accountTypeSaving);
		verifyEquals(balanceEnquiryPage.getBankGuruRowValueByRowName(driver, "Balance"), "1500");
		
		balanceEnquiryPage.openBankGuruPage(driver, "Balance Enquiry");
		
		// CHECK SECOND ACCOUNT
		balanceEnquiryPage.inputToBankGuruTextboxByName(driver, "accountno", secondAccountID);
		balanceEnquiryPage.clickToBankGuruButtonByValue(driver, "Submit");
		
		verifyEquals(balanceEnquiryPage.getBankGuruHeaderText(driver), "Balance Details for Account " + secondAccountID );
		verifyEquals(balanceEnquiryPage.getBankGuruRowValueByRowName(driver, "Account No"), secondAccountID);
		verifyEquals(balanceEnquiryPage.getBankGuruRowValueByRowName(driver, "Type of Account"), accountTypeCurrent);
		// BUG
		verifyEquals(balanceEnquiryPage.getBankGuruRowValueByRowName(driver, "Balance"), "3500");
	}

	@Test
	public void Payment_09_DeleteAllAccount() {
		// Delete First Account
		balanceEnquiryPage.openBankGuruPage(driver, "Delete Account");
		deleteAccountPage = PageObjects.bankGuru.PageGeneratorManager.getDeleteAccountPage(driver);
		
		deleteAccountPage.inputToBankGuruTextboxByName(driver, "accountno", firstAccountID);
		deleteAccountPage.clickToBankGuruButtonByValue(driver, "Submit");
		
		verifyTrue(deleteAccountPage.isAlertTextDisplayedAndAcceptAlert(driver, "Do you really want to delete this Account?"));
		verifyTrue(deleteAccountPage.isAlertTextDisplayedAndAcceptAlert(driver, "Account Deleted Sucessfully"));

		deleteAccountPage.openBankGuruPage(driver, "Delete Account");
		deleteAccountPage.inputToBankGuruTextboxByName(driver, "accountno", firstAccountID);
		deleteAccountPage.clickToBankGuruButtonByValue(driver, "Submit");
		
		verifyTrue(deleteAccountPage.isAlertTextDisplayedAndAcceptAlert(driver, "Do you really want to delete this Account?"));
		verifyTrue(deleteAccountPage.isAlertTextDisplayedAndAcceptAlert(driver, "Account does not exist"));


		// Delete Second Account
		deleteAccountPage.openBankGuruPage(driver, "Delete Account");
		
		deleteAccountPage.inputToBankGuruTextboxByName(driver, "accountno", secondAccountID);
		deleteAccountPage.clickToBankGuruButtonByValue(driver, "Submit");
		
		verifyTrue(deleteAccountPage.isAlertTextDisplayedAndAcceptAlert(driver, "Do you really want to delete this Account?"));
		verifyTrue(deleteAccountPage.isAlertTextDisplayedAndAcceptAlert(driver, "Account Deleted Sucessfully"));

		deleteAccountPage.openBankGuruPage(driver, "Delete Account");
		deleteAccountPage.inputToBankGuruTextboxByName(driver, "accountno", secondAccountID);
		deleteAccountPage.clickToBankGuruButtonByValue(driver, "Submit");
		
		verifyTrue(deleteAccountPage.isAlertTextDisplayedAndAcceptAlert(driver, "Do you really want to delete this Account?"));
		verifyTrue(deleteAccountPage.isAlertTextDisplayedAndAcceptAlert(driver, "Account does not exist"));

		
	}

	@Test
	public void Payment_10_DeleteCustomer() {
		deleteAccountPage.openBankGuruPage(driver, "Delete Customer");
		deleteCustomerPage = PageObjects.bankGuru.PageGeneratorManager.getDeleteCustomerPage(driver);
		
		deleteCustomerPage.inputToBankGuruTextboxByName(driver, "cusid", customerID);
		deleteCustomerPage.clickToBankGuruButtonByValue(driver, "Submit");
		
		verifyTrue(deleteCustomerPage.isAlertTextDisplayedAndAcceptAlert(driver, "Do you really want to delete this Customer?"));
		verifyTrue(deleteCustomerPage.isAlertTextDisplayedAndAcceptAlert(driver, "Customer deleted Successfully"));
		
		deleteCustomerPage.openBankGuruPage(driver, "Delete Customer");
		
		deleteCustomerPage.inputToBankGuruTextboxByName(driver, "cusid", customerID);
		deleteCustomerPage.clickToBankGuruButtonByValue(driver, "Submit");
		
		verifyTrue(deleteCustomerPage.isAlertTextDisplayedAndAcceptAlert(driver, "Do you really want to delete this Customer?"));
		verifyTrue(deleteCustomerPage.isAlertTextDisplayedAndAcceptAlert(driver, "Customer does not exist!!"));
		

	}

	@AfterTest
	public void afterTest() {
		closeBrowserAndDriver(driver);
	}

}
