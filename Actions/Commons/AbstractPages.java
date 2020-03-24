package Commons;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.Nop_Commerce.FooterMyAccountPageObject;
import PageObjects.Nop_Commerce.FooterNewProductPageObject;
import PageObjects.Nop_Commerce.FooterSearchPageObject;
import PageObjects.Nop_Commerce.HomePageObject;
import PageUIs.Nop_Commerce.AbstractPageUI;
import PageUIs.Nop_Commerce.FooterMyAccountPageUI;
import PageUIs.Nop_Commerce.FooterNewProductPageUI;
import PageUIs.Nop_Commerce.FooterSearchPageUI;
import PageUIs.Nop_Commerce.HomePageUI;

public class AbstractPages {
	private Select select;
	private WebElement element;
	private Actions action;
	private By byLocator;
	List<WebElement> elements;
	private JavascriptExecutor javascriptExecutor;
	private WebDriverWait waitExplicit;
	

	public void openUrl(WebDriver driver,String urlValue) {
		driver.get(urlValue);
		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	
	public void sleepInSecond(long timeout){
		try {
			Thread.sleep(timeout * 1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public String getCurrentPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}
	
	public void Back(WebDriver driver) {
		driver.navigate().back();
	}
	
	public void forward(WebDriver driver) {
		driver.navigate().forward();
	}
	
	public void refresh(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	public void acceptAler(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();	
	}
	
	public String getTextAlert(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}
	
	public void sendkeyToAlert(WebDriver driver,String value) {
		driver.switchTo().alert().sendKeys("value");
	}
	
	public WebElement find(WebDriver driver,String locator) {
		return driver.findElement(By.xpath(locator));		
	}
	
	public List<WebElement>finds(WebDriver driver,String locator){
		return driver.findElements(By.xpath(locator));
	}
	
	public WebElement findElementByXpath(WebDriver driver,String locator) {
		return driver.findElement(By.xpath(locator));
	}
	
	public WebElement findElementByXpath(WebDriver driver,String locator,String... values) {
		locator = String.format(locator,(Object[]) values);
		return  driver.findElement(By.xpath(locator));
		
	}
	
	public List <WebElement> findElementsByXpath(WebDriver driver,String locator) {
		return driver.findElements(By.xpath(locator));
	}
	
	public List <WebElement> findElementsByXpath(WebDriver driver,String locator,String... values) {
		locator = String.format(locator,(Object[]) values);
		return driver.findElements(By.xpath(locator));
	}
	
	
	
	public By byxpathLocator(String locator) {
		return By.xpath(locator);
	}
	
	public By byxpathLocator(String locator,String... values) {
		locator = String.format(locator, (Object[]) values);
		return By.xpath(locator);
	}
	
	public void clickToElement(WebDriver driver,String locator) {
		findElementByXpath(driver, locator).click();
	}
	
	public void clickToElement(WebDriver driver,String locator, String...values) {
		findElementByXpath(driver,locator,values).click();
	}
	
	public void selectItemInDropdown (WebDriver driver,String locator, String valueItem) {
		element = findElementByXpath(driver, locator);
		select = new Select(element);
		select.selectByVisibleText(valueItem);
	}
	
	public WebElement getSelectItemInDropdown (WebDriver driver,String locator) {
		element = findElementByXpath(driver, locator);
		select = new Select(element);
		return select.getFirstSelectedOption();
	}
		
	public void selectItemInCustomDropdown(WebDriver driver,String locator, String valueItem) {
		element = findElementByXpath(driver, locator);
		select = new Select(element);
		select.selectByVisibleText(valueItem);		
	}
	
	public int countElementNumber(WebDriver driver,String locator) {
		return findElementsByXpath(driver, locator).size();
	}
	
	public void checkTheCheckBox(WebDriver driver,String locator) {
		element= driver.findElement(By.xpath(locator));
		if (element.isSelected()==false) {
			element.click();
		}
	}
	
	public void unCheckTheCheckBox(WebDriver driver,String locator) {
		element= driver.findElement(By.xpath(locator));
		if (element.isSelected()==true) {
			element.click();
		}
	}
	
	public void senkeyToElement(WebDriver driver,String locator , String value) {
		findElementByXpath(driver, locator).clear();
		findElementByXpath(driver, locator).sendKeys(value);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	
	public String getAttributeElement(WebDriver driver,String locator , String attributeName) {
		return findElementByXpath(driver, locator).getAttribute(attributeName);
	}
	
	public String getTextlement(WebDriver driver,String locator) {
		return findElementByXpath(driver, locator).getText();
	}
	
	public boolean isElementDisplayed(WebDriver driver,String locator) {
		return findElementByXpath(driver, locator).isDisplayed();
	}
	
	public boolean isElementDisplayed(WebDriver driver,String locator,String...values) {
		return findElementByXpath(driver, locator , values).isDisplayed();
	}
	
	public boolean isElementSelected(WebDriver driver,String locator) {
		return findElementByXpath(driver, locator).isSelected();
	}
	
	public boolean isElementEnabled(WebDriver driver,String locator) {
		return findElementByXpath(driver, locator).isEnabled();
	}
	
	public void switchToWindowsbyID (WebDriver driver,String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String TermID:allWindows) {
			if(!TermID.equals(parentID)) {
				driver.switchTo().window(TermID);
				break;
			}
		}
	}

	public void switchToWindowsbyTitle (WebDriver driver,String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String TermID:allWindows) {
			driver.switchTo().window(TermID);
			String currentWin= driver.getTitle();
			if(currentWin.equals(title)) {
				break;
			}
		}
	}

	public boolean closeAllWindowsWithoutParent(WebDriver driver,String parentWindow) {
		Set<String> allWindows=driver.getWindowHandles();
		for(String runWindows:allWindows) {
			if(!runWindows.equals(parentWindow)) {
				driver.switchTo().window(runWindows);
				driver.close();
			}
		}
		driver.switchTo().window(parentWindow);
		if(driver.getWindowHandles().size()==1)
			return true;
		else
			return false;
	}
	
	public void swithToFrameOrIframe(WebDriver driver,String locator) {
		element = driver.findElement(By.xpath(locator));
		driver.switchTo().frame(element);
	}
	
	public void doubleClickElement(WebDriver driver,String locator) {
		Actions action= new Actions(driver);
		element = findElementByXpath(driver, locator);
		action.doubleClick().perform();
	}

	public void hoverMouseToElement(WebDriver driver,String locator) {
		Actions action= new Actions(driver);
		WebElement element = findElementByXpath(driver, locator);
		action.moveToElement(element).perform();
	}
	
	public void rightClick(WebDriver driver,String locator) {
		Actions action= new Actions(driver);
		WebElement element = findElementByXpath(driver, locator);
		action.contextClick(element).perform();
	}
	
	public void dragAndDrop(WebDriver driver,String locatorSource, String locatorTarget) {
		WebElement elementSource = driver.findElement(By.xpath(locatorSource));
		WebElement elementTarget = driver.findElement(By.xpath(locatorTarget));
		action.dragAndDrop(elementSource, elementTarget).perform();
	}
	
	public void sendKeyboardToElement (WebDriver driver, String locator,Keys key) {
		element = driver.findElement(By.xpath(locator));
		action = new Actions(driver);
		action.sendKeys(element,key).perform();
	}
	
	public void waitToElementPresence(WebDriver driver,String locator) {
		waitExplicit = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		byLocator = By.xpath(locator);
		waitExplicit.until(ExpectedConditions.presenceOfElementLocated(byLocator));
	}
	
	public void waitToElementDisplayed(WebDriver driver,String locator) {
		waitExplicit = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		byLocator = By.xpath(locator);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
	}
	
	public void waitToElementVisible(WebDriver driver,String locator) {
		waitExplicit = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		byLocator = By.xpath(locator);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
	}
	
	public void waitToElementVisible(WebDriver driver,String locator,String... values) {
		waitExplicit = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		byLocator = byxpathLocator(locator,values);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(byLocator));	
	}
	
	public void waitToElementClickable(WebDriver driver,String locator) {
		waitExplicit = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		byLocator = byxpathLocator(locator);
		waitExplicit.until(ExpectedConditions.elementToBeClickable(byLocator));
	}
	
	public void waitToElementClickable(WebDriver driver,String locator,String... values) {
		waitExplicit = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		byLocator = byxpathLocator(locator,values);
		waitExplicit.until(ExpectedConditions.elementToBeClickable(byLocator));
	}
	
	
	
	public void waitToElementInvisible(WebDriver driver,String locator) {
		waitExplicit = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		byLocator = By.xpath(locator);
		waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(byLocator));
	}
	
	public void waitToAlertPresence(WebDriver driver,String locator) {
		waitExplicit = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		element = driver.findElement(By.xpath(locator));
		waitExplicit.until(ExpectedConditions.alertIsPresent());
	}
	
	public void scrollToElement(WebDriver driver,String locator) {
		element= driver.findElement(By.xpath(locator));
		javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void removeElementAttribute(WebDriver driver,String locator, String attributeRemove) {
		element= driver.findElement(By.xpath(locator));
		javascriptExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", element);
	}
	
	public void highlightElement(WebDriver driver,String locator) {
		element = driver.findElement(By.xpath(locator));
		String originalStyle = element.getAttribute("style");
		javascriptExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 5px solid red; border-style: dashed;");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		javascriptExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);

	}
	
	public boolean checkAnyImageLoaded(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		javascriptExecutor = (JavascriptExecutor)driver;
		boolean status =(boolean) javascriptExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth!=\"undefined\" &&arguments[0].naturalWidth>0 ", element);
				if (status) {
					return true;
				}else {
					return false;
				}
	}
	
	public boolean verifyTextInInnerText(WebDriver driver, String textExpected) {
		javascriptExecutor = (JavascriptExecutor)driver;
		String textActual = (String)javascriptExecutor.executeScript("return document.documentElement.innerText.match("+ textExpected + ")[0]");
		return textActual.equals(textExpected);
	}
	
	
	// OPEN FOOTER PAGE
	
	public FooterMyAccountPageObject openFooterMyAccountPage(WebDriver driver) {
		waitToElementVisible(driver,AbstractPageUI.FOOTER_MY_ACCOUNT_LINK);
		clickToElement(driver, AbstractPageUI.FOOTER_MY_ACCOUNT_LINK);		
		return PageGeneratorManager.getFooterMyAccountPage(driver);
	}


	public FooterSearchPageObject openFooterSearchPage(WebDriver driver) {
		waitToElementVisible(driver,AbstractPageUI.FOOTER_SEARCH_LINK);
		clickToElement(driver, AbstractPageUI.FOOTER_SEARCH_LINK);		
		return PageGeneratorManager.getFooterSearchPage(driver);
	}
	

	public HomePageObject openHomePage(WebDriver driver) {	
		waitToElementVisible(driver,AbstractPageUI.HOME_PAGE_LINK);
		clickToElement(driver, AbstractPageUI.HOME_PAGE_LINK);		
		return PageGeneratorManager.getHomePage(driver);
		
	}
	
	public FooterNewProductPageObject openFooterNewProductPage(WebDriver driver) {
		waitToElementVisible(driver, AbstractPageUI.FOOTER_NEW_PRODUCT_LINK);	
		clickToElement(driver, AbstractPageUI.FOOTER_NEW_PRODUCT_LINK);		
		return PageGeneratorManager.getFooterNewProductPage(driver);
	}
	
	// TRONG TRƯỜNG HỢP MÀ APPLICATION ÍT PAGE (10-15)
	public AbstractPages openFooterPageByName(WebDriver driver,String pageName) {
		waitToElementVisible(driver, AbstractPageUI.DYNAMIC_FOOTER_LINK,pageName);	
		clickToElement(driver, AbstractPageUI.DYNAMIC_FOOTER_LINK,pageName);		
		switch (pageName) {
		case "Search":		
			return PageGeneratorManager.getFooterSearchPage(driver);
		case "New producets":
			return PageGeneratorManager.getFooterNewProductPage(driver);
		default:
			return PageGeneratorManager.getFooterMyAccountPage(driver);
		}
	}

	// TRONG TRƯỜNG HỢP MÀ APPLICATION NHIỀU PAGE(N)
	public void openFooterPagesByName(WebDriver driver,String pageName) {
		waitToElementVisible(driver, AbstractPageUI.DYNAMIC_FOOTER_LINK,pageName);	
		clickToElement(driver, AbstractPageUI.DYNAMIC_FOOTER_LINK,pageName);		
		
	}
	
}

