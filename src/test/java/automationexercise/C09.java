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

    @Test
    public void test() {

//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
//3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(homePage.isDisplayed());
//4. Click on 'Products' button
        driver.findElement(By.xpath("//a[@href='/products']")).click();
//5. Verify user is navigated to ALL PRODUCTS page successfully
        String expectedUrl = "https://automationexercise.com/products";
        String actualUrl = driver.getCurrentUrl();
        result = expectedUrl.equals(actualUrl) ? "passed" : "failed";

//6. Enter product name in search input and click search button
        driver.findElement(By.xpath("//*[@id='search_product']")).sendKeys("tshirt");

        driver.findElement(By.xpath("//*[@id='submit_search']")).click();
        //7. Verify 'SEARCHED PRODUCTS' is visible
        WebElement searchedProducts = driver.findElement(By.xpath("//*[text()='Searched Products']"));
        result = searchedProducts.isDisplayed() ? "passed" : "failed";
        System.out.println(result);
        WebElement searchedProduct = driver.findElement(By.xpath("//h2[text()='Searched Products']"));
        result = searchedProduct.isDisplayed() ? "pass" : "fail";

        //8. Verify all the products related to search are visible


    }
}

