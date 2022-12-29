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

import static automationexercise.user.driver;

public class C11 {
    WebDriver Ddriver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test(){
        //1. Launch browser
        //2. Navigate to url 'htttps'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(homePage.isDisplayed());
        //4. Click 'Cart' button
        driver.findElement(By.xpath("//*[@class='fa fa-shopping-cart']")).click();
        //5. Scroll down to footer
        WebElement scrollDown=driver.findElement(By.xpath("//*[@lang='en']"));
        for (int i = 0; i <100 ; i++) {
            scrollDown.sendKeys(Keys.DOWN,Keys.ARROW_DOWN,Keys.ENTER);
        }
        //6. Verify text 'SUBSCRIPTION'
        WebElement subscription= driver.findElement(By.xpath("//h2[text()='Subscription']"));
        Assert.assertTrue(subscription.isDisplayed());
        //7. Enter email address in input and click arrow button
        driver.findElement(By.id("susbscribe_email")).sendKeys("smyrduran3535@gmail.com");

        driver.findElement(By.xpath("//*[@class='fa fa-arrow-circle-o-right']")).click();

        //8. Verify success message 'You have been successfully subscribed!' is visible
        WebElement message= driver.findElement(By.xpath("//*[text()='You have been successfully subscribed!']"));
        Assert.assertFalse (message.isDisplayed());
    }
}
