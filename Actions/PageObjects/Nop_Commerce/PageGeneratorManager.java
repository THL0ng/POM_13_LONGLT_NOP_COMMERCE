package PageObjects.Nop_Commerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageGeneratorManager {
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
	
	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
		
	}
	
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
		
	}
	
	public static LoginPageObject getLoginPage(WebDriver driver ,WebDriverWait wait) {
		return new LoginPageObject(driver, wait);
		
	}
	public static FooterMyAccountPageObject getFooterMyAccountPage(WebDriver driver) {
		return new FooterMyAccountPageObject(driver);
		
	}
	
	public static FooterNewProductPageObject getFooterNewProductPage(WebDriver driver) {
		return new FooterNewProductPageObject(driver);
		
	}
	
	public static FooterSearchPageObject getFooterSearchPage(WebDriver driver) {
		return new FooterSearchPageObject(driver);
		
	}
	
	public static DesktopsPageObject getDesktopsPage(WebDriver driver) {
		return new DesktopsPageObject(driver);
		
	}


	

}
