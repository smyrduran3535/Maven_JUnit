package Slayt_Questions_Odev;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilies.TestBase;

public class Assertion extends TestBase {

    @Test
    public void test01() {

        //2) https://www.youtube.com adresine gidin
        driver.get("https://www.youtube.com");
        //3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
    }
        //○ titleTest
        @Test
        public void test02() {
        driver.get("https://www.youtube.com");
        String actualedTitle= driver.getTitle();
        String expectedTitle="YouTube";
            Assert.assertEquals(expectedTitle,actualedTitle);
            driver.findElement(By.xpath("(//*[@class='style-scope ytd-topbar-logo-renderer'])[1]")).isDisplayed();
            driver.findElement(By.id("search")).isEnabled();
            String wrongTitle="youtube";
            Assert.assertNotEquals(actualedTitle,wrongTitle);
        }

        //○ imageTest
        //=> Sayfa başlığının “YouTube” oldugunu test edin
        //=> YouTube resminin görüntülendiğini (isDisplayed()) test edin
        //○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        //○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
    }

