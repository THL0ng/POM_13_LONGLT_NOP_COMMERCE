package Com.nopcommerce_Login;

import org.testng.annotations.Test;

import Commons.AbstractTest;
import PageObjects.Nop_Commerce.FooterMyAccountPageObject;
import PageObjects.Nop_Commerce.FooterNewProductPageObject;
import PageObjects.Nop_Commerce.FooterSearchPageObject;
import PageObjects.Nop_Commerce.HomePageObject;
import PageObjects.Nop_Commerce.LoginPageObject;
import PageObjects.Nop_Commerce.PageGeneratorManager;
import PageObjects.Nop_Commerce.RegisterPageObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Login_08_RegisterAndLogin_Action_Chain extends AbstractTest  {
	private WebDriver driver;
	private String email, password , registerSuccessMsg;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private FooterMyAccountPageObject myAccountPage;
	private FooterNewProductPageObject newProductPage;
	private FooterSearchPageObject searchPage; 
	
	@Parameters ({"browser"})
	@BeforeTest
	  public void beforeTest(String browserName) {
		driver = getBrowserDriver(browserName);
		
		homePage = PageGeneratorManager.getHomePage(driver);	
		email = "corona" + randowmNumber() + "@hotmail.com";
		password = "coronavirus";
	  } 
	
  @Test
  public void TC_01_RegisterToSystem() {
	  registerPage = homePage.clickToRegisterLink();
	  registerPage = new RegisterPageObject(driver);
	  registerPage.clickToMaleRadio();
	  registerPage.inputToFirstNameTextbox("shen");
	  registerPage.inputToLastNameTextbox("long");
	  registerPage.selectDayDropdown("8");	  	
	  registerPage.selectMonthDropdown("August");	  	
	  registerPage.selectYearDropdown("1988");  
	  registerPage.inputToEmailTextbox(email);  
	  registerPage.inputToCompanyextbox("Auto channel");
	  registerPage.inputToPasswordTextbox(password);
	  registerPage.inputToConfirmPasswordTextbox(password);
	  registerPage.clickToRegisterButton();
	  registerSuccessMsg = registerPage.getRegisterSuccessMessage();
	  Assert.assertEquals(registerSuccessMsg, "Your registration completed");
	  homePage = registerPage.clickToLogoutLink();  
	  
  }
  
  @Test
  public void TC_02_LoginToSystem() { 
	  loginPage = homePage.clickToLoginlink();
	  loginPage.inputToEmailTextbox(email);
	  loginPage.inputToPasswordTextBox(password);
	  homePage = loginPage.clickToLoginButton();
	  Assert.assertTrue(homePage.isMyAccountLinkDisplayed());	  
	 
  }
  
  
  @Test
  public void TC_03_Action_Chain() {
	  //Home Page -> My Account (Footer)
	  myAccountPage = homePage.openFooterMyAccountPage(driver);
	  myAccountPage.sleepInSecond(2);
	  
	  // My Account -> Search
	  searchPage = myAccountPage.openFooterSearchPage(driver);
	  searchPage.sleepInSecond(2);

	  
	  // Search -> New products
	  newProductPage = searchPage.openFooterNewProductPage(driver);
	  newProductPage.sleepInSecond(2);
	  
	  // New products -> Home page
	  homePage = newProductPage.openHomePage(driver);
	  homePage.sleepInSecond(2);
	  
	  // Home page -> Search
	  searchPage = homePage.openFooterSearchPage(driver);
	  searchPage.sleepInSecond(2);
	  
	  // Search -> My Account
	  myAccountPage = searchPage.openFooterMyAccountPage(driver);
	  myAccountPage.sleepInSecond(2);
	  
	  // My Account -> New Products
	  newProductPage = myAccountPage.openFooterNewProductPage(driver);
	  newProductPage.sleepInSecond(2);
  
	  // New Product -> Search
	  searchPage = newProductPage.openFooterSearchPage(driver);
	  searchPage.sleepInSecond(2);

	  
	  

	  
	  
	  	  
	 
  }
  
  
  @AfterTest
  public void afterTest() {
  }
  
  public int randowmNumber() {
	  Random Rand = new Random();
	  return Rand.nextInt(5000);
  }

}
