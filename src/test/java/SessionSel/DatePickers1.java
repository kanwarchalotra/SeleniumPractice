package SessionSel;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePickers1 {
	WebDriver dr;

	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		dr = new ChromeDriver();
		dr.get("https://demoqa.com/date-picker");
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(180));
	}

	@Test
	public void datePickerWithTime() {
		dr.findElement(By.id("dateAndTimePickerInput")).click();
		dr.findElement(By.xpath("//*[@class='react-datepicker__month-read-view--down-arrow']")).click();
		List<WebElement> monthPick = dr.findElements(By.xpath("//*[@class='react-datepicker__month-dropdown']/div"));
		System.out.println(monthPick);
		for (WebElement e : monthPick) {
			if (e.getText().equalsIgnoreCase("July")) {
				// act.click(e);
				e.click();
				break;
			}
		}
		dr.findElement(By.xpath("//*[@class='react-datepicker__year-read-view--down-arrow']")).click();
		List<WebElement> datePick = dr.findElements(By.xpath("//*[@class='react-datepicker__year-dropdown']/div"));
		System.out.println(datePick);
		List<WebElement> days = dr.findElements(By.xpath("//*[@class='react-datepicker__week']/div"));
		System.out.println(days);
		for (WebElement e : days) {
			if (e.getText().equalsIgnoreCase("14")) {
				// act.click(e);
				e.click();
				break;
			}
			List<WebElement> time = dr.findElements(By.xpath("//*[@class='react-datepicker__time-list']/li"));
			System.out.println(time);
			for (WebElement f : time) {
				if (f.getText().equalsIgnoreCase("05:45")) {
					// act.click(e);
					f.click();
					break;
				}
			}
		}
	}
}
