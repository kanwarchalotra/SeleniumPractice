package Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class demoqaButtons {
	WebDriver driver;
	Actions act;
	@BeforeTest
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		driver.get("https://demoqa.com/buttons");
		driver.manage().window().maximize();
	}

	
	@Test
	public void clickMe()
	{
		//driver.findElement(By.xpath("(//*[@type=\"button\"])[4]")).click();
	WebElement clickme=driver.findElement(By.xpath("(//*[@type=\"button\"])[4]"));
	act=new Actions(driver);
	act.click(clickme).build().perform();
	
	}
	
	

	@Test
	public void rightClick()
	{
		
		Actions action=new Actions(driver);

	WebElement rightClick=driver.findElement(By.id("rightClickBtn"));
		action.contextClick(rightClick).perform();
		
		
	}

	@Test
	public void doubleClick()
	{
		
		Actions action=new Actions(driver);

	WebElement doubleclick=driver.findElement(By.id("doubleClickBtn"));
		action.doubleClick(doubleclick).perform();
		
		
	}	
	
	
}
