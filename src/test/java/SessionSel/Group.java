package SessionSel;

import org.testng.annotations.Test;

public class Group {
	
	
	@Test(groups="smoke",priority = 1)
	public void tc1()
	{
		System.out.println("smoke");
	}
	
	@Test(groups="regression",priority = 0)
	public void tc2()
	{
		System.out.println("regression");

	}
	
	@Test(groups="smoke",priority = 1)
	public void tc3()
	{
		System.out.println("smoke");

	}
	
	@Test(groups="regression",priority = 0)
	public void tc4()
	{
		System.out.println("regression");

	}
	
	
	

}
