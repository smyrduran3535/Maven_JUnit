package Selenium_Practice.practice02;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilies.TestBase;

import java.util.List;

public class P03 extends TestBase {
    @Test
    public void test() throws InterruptedException {
        //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");
        //2) sayfadaki iframe sayısını bulunuz.
        List<WebElement> iframe=driver.findElements(By.xpath("//iframe"));
        System.out.println("iframe sayısı "+iframe.size());
        //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        WebElement ilkFrame= driver.findElement(By.xpath("//*[@wmode='transparent']"));
        //link ile de yaparız ama link sonradan her calıstırmada degisirse olmaz calısmaz

        driver.switchTo().frame(ilkFrame);
        driver.findElement(By.cssSelector("button[aria-label='Oynat']")).click();
        Thread.sleep(2000);
        //4) ilk iframe'den çıkıp ana sayfaya dönünüz
driver.navigate().refresh();//boyle yaptıgımz icin iframe secmeye gerek yok
        //5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html)
        WebElement iframe2= driver.findElement(By.xpath("//*[@id='a077aa5e']"));
    driver.switchTo().frame(iframe2);
    driver.findElement(By.xpath("//*[@src='Jmeter720.png']")).click();
        //tıklayınız
    }
}
