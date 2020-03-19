package PageObjects.Nop_Commerce;

import org.openqa.selenium.WebDriver;

import Commons.AbstractPages;
import Commons.PageGeneratorManager;
import PageUIs.Nop_Commerce.FooterMyAccountPageUI;
import PageUIs.Nop_Commerce.FooterSearchPageUI;

public class FooterSearchPageObject extends AbstractPages {
private WebDriver driver;
	
	public FooterSearchPageObject(WebDriver _driver) {
		driver = _driver;
		
	}

	public FooterNewProductPageObject openFooterNewProductPage() {
		waitToElementDisplayed(driver, FooterSearchPageUI.FOOTER_NEW_PRODUCT_LINK);	
		clickToElement(driver, FooterSearchPageUI.FOOTER_NEW_PRODUCT_LINK);		
		return PageGeneratorManager.getFooterNewProductPage(driver);
	}

}
