package InterviewWalletHub.InterviewTests;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FaceBookPost {
	
	WebDriver driver;

	/*This method sets up the driver 
	 It's designed for  testing in Chrome browser and solves the issue of notification 
	 pop up in Facebook
	
	*/
	

	  public void setUp() {
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			WebDriverManager.chromedriver().setup();
			
			
			// Now initialize chrome driver with chrome options which will switch off this browser notification on the chrome browser
			driver = new ChromeDriver(options);
			
			// setting up wait time and entering full screen mode
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().window().fullscreen();
			
			//openning Facebook Pgae
			 driver.get("https://www.facebook.com/");
		}



	  public void logInUser(String accountEmail, String accountPassword) throws InterruptedException {
	   
		// log in to a Facebook Page
	    WebElement email = driver.findElement(By.id("email"));
	    WebElement password = driver.findElement(By.id("pass"));
	    WebElement logIn = driver.findElement(By.name("login"));
	    email.sendKeys(accountEmail);
	    password.sendKeys(accountPassword);
	    logIn.click();
	    
	    //locating "What's on Your Mind" field
	    WebElement TextArea = driver.findElement(By.cssSelector("div[role='button']>div>span[style*='webkit-box-orient']"));
	    TextArea.click();
	    Thread.sleep(3000);

	    //Click on the expanded text area
	    WebElement TextAreaExpanded = driver.findElement(By.cssSelector("div[aria-describedby*='placeholder']"));
	   TextAreaExpanded.click();
	    TextAreaExpanded.sendKeys("Hello World");

	    //Wait
	    Thread.sleep(3000);

	    //Click On Post Button
	   WebElement PostBtn = driver.findElement(By.cssSelector("div[aria-label='Post']"));;
	   PostBtn.click();
	    
	   
	}
	  
	  public static void main(String[] args) {
			/**
			 * Creates object of main class and accesses its methods.
			 */		
			FaceBookPost userAcc = new FaceBookPost();
			//setting up the browser and redirecting to the facebook page
			userAcc.setUp();
			//log in to facebook (email and password should be provided)
			//userAcc.logInUser("", "");
			
			}
			
			
		}
	
	



