package stringformat;

public class StringFormat {
	public static void Main(String[] args) {
		String DYNAMIC_FOOTER_LINK = "//div[@class='footer']//a[text()='%s']";
		String DYNAMIC_HEADER_FOOTER_LINK = "//div[@class='%s']//a[text()='%s']";
		
		
		String DYNAMIC_COUNTRY_TEXT = "//td[text()='%s']/following-sibling::td[@data-key='total']";
		
		// 4 PARAMS
		String DYNAMIC_COUNTRY_MALE_FEMALE_TOTAL = "//td[@data-key='females' and text()='%s']/following-sibling::td"
				+ "[@data-key='country' and text()='%s']/following-sibling::td"
				+ "[@data-key='males' and text()='%s']/following-sibling::td"
				+ "[@data-key='total' and text()='%s']";
		
		
		clickToFooterLink(DYNAMIC_FOOTER_LINK , "search");
		clickToFooterLink(DYNAMIC_FOOTER_LINK , "My account");
		clickToFooterLink(DYNAMIC_FOOTER_LINK , "Shopping cart");
		
		// 2 PARAMS
		clickToFooterLink(DYNAMIC_HEADER_FOOTER_LINK , "header" , "Computers");
		clickToFooterLink(DYNAMIC_HEADER_FOOTER_LINK , "header" , "Electronics");
		clickToFooterLink(DYNAMIC_HEADER_FOOTER_LINK , "footer" , "Search");
		
		// 1 PARAM
		clickToFooterLink(DYNAMIC_COUNTRY_TEXT , "Afghanistan");
		clickToFooterLink(DYNAMIC_COUNTRY_TEXT , "Algeria");
		
		// 4 PARAM
		clickToFooterLink(DYNAMIC_COUNTRY_MALE_FEMALE_TOTAL, "338282","Argentina","349238","687522");
		clickToFooterLink(DYNAMIC_COUNTRY_MALE_FEMALE_TOTAL, "276880","Angola","276472","553353");
		clickToFooterLink(DYNAMIC_COUNTRY_MALE_FEMALE_TOTAL, "338282","Grmany","349238","687522");

		

		
		
	}
	
	// 1 PARAMS
	public static void clickToFooterLink(String locator, String pageName) {
		locator = String.format(locator , pageName)	;
		System.out.println("Click to page with 1 param = " + locator);
	}
	// 2 PARAMS
	public static void clickToFooterLink(String locator, String headerOrFooterName, String pageName) {
		locator = String.format(locator , headerOrFooterName , pageName);
		System.out.println("Click to page with 2 param = " + locator);
		
	}
	
	// 4 PARAMS
	public static void clickToFooterLink(String locator, String female, String countryName ,String male , String total) {
		locator = String.format(locator , female , countryName , male , total);
		System.out.println("Click to page with 4 param = " + locator);
		
	}
	
	// N PARAMS
	public static void clickToFooterLink(String locator, String...values) {
		locator = String.format(locator,(Object[]) values);	
		System.out.println("Click to page with N param = \" + locator");
	}

	

}
