package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Waits {
	public static void main(String[] args) {
		
		
		//Driver configuration
		//System.setProperty("webdriver.chromedriver.exe", "./drivers/chromedriver.exe");
		
		//Adding specific version of chrome 
		WebDriverManager.chromedriver().driverVersion("107.0.5304.88").setup();
		WebDriver driver = new ChromeDriver();
		
		//Implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
		
		
		//Test Body
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("automation step by step" + Keys.ENTER);
		
		//Explicit Wait
		WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(10));
		WebElement myLink =  wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Automation Step by Step: NEVER STOP LEARNING")));
		myLink.click();
		
		//Fluent Wait
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class);
		
		//fluentWait.until(ExpectedConditions.elementToBeSelected(By.xpath()));
		
		driver.close();
		driver.quit();		
	}
}
