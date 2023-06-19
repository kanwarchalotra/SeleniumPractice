package Assignment;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationPracticeRahul {
	WebDriver driver;

	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();

	}

	@Test
	public void radioButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(180));

		WebElement element = driver.findElement(By.xpath("//*[@value='radio1']"));
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();

	}

	@Test
	public void sugestionClass() throws InterruptedException {
		// Need to check with madhu

		String countryName = "India";
		driver.findElement(By.id("autocomplete")).sendKeys(countryName);
		

		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(180));

	//	driver.findElement(By.xpath("//*[contains(text(),'countryName')]")).click();

//List<WebElement> countryList= driver.findElements(By.xpath("//ul[@id='ui-id-1']/li/div"));
		/*
		 * wait.until(ExpectedConditions.visibilityOfAllElements(countryList));
		 * System.out.println(countryList.size()); for(WebElement e:countryList) {
		 * e.getText().equalsIgnoreCase(countryName); e.click(); break; }
		 */
	}

	@Test
	public void dropdown() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(180));

		WebElement dpdown = driver.findElement(By.id("dropdown-class-example"));
		wait.until(ExpectedConditions.visibilityOf(dpdown));

		Select select = new Select(dpdown);
		select.selectByVisibleText("Option2");
	}

	@Test
	public void checkbox() {
		String checkOptions = "checkBoxOption1";
		// checkBoxOption2
		// checkBoxOption3

		driver.findElement(By.id(checkOptions)).click();
	}
	@Test
	public void switchToAlert() {

		driver.findElement(By.name("enter-name")).sendKeys("Hello");
		driver.findElement(By.id("alertbtn")).click();
		Alert alt = driver.switchTo().alert();
		alt.accept();
	}
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
