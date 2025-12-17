package firm;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class testExecutive {

	Executive ex;
	@Before
	public void setUp() throws Exception {
		 ex = new Executive ("Sam", "123 Main Line",
		         "555-0469", "123-45-6789", 2423.07);
	}

	@Test
	public void test() {
		ex.awardBonus(1000.00);
		assertEquals(3423.07, ex.pay(),0.001);
	}

}
