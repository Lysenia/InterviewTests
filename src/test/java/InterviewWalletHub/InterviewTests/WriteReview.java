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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WriteReview {
	
	WebDriver driver;

	@Test
	public void logIn() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//System.setProperty("webdriver.chrome.driver",
					//"/Users/lesia/Documents/Cybertek/selenium dependencies/drivers/chromedriver");
			//driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().fullscreen();
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
		   
		   



		String email = "lesialysiak@gmail.com" ;
			String password = "ABC123abc!";
				WebElement logInButton = driver.findElement(By.xpath("//li/a[contains(text(),'Login')]"));
				logInButton.click();;
				WebElement emailField = driver.findElement(By.name("em"));
				emailField.click();
				emailField.sendKeys(email);
				WebElement passwordField = driver.findElement(By.name("pw1"));
				passwordField.click();
				passwordField.sendKeys(password);							
				driver.findElement(By.xpath("//span[contains(text(),'Login')]")).click();
			
				driver.get("https://wallethub.com/profile/67345450i");
				WebElement reviews = driver.findElement(By.xpath("//div[@class='pr-rec-texts-container']/a"));
				   reviews.click();
				   String actualString = driver.findElement(By.xpath("//div[@class='rvtab-ci-content with-links text-select rvtac-ci-cexp']")).getText();
				   String expectedString = "In the age of disruption, businesses live and die by their ability to adapt. Agility and adaptability have become catchy buzz words to get to the point of what businesses need to do – change. But I’m changing all day long you might say…The question is to what end. Change must help us adapt effectively – to us get to a defined destination.";
				   Assert.assertTrue(actualString.contains(expectedString));
	}
}

