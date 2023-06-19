package SessionSel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testng123 {
	WebDriver driver;
	@BeforeTest
	public void start()
	{
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		driver.get("https://www.google.com");
	}
	
	@Test
	public void setup()
	{
	      
	      String googletitile=driver.getTitle();
		Assert.assertEquals(googletitile, "Google");
	      
	      
	}
	@Test
	public void search()
	{
	       driver.findElement(By.xpath("//textarea[@title='Search']")).sendKeys("hello");	
	    	      
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		
	}
}
