import static org.junit.Assert.*;

import org.junit.Test;


public class stateChartTestLever {

	public windshieldWiper testCase;
	
	@Test
	public void testOff() {
	testCase = new windshieldWiper(0, "OFF", 1);
	try {
	testCase.senseLeverUp();
	assertEquals("Lever up error: ", "INT", testCase.getLeverPosition());
	assertEquals("Wiper speed error: ", 4, testCase.getWiperSpeed());
	} catch (LeverErrorException e) {
	fail("LeverErrorException not expected");
	}
	}
	
	
	
	@Test
	public void testInt() {
	testCase = new windshieldWiper(4, "INT", 1);
	try {
	testCase.senseLeverUp();
	assertEquals("Lever up error: ", "LOW", testCase.getLeverPosition());
	assertEquals("Wiper speed error: ", 30, testCase.getWiperSpeed());
	} catch (LeverErrorException e) {
	fail("LeverErrorException not expected");
	}
	
	}
	
	
	@Test
	public void testLow() {
	testCase = new windshieldWiper(30, "LOW", 1);
	try {
	testCase.senseLeverUp();
	assertEquals("Lever up error: ", "HIGH", testCase.getLeverPosition());
	assertEquals("Wiper speed error: ", 60, testCase.getWiperSpeed());
	} catch (LeverErrorException e) {
	fail("LeverErrorException not expected");
	}
	}
	
	@Test
	public void testHigh() {
	testCase = new windshieldWiper(60, "HIGH", 1);
	try {
	testCase.senseLeverUp();
	fail("Expected LeverErrorException");
	} catch (LeverErrorException e) {
	// Exception test succeeded
	}
	}
	
	
}

