package Slayt_Questions_Odev;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilies.TestBase;

import java.awt.*;
import java.util.List;
import java.util.Set;

public class Slayt_windowHandle extends TestBase {
    @Test
    public void test() {
        //● Amazon anasayfa adresine gidin.
        driver.get("https://amazon.com");
        //● Sayfa’nin window handle degerini String bir degiskene atayin
        String window1=driver.getWindowHandle();
        //● Sayfa title’nin “Amazon” icerdigini test edin
        String baslik=driver.getTitle();
        Assert.assertTrue(baslik.contains("Amazon"));
        //● Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://techproeducation.com");
        //● Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
        Set<String> windows = driver.getWindowHandles();
        for (String w:windows){
            if (!w.equals(window1)){
                driver.switchTo().window(w);
            }
        }

        //● Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.walmart.com");
        //● Sayfa title’nin “Walmart” icerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Walmart"));
        //● Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(window1);
    }
}
