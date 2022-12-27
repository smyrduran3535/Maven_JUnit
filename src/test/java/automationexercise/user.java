package automationexercise;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
public class user {


    static WebDriver driver;

    public static void main(String[] args) {
        setupWebdriver();
        addNewUser();
    }

    public static void threadSleep2Second() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static WebDriver setupWebdriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;
    }

    public static void addNewUser() {
        String name = "Sumeyra";
        String email = "smyrduran3535@gmail.com";
        // 1. Launch browser

        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

    }
}