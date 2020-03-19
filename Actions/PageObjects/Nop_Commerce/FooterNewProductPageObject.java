package PageObjects.Nop_Commerce;

import org.openqa.selenium.WebDriver;

import Commons.AbstractPages;
import Commons.PageGeneratorManager;
import PageUIs.Nop_Commerce.FooterMyAccountPageUI;
import PageUIs.Nop_Commerce.FooterNewProductPageUI;

public class FooterNewProductPageObject extends AbstractPages {
private WebDriver driver;
	
	public FooterNewProductPageObject(WebDriver _driver) {
		driver = _driver;
		
	}
	
	public HomePageObject openHomePage() {	
		waitToElementDisplayed(driver,FooterNewProductPageUI.HOME_PAGE_IMAGE);
		clickToElement(driver, FooterNewProductPageUI.HOME_PAGE_IMAGE);		
		return PageGeneratorManager.getHomePage(driver);
		
	}

	

}
