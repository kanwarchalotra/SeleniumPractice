package SessionSel;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {
	WebDriver driver;
	JavascriptExecutor js;
	String nestedFrame = "https://demoqa.com/nestedframes";
	String frame = "\"https://demoqa.com/frames\"";
	

	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// driver.get(frame);
		//driver.get(nestedFrame);
		driver.get("https://demoqa.com/slider");
		driver.manage().window().maximize();
	}
	@Test(enabled = false)
	public void Slider() throws Exception {

        WebElement range=   driver.findElement(By.xpath("/*[@type='range']"));
    
        Actions act=new Actions(driver);
        
        act.dragAndDropBy(range, 0, 35).build().perform();
	}

	@Test(enabled = false)
	public void fram1() throws Exception {

		js = (JavascriptExecutor) driver;
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

		WebElement el = driver.findElement(By.id("frame2"));

		driver.switchTo().frame(el);
		js = (JavascriptExecutor) driver;
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

	}

	@Test
	public void nested() throws Exception {

		js = (JavascriptExecutor) driver;
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

		WebElement el = driver.findElement(By.id("frame1"));

		driver.switchTo().frame(el);

		WebElement ele = driver.findElement(By.tagName("iframe"));

		driver.switchTo().frame(ele);
		String childFrameText = driver.findElement(By.xpath("//*[contains(text(),'Child Iframe')]")).getText();
		System.out.println(childFrameText);

	}

}
