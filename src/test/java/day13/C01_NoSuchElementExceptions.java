package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilies.TestBase;

public class C01_NoSuchElementExceptions extends TestBase {
    @Test
    public void test() {
        /*
(C01_NoSuchElementExceptions.java:15) yanlıs locate old soyluyor ===>>>bu hata selenyumdan gelir
         */
        driver.get("https://www.techproeducation.com");
        driver.findElement(By.xpath("//input[@type='searchhh']")).sendKeys("QA", Keys.ENTER);

    }
}
