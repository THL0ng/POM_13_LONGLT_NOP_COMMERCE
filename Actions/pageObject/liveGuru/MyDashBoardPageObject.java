package pageObject.liveGuru;

import org.openqa.selenium.WebDriver;

import Commons.AbstractPages;
import PageUIs.liveGuru.LoginPageUI;
import PageUIs.liveGuru.MyDashBoardUI;

public class MyDashBoardPageObject  extends AbstractPages{
	private WebDriver driver;
	
	public MyDashBoardPageObject (WebDriver driver) {
		this.driver = driver ; 
		
	}
	public boolean isFullnameOrEmailTextDisplayed(String errorMessage) {
		waitToElementDisplayed(driver, String.format(MyDashBoardUI.EMAIL_PASSWORD_TEXT,errorMessage ));
		return isElementDisplayed(driver, String.format(MyDashBoardUI.EMAIL_PASSWORD_TEXT,errorMessage ));
	}
	
}
