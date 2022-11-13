package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyboardActions {
	public static void main(String[] args) throws InterruptedException {
		
		//Create New Chrome Option and pass to web driver. 
		ChromeOptions options = new ChromeOptions();
		//Wait for all resources to be loaded - With NORMAL, some load with EAGER and no wait with NONE
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		
		//Adding specific version of chrome 
		WebDriverManager.chromedriver().driverVersion("107.0.5304.88").setup();
		WebDriver driver = new ChromeDriver(options);
		
		/*
		//Send Keys
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("selenium" + Keys.ENTER);
		
		
		//KeyDown
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("selenium" + Keys.ENTER);
		
		Actions actionProvider = new Actions(driver);
		Action keydown = actionProvider.keyDown(Keys.CONTROL).sendKeys("a").build();
		keydown.perform();
		
		*/
		
		//KeyUp
		driver.get("https://google.com");
		Actions action2 = new Actions(driver);
		WebElement searchBox = driver.findElement(By.name("q"));
		action2.keyDown(Keys.SHIFT).sendKeys(searchBox, "selenium")
		.keyUp(Keys.SHIFT).sendKeys("selenium").perform();
		Thread.sleep(2000);
		searchBox.clear();
		
		
		Thread.sleep(2000);
		//driver.quit();
	
}
}
