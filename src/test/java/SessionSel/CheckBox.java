package SessionSel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBox {
	WebDriver driver;
	public String URL1="https://demoqa.com/checkbox";
	public String URL2="https://demoqa.com/radio-button";
	public String URL3="https://rahulshettyacademy.com/AutomationPractice/";
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(URL3);
		driver.manage().window().maximize();

	}
	
	@Test
	public void checkbox() throws InterruptedException
	{
		Thread.sleep(4000);
		//driver.findElement(By.xpath("//*[@class='rct-checkbox']")).click();
		driver.findElement(By.name("radioButton")).click();
		
	}
	
	
	
}
