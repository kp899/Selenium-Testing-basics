package test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {
	public static void main(String[] args) throws InterruptedException {
		//Create New Chrome Option and pass to web driver. 
		ChromeOptions options = new ChromeOptions();
		//Wait for all resources to be loaded - With NORMAL, some load with EAGER and no wait with NONE
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		
		//Adding specific version of chrome 
		WebDriverManager.chromedriver().driverVersion("107.0.5304.88").setup();
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://trytestingthis.netlify.app/");
		
		WebElement dropdown = driver.findElement(By.id("owc"));
		
		Select selectObject = new Select(dropdown);
		
		selectObject.selectByIndex(1);
		Thread.sleep(1000);
		selectObject.selectByValue("option 2");
		Thread.sleep(1000);
		selectObject.deselectByVisibleText("Option 3");
		
		
		/*
		List<WebElement> allAvailableoptions = selectObject.getOptions();
		List<WebElement> alloptions = driver.findElements(By.id("option"));
		
		
		for(WebElement option: alloptions) {
			System.out.println(option.getText());
			if(option.getText().equalsIgnoreCase("option 2"))
				option.click();
			
			Thread.sleep(1000);
		}
		*/
		
		Thread.sleep(2000);
		driver.quit();
		System.out.println("Done");
	}
}
