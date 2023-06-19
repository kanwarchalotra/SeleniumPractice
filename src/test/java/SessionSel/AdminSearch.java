package SessionSel;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AdminSearch {
	
	WebDriver driver;
	String s1="/SeleniumPractice/demo.png";
	@Test
	public void set() throws IOException
	{
		driver=new ChromeDriver();
		
		driver.get("https://www.google.com");
       File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);	
       File dest=new File(s1);
       
       FileUtils.copyFile(src, dest);

		
	}

}
