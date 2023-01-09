import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilies.TestBase;

import java.nio.file.Files;
import java.time.Duration;
import java.util.List;

public class Tekrar extends TestBase {
    @Test
    public void name() {

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

    }
}



