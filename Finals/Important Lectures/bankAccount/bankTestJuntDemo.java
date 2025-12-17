

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class bankTestJuntDemo {

	static bankAccount b;
	// This method will be executed only once
	/*@BeforeClass
	public static void setupAccount()
	{
		b = new bankAccount("Janaka", "Balasooriya", 100.00);
	}*/
	
	// This method will be executed only once
	/*	@AfterClass
		public static void tearDownAccount()
		{
			b = null;
		}
	*/
	
	// This method will be executed before each test case
	@Before
	public void setup()
	{
		b = new bankAccount("Janaka", "Balasooriya", 100.00);
	}
	
	// This method will be executed before each test case
	@After
	public void tearDown()
	{
		b = null;
	}
		
	
	@Test
	public void DepositTestOne() {
		b.deposit(50);
		b.deposit(-10);
		b.deposit(100.50);
		assertEquals(250.50, b.getBalance(), 0.001);
	}
	
	@Test
	public void DepositTestTwo() {
		b.deposit(-10);
		b.deposit(50);
		b.deposit(100.50);
		assertEquals(250.50, b.getBalance(), 0.001);
	}
	
	@Test
	public void withDrawTestOne() {
		b.withdraw(-10);
		b.deposit(50.50);	
		assertEquals(50.50, b.getBalance(), 0.001);
	}
	
	// give a timeout , a performance parameter
	@Test(timeout=10)
	public void withDrawTestTwo() {
		b.withdraw(10);
		b.withdraw(50.50);
		assertEquals(39.50, b.getBalance(), 0.001);
	}

}
