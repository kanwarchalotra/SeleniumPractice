package SessionSel;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alertss {

	WebDriver driver;
	public String URL="https://www.ksrtc.in/oprs-web/";
	public String URL1="https://demoqa.com/alerts";
	

	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(URL1);
		driver.manage().window().maximize();
		

	}
	@Test
	public void ksrtcalert() throws Exception{
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='col-md-22 mb-1 booking-input']/button")).click();
		Alert alt=driver.switchTo().alert();
		Thread.sleep(2000);
		alt.accept();
		
	}
	

	@Test(enabled = false)
	public void alertsMethods() throws Exception{

		driver.findElement(By.id("alertButton")).click();
		Alert alt=driver.switchTo().alert();
		Thread.sleep(2000);
		alt.accept();
		
	}
	@Test
	public void alertsMethodsfor5sec() {

		driver.findElement(By.id("timerAlertButton")).click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(180)); // Explicit wait--> will wait for the web element or the alert
		// till it appears
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alt=driver.switchTo().alert();
		alt.accept();
				
	}
	@Test
	public void confirmbutDismiss() throws Exception{

		driver.findElement(By.id("confirmButton")).click();
		Alert alt=driver.switchTo().alert();
		Thread.sleep(2000);
		alt.dismiss();
				
	}
	@Test
	public void promptbox() throws Exception{

		driver.findElement(By.id("promtButton")).click();
		Alert alt=driver.switchTo().alert();
		Thread.sleep(2000);
		alt.sendKeys("jagancorruptedleader");
		Thread.sleep(2000);
				alt.accept();
	}
	
	
}
