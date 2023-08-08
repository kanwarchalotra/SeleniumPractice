package SessionSel;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class alertviajavascript {

	public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.google.com");
		
	JavascriptExecutor js=(JavascriptExecutor)driver;
		
	//js.executeScript("window.alert('hello im there');");
	
	// using js create a prompt in "www.googl.com"
	js.executeScript("window.prompt('Enter your name: ');");

	
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.alertIsPresent());
	//driver.switchTo().alert().accept();		
	
	// Switching to alert and passing name "johndoe"
	driver.switchTo().alert().sendKeys("johndoe");
	
	// clicking ok button in alert prompt
	driver.switchTo().alert().accept();
	
	
	}
	
	
}
