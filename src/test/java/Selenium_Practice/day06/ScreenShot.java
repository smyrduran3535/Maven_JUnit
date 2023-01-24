package Selenium_Practice.day06;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import utilies.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ScreenShot extends TestBase {
    String tarih;
    @Test
    public void test() throws IOException, InterruptedException {
        //Amazon sayfasına gidelim
        //Tüm sayfanın resmini alalım
        //Yeni bir sekmede techproeducation sayfasına gidip sayfanın resmini alalım
        //Tekrar amazon sayfasına dönüp iphone aratalım
        //Arama sonucunun resmini alalım


            //Amazon sayfasına gidelim
            driver.get("https://amazon.com");
            String amazonSayfasi = driver.getWindowHandle();
            //Tüm sayfanın resmini alalım
            tarih = new SimpleDateFormat("hh_mm_ss_ddMMyyyy").format(new Date());
            TakesScreenshot ts = (TakesScreenshot) driver;
            FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File("target/tumSayfaResmi/tumSayfa"+tarih+".jpeg"));
        /*
        FILEUTILS CLASS'I, FİLE NESNELERİ İLE BİRLİKTE KULLANABİLECEĞİMİZ METHODLAR İÇERİR.
        BU METHODLARI KULLANARAK DOSYALARDA OKUMA, YAZMA VE KOPYALAMA İŞLEMLERİNİ ÇOK DAHA KOLAY YAPABİLİRİZ
         */
            //Yeni bir sekmede techproeducation sayfasına gidip sayfanın resmini alalım
            Thread.sleep(6000);
            driver.switchTo().newWindow(WindowType.TAB); //Yeni bir sekme açtık
            driver.get("https://techproeducation.com");
            tarih = new SimpleDateFormat("hh_mm_ss_ddMMyyyy").format(new Date());
            FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File("target/tumSayfaResmi/tumSayfa"+tarih+".jpeg"));
            //Tekrar amazon sayfasına dönüp iphone aratalım
            driver.switchTo().window(amazonSayfasi);
            driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
            //Arama sonucunun resmini alalım
            WebElement sonuc = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
            FileUtils.copyFile(sonuc.getScreenshotAs(OutputType.FILE),new File("target/WebElementScreenShot/WEScreenShot"+tarih+".jpeg"));
            //sonuc elementini locate edip webelmente assine edin
            //FileUtils.copyFile(WE.getScreenshotAs(OutputType.FILE),new File("target/tumSayfaResmi/tumSayfa"+tarih+".jpeg"));
    }
}
