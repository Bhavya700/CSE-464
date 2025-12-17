

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class bankTest {
	  static bankAccount  b;
	
	@BeforeClass
	public  static void setUp() throws Exception {
		b=new bankAccount("Test", "Test", 1000);
	}

	@Test
	public void testDeposit() {
		b.deposit(100);
		b.deposit(-10);
		b.deposit(50);
		assertEquals(1130, b.getBalance(), 0.001);
	}

	@Test
	public void testDepositRecord() {
		/*b.deposit(100);
		b.deposit(-10)*/
		double [] deposit={100,30,0,0,0,0,0,0,0,0};
		assertArrayEquals(deposit, b.getLastTenDeposits(), 0.001);
	}
}
