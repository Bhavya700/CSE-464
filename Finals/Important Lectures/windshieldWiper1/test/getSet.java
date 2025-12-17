import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;


public class getSet {
	private static windshieldWiper testCase;
	
	@BeforeClass
	public  static void setUpObjects()
	{
		testCase = new windshieldWiper(0, "OFF", 1);
	}
	
	@Test
	public   void wiperSpeedSetGet()
	{
		testCase.setWiperSpeed(6);
		assertEquals("Result:", 6, testCase.getWiperSpeed());
		
	}
	
	@Test
	public   void wiperLeverPosSetGet()
	{
		testCase.setLeverPosition("INT");
		assertEquals("Result:", "INT", testCase.getLeverPosition());
		
	}
	
	@Test
	public  void wiperDialPosSetGet()
	{
	testCase.setDialPosition(2);
	assertEquals("Result:", 2, testCase.getDialPosition());
	}

}
