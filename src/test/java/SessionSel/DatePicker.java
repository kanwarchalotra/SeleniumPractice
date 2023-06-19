package SessionSel;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker {
	WebDriver driver;
	
@BeforeTest
public void setup()
{
 WebDriverManager.chromedriver().setup();
 driver=new ChromeDriver();
 driver.get("https://www.ksrtc.in/oprs-web/");
 driver.manage().window().maximize();
 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	
}

@Test
public void datePicker()
{
	//driver.findElement(By.xpath("(//*[@class='ui-datepicker-title']/span)[1]")).sendKeys("June");
	
	/*
	 * List<WebElement> date =driver.findElements(By.xpath("//tbody/tr/td"));
	 * 
	 * for(WebElement e:date) { if(e.getText().equals("29")) { e.click(); break; }
	 * 
	 * 
	 * 
	 * }
	 */
	driver.findElement(By.id("txtJourneyDate")).click();

	String dates="30";
	WebElement date=driver.findElement(By.xpath("(//*[@class='ui-state-default'])["+dates+"]"));
	
	Actions act=new Actions(driver);
	act.click(date).build().perform();
	
	
	
	
	
}
	
	

}
