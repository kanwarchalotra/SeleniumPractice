package SessionSel;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class orangHRMWindow {

	WebDriver driver;
	
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(180));
	}

	
	@Test
	public void window()
	{
		
		driver.findElement(By.xpath("//*[@class='oxd-text oxd-text--p orangehrm-copyright']/a")).click();
	   Set<String> window=driver.getWindowHandles();
		ArrayList<String> fe=new ArrayList<String>(window);
	
		System.out.println("My parent window is "+fe.get(0));
		System.out.println("My child window is "+fe.get(1));

		String parentwindow=fe.get(0);
		String childwindow=fe.get(1);

       driver.switchTo().window(childwindow);
       System.out.println(driver.getTitle());
       driver.get("https://www.google.com");
       
       System.out.println(driver.getCurrentUrl());
       driver.switchTo().window(parentwindow);
       System.out.println(driver.getTitle());
       
       System.out.println(driver.getCurrentUrl());

	}

}
