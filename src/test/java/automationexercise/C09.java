package automationexercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C09 {
    String result;
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


//1. Launch browser
// Test Case 9: Search Product
        // 1. Launch browser
        @Test
        public void test01() {
            // 2. Navigate to url 'http://automationexercise.com'
            driver.get("http://automationexercise.com");
            // 3. Verify that home page is visible successfully
            String mainPageTitle = driver.getTitle();
            String expectedTitle = "Automation Exercise";
            Assert.assertEquals(expectedTitle,mainPageTitle);
            // 4. Click on 'Products' button
            driver.findElement(By.xpath("//*[text()=' Products']")).click();
            driver.navigate().back();
            driver.navigate().forward();
            // 5. Verify user is navigated to ALL PRODUCTS page successfully
            String actualUrl = driver.getCurrentUrl();
            String expectedUrl = "https://automationexercise.com/products";
            Assert.assertEquals(expectedUrl,actualUrl);
            // 6. Enter product name in search input and click search button
            WebElement wanted = driver.findElement(By.id("search_product"));
            wanted.sendKeys("Tshirt");
            driver.findElement(By.id("submit_search")).click();
            // 7. Verify 'SEARCHED PRODUCTS' is visible
            WebElement title = driver.findElement(By.xpath("//h2[text()='Searched Products']"));
            Assert.assertTrue(title.isDisplayed());
            // 8. Verify all the products related to search are visible
            List<WebElement> names = driver.findElements(By.xpath("//div[@class='productinfo text-center']/p"));
            for (WebElement eachName : names){
                System.out.println(eachName.getText() + " " + eachName.isDisplayed());
                Assert.assertTrue(eachName.isDisplayed());
            }
        }
    }


