package SessionSel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavScriptexecutora {
	
	
	
	WebDriver driver;

	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//driver.get("https://www.justdail.com/");
		//driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(180));
	}

	
	
	
	@Test
	public void jsp()
	{
		//Scroll to top of the page
		/*
		 * JavascriptExecutor js = ((JavascriptExecutor) driver);
		 * js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		 * 
		 */
		
		     JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("document.getElementById('password').value='secret_sauce';");

		js.executeScript("document.getElementById('password').value='secret_sauce';");
	}
	
	
	@Test
	public void jsp1() throws InterruptedException
	{
		/*
		 * driver.findElement(By.name("username")).sendKeys("Admin");
		 * driver.findElement(By.name("password")).sendKeys("admin123");
		 * driver.findElement(By.xpath("//*[@type='submit']")).click();
		 */
		/*
		 * WebElement scrollOrange= driver.findElement(By.
		 * xpath("//*[@class='oxd-text oxd-text--p orangehrm-copyright']/a")); // to
		 * scroll to some extent JavascriptExecutor jse = (JavascriptExecutor)driver;
		 * jse.executeScript("window.scrollTo(0,1000)");
		 * 
		 * //scrollOrange.click();
		 */		
		
	//WebElement orngLink=driver.findElement(By.xpath("oxd-text oxd-text--p orangehrm-copyright"));
		
	JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("document.getElementById('mousehover').scrollIntoView()");
		/*
		 * js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		 * Thread.sleep(3000);
		 * js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		 */
		String title=js.executeScript("return document.title").toString();
		String url=js.executeScript("return document.URL").toString();
System.out.println(title);
System.out.println(url);
		
	}

	
	
	@Test
	public void sauceLab()
	{
		/*
		 * document.getElementById('user-name').value='standard_user';
'standard_user'
document.getElementById('password').value='secret_sauce';
'secret_sauce'
		 */
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript(" document.getElementById('user-name').value='standard_user';");
		js.executeScript(" document.getElementById('password').value='secret_sauce';");
		js.executeScript(" document.getElementById('login-button').click();");

	}


}
