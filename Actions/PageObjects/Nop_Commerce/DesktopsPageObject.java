package PageObjects.Nop_Commerce;

import org.openqa.selenium.WebDriver;

import Commons.AbstractPages;
import PageUIs.Nop_Commerce.FooterMyAccountPageUI;
import PageUIs.Nop_Commerce.FooterSearchPageUI;

public class DesktopsPageObject extends AbstractPages {
	WebDriver driver;
	
	public DesktopsPageObject(WebDriver _driver) {
		driver = _driver;
		
	}

}
