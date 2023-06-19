package Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddingAndDeletingWebTable {
	WebDriver driver;
	@BeforeTest
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
	 driver=new ChromeDriver();	
	 driver.get("https://demoqa.com/webtables");
	 driver.manage().window().maximize();
	}
	
	
	@Test
	public void newAddRecord()
	{
		driver.findElement(By.id("addNewRecordButton")).click();
		driver.findElement(By.id("firstName")).sendKeys("jon");
		driver.findElement(By.id("lastName")).sendKeys("doe");
		driver.findElement(By.id("userEmail")).sendKeys("jondoe@gmail.com");
		driver.findElement(By.id("age")).sendKeys("23");
		driver.findElement(By.id("salary")).sendKeys("40000");
		driver.findElement(By.id("department")).sendKeys("growth ");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		driver.findElement(By.xpath("//span[@id='edit-record-3']//*[name()='svg']")).click();
		driver.findElement(By.id("lastName")).clear();
		driver.findElement(By.id("lastName")).sendKeys("group1");
		driver.findElement(By.xpath("//*[@type='submit']")).click();



		

	}

}
