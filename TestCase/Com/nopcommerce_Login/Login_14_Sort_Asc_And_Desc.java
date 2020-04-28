package Com.nopcommerce_Login;

import org.testng.annotations.Test;

import Commons.AbstractTest;
import PageObjects.Nop_Commerce.DesktopsPageObject;
import PageObjects.Nop_Commerce.HomePageObject;
import PageObjects.Nop_Commerce.PageGeneratorManager;
import PageObjects.Nop_Commerce.RegisterPageObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class Login_14_Sort_Asc_And_Desc extends AbstractTest  {
	private WebDriver driver;
	
	
	
	
	@Parameters ({"browser"})
	@BeforeTest
	  public void beforeTest(String browserName) {
		driver = getBrowserDriver(browserName);	
		homePage = PageGeneratorManager.getHomePage(driver);	
		
		
	  } 
	
  @Test
  public void TC_01_Sort_Ascending() {
	  homePage.openHeaderSubMenuPageByName(driver, "Computers", "Desktops");
	  desktopPage = PageGeneratorManager.getDesktopsPage(driver);
	  
	  // A-Z: ASCENDING
	  desktopPage.selectNopCommerceDropdownByName(driver, "products-orderby", "Name: A to Z");
	  desktopPage.sleepInSecond(2);
	  // VERIFY
	  verifyTrue(desktopPage.isNameDataSortedAscending(driver));
	  
	  // Z-A : DESCENDING
	  desktopPage.selectNopCommerceDropdownByName(driver, "products-orderby", "Name: Z to A");
	  desktopPage.sleepInSecond(2);

	  // VERIFY
	  verifyTrue(desktopPage.isNameDataSortedDescending(driver));
	  
  }
  
  @Test
  public void TC_02_Sort_Price() { 
	  desktopPage.openHeaderSubMenuPageByName(driver, "Computers", "Desktops");
	  
	  // Price: Ascending
	  desktopPage.selectNopCommerceDropdownByName(driver, "products-orderby", "Price: Low to High");
	  desktopPage.sleepInSecond(2);
	  
	  // VERIFY
	  verifyTrue(desktopPage.isPriceSortedAscending(driver));
	  
	  // Price: DESCENDING
	  desktopPage.selectNopCommerceDropdownByName(driver, "products-orderby", "Price: High to Low");
	  desktopPage.sleepInSecond(2);
	  
	  // VERIFY
	  verifyTrue(desktopPage.isPriceSortedDescending(driver));
  }
  

  
  @AfterTest
  public void afterTest() {
	  closeBrowserAndDriver(driver);
  }
  
  	private HomePageObject homePage;
	private DesktopsPageObject desktopPage;
 
}
