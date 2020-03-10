package Com.nopcommerce_Login;

import org.testng.annotations.Test;

import Commons.AbstractTest;
import Commons.PageGeneratorManager;
import PageObjects.Nop_Commerce.HomePageObject;
import PageObjects.Nop_Commerce.LoginPageObject;
import PageObjects.Nop_Commerce.RegisterPageObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Login_06_RegisterAndLogin_Multi_Browser_Parallel extends AbstractTest  {
	private WebDriver driver;
	private String email, password , registerSuccessMsg;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	
	@Parameters ({"browser" , "url"})
	@BeforeTest
	  public void beforeTest(String browserName , String autUrl) {
		driver = getBrowserDriver(browserName, autUrl);
		
		homePage = PageGeneratorManager.getHomePageObject(driver);	
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
  
  
  @AfterTest
  public void afterTest() {
  }
  
  public int randowmNumber() {
	  Random Rand = new Random();
	  return Rand.nextInt(5000);
  }

}