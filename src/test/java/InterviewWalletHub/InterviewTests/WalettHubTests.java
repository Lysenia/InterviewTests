package InterviewWalletHub.InterviewTests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.interactions.internal.Locatable;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WalettHubTests {
	
	WebDriver driver;


	public void setUp() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().fullscreen();
		
		   
	}
	
	
	public void writeReview() {
	
		driver.get("http://wallethub.com/profile/test_insurance_company/");
	// leaving a review
			WebElement writeReview = driver.findElement(By.xpath("//button[@class='btn blue-brds']"));
			writeReview.click();
			
			//selecting from drop down
			WebElement dropDown = driver.findElement(By.xpath("//div[@class='dropdown second']//span[@class='dropdown-placeholder']"));
			dropDown.click();
			
			WebDriverWait wait = new WebDriverWait(driver, 20);		

			//presence in DOM
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[contains(text(),'Health')]")));		

			//clickable
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(text(),'Health')]")));
			List<WebElement> options = dropDown.findElements(By.xpath("//li[contains(text(),'Health')]"));
			options.get(0).click();
			
			//leaving a text review in the field
			WebElement textField = driver.findElement(By.xpath("//textarea[1]"));
			textField.click();
			textField.sendKeys("In the age of disruption, businesses live and die by their ability to adapt. Agility and adaptability have become catchy buzz words to get to the point of what businesses need to do – change. But I’m changing all day long you might say…The question is to what end. Change must help us adapt effectively – to us get to a defined destination.");
			
			//clicking on stars
			WebElement allStarField = driver.findElement(By.xpath("//div[@class='ng-modal-container ready']//div[@class='rating-box-wrapper']"));
			WebElement star1 = driver.findElement(By.xpath("//div[@class='ng-modal-container ready']//div[@class='rating-box-wrapper']//*[@class='rvs-star-svg'][1]"));
			WebElement star2 = driver.findElement(By.xpath("//div[@class='ng-modal-container ready']//div[@class='rating-box-wrapper']//*[@class='rvs-star-svg'][2]"));
			WebElement star3 = driver.findElement(By.xpath("//div[@class='ng-modal-container ready']//div[@class='rating-box-wrapper']//*[@class='rvs-star-svg'][3]"));
			WebElement star4 = driver.findElement(By.xpath("//div[@class='ng-modal-container ready']//div[@class='rating-box-wrapper']//*[@class='rvs-star-svg'][4]"));
			WebElement star5 = driver.findElement(By.xpath("//div[@class='ng-modal-container ready']//div[@class='rating-box-wrapper']//*[@class='rvs-star-svg'][5]"));
			
			//hovering over the stars
			Locatable hoverItem1 = (Locatable) star1;
			Mouse mouse = ((HasInputDevices) driver).getMouse();
			mouse.mouseMove(hoverItem1.getCoordinates());
			
			Locatable hoverItem2 = (Locatable) star2;
			Mouse mouse2 = ((HasInputDevices) driver).getMouse();
			mouse.mouseMove(hoverItem2.getCoordinates());
			
			Locatable hoverItem3 = (Locatable) star3;
			Mouse mouse3 = ((HasInputDevices) driver).getMouse();
			mouse.mouseMove(hoverItem3.getCoordinates());
			
			Locatable hoverItem4 = (Locatable) star4;
			Mouse mouse4 = ((HasInputDevices) driver).getMouse();
			mouse.mouseMove(hoverItem3.getCoordinates());
			
			Locatable hoverItem5 = (Locatable) star5;
			Mouse mouse5 = ((HasInputDevices) driver).getMouse();
			mouse.mouseMove(hoverItem3.getCoordinates());
			
			//clicking on 1-4 stars
			Actions builder = new Actions(driver);  
		    builder.moveToElement(star1).build().perform();
		    builder.moveToElement(star2).build().perform();
		    builder.moveToElement(star3).build().perform();
		    builder.moveToElement(star4).build().perform();
		    star4.click();

		    //submitting review
		   WebElement submit = driver.findElement(By.xpath("//div[contains(text(),'Submit')]"));
		   submit.click();
		   
		   
	}

/*
 * The review can not be submitted without further log in. To log further steps are needed
 */


	public void logIn(String email, String password) {
		
		WebElement logInButton = driver.findElement(By.xpath("//li/a[contains(text(),'Login')]"));
		logInButton.click();;
		WebElement emailField = driver.findElement(By.name("em"));
		emailField.click();
		emailField.sendKeys(email);
		WebElement passwordField = driver.findElement(By.name("pw1"));
		passwordField.click();
		passwordField.sendKeys(password);							
		driver.findElement(By.xpath("//span[contains(text(),'Login')]")).click();
	}



 public boolean reviewPresentVerif() {
	
			//redirecting to the profile page	
			driver.get("https://wallethub.com/profile/67345450i");
			
			//clicking on reviews
			WebElement reviews = driver.findElement(By.xpath("//div[@class='pr-rec-texts-container']/a"));
			reviews.click();
			
			//verifying the review contains the text posted by user
			String actualString = driver.findElement(By.xpath("//div[@class='rvtab-ci-content with-links text-select rvtac-ci-cexp']")).getText();
			String expectedString = "In the age of disruption, businesses live and die by their ability to adapt. Agility and adaptability have become catchy buzz words to get to the point of what businesses need to do – change. But I’m changing all day long you might say…The question is to what end. Change must help us adapt effectively – to us get to a defined destination.";
		    Boolean result = actualString.contains(expectedString);
		   return result;
	}


public static void main(String[] args) {
	/**
	 * Creates object of main class and accesses its methods.
	 */		
	
	WalettHubTests obj = new WalettHubTests();
	//setting up the browser and redirecting to the facebook page
	obj.setUp();
	
	obj.writeReview();
	obj.logIn("lesialysiak@gmail.com", "ABC123abc!");
	obj.reviewPresentVerif();
	
	if (obj.reviewPresentVerif()) {
		System.out.println("Review posted successfully");		
	}
	else {
		System.err.println("Failed to verify");
	}
		
	}
	
	}


