package test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTest {
	public static void main(String[] args) {
		
		//Driver configuration
		//System.setProperty("webdriver.chromedriver.exe", "./drivers/chromedriver.exe");
		
		//Adding specific version of chrome 
		WebDriverManager.chromedriver().driverVersion("107.0.5304.88").setup();
		WebDriver driver = new ChromeDriver();
		
		//Setting global wait times
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		//Test Body
		driver.get("https://google.com");
		driver.close();
		
	}
}
