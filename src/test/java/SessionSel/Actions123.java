package SessionSel;

import java.awt.AWTException;
import java.awt.Robot;

import javax.swing.event.MenuKeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Actions123 {
	WebDriver driver;
	Robot rob;

	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// driver.get("https://www.google.com");
		// driver.get("https://demoqa.com");
		driver.get("https://demoqa.com/automation-practice-form");
		driver.manage().window().maximize();
	}

	@Test
	public void test1() throws InterruptedException, AWTException {
		WebElement gmailclick = driver.findElement(By.xpath("(//*[@class='gb_t'])[1]"));
		Actions act = new Actions(driver);
		// act.contextClick(gmailclick).build().perform();
		/*
		 * Robot rob=new Robot(); Thread.sleep(2000);
		 * rob.keyPress(MenuKeyEvent.VK_DOWN); Thread.sleep(2000);
		 * rob.keyPress(MenuKeyEvent.VK_DOWN); rob.keyPress(MenuKeyEvent.VK_ENTER);
		 * Thread.sleep(2000); //rob.keyPress(MenuKeyEvent.VK_CONTROL);
		 * Thread.sleep(2000); rob.keyPress(MenuKeyEvent.VK_ALT);
		 * rob.keyPress(MenuKeyEvent.VK_TAB);
		 * 
		 * 
		 * rob.keyPress(MenuKeyEvent.VK_TAB); //rob.keyRelease(MenuKeyEvent.VK_CONTROL);
		 * //rob.keyRelease(MenuKeyEvent.VK_TAB); rob.keyRelease(MenuKeyEvent.VK_ALT);
		 * rob.keyRelease(MenuKeyEvent.VK_TAB);
		 */

		// act.moveToElement(gmailclick).build().perform();
		WebElement images = driver.findElement(By.linkText("Images"));
		act.moveToElement(images).build().perform();

		// act.keyDown(Keys.ARROW_UP).build().perform();
		// Thread.sleep(2000);
		// act.keyDown(Keys.ENTER).build().perform();

	}

	@Test
	public void test2() throws AWTException, Exception {
		rob = new Robot();
		Thread.sleep(2000);
		rob.mouseWheel(2);
	}
	// act.keyDown(Keys.ENTER).build().perform();

	@Test
	public void test23() throws AWTException, Exception {
		rob = new Robot();
		/*
		 * rob.keyPress(MenuKeyEvent.VK_CONTROL); rob.keyPress(MenuKeyEvent.VK_ADD);
		 * rob.keyRelease(MenuKeyEvent.VK_ADD); Thread.sleep(1000);
		 * rob.keyPress(MenuKeyEvent.VK_ADD); rob.keyRelease(MenuKeyEvent.VK_ADD);
		 * Thread.sleep(1000); rob.keyPress(MenuKeyEvent.VK_ADD);
		 * rob.keyRelease(MenuKeyEvent.VK_ADD); Thread.sleep(2000);
		 * rob.keyRelease(MenuKeyEvent.VK_CONTROL); rob.keyRelease(MenuKeyEvent.VK_ADD);
		 */
		rob.keyPress(MenuKeyEvent.VK_PAGE_DOWN);
		rob.keyRelease(MenuKeyEvent.VK_PAGE_DOWN);
		rob.keyPress(MenuKeyEvent.VK_CONTROL);
		rob.keyPress(MenuKeyEvent.VK_F);
		rob.keyRelease(MenuKeyEvent.VK_PAGE_DOWN);
		rob.keyRelease(MenuKeyEvent.VK_CONTROL);
		rob.keyRelease(MenuKeyEvent.VK_F);
		Thread.sleep(1000);
		rob.keyPress(MenuKeyEvent.VK_T);
		rob.keyRelease(MenuKeyEvent.VK_T);
		rob.keyPress(MenuKeyEvent.VK_O);
		rob.keyRelease(MenuKeyEvent.VK_O);


		
		/*
		 * rob.keyPress(MenuKeyEvent.VK_CONTROL);
		 * rob.keyPress(MenuKeyEvent.VK_SUBTRACT);
		 * rob.keyPress(MenuKeyEvent.VK_CONTROL);
		 * rob.keyPress(MenuKeyEvent.VK_SUBTRACT);
		 * rob.keyPress(MenuKeyEvent.VK_CONTROL);
		 * rob.keyPress(MenuKeyEvent.VK_SUBTRACT);
		 * rob.keyPress(MenuKeyEvent.VK_CONTROL);
		 * rob.keyPress(MenuKeyEvent.VK_SUBTRACT);
		 * rob.keyPress(MenuKeyEvent.VK_CONTROL);
		 * rob.keyPress(MenuKeyEvent.VK_SUBTRACT);
		 */

	}

}
