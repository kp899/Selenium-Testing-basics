package test;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts {
	public static void main(String[] args) throws InterruptedException {
		
		//Adding specific version of chrome 
		WebDriverManager.chromedriver().driverVersion("107.0.5304.88").setup();
		WebDriver driver = new ChromeDriver();
		
		//Implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		//JS Alert
		//WebElement firstAlert = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
		
		//Explicit Wait
		WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(10));
		WebElement firstAlert =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@onclick='jsAlert()']")));
		firstAlert.click();
		
		//firstAlert.click();
		Alert alert1 = driver.switchTo().alert();
		System.out.println(alert1.getText()); 
		Thread.sleep(2000);
		alert1.accept();
		if(driver.getPageSource().contains("You Successfully clicked an alert"));
		System.out.println("You Successfully clicked an alert");
		System.out.println("=============");
		

		
		//js confirm box
		
		driver.navigate().refresh(); // Page Refresh
		
		//Explicit Wait
		WebDriverWait wait2 = new WebDriverWait (driver, Duration.ofSeconds(10));
		WebElement secondAlert =  wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@onclick='jsConfirm()']")));
		secondAlert.click();
		
		//firstAlert.click();
		Alert alert2 = driver.switchTo().alert();
		Thread.sleep(2000);
		alert2.dismiss();
		
		if(driver.getPageSource().contains("You clicked: Cancel"));
		System.out.println("You clicked: Cancel");
		System.out.println("=============");
		
		//Js prompt
		
		driver.navigate().refresh(); // Page Refresh
		
		//Explicit Wait
		WebDriverWait wait3 = new WebDriverWait (driver, Duration.ofSeconds(10));
		WebElement thirdAlert =  wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@onclick='jsPrompt()']")));
		thirdAlert.click();
		
		Alert alert3 = driver.switchTo().alert();
		Thread.sleep(2000);
		alert3.sendKeys("Automation Step By Step");
		alert3.accept();
		
		if(driver.getPageSource().contains("You entered: Automation Step By Step"));
		System.out.println("You entered: Automation Step By Step");
		System.out.println("=============");
	
		
		driver.close();
		driver.quit();
	}
}
