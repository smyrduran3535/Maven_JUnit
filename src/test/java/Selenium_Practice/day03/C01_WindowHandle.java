package Selenium_Practice.day03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import utilies.TestBase;

public class C01_WindowHandle extends TestBase {
    @Test
    public void test01() {
        //Amazon anasayfa adresine gidin.
        driver.get("https://amazon.com");
        //Sayfa’nin window handle degerini String bir degiskene atayin
        String window1= driver.getWindowHandle();
        System.out.println("window1 = " + window1);
        //Sayfa title’nin “Amazon” icerdigini test edin
        String title=driver.getTitle();
        Assert.assertTrue(title.contains("Amazon"));
        //Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);//yeni sekme actık
        driver.get("https://techproeducation.com");
       //driver.switchTo().newWindow(WindowType.TAB).get("https://techproeducation.com"); 2.yol
        //Sayfa title’nin “TECHPROEDUCATION” icerip icermedigini test edin
String actualTechProTitle=driver.getTitle();
String expectedTitle="TECHPROEDUCATION";
Assert.assertNotEquals(expectedTitle,actualTechProTitle);
        //Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://walmart.com");
        //Sayfa title’nin “Walmart” icerdigini test edin
 String actualWalmart=driver.getTitle();
 Assert.assertTrue(actualWalmart.contains("Walmart"));
        //Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(window1);
        String amazon=driver.getCurrentUrl();
        Assert.assertTrue(amazon.contains("amazon.com"));
        // yada ======>>>driver.switchTo().window(amazonWindow);
                         //String actualUrl = driver.getCurrentUrl();
                         //String expectedUrl = "https://www.amazon.com/";
                         //Assert.assertEquals(expectedUrl,actualUrl);
    }
}
