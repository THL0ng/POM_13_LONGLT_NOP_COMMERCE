package Com.nopcommerce_Login;

import org.testng.annotations.Test;

import Commons.AbstractPage;
import Commons.AbstractPages;

import org.testng.annotations.BeforeTest;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Login_02_RegisterAndLogin2_AbstractPage_02_Extends extends AbstractPages {
	private WebDriver driver;
	private Select select;
	private String email, password;	
	//Declare an instance of Abstract Page
	private AbstractPage abstractPage;
	
	@BeforeTest
	  public void beforeTest() {
		System.setProperty("webdriver.gecko.driver", ".\\LIB\\geckodriver.exe");
		driver = new FirefoxDriver();
	
		openUrl(driver,"https://demo.nopcommerce.com/");
		//driver.get("https://demo.nopcommerce.com/");

		// GENERATE RANDOM
		email = "corona" + randowmNumber() + "@hotmail.com";
		password = "coronavirus";
	  } 
	
  @Test
  public void TC_01_RegisterToSystem() {
	  clickToElement(driver,"//a[@class='ico-register']");
	  //driver.findElement(By.cssSelector(".ico-register")).click();
	  
	  //click male radio button
	  clickToElement(driver,"//input[@id='gender-male']");
	  //driver.findElement(By.cssSelector("#gender-male")).click();
	  sendkeyToElement(driver,"//input[@id='FirstName']", "corona");
	  //driver.findElement(By.cssSelector("#FirstName")).sendKeys("corona");
	  sendkeyToElement(driver,"//input[@id='LastName']","virus");
	  //driver.findElement(By.cssSelector("#LastName")).sendKeys("virus");
	  
	  
	  selectItemInDropdown(driver,"//select[@name='DateOfBirthDay']", "1");
	 // select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']")));
	 //select.selectByVisibleText("1");
	   
	  selectItemInDropdown(driver,"//select[@name='DateOfBirthMonth']", "February");
	  //select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']")));
	  //select.selectByVisibleText("February");
	  
	  selectItemInDropdown(driver,"//select[@name='DateOfBirthYear']", "1986");
	  //select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthYear']")));
	  //select.selectByVisibleText("1986");
	  
	  sendkeyToElement(driver,"//input[@id='Email']", email);
	  //driver.findElement(By.cssSelector("#Email")).sendKeys(email);
	  sendkeyToElement(driver,"//input[@id='Company']", "corona virus");
	  //driver.findElement(By.cssSelector("#Company")).sendKeys("corona virus");
	 sendkeyToElement(driver,"//input[@id='Password']", password);
	  // driver.findElement(By.cssSelector("#Password")).sendKeys(password);
	  sendkeyToElement(driver,"//input[@id='ConfirmPassword']", password);
	  //driver.findElement(By.cssSelector("#ConfirmPassword")).sendKeys(password);
	  clickToElement(driver,"//input[@id='register-button']");
	  //driver.findElement(By.cssSelector("#register-button")).click();
	  
	  String resultText = getTextlement(driver,"//div[@class='result']");
	  Assert.assertEquals(resultText, "Your registration completed");
	  
	  clickToElement(driver,"//a[@class='ico-logout']");
	  //driver.findElement(By.cssSelector(".ico-logout")).click();
  }
  
  @Test
  public void TC_02_LoginToSystem() {
	  clickToElement(driver,"//a[@class='ico-login']");
	  //driver.findElement(By.cssSelector(".ico-login")).click();
	  sendkeyToElement(driver,"//input[@id='Email']", email);
	  //driver.findElement(By.cssSelector("#Email")).sendKeys(email);
	  sendkeyToElement(driver,"//input[@id='Password']", password);
	  //driver.findElement(By.cssSelector("#Password")).sendKeys(password);
	  clickToElement(driver,"//input[@class='button-1 login-button']");
	  //driver.findElement(By.cssSelector(".login-button")).click();
	  
	  Assert.assertTrue(isElementDisplayed(driver,"//a[@class='ico-account']"));
	  
  }
  
  
  @AfterTest
  public void afterTest() {
  }
  
  public int randowmNumber() {
	  Random Rand = new Random();
	  return Rand.nextInt(5000);
  }

}
