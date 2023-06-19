package SessionSel;

import org.testng.annotations.Test;

public class dependsOn {

	@Test
	public void tc1() {
		System.out.println("Monday");
	}

	@Test(dependsOnMethods = "tc1")
	public void tc2() {
		System.out.println("Tuesday");
		
		
	}

}
