package MyPackage;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class SearchTest {

    private WebDriver driver;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
    }

    @Test
    public void testGooglePage() {
        WebElement searchbox = driver.findElement(By.name("q"));
        searchbox.clear();
        searchbox.sendKeys("GitHub");
        searchbox.submit();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        assertEquals("GitHub", driver.getTitle());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}
