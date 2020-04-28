package PageUIs.Nop_Commerce;

public class AbstractNopCommercePageUI {
	public static final String HOME_PAGE_LINK = "//div[@class='header-logo']//img";
	
	
	public static final String FOOTER_SEARCH_LINK = "//div[@class='footer']//a[text()='Search']";	
	public static final String FOOTER_NEW_PRODUCT_LINK = "//div[@class='footer']//a[text()='New products']";
	public static final String FOOTER_MY_ACCOUNT_LINK = "//div[@class='footer']//a[text()='My account']";


	// Header Link
	public static final String DYNAMIC_HEADER_LINK = "//div[@class='header']//a[text()='%s']";
	
	// Header Menu/ Sub Menu
	public static final String DYNAMIC_HEADER_MENU_LINK = "//div[@class='header-menu']//ul[@class='top-menu notmobile']//a[contains(text(),'%s')]";

	// Footer
	public static final String DYNAMIC_FOOTER_LINK = "//div[@class='footer']//a[text()='%s']";
	
	// Textbox
	public static final String DYNAMIC_TEXTBOX = "//input[@id='%s']";

	// Radio Button
	public static final String DYNAMIC_RADIO_BUTTON = "//input[@id='%s' and @type='radio']";
	
	//Checkbox
	public static final String DYNAMIC_CHECKBOX = "//input[@id='%s' and @type='checkbox']";

	
	// Dropdown List
	public static final String DYNAMIC_DROPDOWN = "//select[@name='%s']";
	
	// Button
	public static final String DYNAMIC_BUTTON = "//input[@value='%s']";
	
	// Product title
	public static final String PRODUCT_TITLE = "//h2[@class='product-title']/a";


	// Product price
	public static final String PRODUCT_PRICE = "//div[@class='prices']//span";

}
