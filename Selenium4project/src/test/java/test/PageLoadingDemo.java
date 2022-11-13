package test;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PageLoadingDemo {
	public static void main(String[] args) {
		
		//Create New Chrome Option and pass to web driver. 
		ChromeOptions options = new ChromeOptions();
		//Wait for all resources to be loaded - With NORMAL, some load with EAGER and no wait with NONE
		options.setPageLoadStrategy(PageLoadStrategy.NONE);
		
		//Adding specific version of chrome 
		WebDriverManager.chromedriver().driverVersion("107.0.5304.88").setup();
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://google.com");
		driver.quit();
		
	}
}
