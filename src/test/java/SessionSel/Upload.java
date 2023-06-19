package SessionSel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Upload {
	WebDriver driver;
	@BeforeTest
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://demoqa.com/upload-download");
		driver.manage().window().maximize();
	}
	
	@Test
	public void upload() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.id("uploadFile")).sendKeys("C:\\Users\\knwrp\\OneDrive\\Pictures\\ProfessionalPhoto.jpeg");
	}
	@Test
	public void download() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.id("downloadButton")).sendKeys("C:\\Users\\knwrp\\Downloads");
	}


}
