package Sessionsel2;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1 {
	
	static WebDriver driver;
	public static void main(String[] args) {
		
		
		/*
		 * WebDriverManager.chromedriver().setup(); driver=new ChromeDriver();
		 * driver.get(
		 * "https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java");
		 * 
		 * String appURL= driver.getCurrentUrl(); System.out.println(appURL);
		 * driver.close();
		 */
			/*
			 * WebDriverManager.firefoxdriver().setup(); driver=new FirefoxDriver();
			 * WebDriverManager.edgedriver().setup(); driver=new EdgeDriver();
			 */
		
		int n=15;
		/*
		 * System.out.println(n++); //15++ System.out.println(n);
		 */
		String value=" Hello ";
		System.out.println(value.trim());
		System.out.println(value.charAt(0));
		System.out.println(value.length());
		System.out.println(value.toUpperCase());
		System.out.println(value.toLowerCase());
		System.out.println(value.replace('H','F'));
		
		int[] crop=new int[5]; //size
		crop[0]=10;
		int[] crop1= {1,2,3,4,5,5};
	System.out.println(crop1[3]);
	
	ArrayList<Integer> a=new ArrayList<Integer>();
	a.add(10);
	a.add(20);
	a.add(30);
	a.remove(0);
	
for(Integer e:a)  //for each loop
{
	System.out.println(e);
}

		
	}

}
