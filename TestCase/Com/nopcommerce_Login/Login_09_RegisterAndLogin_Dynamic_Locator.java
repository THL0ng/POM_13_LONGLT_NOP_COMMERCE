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

public class Login_09_RegisterAndLogin_Dynamic_Locator extends AbstractTest  {
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
  
  
  @Test(description = "Only use incase less page")
  public void TC_03_Dynamic_less() {
	  //Home Page -> My Account (Footer)
	  myAccountPage = (FooterMyAccountPageObject) homePage.openFooterPageByName(driver, "My account");
	  myAccountPage.sleepInSecond(2);
	  
	  // My Account -> Search
	  searchPage = (FooterSearchPageObject) myAccountPage.openFooterPageByName(driver,"Search");
	  searchPage.sleepInSecond(2);

	  
	  // Search -> New products
	  newProductPage = (FooterNewProductPageObject) searchPage.openFooterPageByName(driver, "New products");
	  newProductPage.sleepInSecond(2);

	  
	  // New products -> Home page
	  homePage = newProductPage.openHomePage(driver);
	  homePage.sleepInSecond(2);
	  
	  // Home page -> Search
	  searchPage = (FooterSearchPageObject) homePage.openFooterPageByName(driver,"Search");
	  searchPage.sleepInSecond(2);
	  
	  // Search -> My Account
	  myAccountPage = (FooterMyAccountPageObject) searchPage.openFooterPageByName(driver, "My account");
	  myAccountPage.sleepInSecond(2);
	  
	  // My Account -> New Products
	  newProductPage = (FooterNewProductPageObject) myAccountPage.openFooterPageByName(driver,"New products");
	  newProductPage.sleepInSecond(2);
  
	  // New Product -> Search
	  searchPage = (FooterSearchPageObject) newProductPage.openFooterPageByName(driver,"Search");
	  searchPage.sleepInSecond(2);	 
  }
  
  @Test(description = "Only use incase more page")
  public void TC_04_Dynamic_More() {
	  // New Product -> My Account (Footer)
	  newProductPage.openFooterPagesByName(driver, "My account");
	  myAccountPage = PageGeneratorManager.getFooterMyAccountPage(driver);
	  myAccountPage.sleepInSecond(2);
	  
	  // My Account -> Search
	  myAccountPage.openFooterPagesByName(driver,"Search");
	  searchPage = PageGeneratorManager.getFooterSearchPage(driver);
	  searchPage.sleepInSecond(2);

	  
	  // Search -> New products
	  searchPage.openFooterPagesByName(driver,"New products");
	  newProductPage = PageGeneratorManager.getFooterNewProductPage(driver);
	  newProductPage.sleepInSecond(2);
	  
	  // New products -> Home page
	  homePage = newProductPage.openHomePage(driver);
	  homePage.sleepInSecond(2);
	  
	  // Home page -> Search
	  homePage.openFooterPagesByName(driver,"Search");
	  searchPage = PageGeneratorManager.getFooterSearchPage(driver);
	  searchPage.sleepInSecond(2);
	  
	  // Search -> My Account
	  searchPage.openFooterPagesByName(driver,"My account");
	  myAccountPage = PageGeneratorManager.getFooterMyAccountPage(driver);
	  myAccountPage.sleepInSecond(2);
	  
	  // My Account -> New Products
	  myAccountPage.openFooterPagesByName(driver,"New products");
	  newProductPage = PageGeneratorManager.getFooterNewProductPage(driver);
	  newProductPage.sleepInSecond(2);
  
	  // New Product -> Search
	  newProductPage.openFooterPagesByName(driver,"Search");
	  searchPage = PageGeneratorManager.getFooterSearchPage(driver);
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
