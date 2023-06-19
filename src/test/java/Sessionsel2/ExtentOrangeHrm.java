package Sessionsel2;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentOrangeHrm {
	ExtentReports extent;
	ExtentTest extenttest;
	WebDriver dr;
	
	 @BeforeTest
	    public void BT() {
	    extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/march23.html");
	        extent.loadConfig(new File(System.getProperty("user.dir")+"/src/test/java/extent-config.xml"));
	        
	        WebDriverManager.chromedriver().setup();
	        dr = new ChromeDriver();
	        dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        
	    }
	  
	    @Test
	    
	    public void Login() {
	        
	        extenttest = extent.startTest("march");
	        
	        dr.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	        extenttest.log(LogStatus.PASS, "web page has been opened");
	        
	        
	        dr.findElement(By.name("username")).sendKeys("Admin");
	        extenttest.log(LogStatus.FAIL, "username textbox is filled");
	        
	        dr.findElement(By.name("password")).sendKeys("admin123");
	        extenttest.log(LogStatus.PASS, "password textbox is filled");
	        
	        
	        
	       dr.findElement(By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")).click();
	       extenttest.log(LogStatus.PASS, "user is re-directed to home page");
	        
	        
	        
	        
	    }
	    
	    @Test(dependsOnMethods = "Login")
	    public void Logout() {
	        dr.findElement(By.xpath("//*[@class='oxd-userdropdown-name']")).click();
	        extenttest.log(LogStatus.PASS, "clicking on the dropdown");
	        
	        
	        dr.findElement(By.xpath(".//*[@class='--active oxd-userdropdown']/ul/li[4]/a")).click();
	        extenttest.log(LogStatus.PASS, "clicking on logout");
	        
	    }
	    
	    @AfterTest
	    public void At() {
	        
	        dr.close();
	        extent.endTest(extenttest);
	        extent.flush();
	        extent.close();
	        
	    }
	    

}
