import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilies.TestBase;

import java.nio.file.Files;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class Tekrar extends TestBase {
    @Test
    public void name() throws InterruptedException {
        driver.get("https://www.techproeducation.com");

       //1,adım elementi bul
        WebElement weOffer= driver.findElement(By.xpath("//span[text()='we offer']"));
       //js objesi olustur
        JavascriptExecutor js= (JavascriptExecutor) driver;
        //yapmak istedigim islemi js objesi ile js.executors metodu kullanırım
        js.executeScript("arguments[0].scrollIntoView(true);",weOffer);

                      /*
        WebElement element = driver.findElement(By.xpath("element"));
        Actions actions = new Actions(driver);
        actions.moveToElement(ele);
        actions.perform();

         Bir öğeyi scrollIntoView() için Yukarı veya Aşağıya görünürlükOfElementLocated() için
        WebDriverWait'i tetiklemeniz gerekir ve aşağıdaki çözümü kullanabilirsiniz:

       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", new WebDriverWait(driver, 20).
       until(ExpectedConditions.visibilityOfElementLocated(By.xpath("element"))));
         */

    }
}








