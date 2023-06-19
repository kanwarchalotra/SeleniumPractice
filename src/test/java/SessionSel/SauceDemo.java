package SessionSel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SauceDemo {
	WebDriver driver;

	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
	}

	@Test(dataProvider = "dp")
	public void sauceDemo(String s, String p) throws Exception {

		driver.findElement(By.id("user-name")).clear();

		driver.findElement(By.id("user-name")).sendKeys(s);

		Thread.sleep(2000);
		driver.findElement(By.id("password")).clear();

		driver.findElement(By.id("password")).sendKeys(p);

		Thread.sleep(2000);

		driver.findElement(By.id("login-button")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@class='bm-burger-button']/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("logout_sidebar_link")).click();
	}

	@DataProvider
	public Object[][] dp() {

		return new Object[][] { 
				new Object[] { "standard_user", "secret_sauce" }, 
				new Object[] { "problem_user", "secret_sauce" },
				new Object[] { "performance_glitch_user", "secret_sauce" },

		};
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
