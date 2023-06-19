package SessionSel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatProvider {

	WebDriver driver;

	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
	}

	@Test(dataProvider = "dp")
	public void loginBt(String n, String s) throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.name("username")).sendKeys(n);
		driver.findElement(By.name("password")).sendKeys(s);
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//ul[@class='oxd-dropdown-menu']/li[4]/a")).click();
	}

	@DataProvider
	public Object[][] dp() {

		return new Object[][] {

				new Object[] { "Admin", "admin123" }, new Object[] { "Admin", "admin123" },
				 new Object[] { "Admin", "admin123" }, 
				 
		};
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
