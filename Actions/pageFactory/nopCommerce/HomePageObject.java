package pageFactory.nopCommerce;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


import PageUIs.Nop_Commerce.HomePageUI;

public class HomePageObject extends AbstractPageFactory {
	private WebDriver driver;
	
	// KHỞI TẠO ELEMENT
	
	public HomePageObject(WebDriver driver) {
		// GÁN DRIVER
		this.driver = driver;
		// KHỞI TẠO ELEMENT VÀ LƯU VÀO TRONG CACHE
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//div[@class ='header-links']//a[text()='Register']")
	private WebElement registerLink;
	
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//div[@class ='header-links']//a[text()='Log in']")
	private WebElement loginLink;
	
	@FindBy(how = How.XPATH, using = "//div[@class='header-links']//a[text()='My account']")
	private WebElement myAccountLink;
	
	public RegisterPageObject clickToRegisterLink() {
		waitToElementClickable(driver, registerLink);
		clickToElement(driver, registerLink);		
		return new RegisterPageObject(driver);
	}

	public LoginPageObject clickToLoginlink() {
		waitToElementClickable(driver, loginLink);
		clickToElement(driver, loginLink);		
		return new LoginPageObject(driver);
	}

	public boolean isMyAccountLinkDisplayed() {
		waitToElementDisplayed(driver,myAccountLink);
		isElementDisplayed(driver,myAccountLink);
		return isElementDisplayed(driver,myAccountLink);
	}

}
