package Assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker {

	WebDriver driver;

	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/automation-practice-form");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(180));
	}

	@Test
	public void datePicker() {

		driver.findElement(By.id("firstName")).sendKeys("jon");
		driver.findElement(By.id("lastName")).sendKeys("doe");
		driver.findElement(By.id("userEmail")).sendKeys("jondoe@gmail.com");
		Actions action=new Actions(driver);
		WebElement clicke=driver.findElement(By.xpath("//*[@id='gender-radio-1']"));

		action.click(clicke).perform();

		driver.findElement(By.id("dateOfBirthInput")).click();
		WebElement datePick = driver.findElement(By.className("react-datepicker__month-select"));

		Select slt = new Select(datePick);
		slt.selectByVisibleText("April");
		WebElement yearPick = driver.findElement(By.className("react-datepicker__year-select"));

		Select slt1 = new Select(yearPick);
		slt1.selectByVisibleText("2024");

		List<WebElement> dates = driver.findElements(By.xpath("//*[@class='react-datepicker__month']/div/div"));

		for (WebElement e : dates) {
			if (e.getText().equals("20")) {
				e.click();
				break;
			}
		}

		/*
		 * WebElement
		 * subj=driver.findElement(By.xpath("//*[@id=\"subjectsContainer\"]/div/div[1]")
		 * ); action.moveToElement(subj).sendKeys("Sceince").perform();
		 */
		
		/*
		 * WebElement
		 * check=driver.findElement(By.xpath("//label[normalize-space()='Sports']"));
		 * action.click(check).perform();
		 */
//driver.findElement(By.xpath("//*[@id='uploadPicture']")).sendKeys("");
		driver.findElement(By.id("currentAddress")).sendKeys("Hi, Im john doe and dont remember anyones name");
		driver.findElement(By.xpath("//div[contains(text(),'Select State')]")).click();
		List<WebElement> state=driver.findElements(By.xpath("//div[@class=' css-11unzgr']/div"));
		
		for(WebElement s:state)
		{
			if(s.getText().equals("Uttar Pradesh"))
			{
				s.click();
				break;
			}
		}
		
		driver.findElement(By.id("submit")).click();

	}

}
