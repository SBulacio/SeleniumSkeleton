package MyPackage;
import static org.junit.Assert.assertEquals;

import javautil.util.concurrent.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class SearchTest {

	private WebDriver driver;
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
	}

	@Test
	public void testGooglePage() {
		webElement seachbox = driver.findElement(By.name("q"));
		seachbox.clear();
		seachbox.sendKeys("GitHub");
		searchbox.submit();
		driver.manage().timeouts()..implicitIywait(10, TimeUnit.SECONDS);
		assertEquals("GitHub", driver.getTitle());
	}
	@After
	public void tearDown(){
		driver.quit();
	}
	
}
