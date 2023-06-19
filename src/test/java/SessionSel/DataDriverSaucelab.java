package SessionSel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataDriverSaucelab {

	WebDriver dr;
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		dr = new ChromeDriver();
		dr.get("https://www.saucedemo.com/");
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	@Test
	public void drivenSetup() throws IOException {
		File excel = new File("C:\\Users\\knwrp\\OneDrive\\Desktop\\SauceDemoTestData.xlsx");
		FileInputStream fis = new FileInputStream(excel);
		
		XSSFWorkbook book = new XSSFWorkbook(fis);// telling that its an excel file
		XSSFSheet sheet = book.getSheet("Sheet1");//
		int rowcount = sheet.getLastRowNum();// fetches the data till the last row
		for (int i = 0; i <= rowcount; i++) {
			String username = sheet.getRow(i).getCell(0).getStringCellValue();
			String password = sheet.getRow(i).getCell(1).getStringCellValue();
			dr.findElement(By.name("user-name")).clear();
			dr.findElement(By.name("user-name")).sendKeys(username);
			dr.findElement(By.name("password")).clear();

			dr.findElement(By.name("password")).sendKeys(password);
			dr.findElement(By.xpath("//*[@type='submit']")).click();

			if (dr.getCurrentUrl().equalsIgnoreCase("https://www.saucedemo.com/inventory.html")) {
				dr.findElement(By.id("react-burger-menu-btn")).click();
				dr.findElement(By.id("logout_sidebar_link")).click();
			} else if (dr
					.findElement(
							By.xpath("//*[contains(text(),'Epic sadface: Sorry, this user has been locked out.')]"))
					.isDisplayed()) {
				for (int j = i + 1; j <= rowcount; j++) {
					String username1 = sheet.getRow(j).getCell(0).getStringCellValue();
					String password1 = sheet.getRow(j).getCell(1).getStringCellValue(); // negative credi
					dr.findElement(By.name("user-name")).clear();
					dr.findElement(By.name("user-name")).sendKeys(username1);
					dr.findElement(By.name("password")).clear();
					dr.findElement(By.name("password")).sendKeys(password1);
					dr.findElement(By.xpath("//*[@type='submit']")).click();

					if (dr.getCurrentUrl().equalsIgnoreCase("https://www.saucedemo.com/inventory.html")) {
						dr.findElement(By.id("react-burger-menu-btn")).click();
						dr.findElement(By.id("logout_sidebar_link")).click();
					}
				}
				break;
			}

		}
	}

}
