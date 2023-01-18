package Selenium_Practice.day06;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilies.TestBase;

import java.security.Key;
import java.util.List;

public class Stale_Exception extends TestBase {
    /*
   NO_SUCH_ELEMENT_EXCEPTION:
   Sayfada bulunmayan bir elemente erişim sağlanmaya çalışıldığında karşılaşılır
   WEB_DRIVER_EXCEPTION:
   Herhangi bir kod bloğu Selenium Web Driver’ı çalıştıramadığında oluşan exception türüdür.
   NO_SUCH_WINDOW_EXCEPTION:
   Yeni bir pencereye geçmeye çalışıldığında alınan exception türüdür.
   NO_ALERT_PRESENT_EXCEPTION:
   Olmayan bir uyarı/pop-up şeklindeki diyalog üzerinde işlem yapılmaya çalışıldığında karşılaşılır.
   ELEMENT_NOT_VISIBLE_EXCEPTION:
       WebDriver, sayfa tamamen yüklenmeden önce web sayfasında bir öğe bulmaya çalışırsa,
   ElementNotVisibleException hatası verir. Bu hatayı önlemek için bekleme komutları eklenir.
   En ideali implicitly wait'dir.
   TIME_OUT_EXCEPTION:
       Sayfada aradığımız elementi wait ile belirttiğimiz max. sürede, bulamadığı durumda
   selenium.TimeoutException fırlatacaktır.
   NULL_POINTER_EXCEPTION :
   Değişken oluşturup bu değişkene atama yapmadığımızda yada eşitlemediğimizde bu hatayı alırız.
   STALE_ELEMENT_REFERANCE_EXCEPTION:
       Bir web sayfasındaki bir elementin geçerliliğinin kaybolduğu durumlarda oluşur.
   Örneğin, sayfa yenilendi veya elementin DOM yapısı değiştiğinde bu hata oluşabilir.
          *->DOM (Document Object Model):yapısı, bir web sayfasının yapısını ve içeriğini tanımlayan
           bir modelidir.web uygulamalarının dinamik olarak işleyebilmesi için tasarlanmıştır.
           Örneğin, JavaScript ile bir web sayfasındaki bir elementin değerini değiştirebilir,
           yeni elementler ekleyebilir veya mevcut elementleri silebilirsiniz.
           Bu sayede web uygulamaları daha etkili bir şekilde işleyebilir ve daha etkileşimli hale gelir.
    */
    @Test
    public void test() {
        //Amazon sayfasına gidelim
        driver.get("https://www.amazon.com");
//iphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
//Çıkan ürünlerde sadece Apple iPhone yazanları tıklayalım
        // List<WebElement> urunler=driver.findElements(By.xpath(""))
        //partıal link text ile yapalım
        List<WebElement> iphones = driver.findElements(By.partialLinkText("Apple iPhone"));
        //text icinde apple ıphone yazası gecenleri alacak
        for (int i = 0; i <iphones.size() ; i++) {
            iphones=driver.findElements(By.partialLinkText("Apple iPhone"));
            iphones.get(i).click();
            driver.navigate().back();//back yapmazsak sıralı tıklayamaz o urunu goremeyiz
        }
        /*
         for (int i = 0; i <iphones.size() ; i++) { geri gelip o sayfayı bulamıyor o yuzden driver.findElements(By.partialLinkText("Apple iPhone")); bunu listin
         icine koyuyoruz. geriye donunce bulsun acmaya devam etsin diye ... KOYMASAYDIK STALE ELEMENT EXCEPTION VERİR cunku geriye donunce o elementi bulamıyor bayatlamıs oluyor....
            iphones.get(i).click();
            driver.navigate().back();//back yapmazsak sıralı tıklayamaz o urunu goremeyiz
        }
         */
        //StaleElementReferansException hatasını handle etmek için loop içine webelementlerden oluşturduğumuz
        //list'i koymalıyız
    }
}