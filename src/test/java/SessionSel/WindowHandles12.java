package SessionSel;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.Iterator;
import java.util.Set;

import javax.swing.event.MenuKeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandles12 {
	WebDriver driver;
	Robot rob;

	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/browser-windows");
		driver.manage().window().maximize();
	}

	@Test
	public void windowsTest() throws InterruptedException, AWTException

	{
		Thread.sleep(2000);
		driver.findElement(By.id("tabButton")).click();
		rob = new Robot();
		rob.keyPress(MenuKeyEvent.VK_CONTROL);
		rob.keyPress(MenuKeyEvent.VK_TAB);
		rob.keyRelease(MenuKeyEvent.VK_CONTROL);
		rob.keyRelease(MenuKeyEvent.VK_TAB);

	}

	@Test
	public void windowsTest1() throws InterruptedException, AWTException

	{
		Thread.sleep(2000);
		driver.findElement(By.id("windowButton")).click();
		rob = new Robot();
		rob.keyPress(MenuKeyEvent.VK_ALT);
		rob.keyPress(MenuKeyEvent.VK_TAB);
		rob.keyRelease(MenuKeyEvent.VK_ALT);
		rob.keyRelease(MenuKeyEvent.VK_TAB);

	}

	@Test
	public void windowsTest12() throws InterruptedException, AWTException

	{
		Thread.sleep(3000);
		String parentWindow = driver.getWindowHandle(); // To get any window ID
		System.out.println(parentWindow); // print the window id
		WebElement windowButton = driver.findElement(By.id("windowButton")); // clicking on new window button

		for (int i = 0; i < 3; i++) {
			windowButton.click(); // To click on new window 3 times
		}
		Set<String> allTheWindows = driver.getWindowHandles(); // to get all the open windows id
		System.out.println(allTheWindows); // printing all the open window id

		for (String handle : allTheWindows) {// to get access to all the open windows
			// System.out.println("I want to open google.com in all the windows");
			driver.switchTo().window(handle);// switch to particular windows
			driver.manage().window().maximize(); // all the windows will get maximized

			driver.get("https://www.google.com");// google url will be run in all the open windows
		}
		Thread.sleep(3000);
		driver.switchTo().window(parentWindow); // switching to parent window or a particular window
		driver.get("https://www.gmail.com");// open gmail.com in any window
		Thread.sleep(2000);
		// driver.close();
		String childWindow = driver.getWindowHandle();// to get particular open window

		System.out.println(childWindow);
		driver.manage().window().maximize();
		String lastwindow = "";
		driver.switchTo().window(lastwindow);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
		driver.quit();

	}

}
