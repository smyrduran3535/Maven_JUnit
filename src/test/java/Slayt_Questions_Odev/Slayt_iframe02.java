package Slayt_Questions_Odev;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilies.TestBase;

import java.util.List;

public class Slayt_iframe02 extends TestBase {
    @Test
    public void name() {
    //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");
    //2) sayfadaki iframe sayısını bulunuz.
        List<WebElement> iframe1= driver.findElements(By.tagName("iframe"));
        System.out.println("iframe1.size() = " + iframe1.size());
        //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        WebElement iframe= driver.findElement(By.xpath("//iframe[@wmode='transparent']"));
        driver.switchTo().frame(iframe);
        Actions actions=new Actions(driver);
        WebElement youTube= driver.findElement(By.xpath("//div[@class='ytp-cued-thumbnail-overlay-image']"));
        actions.moveToElement(youTube);
        driver.findElement(By.xpath("//button[@aria-label='Oynat']")).click();
    //4) ilk iframe'den çıkıp ana sayfaya dönünüz

        driver.switchTo().defaultContent();

    //5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html) tıklayınız
WebElement iframe2= driver.findElement(By.xpath("//iframe[@name='googlefcPresent']"));
        driver.switchTo().frame(iframe2);
        driver.findElement(By.xpath("//a[@href='https://www.guru99.com/live-selenium-project.html']")).click();
    }
}