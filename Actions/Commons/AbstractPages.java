package Commons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.grid.web.Values;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.Nop_Commerce.FooterMyAccountPageObject;
import PageObjects.Nop_Commerce.FooterNewProductPageObject;
import PageObjects.Nop_Commerce.FooterSearchPageObject;
import PageObjects.Nop_Commerce.HomePageObject;
import PageObjects.Nop_Commerce.PageGeneratorManager;
import PageUIs.Nop_Commerce.AbstractNopCommercePageUI;
import PageUIs.bankGuru.AbstractBankPageUI;


public class AbstractPages {
	private Select select;
	private WebElement element;
	private Actions action;
	private By byLocator;
	List<WebElement> elements;
	private JavascriptExecutor javascriptExecutor;
	private WebDriverWait waitExplicit;
	private Date date;
	private JavascriptExecutor js;
	

	public void openUrl(WebDriver driver,String urlValue) {
		driver.get(urlValue);

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
		element = findElementByXpath(driver,locator);
		if(driver.toString().contains("internet explorer")) {
			clickToElementByJS(driver, locator);
			sleepInSecond(3);
		} else {
			element.click();
		}
	}
	
	public void clickToElement(WebDriver driver,String locator, String...values) {
		element = findElementByXpath(driver,locator,values);
		if(driver.toString().contains("internet explorer")) {
			clickToElementByJS(driver, locator,values);
			sleepInSecond(3);
		} else {
			element.click();
		}
	}
	
	public void selectItemInDropdown (WebDriver driver,String locator, String valueItem) {
		element = findElementByXpath(driver, locator);
		select = new Select(element);
		select.selectByVisibleText(valueItem);
	}
	
	public void selectItemInDropdown (WebDriver driver,String locator, String valueItem,String...values) {
		element = findElementByXpath(driver, locator,values);
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
	
	public void sendkeyToElement(WebDriver driver,String locator , String value) {
		findElementByXpath(driver, locator).clear();
		findElementByXpath(driver, locator).sendKeys(value);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	
	
	public void sendkeyToElement(WebDriver driver,String locator , String valueToSenkey, String... values) {
		findElementByXpath(driver, locator, values).clear();
		findElementByXpath(driver, locator, values).sendKeys(valueToSenkey);
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
	
	public String getTextlement(WebDriver driver,String locator,String... values) {
		return findElementByXpath(driver, locator, values).getText();
	}
	
	public boolean isElementDisplayed(WebDriver driver,String locator) {
		overrideGlobalTimeout(driver, GlobalConstants.SHORT_TIMEOUT);
		try {
			element = findElementByXpath(driver, locator);
			overrideGlobalTimeout(driver, GlobalConstants.LONG_TIMEOUT);
			return element.isDisplayed();
		} catch (Exception ex) {
			overrideGlobalTimeout(driver, GlobalConstants.LONG_TIMEOUT);
			return false;
		}
		
	}
	
	public boolean isElementDisplayed(WebDriver driver,String locator,String...values) {
		try {
			element = findElementByXpath(driver, locator, values);
			return element.isDisplayed();
		} catch (Exception ex) {
			return false;
		}
	}
	
	public boolean isElementEnabled(WebDriver driver,String locator) {
		try {
			element = findElementByXpath(driver, locator);
			return element.isEnabled();
		} catch (Exception ex) {
			return false;
		}
	}
	
	public boolean isElementEnabled(WebDriver driver,String locator,String...values) {
		try {
			element = findElementByXpath(driver, locator, values);
			return element.isEnabled();
		} catch (Exception ex) {
			return false;
		}
	}
	
	public boolean isElementSelected(WebDriver driver,String locator,String...values) {
		try {
			element = findElementByXpath(driver, locator, values);
			return element.isSelected();
		} catch (Exception ex) {
			return false;
		}
	}
	
	public boolean isElementSelected(WebDriver driver,String locator) {
		return findElementByXpath(driver, locator).isSelected();
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
	
	public void hoverMouseToElement(WebDriver driver,String locator,String... values) {
		Actions action= new Actions(driver);
		element = findElementByXpath(driver, locator,values);
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
	
	public void waitAlertPresence(WebDriver driver) {
		waitExplicit = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		waitExplicit.until(ExpectedConditions.alertIsPresent());	
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
	
	
	public void overrideGlobalTimeout(WebDriver driver , long timeOut) {
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
	
	}
	
	
	public void waitToElementInvisible(WebDriver driver, String locator) {
		date = new Date();
		By byLocator = By.xpath(locator);
		waitExplicit = new WebDriverWait(driver, GlobalConstants.SHORT_TIMEOUT);
		overrideGlobalTimeout(driver,GlobalConstants.SHORT_TIMEOUT);
		try {
			System.out.println("Start time for wait invisible = " + date.toString());
			waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(byLocator));		
		} catch(TimeoutException ex) {
			ex.printStackTrace();
			
		}
		
		System.out.println("End time for wait invisible = " + new Date().toString());
		overrideGlobalTimeout(driver,GlobalConstants.LONG_TIMEOUT);
	}
	
	
	public boolean isElementUndisplayed(WebDriver driver,String locator) {
		date = new Date();
		System.out.println("Start time = " + date.toString());
		overrideGlobalTimeout(driver,GlobalConstants.SHORT_TIMEOUT);
		List<WebElement> elements = driver.findElements(By.xpath(locator));
		
		if (elements.size() == 0) {
			System.out.println("Element not in DOM");
			System.out.println("End time = " + new Date().toString());
			overrideGlobalTimeout(driver,GlobalConstants.LONG_TIMEOUT);
			return true;
		} else if(elements.size() > 0 && !elements.get(0).isDisplayed()) {
			System.out.println("Element in DOM but not visible/displayed");
			System.out.println("End time = " + new Date().toString());
			overrideGlobalTimeout(driver,GlobalConstants.LONG_TIMEOUT);
			return true;
		} else {
			System.out.println("Element in DOM and visible");
			overrideGlobalTimeout(driver,GlobalConstants.LONG_TIMEOUT);
			return false;
		}

	}
	
	
	public boolean isElementUndisplayed(WebDriver driver,String locator,String...value) {
		date = new Date();
		System.out.println("Start time = " + date.toString());
		overrideGlobalTimeout(driver,GlobalConstants.SHORT_TIMEOUT);
		
		locator = String.format(locator, (Object[]) value);
		List<WebElement> elements = driver.findElements(By.xpath(locator));
		
		if(elements.size()== 0) {
			System.out.println("Element not in DOM");
			System.out.println("End time = " + new Date().toString());
			overrideGlobalTimeout(driver,GlobalConstants.LONG_TIMEOUT);
			return true;
			
		} else if(elements.size() > 0 && !elements.get(0).isDisplayed()) {
			System.out.println("Element in DOM but not visible/displayed");
			System.out.println("End time = " + new Date().toString());
			overrideGlobalTimeout(driver,GlobalConstants.LONG_TIMEOUT);
			return true;
		} else {
			System.out.println("Element in DOM and visible");
			overrideGlobalTimeout(driver,GlobalConstants.LONG_TIMEOUT);
			return false;
		}
	}
	
	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		js = (JavascriptExecutor) driver;
		element = findElementByXpath(driver,locator);
		js.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", element);
	}
	
	public void clickToElementByJS(WebDriver driver, String locator) {
		js = (JavascriptExecutor) driver;
		element = findElementByXpath(driver,locator);
		js.executeScript("arguments[0].click();", element);
	}
	
	public void clickToElementByJS(WebDriver driver, String locator,String...values) {
		js = (JavascriptExecutor) driver;
		element = findElementByXpath(driver,locator,values);
		js.executeScript("arguments[0].click();", element);
	}
	
	
	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove, String...values) {
		js = (JavascriptExecutor) driver;
		element = findElementByXpath(driver,locator,values);
		js.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", element);
		sleepInSecond(1);
	}
	

	// OPEN FOOTER PAGE
	
	public FooterMyAccountPageObject openFooterMyAccountPage(WebDriver driver) {
		waitToElementVisible(driver,AbstractNopCommercePageUI.FOOTER_MY_ACCOUNT_LINK);
		clickToElement(driver, AbstractNopCommercePageUI.FOOTER_MY_ACCOUNT_LINK);		
		return PageGeneratorManager.getFooterMyAccountPage(driver);
	}


	public FooterSearchPageObject openFooterSearchPage(WebDriver driver) {
		waitToElementVisible(driver,AbstractNopCommercePageUI.FOOTER_SEARCH_LINK);
		clickToElement(driver, AbstractNopCommercePageUI.FOOTER_SEARCH_LINK);		
		return PageGeneratorManager.getFooterSearchPage(driver);
	}
	

	public HomePageObject openHomePage(WebDriver driver) {	
		waitToElementVisible(driver,AbstractNopCommercePageUI.HOME_PAGE_LINK);
		clickToElement(driver, AbstractNopCommercePageUI.HOME_PAGE_LINK);		
		return PageGeneratorManager.getHomePage(driver);
		
	}
	
	public FooterNewProductPageObject openFooterNewProductPage(WebDriver driver) {
		waitToElementVisible(driver, AbstractNopCommercePageUI.FOOTER_NEW_PRODUCT_LINK);	
		clickToElement(driver, AbstractNopCommercePageUI.FOOTER_NEW_PRODUCT_LINK);		
		return PageGeneratorManager.getFooterNewProductPage(driver);
	}
	
	// TRONG TRƯỜNG HỢP MÀ APPLICATION ÍT PAGE (10-15)
	public AbstractPages openFooterPageByName(WebDriver driver,String pageName) {
		waitToElementVisible(driver, AbstractNopCommercePageUI.DYNAMIC_FOOTER_LINK,pageName);	
		clickToElement(driver, AbstractNopCommercePageUI.DYNAMIC_FOOTER_LINK,pageName);		
		switch (pageName) {
		case "Search":		
			return PageGeneratorManager.getFooterSearchPage(driver);
		case "New products":
			return PageGeneratorManager.getFooterNewProductPage(driver);
		default:
			return PageGeneratorManager.getFooterMyAccountPage(driver);
		}
	}

	// TRONG TRƯỜNG HỢP MÀ APPLICATION NHIỀU PAGE(N)
	public void openFooterPagesByName(WebDriver driver,String pageName) {
		waitToElementVisible(driver, AbstractNopCommercePageUI.DYNAMIC_FOOTER_LINK,pageName);	
		clickToElement(driver, AbstractNopCommercePageUI.DYNAMIC_FOOTER_LINK,pageName);		
		
	}
	
	public void openHeaderPageByName(WebDriver driver,String pageName) {
		waitToElementVisible(driver, AbstractNopCommercePageUI.DYNAMIC_HEADER_LINK,pageName);	
		clickToElement(driver, AbstractNopCommercePageUI.DYNAMIC_HEADER_LINK,pageName);		
		
	}
	
	public void openHeaderMenuPageByName(WebDriver driver,String pageName) {
		waitToElementVisible(driver, AbstractNopCommercePageUI.DYNAMIC_HEADER_MENU_LINK,pageName);	
		clickToElement(driver, AbstractNopCommercePageUI.DYNAMIC_HEADER_MENU_LINK,pageName);		
		
	}
	
	public void openHeaderSubMenuPageByName(WebDriver driver,String pageMenuName, String subMenuName) {
		waitToElementVisible(driver, AbstractNopCommercePageUI.DYNAMIC_HEADER_MENU_LINK,pageMenuName);	
		hoverMouseToElement(driver, AbstractNopCommercePageUI.DYNAMIC_HEADER_MENU_LINK,pageMenuName);
		waitToElementVisible(driver, AbstractNopCommercePageUI.DYNAMIC_HEADER_MENU_LINK,subMenuName);	
		clickToElement(driver, AbstractNopCommercePageUI.DYNAMIC_HEADER_MENU_LINK,subMenuName);		
		
	}
	
	public void inputToNopCommerceTextboxByID(WebDriver driver , String textboxID, String value) {
		waitToElementVisible(driver, AbstractNopCommercePageUI.DYNAMIC_TEXTBOX,textboxID);	
		sendkeyToElement(driver, AbstractNopCommercePageUI.DYNAMIC_TEXTBOX, value, textboxID);
		
	}
	
	public void clickToNopCommerceRadioButtonByID(WebDriver driver , String radioButtonID) {
		waitToElementVisible(driver, AbstractNopCommercePageUI.DYNAMIC_RADIO_BUTTON,radioButtonID);	
		clickToElement(driver, AbstractNopCommercePageUI.DYNAMIC_RADIO_BUTTON,radioButtonID);		

	}
	
	// status = true (click = check)/false (uncheck)
	public void clickToNopCommerceCheckboxByID(WebDriver driver , String checkboxID, boolean status) {
		waitToElementVisible(driver, AbstractNopCommercePageUI.DYNAMIC_CHECKBOX,checkboxID);
		
		//chọn rồi = true/ chưa chọn = false
		boolean checkboxStatus = isElementSelected(driver, AbstractNopCommercePageUI.DYNAMIC_CHECKBOX,checkboxID);
		
		if(checkboxStatus == status) {
			clickToElement(driver, AbstractNopCommercePageUI.DYNAMIC_CHECKBOX,checkboxID);		

		}
	}
	
	public void selectNopCommerceDropdownByName (WebDriver driver, String dropdownName, String value){
		waitToElementVisible(driver, AbstractNopCommercePageUI.DYNAMIC_DROPDOWN,dropdownName);	
		selectItemInDropdown(driver, AbstractNopCommercePageUI.DYNAMIC_DROPDOWN, value, dropdownName);

	}
	
	public void clickToNopCommerceButtonByValue(WebDriver driver , String buttonValue) {
		waitToElementVisible(driver, AbstractNopCommercePageUI.DYNAMIC_BUTTON,buttonValue);	
		clickToElement(driver, AbstractNopCommercePageUI.DYNAMIC_BUTTON,buttonValue);		

	}
	
	public boolean isNameDataSortedAscending(WebDriver driver) {
		// KHAI BÁO 1 ARRAY LIST
		ArrayList<String> arrayList= new ArrayList<String>();
		
		// TÌM TẤT CẢ ELEMENT MATCHING VS ĐIỀU KIỆN (NAME/PRICE/...)
		List<WebElement>elementList = findElementsByXpath(driver, AbstractNopCommercePageUI.PRODUCT_TITLE);
		// LẤY TEXT CỦA TỪNG ELEMENT ADD VÀO ARRAY LIST
		for(WebElement element:elementList) {
			arrayList.add(element.getText());
		}
		
		System.out.println("-----DỮ LIỆU TRÊN UI-----");
		for(String name: arrayList) {
			System.out.println(name);
		}
		
		// COPY QUA 1 ARRAY LIST MỚI ĐỂ SORT TRONG CODE
		ArrayList<String>sortedList = new ArrayList<>();
		for(String child:arrayList) {
			sortedList.add(child);
		}
		
		// THỰC HIỆN SORT ASC
		Collections.sort(arrayList);
		
		System.out.println("----DỮ LIỆU ĐÃ SORT ASC TRONG CODE-----");
		for(String name:arrayList) {
			System.out.println(name);
		}
		
		// VERIFY 2 ARRAY BẰNG NHAU - NẾU DỮ LIỆU SORT TRÊN UI KO CHÍNH XÁC THÌ KẾT QUẢ TRẢ VỀ SAI
		return sortedList.equals(arrayList);
	}
	
	
	public boolean isNameDataSortedDescending(WebDriver driver) {
		// KHAI BÁO 1 ARRAY LIST
		ArrayList<String> arrayList= new ArrayList<String>();
		
		// TÌM TẤT CẢ ELEMENT MATCHING VS ĐIỀU KIỆN (NAME/PRICE/...)
		List<WebElement>elementList = findElementsByXpath(driver, AbstractNopCommercePageUI.PRODUCT_TITLE);

		
		// LẤY TEXT CỦA TỪNG ELEMENT ADD VÀO ARRAY LIST
		for(WebElement element:elementList) {
			arrayList.add(element.getText());
		}
		
		System.out.println("-----DỮ LIỆU TRÊN UI-----");
		for(String name: arrayList) {
			 System.out.println(name);
		}
		
		// COPY QUA 1 ARRAY LIST MỚI ĐỂ SORT TRONG CODE
		ArrayList<String>sortedList = new ArrayList<>();
		for(String child:arrayList) {
			sortedList.add(child);
		}
		
		// THỰC HIỆN SORT ASC
		Collections.sort(arrayList);
		
		System.out.println("----DỮ LIỆU ĐÃ SORT ASC TRONG CODE-----");
		for(String name:arrayList) {
			System.out.println(name);
		}
		
		// REVERSE DATA ĐỂ SORT DESC ( DÙNG 1 TRONG 2 CÁCH BÊN DƯỚI )
		Collections.reverse(arrayList);
		// COLLECTIONS.SORT(ARRAYLIST , COLLECTIONS.REVERSEPRDER());
		System.out.println("-----DỮ LIỆU ĐÃ SORT DESC TRONG CODE-----");
		for(String name:arrayList) {
			System.out.println(name);
		}
		
		// VERIFY 2 ARRAY BẰNG NHAU-NẾU DỮ LIỆU SORT TRÊN UI KO CHÍNH XÁC THÌ KẾT QUẢ TRẢ VỀ SAI
		return sortedList.equals(arrayList);
	}
	
	public boolean isPriceSortedAscending(WebDriver driver) {
		// KHAI BÁO 1 ARRAY LIST
		ArrayList<Float> arrayList= new ArrayList<Float>();
		
		// TÌM TẤT CẢ ELEMENT MATCHING VS ĐIỀU KIỆN (NAME/PRICE/...)
		List<WebElement>elementList = findElementsByXpath(driver, AbstractNopCommercePageUI.PRODUCT_PRICE);
		// LẤY TEXT CỦA TỪNG ELEMENT ADD VÀO ARRAY LIST
		for(WebElement element:elementList) {
			arrayList.add(Float.parseFloat(element.getText().replace("$", "").replace(",", "").trim()));
		}
		
		System.out.println("-----DỮ LIỆU TRÊN UI-----");
		for(Float name: arrayList) {
			System.out.println(name);
		}
		
		// COPY QUA 1 ARRAY LIST MỚI ĐỂ SORT TRONG CODE
		ArrayList<Float>sortedList = new ArrayList<Float>();
		for(Float child:arrayList) {
			sortedList.add(child);
		}
		
		// THỰC HIỆN SORT ASC
		Collections.sort(arrayList);
		
		System.out.println("----DỮ LIỆU ĐÃ SORT ASC TRONG CODE-----");
		for(Float name:arrayList) {
			System.out.println(name);
		}
		
		// VERIFY 2 ARRAY BẰNG NHAU - NẾU DỮ LIỆU SORT TRÊN UI KO CHÍNH XÁC THÌ KẾT QUẢ TRẢ VỀ SAI
		return sortedList.equals(arrayList);
	}
	
	
	public boolean isPriceSortedDescending(WebDriver driver) {
		// KHAI BÁO 1 ARRAY LIST
		ArrayList<Float> arrayList= new ArrayList<Float>();
		
		// TÌM TẤT CẢ ELEMENT MATCHING VS ĐIỀU KIỆN (NAME/PRICE/...)
		List<WebElement>elementList = findElementsByXpath(driver, AbstractNopCommercePageUI.PRODUCT_PRICE);

		
		// LẤY TEXT CỦA TỪNG ELEMENT ADD VÀO ARRAY LIST
		for(WebElement element:elementList) {
			arrayList.add(Float.parseFloat(element.getText().replace("$", "").replace(",", "").trim()));
		}
		
		System.out.println("-----DỮ LIỆU TRÊN UI-----");
		for(Float name: arrayList) {
			 System.out.println(name);
		}
		
		// COPY QUA 1 ARRAY LIST MỚI ĐỂ SORT TRONG CODE
		ArrayList<Float>sortedList = new ArrayList<Float>();
		for(Float child:arrayList) {
			sortedList.add(child);
		}
		
		// THỰC HIỆN SORT ASC
		Collections.sort(arrayList);
		
		System.out.println("----DỮ LIỆU ĐÃ SORT ASC TRONG CODE-----");
		for(Float name:arrayList) {
			System.out.println(name);
		}
		
		// REVERSE DATA ĐỂ SORT DESC ( DÙNG 1 TRONG 2 CÁCH BÊN DƯỚI )
		Collections.reverse(arrayList);
		// COLLECTIONS.SORT(ARRAYLIST , COLLECTIONS.REVERSEPRDER());
		System.out.println("-----DỮ LIỆU ĐÃ SORT DESC TRONG CODE-----");
		for(Float name:arrayList) {
			System.out.println(name);
		}
		
		// VERIFY 2 ARRAY BẰNG NHAU-NẾU DỮ LIỆU SORT TRÊN UI KO CHÍNH XÁC THÌ KẾT QUẢ TRẢ VỀ SAI
		return sortedList.equals(arrayList);
	}
	
	
	
	
	// DÙNG CHO BANK GURU
	
	public void openBankGuruPage(WebDriver driver , String pageName) {
		waitToElementVisible(driver, AbstractBankPageUI.DYNAMIC_MENU_LINK,pageName);	
		clickToElement(driver, AbstractBankPageUI.DYNAMIC_MENU_LINK,pageName);		
		
	}
	
	public void inputToBankGuruTextboxByName(WebDriver driver , String textboxName, String value) {
		waitToElementVisible(driver, AbstractBankPageUI.DYNAMIC_TEXTBOX,textboxName);	
		if(textboxName.contains("dob")) {
			removeAttributeInDOM(driver, AbstractBankPageUI.DYNAMIC_TEXTBOX, "type", textboxName);
		}
		sendkeyToElement(driver, AbstractBankPageUI.DYNAMIC_TEXTBOX, value, textboxName);
		
	}
	
	public void inputToBankGuruTextAreaByName(WebDriver driver , String textAreaName, String value) {
		waitToElementVisible(driver, AbstractBankPageUI.DYNAMIC_TEXTAREA,textAreaName);	
		sendkeyToElement(driver, AbstractBankPageUI.DYNAMIC_TEXTAREA, value, textAreaName);
		
	}
	
	public void clickToBankGuruButtonByValue(WebDriver driver , String buttonValue) {
		waitToElementClickable(driver, AbstractBankPageUI.DYNAMIC_BUTTON,buttonValue);	
		clickToElement(driver, AbstractBankPageUI.DYNAMIC_BUTTON,buttonValue);
		
	}
	
	public void clickToBankGuruRadioButtonByValue(WebDriver driver , String radioButtonValue) {
		waitToElementClickable(driver, AbstractBankPageUI.DYNAMIC_RADIO,radioButtonValue);	
		clickToElement(driver, AbstractBankPageUI.DYNAMIC_RADIO,radioButtonValue);
		
	}
	
	public String getBankGuruHeaderText(WebDriver driver) {
		waitToElementVisible(driver, AbstractBankPageUI.HEADING_TEXT);	
		return getTextlement(driver, AbstractBankPageUI.HEADING_TEXT);
		
	}
	
	public String getBankGuruRowValueByRowName(WebDriver driver, String rowName) {
		waitToElementVisible(driver, AbstractBankPageUI.DYNAMIC_ROW_NAME, rowName);	
		return getTextlement(driver, AbstractBankPageUI.DYNAMIC_ROW_NAME, rowName);
		
	}
	
	public boolean isBankGuruTextboxEnabled(WebDriver driver,String textboxName) {
		waitToElementVisible(driver, AbstractBankPageUI.DYNAMIC_TEXTBOX,textboxName);	
		return isElementEnabled(driver, AbstractBankPageUI.DYNAMIC_TEXTBOX,textboxName);
		
	}
	
	public void selectBankGuruDropdownItemByName(WebDriver driver, String dropdownName,String valueItem) {
		waitToElementVisible(driver, AbstractBankPageUI.DYNAMIC_DROPDOWN,dropdownName);	
		selectItemInDropdown(driver, AbstractBankPageUI.DYNAMIC_DROPDOWN, valueItem,dropdownName);
	}
	
	public boolean isAlertTextDisplayedAndAcceptAlert(WebDriver driver, String alertText) {
		waitAlertPresence(driver);
		String actualText = getTextAlert(driver);
		sleepInSecond(1);
		acceptAler(driver);
		sleepInSecond(1);
		return actualText.equals(alertText);
	}
		
	
	
}

