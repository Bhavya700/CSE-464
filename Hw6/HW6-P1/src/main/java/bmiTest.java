import java.time.Duration;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class bmiTest {
    private WebDriver driver;

    @Before
    public void startDriver() {
        System.setProperty("webdriver.chrome.driver",
                "/Users/bhavyapatel/Documents/Fall25/CSE464/chromedriver-mac-arm64/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    // Case 1: Underweight interior point (BMI well below 18.5)
    @Test
    public void testcase1() {
        verifyBMI("70", "100", "14.35", "Underweight");
    }

    // Case 2: Normal weight interior point (BMI clearly between 18.5 and 25)
    @Test
    public void testcase2() {
        verifyBMI("70", "150", "21.52", "Normal weight");
    }

    // Case 3: Overweight interior point (BMI clearly between 25 and 30)
    @Test
    public void testcase3() {
        verifyBMI("70", "180", "25.82", "Overweight");
    }

    // Case 4: Obese interior point (BMI clearly greater than or equal to 30)
    @Test
    public void testcase4() {
        verifyBMI("70", "220", "31.56", "Obese");
    }

    // Case 5: Boundary just below 18.5 (should still be Underweight)
    @Test
    public void testcase5() {
        verifyBMI("70", "128", "18.37", "Underweight");
    }

    // Case 6: Boundary at/just above 18.5 (first Normal weight value)
    @Test
    public void testcase6() {
        verifyBMI("70", "129", "18.51", "Normal weight");
    }

    // Case 7: Boundary just below 25 (last Normal weight value)
    @Test
    public void testcase7() {
        verifyBMI("70", "174", "24.96", "Normal weight");
    }

    // Case 8: Boundary at/just above 25 (first Overweight value)
    @Test
    public void testcase8() {
        verifyBMI("70", "175", "25.11", "Overweight");
    }

    // Case 9: Boundary just below 30 (last Overweight value)
    @Test
    public void testcase9() {
        verifyBMI("70", "209", "29.99", "Overweight");
    }

    // Case 10: Boundary at/just above 30 (first Obese value)
    @Test
    public void testcase10() {
        verifyBMI("70", "210", "30.13", "Obese");
    }

    // Case 11: Negative height should trigger the 'negative' error message
    @Test
    public void testcase11() {
        verifyBMI("-10", "150", null, "Height or weight cannot be negative");
    }

    // Case 12: Negative weight should trigger the 'negative' error message
    @Test
    public void testcase12() {
        verifyBMI("70", "-150", null, "Height or weight cannot be negative");
    }

    // Case 13: Zero height should trigger the 'zero' error message
    @Test
    public void testcase13() {
        verifyBMI("0", "150", null, "Height or weight cannot be zero");
    }

    // Case 14: Zero weight should trigger the 'zero' error message
    @Test
    public void testcase14() {
        verifyBMI("70", "0", null, "Height or weight cannot be zero");
    }

    private void verifyBMI(String height, String weight, String expectedBMI, String expectedMessage) {
        driver.get("http://webstrar100.fulton.asu.edu/page2/");

        WebElement hInput = driver.findElement(By.id("H"));
        WebElement wInput = driver.findElement(By.id("W"));
        WebElement calcBtn = driver.findElement(By.id("Button1"));

        hInput.clear();
        hInput.sendKeys(height);
        wInput.clear();
        wInput.sendKeys(weight);

        calcBtn.click();

        WebElement bmiOutput = driver.findElement(By.id("BMI"));
        WebElement msgOutput = driver.findElement(By.id("Message"));

        String actualMessage = msgOutput.getAttribute("value");
        assertTrue(actualMessage.contains(expectedMessage));

        if (expectedBMI != null) {
            String actualBMIString = bmiOutput.getAttribute("value");
            double expectedVal = Double.parseDouble(expectedBMI);
            double actualVal = Double.parseDouble(actualBMIString);
            assertEquals(expectedVal, actualVal, 0.01);
        }
    }

    @After
    public void closeDriver() {
        driver.quit();
    }
}
