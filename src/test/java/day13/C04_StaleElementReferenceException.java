package day13;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilies.TestBase;

public class C04_StaleElementReferenceException extends TestBase {
    @Test
    public void staleElementReferenceException() {
        /*
    Stale Element = eski,kullanilamaz durumda, kullanima artik elverisli degil.
    -Sayfayi yenilediginizde refresh()
    -Sayfada back() veya forward() yaparsak
      Çözüm
     Elemanı tekrar bulmak.
 */
            driver.get("https://www.techproeducation.com");
            waitFor(5);
//        LMS LOGIN linkine tikla ve o sayfanin URL inin lms icerdigini test et
            WebElement lmsLoginLink = driver.findElement(By.linkText("LMS LOGIN"));
            waitFor(5);
            lmsLoginLink.click();//LMS e git
            Assert.assertTrue(driver.getCurrentUrl().contains("lms"));//URl in lms kelimesini icerdigini test et
            waitFor(5);
//        Tekrar ana sayfaya gel ve LMS LOGIN sayfasina tekrar
            driver.navigate().back();//tekrar ana sayfaya gittik
            waitFor(5);
            lmsLoginLink.click();//LMS e git
        //org.openqa.selenium.StaleElementReferenceException:
    }

    @Test
    public void test02() {
        driver.get("https://www.techproeducation.com");
        waitFor(5);
//        LMS LOGIN linkine tikla ve o sayfanin URL inin lms icerdigini test et
        WebElement lmsLoginLink = driver.findElement(By.linkText("LMS LOGIN"));
        waitFor(5);
        driver.navigate().refresh();
        waitFor(5);
        lmsLoginLink.click();//sayfa yenilemeden once buldugum elementi, sayfa yenilendikten sonra kullanmak istedim
        //org.openqa.selenium.StaleElementReferenceException:
    }
}
