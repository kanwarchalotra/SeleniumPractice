package SessionSel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testNG {
	WebDriver driver;

	@BeforeTest
	public void setup() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
	}
	@Test(priority = 1)
	public void login() throws InterruptedException {
       WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    // WebElement user=driver.findElement(By.name("username"));
     
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))); 
      
       driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		  WebElement logBtn= driver.findElement(By.xpath("//*[@type='submit']"));
		  Actions act=new Actions(driver);
		act.click(logBtn).build().perform();
	//	  act.contextClick(logBtn).build().perform();

		Thread.sleep(2000);
		// thread.sleep---- it will pause the test for that particular time .
		
		// implicit wait-----for all the findelement and findelements
		//explict wait------ used to wait for a particular element or conditions, can be used to wait on titles,alerts,frames
		
		
	}
	@Test(priority = 2)
	public void adminSearch() throws InterruptedException {
		driver.findElement(By.linkText("Admin")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[@class='oxd-input oxd-input--active'])[2]")).sendKeys("Alice.Duval");
		driver.findElement(By.xpath("(//*[@class='oxd-select-text--after'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[contains(text(),'ESS')]")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='oxd-icon bi-trash']")).click();
	
	}

	@Test(enabled = false)
	public void logout() throws InterruptedException {

		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//ul[@class='oxd-dropdown-menu']/li[4]/a")).click();
	}

	@AfterTest
	public void tearDown() {
		// driver.close();
	}
}
