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

import java.util.Date;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Login_10_RegisterAndLogin_Undisplayed extends AbstractTest  {
	private WebDriver driver;
	private WebElement element;
	private Date date;
	private String email, password , registerSuccessMsg;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private FooterMyAccountPageObject myAccountPage;
	private FooterNewProductPageObject newProductPage;
	private FooterSearchPageObject searchPage; 
	
	
	@Parameters ({"browser"})
	@BeforeTest
	  public void beforeTest(String browserName ) {
		driver = getBrowserDriver(browserName);
		
		homePage = PageGeneratorManager.getHomePage(driver);	
		email = "corona" + randowmNumber() + "@hotmail.com";
		password = "coronavirus";
	  } 
	
  @Test(description = "Check element displayed")
  public void TC_01_CheckDisplayed() {
	  registerPage = homePage.clickToRegisterLink();
	  
	  // Firstname textbox displayed
	  Assert.assertTrue(registerPage.isFirstnameTextboxDisplayed());

  }
  
  @Test
  public void TC_02_CheckUndisplayed_In_DOM() { 
	  
	 
	  // Request verification token undisplayed ( Có trong DOM)
	  registerPage.isRequestVerifyTokenTextboxUndisplayed();
	  Assert.assertTrue(registerPage.isRequestVerifyTokenTextboxUndisplayed());
	  Assert.assertFalse(registerPage.isRequestVerifyTokenTextboxdisplayed());

	 
  }
  
  @Test
  public void TC_03_CheckUndisplayed_Not_In_DOM() {
	 
	  // Register button undisplayed ( Ko có trong DOM)
	  Assert.assertTrue(registerPage.isRegisterButtonUndisplayed());
  }
 
  
  @AfterTest
  public void afterTest() {
  }
  
  public int randowmNumber() {
	  Random Rand = new Random();
	  return Rand.nextInt(5000);
  }

}
