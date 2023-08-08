package SessionSel;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class demoqa {

	
@Test
public void demoqatest()
{
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("https://demoqa.com/buttons");
	driver.manage().window().maximize();
	
	Actions act=new Actions(driver);
	WebElement doubleclick=driver.findElement(By.id("doubleClickBtn"));
	WebElement rightclick=driver.findElement(By.id("rightClickBtn"));
	WebElement clickme=driver.findElement(By.id("cfuPn"));
	
	//act.doubleClick(doubleclick).perform();
	act.contextClick(rightclick);
	//act.click(clickme);
	
	
	    }
}

	

