package Selenium_Practice.day03;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilies.TestBase;

import java.util.List;

public class C02 extends TestBase {
    @Test
    public void test() throws InterruptedException {

       //- https://html.com/tags/iframe/ adresine gidiniz
        driver.get("https://html.com/tags/iframe/");
       String ilkWindow= driver.getWindowHandle();

        //    - youtube videosunu çalıştırınız
        WebElement iframe= driver.findElement(By.xpath("//iframe[@frameborder='0']"));

        ////*[@class="render"]/iframe ile de alabiliriz
        driver.switchTo().frame(iframe);
        driver.findElement(By.cssSelector("button[aria-label='Oynat']")).click();

        //    - üç saniye çalıştıktan sonra sayfayı yenileyiniz
        Thread.sleep(3000);
        driver.navigate().refresh();

        //    - yeni sekmede amazon adresine gidiniz
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://amazon.com");
        String amazonWindow=driver.getWindowHandle();
        System.out.println("amazonWindow = " + amazonWindow);

        //    - iphone aratınız
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("iphone", Keys.ENTER);

        //    - arama sonucu olarak sadece sonuc sayısını yazdırınız
        String  result= driver.findElement(By.xpath("//span[text()='1-16 of 144 results for']")).getText();
        System.out.println("result.split(\" \")[2] = " + result.split(" ")[2]);

        //    - ilk sekmeye geri dönüp url'ini konsola yazdıralım
        driver.switchTo().window(ilkWindow);
        System.out.println("ilkwindow url  = " + driver.getCurrentUrl());

        //    - ilk sekmeyi kapatalım
        driver.switchTo().window(amazonWindow);//bunu yazarsak once amazon sayfasıbı kapatır
        driver.close();

        //    - Sonra diğer sekmeyide kapatalım

        //TestBase deki @After metodunu calıstıralım acıp

    }
}
