package Com.nopcommerce_Login;

import org.testng.annotations.Test;

import Commons.AbstractPage;

import org.testng.annotations.BeforeTest;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Login_02_RegisterAndLogin2_AbstractPage_01_Declare {
	private WebDriver driver;
	private Select select;
	private String email, password;	
	//Declare an instance of Abstract Page
	private AbstractPage abstractPage;
	
	@BeforeTest
	  public void beforeTest() {
		System.setProperty("webdriver.gecko.driver", ".\\LIB\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		//Init Abstract Page
		abstractPage = new AbstractPage(driver);
		
		abstractPage.openUrl("https://demo.nopcommerce.com/");
		//driver.get("https://demo.nopcommerce.com/");

		// GENERATE RANDOM
		email = "corona" + randowmNumber() + "@hotmail.com";
		password = "coronavirus";
	  } 
	
  @Test
  public void TC_01_RegisterToSystem() {
	  abstractPage.clickToElement("//a[@class='ico-register']");
	  //driver.findElement(By.cssSelector(".ico-register")).click();
	  
	  //click male radio button
	  abstractPage.clickToElement("//input[@id='gender-male']");
	  //driver.findElement(By.cssSelector("#gender-male")).click();
	  abstractPage.senkeyToElement("//input[@id='FirstName']", "corona");
	  //driver.findElement(By.cssSelector("#FirstName")).sendKeys("corona");
	  abstractPage.senkeyToElement("//input[@id='LastName']","virus");
	  //driver.findElement(By.cssSelector("#LastName")).sendKeys("virus");
	  
	  
	  abstractPage.selectItemInDropdown("//select[@name='DateOfBirthDay']", "1");
	 // select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']")));
	 //select.selectByVisibleText("1");
	   
	  abstractPage.selectItemInDropdown("//select[@name='DateOfBirthMonth']", "February");
	  //select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']")));
	  //select.selectByVisibleText("February");
	  
	  abstractPage.selectItemInDropdown("//select[@name='DateOfBirthYear']", "1986");
	  //select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthYear']")));
	  //select.selectByVisibleText("1986");
	  
	  abstractPage.senkeyToElement("//input[@id='Email']", email);
	  //driver.findElement(By.cssSelector("#Email")).sendKeys(email);
	  abstractPage.senkeyToElement("//input[@id='Company']", "corona virus");
	  //driver.findElement(By.cssSelector("#Company")).sendKeys("corona virus");
	  abstractPage.senkeyToElement("//input[@id='Password']", password);
	  // driver.findElement(By.cssSelector("#Password")).sendKeys(password);
	  abstractPage.senkeyToElement("//input[@id='ConfirmPassword']", password);
	  //driver.findElement(By.cssSelector("#ConfirmPassword")).sendKeys(password);
	  abstractPage.clickToElement("//input[@id='register-button']");
	  //driver.findElement(By.cssSelector("#register-button")).click();
	  
	  String resultText = abstractPage.getTextlement("//div[@class='result']");
	  Assert.assertEquals(resultText, "Your registration completed");
	  
	  abstractPage.clickToElement("//a[@class='ico-logout']");
	  //driver.findElement(By.cssSelector(".ico-logout")).click();
  }
  
  @Test
  public void TC_02_LoginToSystem() {
	  abstractPage.clickToElement("//a[@class='ico-login']");
	  //driver.findElement(By.cssSelector(".ico-login")).click();
	  abstractPage.senkeyToElement("//input[@id='Email']", email);
	  //driver.findElement(By.cssSelector("#Email")).sendKeys(email);
	  abstractPage.senkeyToElement("//input[@id='Password']", password);
	  //driver.findElement(By.cssSelector("#Password")).sendKeys(password);
	  abstractPage.clickToElement("//input[@class='button-1 login-button']");
	  //driver.findElement(By.cssSelector(".login-button")).click();
	  
	  Assert.assertTrue(abstractPage.isElementDisplayed("//a[@class='ico-account']"));
	  
  }
  
  
  @AfterTest
  public void afterTest() {
  }
  
  public int randowmNumber() {
	  Random Rand = new Random();
	  return Rand.nextInt(5000);
  }

}
