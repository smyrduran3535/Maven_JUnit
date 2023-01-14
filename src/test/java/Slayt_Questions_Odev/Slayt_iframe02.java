package Slayt_Questions_Odev;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilies.TestBase;

import java.util.List;

public class Slayt_iframe02 extends TestBase {
    @Test
    public void name() {
//1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");
//2) sayfadaki iframe sayısını bulunuz.
        List<WebElement> iframe= driver.findElements(By.xpath("//iframe"));
        System.out.println("iframe.size() = " + iframe.size());
//3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        driver.switchTo().frame(11);
        WebElement youTube= driver.findElement(By.xpath("//div[@class='ytp-cued-thumbnail-overlay-image']"));
        driver.findElement(By.xpath("//button[@aria-label='Oynat']")).click();
        //4) ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().parentFrame();
//5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html)
//tıklayınız

    }
}