package Com.nopcommerce_Login;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Login_01_RegisterAndLogin {
	private WebDriver driver;
	private Select select;
	private String email, password;
	
	@BeforeTest
	  public void beforeTest() {
		System.setProperty("webdriver.gecko.driver", ".\\LIB\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		
		// GENERATE RANDOM
		email = "corona" + randowmNumber() + "@hotmail.com";
		password = "coronavirus";
	  } 
	
  @Test
  public void TC_01_RegisterToSystem() {
	  driver.findElement(By.cssSelector(".ico-register")).click();
	  
	  //click male radio button
	  driver.findElement(By.cssSelector("#gender-male")).click();
	  driver.findElement(By.cssSelector("#FirstName")).sendKeys("corona");
	  driver.findElement(By.cssSelector("#LastName")).sendKeys("virus");
	  
	  select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']")));
	  select.selectByVisibleText("1");
	   
	  select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']")));
	  select.selectByVisibleText("February");
	  
	  select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthYear']")));
	  select.selectByVisibleText("1986");
	  
	  driver.findElement(By.cssSelector("#Email")).sendKeys(email);
	  driver.findElement(By.cssSelector("#Company")).sendKeys("corona virus");
	  driver.findElement(By.cssSelector("#Password")).sendKeys(password);
	  driver.findElement(By.cssSelector("#ConfirmPassword")).sendKeys(password);
	  driver.findElement(By.cssSelector("#register-button")).click();
	  
	  String resultText = driver.findElement(By.cssSelector(".result")).getText();
	  Assert.assertEquals(resultText, "Your registration completed");
	  
	  driver.findElement(By.cssSelector(".ico-logout")).click();
  }
  
  @Test
  public void TC_02_LoginToSystem() {
	  driver.findElement(By.cssSelector(".ico-login")).click();
	  
	  driver.findElement(By.cssSelector("#Email")).sendKeys(email);
	  
	  driver.findElement(By.cssSelector("#Password")).sendKeys(password);
	  
	  driver.findElement(By.cssSelector(".login-button")).click();
	  
	  Assert.assertTrue(driver.findElement(By.cssSelector(".ico-account")).isDisplayed());
	  
  }
  
  
  @AfterTest
  public void afterTest() {
  }
  
  public int randowmNumber() {
	  Random Rand = new Random();
	  return Rand.nextInt(5000);
  }

}
