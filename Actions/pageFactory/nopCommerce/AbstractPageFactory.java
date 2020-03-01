package pageFactory.nopCommerce;

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

public class AbstractPageFactory {
	private Select select;
	private WebElement element;
	private Actions action;
	private By byLocator;
	List<WebElement> elements;
	private JavascriptExecutor javascriptExecutor;
	private WebDriverWait waitExplicit;
	long shortTimeout = 5;
	long longTimeout = 30;

	public void openUrl(WebDriver driver,String urlValue) {
		driver.get(urlValue);
		driver.manage().timeouts().implicitlyWait(longTimeout, TimeUnit.SECONDS);
		driver.manage().window().maximize();
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
	
	public List <WebElement> findElementsByXpath(WebDriver driver,String locator) {
		return driver.findElements(By.xpath(locator));
	}
	
	public By byxpathLocator(String locator) {
		return By.xpath(locator);
	}
	
	public void clickToElement(WebDriver driver,WebElement element) {
		element.click();
	}
	
	public void selectItemInDropdown (WebDriver driver,WebElement element, String valueItem) {
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
	
	public void senkeyToElement(WebDriver driver,WebElement element , String value) {
		element.clear();
		element.sendKeys(value);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	
	public String getAttributeElement(WebDriver driver,String locator , String attributeName) {
		return findElementByXpath(driver, locator).getAttribute(attributeName);
	}
	
	public String getTextlement(WebDriver driver,WebElement element) {
		return element.getText();
	}
	
	public boolean isElementDisplayed(WebDriver driver,WebElement element) {
		return element.isDisplayed();
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
		waitExplicit = new WebDriverWait(driver, 30);
		byLocator = By.xpath(locator);
		waitExplicit.until(ExpectedConditions.presenceOfElementLocated(byLocator));
	}
	
	public void waitToElementVisible(WebDriver driver,String locator) {
		waitExplicit = new WebDriverWait(driver, 30);
		byLocator = By.xpath(locator);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
	}
	
	public void waitToElementClickable(WebDriver driver,WebElement element) {
		waitExplicit = new WebDriverWait(driver, 30);
		waitExplicit.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitToElementDisplayed(WebDriver driver,WebElement element) {
		waitExplicit = new WebDriverWait(driver, 30);
		waitExplicit.until(ExpectedConditions.visibilityOf(element));	
	}
	
	public void waitToElementInvisible(WebDriver driver,String locator) {
		waitExplicit = new WebDriverWait(driver, 30);
		byLocator = By.xpath(locator);
		waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(byLocator));
	}
	
	public void waitToAlertPresence(WebDriver driver,String locator) {
		waitExplicit = new WebDriverWait(driver, 30);
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
}
