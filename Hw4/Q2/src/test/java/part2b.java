import static org.junit.Assert.*;
import org.junit.Test;

public class part2b {
    @Test
    public void p1() {
        assertEquals("Invalid Card", CreditCardValidation.Validate(1234567890L));
    }

    @Test
    public void p2() {
        assertEquals("Invalid Card", CreditCardValidation.Validate(1111222233334444L));
    }

    @Test
    public void p3() {
        assertEquals("Valid Card", CreditCardValidation.Validate(1111222233334445L));
    }
}
