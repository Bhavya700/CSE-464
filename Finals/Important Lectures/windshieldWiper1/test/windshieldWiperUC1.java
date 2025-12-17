import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;


public class windshieldWiperUC1 {

private static windshieldWiper testCase;
	
	@BeforeClass
	public   static void setUpObjects()
	{
		testCase = new windshieldWiper(0, "OFF", 1);
	}
	
	@Test
	public  void UC1()
	{
		try{
		testCase.senseLeverUp();
		assertEquals("Result:", 4, testCase.getWiperSpeed());
		}catch (LeverErrorException e) {
			fail("LeverErrorException not expected");
		}
		
		
		try{
			testCase.senseDialUp();
			assertEquals("Result:", 6, testCase.getWiperSpeed());
		} catch (DialErrorException e) {
			fail("LeverErrorException not expected");
		}
		
		try{
		testCase.senseDialUp();
		assertEquals("Result:", 12, testCase.getWiperSpeed());
		}catch (DialErrorException e) {
			fail("LeverErrorException not expected");
		}
		
		
		try{
		testCase.senseLeverUp();
		assertEquals("Result:", 30, testCase.getWiperSpeed());
		}catch (LeverErrorException e) {
			fail("LeverErrorException not expected");
		}
		
		try{
			testCase.senseLeverDown();
		assertEquals("Result:", 12, testCase.getWiperSpeed());
		}catch (LeverErrorException e) {
			fail("LeverErrorException not expected");
		}
		
		try{
			testCase.senseLeverDown();
		assertEquals("Result:", 0, testCase.getWiperSpeed());
		}catch (LeverErrorException e) {
			fail("LeverErrorException not expected");
		}
	}
	

}

