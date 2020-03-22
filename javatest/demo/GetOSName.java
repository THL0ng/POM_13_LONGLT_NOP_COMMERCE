package demo;

public class GetOSName {
	public static void main(String[] args) {
		String osName = System.getProperty("os.name");
		
		if(osName.toLowerCase().contains("windows")) {
			System.setProperty("webdriver.chrome.driver", ".\\LIB\\chromedriver.exe");		
		} else if(osName.toLowerCase().contains("firefox")) {
			System.setProperty("webdriver.gecko.driver", ".\\LIB\\geckodriver.exe");
		}
	}

}
