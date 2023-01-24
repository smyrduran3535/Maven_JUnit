package Selenium_Practice.day07;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilies.TestBase;

import java.time.Duration;

public class C01_ExtendReport extends TestBase {

    @Test
    public void invisibleTest() {
        //https://automationfc.github.io/dynamic-loading/ sayfasına gidelim
        driver.get("https://automationfc.github.io/dynamic-loading/");
        extentTest.info("Url'e gidildi");
        //Start button'nuna basalım
        driver.findElement(By.xpath("//*[text()='Start']")).click();
        extentTest.info("Start buttonuna basıldı");
        //Hello World! yazısının çıktığını doğrulayalım
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[text()='Loading... ']")));
        extentTest.info("Hello World yazısı doğrulandı");
        //Start buttonuna bastıktan sonra Loading webelementi kaybolana kadar bekledik
        assert driver.findElement(By.xpath("//*[text()='Hello World!']")).isDisplayed();
        extentTest.pass("WE beklendi");
    }
}
