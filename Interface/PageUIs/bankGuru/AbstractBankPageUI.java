package PageUIs.bankGuru;

public class AbstractBankPageUI {
	// MENU
	public static final String DYNAMIC_MENU_LINK = "//ul[@class='menusubnav']//a[text()='%s']";
	
	// TEXTBOX
	public static final String DYNAMIC_TEXTBOX = "//input[@name='%s']";
	
	// TEXTAREA
	public static final String DYNAMIC_TEXTAREA = "//textarea[@name='%s']";
		
	// RADIO BUTTON
	public static final String DYNAMIC_RADIO = "//input[@value='%s']";
	
	// DROPDOWN
	public static final String DYNAMIC_DROPDOWN = "//select[@name='%s']";
	
	// BUTTON
	public static final String DYNAMIC_BUTTON = "//input[@value='%s']";

	// HEADING TEXT
	public static final String HEADING_TEXT = "//p[@class='heading3']";
	
	// ROW NAME
	public static final String DYNAMIC_ROW_NAME = "//td[text()='%s']/following-sibling::td";
	
}
