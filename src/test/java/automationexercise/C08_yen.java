package automationexercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class C08_yen {
    // Test Case 8: Verify All Products and product detail page

    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        // 3. Verify that home page is visible successfully
        driver.get("http://automationexercise.com");
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        String expectedTitle = "Automation Exercise";
        Assert.assertEquals(expectedTitle,actualTitle);
        // 4. Click on 'Products' button
        driver.findElement(By.xpath("//*[text()=' Products']")).click();
        Thread.sleep(3000);
        // 5. Verify user is navigated to ALL PRODUCTS page successfully
        String actualTitle2 = driver.getTitle();
        String expectedTitle2 = "Automation Exercise - All Products";
        System.out.println("actualTitle2 = " + actualTitle2);
        Assert.assertEquals(expectedTitle2,actualTitle2);
        // 6. The products list is visible
        WebElement productList = driver.findElement(By.xpath("//div[@class='features_items']"));
        Assert.assertTrue(productList.isDisplayed());
        // 7. Click on 'View Product' of first product
        // WebElement button = driver.findElement(By.xpath("(//div[@class='choose'])[1]//a[text()='View Product']"));
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();
        WebElement button = driver.findElement(By.xpath("(//i[@class='fa fa-plus-square'])[1]"));
        System.out.println("button.getText() = " + button.getText());
        button.click();

        // 8. User is landed to product detail page
        String productActualTitle = driver.getTitle();
        String productExpectedTitle = "Automation Exercise - Product Details";
        Assert.assertEquals(productExpectedTitle,productActualTitle);
        // 9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
        WebElement name = driver.findElement(By.xpath("(//h2)[3]"));
        Assert.assertTrue(name.isDisplayed());
        WebElement category = driver.findElement(By.xpath("(//p)[3]"));
        Assert.assertTrue(category.isDisplayed());
        WebElement price = driver.findElement(By.xpath("//span/span"));
        Assert.assertTrue(price.isDisplayed());
        WebElement availability = driver.findElement(By.xpath("(//div/p)[4]"));
        Assert.assertTrue(availability.isDisplayed());
        WebElement condition = driver.findElement(By.xpath("(//div/p)[5]"));
        Assert.assertTrue(condition.isDisplayed());
        WebElement brand = driver.findElement(By.xpath("(//div/p)[6]"));
        Assert.assertTrue(brand.isDisplayed());
        Thread.sleep(3000);
    }
}
