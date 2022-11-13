package test;

import java.io.File;
import java.io.IOException;
//import java.awt.Dimension;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {
	/**
	 * @param args
	 * @throws InterruptedException
	 */
	/**
	 * @param args
	 * @throws InterruptedException
	 */
	/**
	 * @param args
	 * @throws InterruptedException
	 * @throws IOException 
	 */
	public static void main(String[] args) throws InterruptedException, IOException {
		//Driver configuration
		//System.setProperty("webdriver.chromedriver.exe", "./drivers/chromedriver.exe");
		
		//Adding specific version of chrome 
		WebDriverManager.chromedriver().driverVersion("107.0.5304.88").setup();
		WebDriver driver = new ChromeDriver();
		
		//Setting global wait times
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		//BASIC Tests
		/*
		//Test Body
		driver.get("https://google.com");
		driver.navigate().to("http://automationstepbystep.com");
		
		//Browser actions
		System.out.println(driver.getCurrentUrl()); 
		System.out.println(driver.getTitle()); 
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
		Thread.sleep(2000);
		driver.navigate().refresh();
		
		//Window switch
		String orginalWindow = driver.getWindowHandle();
		driver.switchTo().window(orginalWindow);
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.switchTo().newWindow(WindowType.TAB);
		driver.switchTo().window(orginalWindow);
		
		
		driver.navigate().to("https://www.selenium.dev/documentation/");
		driver.findElement(By.linkText("IDE")).click();
		
		//Switch to the default window of the page 
	
		driver.switchTo().defaultContent();
		
		
		org.openqa.selenium.Dimension size = driver.manage().window().getSize();
		
		System.out.println(size.getHeight());
		System.out.println(size.getWidth());
		
		driver.manage().window().setSize(new Dimension(800,600));
		
		driver.manage().window().getPosition().getX();
		driver.manage().window().getPosition().getY();
		
		Point position = driver.manage().window().getPosition();
		
		System.out.println(position.getX());
		System.out.println(position.getY());
		
		driver.manage().window().setPosition(new Point(500,00));
		
		
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.manage().window().minimize();
		Thread.sleep(2000);
		driver.manage().window().fullscreen();
		
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("./image.png"));
		
		driver.navigate().to("http://google.com");
		WebElement element = driver.findElement(By.cssSelector(".lnXdpd"));
		File scrFile1 = element.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile1, new File("./image1.png"));
		*/
		
		driver.navigate().to("http://google.com");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement button = driver.findElement(By.name("btnI"));
		String text = (String) js.executeScript("return arguments[0].innerText", button);
		js.executeScript("console.log('Hello World')");
				
		
		Thread.sleep(3000);
		driver.close();
		driver.quit();
		
		
		
		
		
	}
}
