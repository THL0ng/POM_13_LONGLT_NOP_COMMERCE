package Com.nopcommerce_Login;

import org.testng.annotations.Test;

import Com.nopcommerce.common.Common_01_RegisterToSystem;
import Commons.AbstractTest;
import PageObjects.Nop_Commerce.HomePageObject;
import PageObjects.Nop_Commerce.LoginPageObject;
import PageObjects.Nop_Commerce.PageGeneratorManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Login_12_Register_ShareClassState extends AbstractTest  {
	private WebDriver driver;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	
	
	
	@Parameters ({"browser"})
	@BeforeTest
	  public void beforeTest(String browserName) {
		driver = getBrowserDriver(browserName);		
		homePage = PageGeneratorManager.getHomePage(driver);	
		
		
		loginPage = homePage.clickToLoginlink();
		loginPage.inputToEmailTextbox(Common_01_RegisterToSystem.email);
		loginPage.inputToPasswordTextBox(Common_01_RegisterToSystem.password);
		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	  } 
	  
  @Test
  public void TC_01_ViewProduct() { 
	
  }
  
  
  @Test
  public void TC_02_Order() {
	  	 
  }
  
  @Test
  public void TC_03_Payment() {
	  
  }
  
  
  @AfterTest
  public void afterTest() {
  }
  
  

}
