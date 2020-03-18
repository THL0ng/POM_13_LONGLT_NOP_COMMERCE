package browserFactory;


import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverManager extends DriverManager {

	@Override
	void createDriver() {
		// ADD SERVICE AND NEW DRIVER
		System.setProperty("webdriver.gecko.driver", ".\\LIB\\geckodriver.exe");
		driver = new FirefoxDriver();		
		
	}


}
