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

public class AbstractPage {
	private WebDriver driver;
	private Select select;
	private WebElement element;
	private Actions action;
	private By byLocator;
	List<WebElement> elements;
	private JavascriptExecutor javascriptExecutor;
	private WebDriverWait waitExplicit;
	
	

	public AbstractPage (WebDriver localDriver) {
		driver = localDriver;
	}
	public void openUrl(String urlValue) {
		driver.get(urlValue);
		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT ,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public String getCurrentPageUrl() {
		return driver.getCurrentUrl();
	}
	
	public String getPageSource() {
		return driver.getPageSource();
	}
	
	public void Back() {
		driver.navigate().back();
	}
	
	public void forward() {
		driver.navigate().forward();
	}
	
	public void refresh() {
		driver.navigate().refresh();
	}
	
	public void acceptAler() {
		driver.switchTo().alert().accept();
	}
	
	public void cancelAlert() {
		driver.switchTo().alert().dismiss();	
	}
	
	public String getTextAlert() {
		return driver.switchTo().alert().getText();
	}
	
	public void sendkeyToAlert(String value) {
		driver.switchTo().alert().sendKeys("value");
	}
	
	public WebElement find(String locator) {
		return driver.findElement(By.xpath(locator));		
	}
	
	public List<WebElement>finds(String locator){
		return driver.findElements(By.xpath(locator));
	}
	
	public WebElement findElementByXpath(String locator) {
		return driver.findElement(By.xpath(locator));
	}
	
	public List <WebElement> findElementsByXpath(String locator) {
		return driver.findElements(By.xpath(locator));
	}
	
	public void clickToElement(String locator) {
		findElementByXpath(locator).click();
	}
	
	public void selectItemInDropdown (String locator, String valueItem) {
		element = findElementByXpath(locator);
		select = new Select(element);
		select.selectByVisibleText(valueItem);
	}
	
	public WebElement getSelectItemInDropdown (String locator) {
		element = findElementByXpath(locator);
		select = new Select(element);
		return select.getFirstSelectedOption();
	}
		
	public void selectItemInCustomDropdown(String locator, String valueItem) {
		element = findElementByXpath(locator);
		select = new Select(element);
		select.selectByVisibleText(valueItem);		
	}
	
	public int countElementNumber(String locator) {
		return findElementsByXpath(locator).size();
	}
	
	public void checkTheCheckBox(String locator) {
		element= driver.findElement(By.xpath(locator));
		if (element.isSelected()==false) {
			element.click();
		}
	}
	
	public void unCheckTheCheckBox(String locator) {
		element= driver.findElement(By.xpath(locator));
		if (element.isSelected()==true) {
			element.click();
		}
	}
	
	public void senkeyToElement(String locator , String value) {
		findElementByXpath(locator).sendKeys(value);
	}
	
	public String getAttributeElement(String locator , String attributeName) {
		return findElementByXpath(locator).getAttribute(attributeName);
	}
	
	public String getTextlement(String locator) {
		return findElementByXpath(locator).getText();
	}
	
	public boolean isElementDisplayed(String locator) {
		return findElementByXpath(locator).isDisplayed();
	}
	
	public boolean isElementSelected(String locator) {
		return findElementByXpath(locator).isSelected();
	}
	
	public boolean isElementEnabled(String locator) {
		return findElementByXpath(locator).isEnabled();
	}
	
	public void switchToWindowsbyID (String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String TermID:allWindows) {
			if(!TermID.equals(parentID)) {
				driver.switchTo().window(TermID);
				break;
			}
		}
	}

	public void switchToWindowsbyTitle (String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String TermID:allWindows) {
			driver.switchTo().window(TermID);
			String currentWin= driver.getTitle();
			if(currentWin.equals(title)) {
				break;
			}
		}
	}

	public boolean closeAllWindowsWithoutParent(String parentWindow) {
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
	
	public void swithToFrameOrIframe(String locator) {
		element = driver.findElement(By.xpath(locator));
		driver.switchTo().frame(element);
	}
	
	public void doubleClickElement(String locator) {
		Actions action= new Actions(driver);
		element = findElementByXpath(locator);
		action.doubleClick().perform();
	}

	public void hoverMouseToElement(String locator) {
		Actions action= new Actions(driver);
		WebElement element = findElementByXpath(locator);
		action.moveToElement(element).perform();
	}
	
	public void rightClick(String locator) {
		Actions action= new Actions(driver);
		WebElement element = findElementByXpath(locator);
		action.contextClick(element).perform();
	}
	
	public void dragAndDrop(String locatorSource, String locatorTarget) {
		WebElement elementSource = driver.findElement(By.xpath(locatorSource));
		WebElement elementTarget = driver.findElement(By.xpath(locatorTarget));
		action.dragAndDrop(elementSource, elementTarget).perform();
	}
	
	public void sendKeyboardToElement (WebDriver driver, String locator,Keys key) {
		element = driver.findElement(By.xpath(locator));
		action = new Actions(driver);
		action.sendKeys(element,key).perform();
	}
	
	public void waitToElementPresence(String locator) {
		waitExplicit = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		byLocator = By.xpath(locator);
		waitExplicit.until(ExpectedConditions.presenceOfElementLocated(byLocator));
	}
	
	public void waitToElementVisible(String locator) {
		waitExplicit = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		byLocator = By.xpath(locator);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
	}
	
	public void waitToElementClickable(String locator) {
		waitExplicit = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		byLocator = By.xpath(locator);
		waitExplicit.until(ExpectedConditions.elementToBeClickable(byLocator));
	}
	
	public void waitToElementInvisible(String locator) {
		waitExplicit = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		byLocator = By.xpath(locator);
		waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(byLocator));
	}
	
	public void waitToElementDisplayed(WebDriver driver ,String locator) {
		waitExplicit = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		byLocator = By.xpath(locator);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(byLocator));	
	}
	
	public void waitToAlertPresence(String locator) {
		waitExplicit = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		element = driver.findElement(By.xpath(locator));
		waitExplicit.until(ExpectedConditions.alertIsPresent());
	}
	
	public void scrollToElement(String locator) {
		element= driver.findElement(By.xpath(locator));
		javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void removeElementAttribute(String locator, String attributeRemove) {
		element= driver.findElement(By.xpath(locator));
		javascriptExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", element);
	}
	
	public void highlightElement(String locator) {
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
}
