package Selenium_Practice.day03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilies.TestBase;

import java.util.ArrayList;
import java.util.List;

public class C03 extends TestBase {
    @Test
    public void test() {
        // https://the-internet.herokuapp.com/iframe adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");
        String window1= driver.getWindowHandle();
        System.out.println("window1 = " + window1);
        // An iFrame conteining... başlığının altındaki Text Box’a “Techproeducation” yazin.
        WebElement iframe=driver.findElement(By.xpath("//*[@id='mce_0_ifr']"));//once iframe i locate ediyoruz
        driver.switchTo().frame(iframe);
        //simdi iceriyi locate etmek lazım
       WebElement texBox= driver.findElement(By.xpath("//p"));
       texBox.clear();//once varolan yazıyı temizler
               texBox.sendKeys("Techproeducation");

        // TextBox’in altinda bulunan “Elemental Selenium” linkinin gorunur oldugunu test edin
             //once iframeden cıkmamız lazım
        driver.switchTo().defaultContent();
        WebElement elementalSelenium=driver.findElement(By.xpath("//a[text()='Elemental Selenium']"));
        Assert.assertTrue(elementalSelenium.isDisplayed());
        // Elemental Selenium linkine tıklayın
       elementalSelenium.click();
        // Açılan sayfada sayfa başlığını yazdırınız
                    //set yapıcaz
        /*
         String origin = driver.getWindowHandle();
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
                if (driver.getTitle().equals(targetTitle)) {
                    return;//loop un dısına cık
                }
            }
            driver.switchTo().window(origin);

            asagıdaki de list ile diger sayfaya gecme olabilir
         */
        List<String> windowsHandles=new ArrayList<>(driver.getWindowHandles());//click yaptıktan sonra yapıyoruz
        System.out.println("windowsHandles = " + windowsHandles);
        driver.switchTo().window(windowsHandles.get(1));//index 0 dan baslıyor.. kac pencere varsa bu yontemle yapabiliriz

        String sayfaBasligi=driver.getTitle();
        System.out.println("sayfaBasligi = " + sayfaBasligi);
        // Elemental Selenium başlığı altındaki "Source Labs" linkinin gorunur olduğunu test edin
        WebElement sourceLabs = driver.findElement(By.xpath("//*[text()='Sauce Labs']"));
        Assert.assertTrue(sourceLabs.isDisplayed());

        // Source labs linkine tıklayın
      sourceLabs.click();

        // Açılan sayfada sayfa başlığını yazdırınız
        List<String> windowsHandles2=new ArrayList<>(driver.getWindowHandles());//click yaptıktan sonra yapıyoruz
        System.out.println("windowsHandles2 = " + windowsHandles2);
        driver.switchTo().window(windowsHandles2.get(2));
        String window2=driver.getTitle();
        System.out.println("window2  = " + window2);
        // ilk sekmeye geri dönelim ve url'ini yazdıralım
        // driver.switchTo().window(window1); bunun yerine artık arrayimiz var
        driver.switchTo().window(windowsHandles2.get(0));
        String ilkUrl=driver.getCurrentUrl();
        System.out.println("ilkUrl = " + ilkUrl);
        // ilk sekmeyi kapatalım
         driver.close();//methodu acarsak hepsini kapatır
        //ilk sekmeyi kapatınca driver nerde dersek;
        driver.switchTo().window(windowsHandles2.get(2));//2.sayfaya gecirmek istersek boyle yaparız..
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());//gecirdigimiz sayfada mı diye kontrol
    }
}
