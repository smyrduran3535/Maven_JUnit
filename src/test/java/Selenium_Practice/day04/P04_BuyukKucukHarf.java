package Selenium_Practice.day04;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilies.TestBase;

public class P04_BuyukKucukHarf extends TestBase {
    @Test
    public void test() {
        //google sayfasına gidelim
        driver.get("https://www.google.com");
        //buyuk kucuk harf olacak sekilde "Hello" yazdıralım
        WebElement searchBox= driver.findElement(By.xpath("//*[@class='gLFyf']"));
        searchBox.sendKeys(Keys.SHIFT,"h",Keys.SHIFT,"e",Keys.SHIFT,"l",Keys.SHIFT,"l",Keys.SHIFT,"O",Keys.SHIFT); // HeLlO


    }
}
