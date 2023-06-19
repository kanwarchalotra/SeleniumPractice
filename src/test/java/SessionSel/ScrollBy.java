package SessionSel;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollBy {
	
	WebDriver driver;
	@BeforeTest
	public void setup()
	
	{
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void set() throws InterruptedException
	{
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,400)"); // from top to botton
	Thread.sleep(2000);

	js.executeScript("window.scrollBy(0,-400)"); // from bottom to top

	}

}
