package Com.bankguru.payment;

import org.testng.annotations.Test;

import Commons.AbstractTest;
import Commons.PageGeneratorManager;
import PageObjects.bankGuru.HomePageObject;
import PageObjects.bankGuru.LoginPageObject;
import PageObjects.bankGuru.NewCustomerPageObject;
import PageObjects.bankGuru.RegisterPageObject;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class Payment_01_PaymentWorkflow extends AbstractTest  {
	private WebDriver driver;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private HomePageObject homePage;
	private NewCustomerPageObject newCustomerPage;
	
	
	
	@Parameters ({"browser", "url"})
	@BeforeTest
	  public void beforeTest(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		
		loginPage = PageObjects.bankGuru.PageGeneratorManager.getLoginPage(driver);
		
		String loginPageUrl = loginPage.getLoginPageUrl();
	
		// pre-condition
		registerPage = loginPage.clickToHereLink();
		
		registerPage.inputToEmailTextbox("");
		
		registerPage.clickToSubmitButton();
		
		String userID = registerPage.getUserIDValue();
		String password = registerPage.getPasswordValue();
		
		loginPage = registerPage.openLoginPage(loginPageUrl);
		
		loginPage.inputToUserIDTextbox(userID);
		loginPage.inputToPasswordTextbox(password);
		homePage  = loginPage.clickToLoginButton();

	  } 
	
  @Test(description = "Create new customer and get customer ID")
  public void Payment_01_CreateNewCustomer() {
	  newCustomerPage = homePage.openNewCustomerPage();
	 
  }
  
  @Test
  public void Payment_02_EditCustomer() { 
	  	   
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
	  closeBrowserAndDriver(driver);
  }
 
}
