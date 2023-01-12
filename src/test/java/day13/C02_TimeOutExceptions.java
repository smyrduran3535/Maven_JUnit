package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilies.TestBase;

import java.time.Duration;

public class C02_TimeOutExceptions extends TestBase {

    //excilipWait kullanıldıgı zaman ve eleman bulunamayınca alınır===>>>TimeOutExceptions

    @Test
    public void test() {
        driver.get("https://www.techproeducation.com");
        //explit wait icin olusturdugumuz methodlardan birini kullanalım
        //Parametre 1: beklemek istedigim element, Parametre 2: Max sure
       // waitForVisibility(driver.findElement(By.xpath("//input[@type='searchhh']")),15).sendKeys("QA"+ Keys.ENTER);
      // yukardaki method bunu verdi: (C02_TimeOutExceptions.java:14)
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("YANLIS İD"))); //belirlene surede eleman bulunamadıgı icin; (C02_TimeOutExceptions.java:21)

    }
}
