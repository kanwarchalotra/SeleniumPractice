package Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class formherok {
	WebDriver driver;
	
	@BeforeTest
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");
		driver.manage().window().maximize();
	}

	
	@Test
	public void formDetails()
	{
		
		driver.findElement(By.name("username")).sendKeys("Jon doe");
		driver.findElement(By.name("password")).sendKeys("jon@123");
		driver.findElement(By.xpath("//*[@name='comments']")).sendKeys("Hi, Im Jon and im doing great. Currently try to automate the text");
		driver.findElement(By.xpath("(//*[@type='checkbox'])[1]")).click();
		driver.findElement(By.xpath("(//*[@type='radio'])[1]")).click();
		WebElement multiSelect=driver.findElement(By.name("multipleselect[]"));
		Select select=new Select(multiSelect);
		select.selectByValue("ms1");
		select.deselectByValue("ms4");
		WebElement dropdown=driver.findElement(By.name("dropdown"));
		Select select1=new Select(dropdown);
        select1.selectByValue("dd3");
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(180));
      WebElement submit=driver.findElement(By.xpath("//*[@type='submit']"));
      wait.until(ExpectedConditions.elementToBeClickable(submit));   
      submit.click();
      String sucessMesg=driver.findElement(By.xpath("(//div/p)[1]")).getText(); 
      Assert.assertTrue(sucessMesg.contains("You submitted a form. "));
 
	}

	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
}
