package Com.nopcommerce_Login;

import org.testng.annotations.Test;

import Commons.AbstractTest;
import PageObjects.Nop_Commerce.HomePageObject;
import PageObjects.Nop_Commerce.LoginPageObject;
import PageObjects.Nop_Commerce.PageGeneratorManager;
import PageObjects.Nop_Commerce.RegisterPageObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class Login_13_RegisterAndLogin_Dynamic_Element_Component extends AbstractTest  {
	private WebDriver driver;
	private String email, password , registerSuccessMsg;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	
	
	
	@Parameters ({"browser"})
	@BeforeTest
	  public void beforeTest(String browserName) {
		driver = getBrowserDriver(browserName);
		
		homePage = PageGeneratorManager.getHomePage(driver);	
		email = "shenlong" + randowmNumber() + "@hotmail.com";
		password = "quenpassroi";
	  } 
	
  @Test
  public void TC_01_RegisterToSystem() {
	  homePage.openHeaderPageByName(driver, "Register");
	  registerPage = PageGeneratorManager.getRegisterPage(driver);
	  
	  //printBrowserConsoleLogs(driver);
	  
	  registerPage.clickToNopCommerceRadioButtonByID(driver, "gender-male");	
	  registerPage.inputToNopCommerceTextboxByID(driver, "FirstName", "shen");
	  registerPage.inputToNopCommerceTextboxByID(driver, "LastName", "long");

	  registerPage.selectNopCommerceDropdownByName(driver, "DateOfBirthDay", "8");
	  registerPage.selectNopCommerceDropdownByName(driver, "DateOfBirthMonth", "August");
	  registerPage.selectNopCommerceDropdownByName(driver, "DateOfBirthYear", "2000");

	  registerPage.inputToNopCommerceTextboxByID(driver, "Email", email);
	  registerPage.inputToNopCommerceTextboxByID(driver, "Company", "Auto channel");
	  
	  // CLICK( Select)
	  registerPage.clickToNopCommerceCheckboxByID(driver, "Newsletter", true);
	  
	  // CLICK( Deselect)
	  registerPage.clickToNopCommerceCheckboxByID(driver, "Newsletter", false);
	  
	  registerPage.inputToNopCommerceTextboxByID(driver, "Password", password);
	  registerPage.inputToNopCommerceTextboxByID(driver, "ConfirmPassword", password);

	 
	  registerPage.clickToNopCommerceButtonByValue(driver, "Register");
	  
	  //printBrowserConsoleLogs(driver);

	  registerSuccessMsg = registerPage.getRegisterSuccessMessage();
	  verifyEquals(registerSuccessMsg, "Your registration completed");
	  registerPage.openHeaderPageByName(driver, "Log out");
	  homePage = PageGeneratorManager.getHomePage(driver);
	  
  }
  
  @Test
  public void TC_02_LoginToSystem() { 
	  homePage.openHeaderPageByName(driver, "Log in");
	  loginPage = PageGeneratorManager.getLoginPage(driver);
	  
	  //printBrowserConsoleLogs(driver);
 
	  loginPage.inputToNopCommerceTextboxByID(driver, "Email", email);
	  loginPage.inputToNopCommerceTextboxByID(driver, "Password", password);

	 loginPage.clickToNopCommerceButtonByValue(driver, "Log in");
	 
	  //printBrowserConsoleLogs(driver);

	  homePage = PageGeneratorManager.getHomePage(driver);
	  verifyTrue(homePage.isMyAccountLinkDisplayed());	  
	 
  }
  

  
  @AfterTest
  public void afterTest() {
	  closeBrowserAndDriver(driver);
  }
 
}
