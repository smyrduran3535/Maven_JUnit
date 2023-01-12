package Selenium_Practice.practice04;

import com.fasterxml.jackson.core.JsonStreamContext;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilies.TestBase;

import java.util.List;

public class C02_windowHandle extends TestBase {
    @Test
    public void test() {

        // 1- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");
        // 2- url'in 'amazon' icerdigini test edelim
       String url= driver.getCurrentUrl();
        Assert.assertTrue(url.contains("amazon"));
        String ilkSayfa=driver.getWindowHandle();
        // 3- yeni bir pencere acip https://www.bestbuy.com sayfasina gidelim

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        // 4- title'in 'Best Buy' icerdigini test edelim
String ikinciWindow= driver.getWindowHandle();
        String ikinciSayfa= driver.getTitle();
        Assert.assertTrue(ikinciSayfa.contains("Best Buy"));
        // 5- ilk sayfaya(amazon) donup sayfada java aratalım
        driver.switchTo().window(ilkSayfa);
driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);
        // 6- arama sonuclarının 'Java' icerdigini test edelim
        List<WebElement> java=driver.findElements(By.xpath("//*[@class='a-color-state a-text-bold']"));
        for (WebElement w:java){
            if (w.getText().contains("Java")){
                break;
            }
        }
        // 7- ikinci sayfaya(bestbuy) donelim
        driver.switchTo().window(ikinciWindow);
        // 8- logonun gorundugunu test edelim
        Assert.assertTrue(driver.findElement(By.className("logo")).isDisplayed());
    }
}
