package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseActions {
	public static void main(String[] args) throws InterruptedException {
		//Create New Chrome Option and pass to web driver. 
		ChromeOptions options = new ChromeOptions();
		//Wait for all resources to be loaded - With NORMAL, some load with EAGER and no wait with NONE
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		
		//Adding specific version of chrome 
		WebDriverManager.chromedriver().driverVersion("107.0.5304.88").setup();
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		/*
		driver.get("https://selenium08.blogspot.com/2020/01/click-and-hold.html");
		WebElement boxA =  driver.findElement(By.xpath("//li[text() = 'A']"));
		WebElement boxD =  driver.findElement(By.xpath("//li[text() = 'D']"));
		
		//move mouse to element a
		Actions actions = new Actions(driver);
		//actions.moveToElement(boxA);
		//actions.clickAndHold();
		//actions.moveToElement(boxD);
		actions.doubleClick(boxD);
		
		actions.build().perform();
		*/
		
		//Drag and Drop Demo
		driver.get("https://selenium08.blogspot.com/2020/01/drag-drop.html");
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));
		
		Actions actions = new Actions(driver);
		actions.dragAndDrop(drag, drop);
		actions.build().perform();
		
		
		Thread.sleep(2000);
		driver.quit();
		System.out.println("Done");
	}
}
