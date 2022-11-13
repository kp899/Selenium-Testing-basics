package test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Elements {
	public static void main(String[] args) throws InterruptedException {
		
		//Driver configuration
		//System.setProperty("webdriver.chromedriver.exe", "./drivers/chromedriver.exe");
		
		//Adding specific version of chrome 
		WebDriverManager.chromedriver().driverVersion("107.0.5304.88").setup();
		WebDriver driver = new ChromeDriver();
		
		//Setting global wait times
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		/*/Test Body
		driver.get("https://google.com");
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("ABCD", Keys.ENTER);
	
		
		driver.navigate().to("https://trytestingthis.netlify.app/");
		List<WebElement> options = driver.findElements(By.name("Optionwithcheck[]"));
		
		for(WebElement element : options) {
			System.out.println(element.getText());
		}
			
		
		driver.findElement(By.cssSelector("#fname")).sendKeys("Komal");
		
		
		
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		WebElement loginButton = driver.findElement(By.id("btnLogin"));
		driver.findElement(RelativeLocator.with(By.tagName("input")).above(loginButton)).sendKeys("ABCD");
		
		*/
		
		Thread.sleep(1000);
		driver.close();
		driver.quit();
	}
}
