package Commons;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class AbstractTest {
	private WebDriver driver;
	protected final Log log;
	private String rootFolder = System.getProperty("user.dir");
	
	public AbstractTest() {
		log = LogFactory.getLog(getClass());
		
	}
	
	protected void printBrowserConsoleLogs(WebDriver driver) {
		LogEntries logs = driver.manage().logs().get("browser");
		List<LogEntry>logList = logs.getAll();
		for(LogEntry logging : logList) {
			log.info("-----"+ logging.getLevel().toString()+"-----\n" + logging.getMessage());
		}
	}
	
	public WebDriver getBrowserDriver(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			//System.setProperty("webdriver.chrome.driver", ".\\LIB\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			
			System.setProperty("webdriver.chrome.args","--disable-logging");
			System.setProperty("webdriver.chrome.silentOutput", "true");
						
			// CHỌN NGÔN NGỮ ĐỂ MỞ TRÌNH DUYỆT
			ChromeOptions options = new ChromeOptions();
			options.addArguments("-lang=vi");
			
			// TẮT INFOBAR
			//options.addArguments("disable-infobars"); // KO ĐƯỢC THÌ DÙNG
			options.setExperimentalOption("useAutomationExtension", false);
			options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));


			// INSTALL PLUGIN FOR CHROME
			File file = new File(rootFolder + "\\browserExtensions\\google_translate.crx");
			options.addExtensions(file);			
			// TẮT TIỆN ÍCH DEVELOPER MODE
			options.addArguments("--disable-extensions");

			// CHẠY ẨN DANH TRÊN CHROME
			//options.addArguments("--incognito");
			
			// AUTO SAVE ON CHROME
			HashMap<String,Object> chromePrefs = new HashMap<String,Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", rootFolder + "\\fileDownloaded");
			options.setExperimentalOption("prefs", chromePrefs);

			driver = new ChromeDriver(options);
	
		} else if(browserName.equalsIgnoreCase("firefox")) {
			//System.setProperty("webdriver.gecko.driver", ".\\LIB\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			
			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,rootFolder + "\\LogBrowser\\Firefox.log");
			
			
			// INSTALL PLUGIN FOR FIREFOX	
			FirefoxProfile profile = new FirefoxProfile();
			File translate = new File(rootFolder + "\\browserExtensions\\google_translate.xpi");
			profile.addExtension(translate);
			profile.setPreference("intl.accept_languages", "fr"); // CHƯA ĐỔI NGÔN NGỮ DC CHO FIREFOX
			FirefoxOptions options = new FirefoxOptions();
			options.setProfile(profile);
			
			// CHẠY ẨN DANH TRÊN FIREFOX
			//options.addArguments("-private");
			
			
			// AUTO SAVE ON FIREFOX
			options.addPreference("browser.download.folderList", 2);
			options.addPreference("browser.download.dir", rootFolder + "\\fileDownloaded");
			options.addPreference("browser.download.useDownloadDir", true);
			options.addPreference("browser.helperApps.neverAsk.saveToDisk","application/pdf");
			options.addPreference("pdfjs.disabled", true);		
			driver = new FirefoxDriver(options);

			
			
		} else if(browserName.equalsIgnoreCase("headless_chrome")) {
			//System.setProperty("webdriver.chrome.driver", ".\\LIB\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("window-size=1920x1080");
			driver = new ChromeDriver(options);
			
		} else if(browserName.equalsIgnoreCase("headless_firefox")) {
			//System.setProperty("webdriver.gecko.driver", ".\\LIB\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			driver = new FirefoxDriver(options);
		}  else if(browserName.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		}	else if(browserName.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().arch32().setup();
			driver = new InternetExplorerDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			// EDGE HTML VERSION 18
			// DÙNG COMMAND LINE
			
			// EDGE HTML VERSION < 18
			// System.setProperty("webdriver.edge.driver",".\\LIB\\MicrosoftWebDriver.exe");

			// EDGE LATEST VERSION
			System.setProperty("webdriver.edge.driver",".\\LIB\\msedgedriver.exe");
			driver = new EdgeDriver();

		}
		
		
		driver.get(GlobalConstants.DEV_URL);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		
		return driver;
	}
	
	public WebDriver getBrowserDriver(String browserName, String url) {
		if(browserName.equalsIgnoreCase("chrome")) {
			//System.setProperty("webdriver.chrome.driver", ".\\LIB\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();		
		} else if(browserName.equalsIgnoreCase("firefox")) {
			//System.setProperty("webdriver.gecko.driver", ".\\LIB\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();		
		} else if(browserName.equalsIgnoreCase("headless_chrome")) {
			//System.setProperty("webdriver.chrome.driver", ".\\LIB\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("window-size=1920x1080");
			driver = new ChromeDriver(options);
			
		} else if(browserName.equalsIgnoreCase("headless_firefox")) {
			//System.setProperty("webdriver.gecko.driver", ".\\LIB\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			driver = new FirefoxDriver(options);
		} else if(browserName.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		}

		driver.get(url);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		return driver;
	}

	private boolean checkTrue(boolean condition) {
		boolean pass = true;
		try {
			if (condition == true) {
				log.info(" -------------------------- PASSED -------------------------- ");
			} else {
				log.info(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			pass = false;

			// Add lỗi vào ReportNG
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyTrue(boolean condition) {
		return checkTrue(condition);
	}

	private boolean checkFailed(boolean condition) {
		boolean pass = true;
		try {
			if (condition == false) {
				log.info(" -------------------------- PASSED -------------------------- ");
			} else {
				log.info(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		return checkFailed(condition);
	}

	private boolean checkEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;
			log.info(" -------------------------- FAILED -------------------------- ");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		return checkEquals(actual, expected);
	}
	
	protected int randowmNumber() {
		  Random Rand = new Random();
		  return Rand.nextInt(5000);
	  }

	protected void closeBrowserAndDriver(WebDriver driver) {
		try {
			// get ra tên của OS và convert qua chữ thường
			String osName = System.getProperty("os.name").toLowerCase();
			log.info("OS name = " + osName);

			// Khai báo 1 biến command line để thực thi
			String cmd = "";
			if (driver != null) {
				driver.manage().deleteAllCookies();
				driver.quit();
			}

			if (driver.toString().toLowerCase().contains("chrome")) {
				if (osName.toLowerCase().contains("mac")) {
					cmd = "pkill chromedriver";
				} else if (osName.toLowerCase().contains("windows")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
				}
			} else if (driver.toString().toLowerCase().contains("internetexplorer")) {
				if (osName.toLowerCase().contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
				}
			} else if (driver.toString().toLowerCase().contains("firefox")) {
				if (osName.toLowerCase().contains("mac")) {
					cmd = "pkill geckodriver";
				} else if (osName.toLowerCase().contains("windows")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq geckodriver*\"";
				}
			}
			
			driver = null;
			
			Process process = Runtime.getRuntime().exec(cmd);
			process.waitFor();

			log.info("---------- QUIT BROWSER SUCCESS ----------");
		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}
	
	
	protected String getCurrentDay() {
		DateTime nowUTC = new DateTime(DateTimeZone.UTC);
		int day = nowUTC.getDayOfMonth();
		if (day < 10) {
			String dayValue = "0" + day;
			return dayValue;
		}
		return day + "";
	}

	protected String getCurrentMonth() {
		DateTime now = new DateTime(DateTimeZone.UTC);
		int month = now.getMonthOfYear();
		if (month < 10) {
			String monthValue = "0" + month;
			return monthValue;
		}
		return month + "";
	}

	protected String getCurrentYear() {
		DateTime now = new DateTime(DateTimeZone.UTC);
		return now.getYear() + "";
	}

	protected String getBankGuruToday() {
		return getCurrentYear() + "-" + getCurrentMonth() + "-" + getCurrentDay();
	}
}




