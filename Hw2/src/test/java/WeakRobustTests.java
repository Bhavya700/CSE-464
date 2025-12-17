import static org.junit.Assert.*;
import org.junit.Test;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class WeakRobustTests {

    private String runWithInput(String input) throws Exception {
        InputStream backupIn = System.in;
        PrintStream backupOut = System.out;
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        try {
            System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
            System.setOut(new PrintStream(buffer, true, StandardCharsets.UTF_8));
            Runnable task = () -> Assignment2.main(new String[0]);
            task.run();
            return buffer.toString(StandardCharsets.UTF_8);
        } finally {
            System.setIn(backupIn);
            System.setOut(backupOut);
        }
    }

    @Test
    public void WR1_ageNegative() throws Exception {
        String output = runWithInput("-5\n150\n60\nM\n");
        assertTrue(output.contains("Error: Age must be between 1 and 119."));
    }

    @Test
    public void WR2_heightZero() throws Exception {
        String output = runWithInput("30\n150\n0\nM\n");
        assertTrue(output.contains("Error: Height must be between 1 and 99 inches."));
    }

    @Test
    public void WR3_weightNegative() throws Exception {
        String output = runWithInput("30\n-1\n60\nF\n");
        assertTrue(output.contains("Error: Weight must be between 1 and 999 pounds."));
    }

    @Test
    public void WR4_ageTooHigh() throws Exception {
        String output = runWithInput("122\n150\n60\nM\n");
        assertTrue(output.contains("Error: Age must be between 1 and 119."));
    }

    @Test
    public void WR5_heightTooHigh() throws Exception {
        String output = runWithInput("30\n150\n101\nM\n");
        assertTrue(output.contains("Error: Height must be between 1 and 99 inches."));
    }

    @Test
    public void WR6_weightTooHigh() throws Exception {
        String output = runWithInput("30\n1100\n60\nF\n");
        assertTrue(output.contains("Error: Weight must be between 1 and 999 pounds."));
    }

    @Test
    public void WR7_genderInvalid() throws Exception {
        String output = runWithInput("30\n150\n60\nother\n");
        assertTrue(output.contains("Error: Invalid gender. Please enter 'M' or 'F'."));
    }

    @Test
    public void WR8_allValid_maleModerate() throws Exception {
        String output = runWithInput("15\n140\n60\nM\n");
        assertTrue(output.contains("Your BMR is:"));
        assertTrue(output.contains("Metabolism Category: Moderate Metabolism"));
    }
}
