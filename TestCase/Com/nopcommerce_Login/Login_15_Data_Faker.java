package Com.nopcommerce_Login;

import org.testng.annotations.Test;

import Commons.AbstractTest;
import Commons.DataHelper;
import PageObjects.Nop_Commerce.HomePageObject;
import PageObjects.Nop_Commerce.LoginPageObject;
import PageObjects.Nop_Commerce.PageGeneratorManager;
import PageObjects.Nop_Commerce.RegisterPageObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class Login_15_Data_Faker extends AbstractTest  {
	private WebDriver driver;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private String firstName,lastName,email,companyName,password;
	private DataHelper data;
	
	
	@Parameters ({"browser"})
	@BeforeTest
	  public void beforeTest(String browserName) {
		driver = getBrowserDriver(browserName);
		
		homePage = PageGeneratorManager.getHomePage(driver);			
		data = DataHelper.getData();
		
		firstName = data.getFirstName();
		lastName = data.getLastName();
		email = data.getEmail();
		companyName = data.getCompany();
		password = data.getPassword();
	  } 
	
  @Test
  public void TC_01_RegisterToSystem() {
	  homePage.openHeaderPageByName(driver, "Register");
	  registerPage = PageGeneratorManager.getRegisterPage(driver);
	  
	  
	  registerPage.clickToNopCommerceRadioButtonByID(driver, "gender-male");	
	  registerPage.inputToNopCommerceTextboxByID(driver, "FirstName", firstName);
	  registerPage.inputToNopCommerceTextboxByID(driver, "LastName", lastName);

	  registerPage.selectNopCommerceDropdownByName(driver, "DateOfBirthDay", "8");
	  registerPage.selectNopCommerceDropdownByName(driver, "DateOfBirthMonth", "August");
	  registerPage.selectNopCommerceDropdownByName(driver, "DateOfBirthYear", "2000");

	  registerPage.inputToNopCommerceTextboxByID(driver, "Email", email);
	  registerPage.inputToNopCommerceTextboxByID(driver, "Company", companyName);
	  
	  // CLICK( Select)
	  registerPage.clickToNopCommerceCheckboxByID(driver, "Newsletter", true);
	  
	  // CLICK( Deselect)
	  registerPage.clickToNopCommerceCheckboxByID(driver, "Newsletter", false);
	  
	  registerPage.inputToNopCommerceTextboxByID(driver, "Password", password);
	  registerPage.inputToNopCommerceTextboxByID(driver, "ConfirmPassword", password);

	 
	  registerPage.clickToNopCommerceButtonByValue(driver, "Register");
	  

	  
	  verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
	 
	  registerPage.openHeaderPageByName(driver, "Log out");
	  homePage = PageGeneratorManager.getHomePage(driver);
	  
  }
  
  @Test
  public void TC_02_LoginToSystem() { 
	  homePage.openHeaderPageByName(driver, "Log in");
	  loginPage = PageGeneratorManager.getLoginPage(driver);
	  
 
	  loginPage.inputToNopCommerceTextboxByID(driver, "Email", email);
	  loginPage.inputToNopCommerceTextboxByID(driver, "Password", password);

	 loginPage.clickToNopCommerceButtonByValue(driver, "Log in");
	 

	  homePage = PageGeneratorManager.getHomePage(driver);
	  verifyTrue(homePage.isMyAccountLinkDisplayed());	  
	 
  }
  

  
  @AfterTest
  public void afterTest() {
	  closeBrowserAndDriver(driver);
  }
 
}
