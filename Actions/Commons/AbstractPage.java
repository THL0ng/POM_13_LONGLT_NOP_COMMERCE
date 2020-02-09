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
import org.openqa.selenium.support.ui.Select;

public class AbstractPage {
	WebDriver driver;
	Select select;
	WebElement element;
	Actions action;
	List<WebElement> elements;
	JavascriptExecutor javascriptExecutor;
	long shortTimeout = 5;
	long longTimeout = 30;
	

	public void openUrl(String urlValue) {
		driver.get(urlValue);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
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
	
	
	
	
	
	
}
