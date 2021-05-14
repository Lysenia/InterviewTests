package InterviewWalletHub.InterviewTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SignUp {
	
	WebDriver driver;


	public void setUp() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().fullscreen();
		
		   
	}
	

	public void createLightUser(String email, String password) throws InterruptedException {
	    driver.get("https://wallethub.com/join/light");

	    WebElement emailField = driver.findElement(By.name("em"));
	    WebElement passwordField = driver.findElement(By.name("pw1"));
	    WebElement confirmPassword = driver.findElement(By.name("pw2"));
	    WebElement getFreeCreditScore = driver.findElement(By.id("get-my-report"));
	    WebElement join = driver.findElement(By.xpath("//div/button"));

	    emailField.sendKeys("lisonka.07@mail.ru");
	    passwordField.sendKeys("ABC123abc!");
	    confirmPassword.sendKeys("ABC123abc!");
	    getFreeCreditScore.click();
	    join.click();

}
	
	public static void main(String[] args) {
		/**
		 * Creates object of main class and accesses its methods.
		 */		
		
		SignUp obj = new SignUp();
		//setting up the browser and redirecting to the facebook page
		obj.setUp();
		
		//obj.createLightUser(email, password);;
}
}
