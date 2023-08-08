package SessionSel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class scroll {
	
	public static void main(String args[]) throws Exception
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.myntra.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	JavascriptExecutor js=(JavascriptExecutor)driver;
		
	    //js.executeScript("scrollTo(0,1000);");
	    //js.executeScript("scrollTo(0,-1000);");
		
	  WebElement scrollto= driver.findElement(By.xpath("//*[text()='MYNTRA LUXE']"));
	  Thread.sleep(5000);

	  js.executeScript("arguments[0].scrollIntoView();", scrollto);
	 // Thread.sleep(5000);
	   // driver.close();
		
	}
	

}
