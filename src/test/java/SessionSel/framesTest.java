package SessionSel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class framesTest {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement Tframe=driver.findElement(By.name("frame-top"));
		driver.switchTo().frame(Tframe);
		WebElement lframe=driver.findElement(By.name("frame-left"));
		driver.switchTo().frame(lframe);
		String leftframe=driver.findElement(By.xpath("//*[contains(text(),'LEFT')]")).getText();
		System.out.println(leftframe);

	}

}
