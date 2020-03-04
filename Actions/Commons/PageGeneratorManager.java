package Commons;

import org.openqa.selenium.WebDriver;

import PageObjects.Nop_Commerce.HomePageObject;
import PageObjects.Nop_Commerce.LoginPageObject;
import PageObjects.Nop_Commerce.RegisterPageObject;

public class PageGeneratorManager {
	// CẤP PHÁT VIỆC KHỞI TAO6 ĐỐI TƯỢNG CHO HOME PAGE
	public static HomePageObject getHomePageObject(WebDriver driver) {
		return new HomePageObject(driver);
	}
	
	// CẤP PHÁT VIỆC KHỞI TAO6 ĐỐI TƯỢNG CHO REGISTER PAGE
	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
		
	}
	
	// CẤP PHÁT VIỆC KHỞI TAO6 ĐỐI TƯỢNG CHO LOGINR PAGE
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
		
	}

}
