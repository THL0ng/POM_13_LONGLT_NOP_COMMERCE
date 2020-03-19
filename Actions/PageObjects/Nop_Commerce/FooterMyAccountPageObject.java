package PageObjects.Nop_Commerce;

import org.openqa.selenium.WebDriver;

import Commons.AbstractPages;
import Commons.PageGeneratorManager;
import PageUIs.Nop_Commerce.FooterMyAccountPageUI;
import PageUIs.Nop_Commerce.HomePageUI;

public class FooterMyAccountPageObject extends AbstractPages {
private WebDriver driver;
	
	public FooterMyAccountPageObject(WebDriver _driver) {
		driver = _driver;
		
	}

	public FooterSearchPageObject openFooterSearchPage() {
		waitToElementDisplayed(driver,FooterMyAccountPageUI.FOOTER_SEARCH_LINK);
		clickToElement(driver, FooterMyAccountPageUI.FOOTER_SEARCH_LINK);		
		return PageGeneratorManager.getFooterSearchPage(driver);
	}

}
