package SessionSel;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Priority {

	@BeforeTest
	public void start() {
		System.out.println("Number of days in a week");
	}

	@Test(priority = 1)
	public void tc1() {
		System.out.println("Monday");
	}

	@Test(priority = 2)
	public void tc2() {
		System.out.println("tuesday");
	}

	@Test(priority = 3)
	public void tc3() {
		System.out.println("wednesday");
	}

	@Test(priority = 4)
	public void tc4() {
		System.out.println("thursday");
	}

	@AfterTest
	public void teardown() {
		System.out.println("The day is ended");
	}

}
