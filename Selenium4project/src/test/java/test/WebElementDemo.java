package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementDemo {
	public static void main(String[] args) throws InterruptedException {
		
		//Create New Chrome Option and pass to web driver. 
		ChromeOptions options = new ChromeOptions();
		//Wait for all resources to be loaded - With NORMAL, some load with EAGER and no wait with NONE
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		
		//Adding specific version of chrome 
		WebDriverManager.chromedriver().driverVersion("107.0.5304.88").setup();
		WebDriver driver = new ChromeDriver(options);
		
	
		// Find single Elements Demo
		driver.get("https://google.com");
		WebElement searchBox =  driver.findElement(By.name("q"));
		searchBox.sendKeys("selenium" + Keys.ENTER);
		//driver.findElement(By.name("btnK"));
		
		
		
		//find multiple Elements via lists
		driver.get("https://trytestingthis.netlify.app/");
		List<WebElement> elements =  driver.findElements(By.tagName("select"));
		
		for(WebElement element: elements) {
			System.out.println(element.getText());
		}
		
		
		
		//find element within element
		driver.get("https://google.com");
		WebElement form = driver.findElement(By.tagName("form"));
		form.findElement(By.name("q")).sendKeys("ABCD" + Keys.ENTER);
		
		
		//How to get active element
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("selenium");
		String title = driver.switchTo().activeElement().getAttribute("title");
		System.out.println(title); 
	
		
		//get tagname, text, css etc
		driver.get("https://google.com");
		WebElement searchBox2 =  driver.findElement(By.name("q"));
		String TagName =searchBox2.getTagName();
		String Text = searchBox2.getText();
		String cssValue = searchBox2.getCssValue("color");
		System.out.println(TagName  + "  |  " + Text + "  |  " + cssValue);
		
		
		//Check Element is enabled, is selected
		driver.get("https://the-internet.herokuapp.com/checkboxes");
		WebElement checkbox =  driver.findElement(By.xpath("(//input[@type = 'checkbox'])[2]"));
		System.out.println(checkbox.isEnabled());
		System.out.println(checkbox.isSelected());
		
		Thread.sleep(1000);
		driver.quit();
		
	}
}
