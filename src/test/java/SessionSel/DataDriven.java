package SessionSel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataDriven {

	WebDriver dr;

	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		dr = new ChromeDriver();
		dr.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	@Test
	public void dataDriven() throws IOException {
		// C:\Users\knwrp\OneDrive\Desktop

		
		        // C:\Users\knwrp\OneDrive\Desktop

		        File excel = new File("C:\\Users\\knwrp\\OneDrive\\Desktop\\orangehrmtestdata.xlsx");
		        FileInputStream fis = new FileInputStream(excel);
		        XSSFWorkbook book = new XSSFWorkbook(fis);// telling that its an excel file
		        XSSFSheet sheet = book.getSheet("Sheet1");//

		        int rowcount = sheet.getLastRowNum();// fetches the data till the last row
		        for (int i = 0; i <= rowcount; i++) {
		            String username = sheet.getRow(i).getCell(0).getStringCellValue();
		            String password = sheet.getRow(i).getCell(1).getStringCellValue();
		            dr.findElement(By.name("username")).sendKeys(username);
		            dr.findElement(By.name("password")).sendKeys(password);
		            dr.findElement(By.xpath("//*[@type='submit']")).click();

		            if (dr.getCurrentUrl()
		                    .equalsIgnoreCase("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index")) {
		                dr.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();

		                dr.findElement(By.xpath("//ul[@class='oxd-dropdown-menu']/li[4]/a")).click();
		            
		            } else if (dr.findElement(By.xpath("//*[@class='oxd-alert-content oxd-alert-content--error']"))
		                    .isDisplayed()) {
		                for (int j = i + 1; j <= rowcount; j++) {
		                    String username1 = sheet.getRow(j).getCell(0).getStringCellValue();
		                    String password1 = sheet.getRow(j).getCell(1).getStringCellValue();
		                    dr.findElement(By.name("username")).sendKeys(username1);
		                    dr.findElement(By.name("password")).sendKeys(password1);
		                    dr.findElement(By.xpath("//*[@type='submit']")).click();
		                    
		                    if (dr.getCurrentUrl().equalsIgnoreCase(
		                            "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index")) {
		                        dr.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']"))
		                                .click();
		                        dr.findElement(By.xpath("//ul[@class='oxd-dropdown-menu']/li[4]/a")).click();

		                    }
		                }
		                break;
		            }
		//break;
		        }
		    }

}
