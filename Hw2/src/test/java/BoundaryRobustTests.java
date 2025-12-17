import static org.junit.Assert.*;
import org.junit.Test;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class BoundaryRobustTests {

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
    public void B1_ageZeroInvalid() throws Exception {
        String output = runWithInput("0\n500\n50\nM\n");
        assertTrue(output.contains("Error: Age must be between 1 and 119."));
    }

    @Test
    public void B2_ageOneValid() throws Exception {
        String output = runWithInput("1\n500\n50\nM\n");
        assertTrue(output.contains("Your BMR is:"));
        assertTrue(output.contains("Metabolism Category:"));
    }

    @Test
    public void B3_age119Valid() throws Exception {
        String output = runWithInput("119\n500\n50\nM\n");
        assertTrue(output.contains("Your BMR is:"));
        assertTrue(output.contains("Metabolism Category:"));
    }

    @Test
    public void B4_age120Invalid() throws Exception {
        String output = runWithInput("120\n500\n50\nM\n");
        assertTrue(output.contains("Error: Age must be between 1 and 119."));
    }

    @Test
    public void B5_heightZeroInvalid() throws Exception {
        String output = runWithInput("30\n500\n0\nM\n");
        assertTrue(output.contains("Error: Height must be between 1 and 99 inches."));
    }

    @Test
    public void B6_heightOneValid() throws Exception {
        String output = runWithInput("30\n500\n1\nM\n");
        assertTrue(output.contains("Your BMR is:"));
        assertTrue(output.contains("Metabolism Category:"));
    }

    @Test
    public void B7_height99Valid() throws Exception {
        String output = runWithInput("30\n500\n99\nM\n");
        assertTrue(output.contains("Your BMR is:"));
        assertTrue(output.contains("Metabolism Category:"));
    }

    @Test
    public void B8_height100Invalid() throws Exception {
        String output = runWithInput("30\n500\n100\nM\n");
        assertTrue(output.contains("Error: Height must be between 1 and 99 inches."));
    }

    @Test
    public void B9_weightZeroInvalid() throws Exception {
        String output = runWithInput("30\n0\n50\nM\n");
        assertTrue(output.contains("Error: Weight must be between 1 and 999 pounds."));
    }

    @Test
    public void B10_weightOneValid() throws Exception {
        String output = runWithInput("30\n1\n50\nM\n");
        assertTrue(output.contains("Your BMR is:"));
        assertTrue(output.contains("Metabolism Category:"));
    }

    @Test
    public void B11_weight999Valid() throws Exception {
        String output = runWithInput("30\n999\n50\nM\n");
        assertTrue(output.contains("Your BMR is:"));
        assertTrue(output.contains("Metabolism Category:"));
    }

    @Test
    public void B12_weight1000Invalid() throws Exception {
        String output = runWithInput("30\n1000\n50\nM\n");
        assertTrue(output.contains("Error: Weight must be between 1 and 999 pounds."));
    }
}
