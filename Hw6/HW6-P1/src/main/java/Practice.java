import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/bhavyapatel/Documents/Fall25/CSE464/chromedriver-mac-arm64/chromedriver");
        WebDriver driver = new ChromeDriver();
        // to visit Google
        driver.get("https://www.google.com");
        //driver.navigate().to("https://www.google.com");
        // Find the text input element by its name
        WebElement InputElement = driver.findElement(By.name("q"));

        // Enter something to search for
        InputElement.sendKeys("ASU");
        // Now submit the form. WebDriver will find the form for us from the element
        InputElement.submit();
        // Thread.sleep(10_000);
        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());
        //Close the browser
        driver.quit();
    }
}
