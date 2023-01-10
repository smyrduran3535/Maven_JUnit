package automationexercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import utilies.TestBase;

import javax.swing.*;
import java.time.Duration;

public class C16 extends C15 {
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        // WebDriverManager.chromedriver().create();==>
        // WebDriverManager.chromedriver().setup(); ve  driver = new ChromeDriver(); ikisi kaldırıp yukardakı kullanılır
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test16() {
        Actions actions=new Actions(driver);
        test();
    }
}
