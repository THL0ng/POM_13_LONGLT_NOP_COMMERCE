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

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;


public class Login_11_RegisterAndLogin_Assert_Verify_Report extends AbstractTest  {
	//private WebDriver driver;	
	//private HomePageObject homePage;
	
	
	@Parameters ({"browser"})
	@BeforeTest
	  public void beforeTest(String browserName ) {
		//driver = getBrowserDriver(browserName);
		//homePage = PageGeneratorManager.getHomePage(driver);	
		
	  } 
	
  @Test
  public void TC_01_Assert() {
	  System.out.println("TC_01 - Step 01: Open New Customer Page");
	  //newCustomerPage = homePage.openNewCustomerPage(driver);
	  
	  log.info("TC_01 - Step 02: Verify New Customer page displayed ");
	  Assert.assertTrue(true);
	  
	  log.info("TC_01 - Step 03: Verify New Customer form not displayed ");
	  Assert.assertTrue(false);
	  
	  log.info("TC_01 - Step 04: Verify Home Page not displayed ");
	  Assert.assertTrue(false);
	 
  }
  
  @Test
  public void TC_02_Verify() { 
	  log.info("TC_02 - Step 01: Open New Customer Page");
	  //newCustomerPage = homePage.openNewCustomerPage(driver);
	  
	  log.info("TC_02 - Step 02: Verify New Customer page displayed ");
	  verifyTrue(true);
	  
	  log.info("TC_02 - Step 03: Verify New Customer form not displayed ");
	  verifyTrue(false);
	  
	  log.info("TC_02 - Step 04: Verify Home Page not displayed ");
	  verifyTrue(true);
	 
  }
  
  @AfterTest
  public void afterTest() {
  }
  
  
}
