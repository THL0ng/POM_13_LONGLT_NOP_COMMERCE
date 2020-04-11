package Com.nopcommerce_Login;

import org.testng.annotations.Test;

import Commons.AbstractTest;
import Commons.PageGeneratorManager;
import PageObjects.Nop_Commerce.HomePageObject;
import PageObjects.Nop_Commerce.LoginPageObject;
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
	  
	  registerPage.clickToRadioButtonByID(driver, "gender-male");	
	  registerPage.inputToTextboxByID(driver, "FirstName", "shen");
	  registerPage.inputToTextboxByID(driver, "LastName", "long");

	  registerPage.selectDropdownByName(driver, "DateOfBirthDay", "8");
	  registerPage.selectDropdownByName(driver, "DateOfBirthMonth", "August");
	  registerPage.selectDropdownByName(driver, "DateOfBirthYear", "2000");

	  registerPage.inputToTextboxByID(driver, "Email", email);
	  registerPage.inputToTextboxByID(driver, "Company", "Auto channel");
	  
	  // CLICK( Select)
	  registerPage.clickToCheckboxByID(driver, "Newsletter", true);
	  
	  // CLICK( Deselect)
	  registerPage.clickToCheckboxByID(driver, "Newsletter", false);
	  
	  registerPage.inputToTextboxByID(driver, "Password", password);
	  registerPage.inputToTextboxByID(driver, "ConfirmPassword", password);

	 
	  registerPage.clickToButtonByValue(driver, "Register");
	  registerSuccessMsg = registerPage.getRegisterSuccessMessage();
	  verifyEquals(registerSuccessMsg, "Your registration completed");
	  registerPage.openHeaderPageByName(driver, "Log out");
	  homePage = PageGeneratorManager.getHomePage(driver);
	  
  }
  
  @Test
  public void TC_02_LoginToSystem() { 
	  homePage.openHeaderPageByName(driver, "Log in");
	  loginPage = PageGeneratorManager.getLoginPage(driver);
	 
	  loginPage.inputToTextboxByID(driver, "Email", email);
	  loginPage.inputToTextboxByID(driver, "Password", password);

	 loginPage.clickToButtonByValue(driver, "Log in");
	 homePage = PageGeneratorManager.getHomePage(driver);
	  verifyTrue(homePage.isMyAccountLinkDisplayed());	  
	 
  }
  

  
  @AfterTest
  public void afterTest() {
	  closeBrowserAndDriver(driver);
  }
 
}
