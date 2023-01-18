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
    @Test
    public void test() throws IOException {
        //Amazon sayfasına gidelim
        driver.get("https://www.amazon.com");
        //Tüm sayfanın resmini alalım !!!!!!!!!!!! icin asagıdaki yolu izle
        //aklına takesreenshot ve getscreenshot gelsin
        TakesScreenshot ts= (TakesScreenshot) driver;
        /*FileUtils classı ;file nesneleri ile birlikte kullanabilecegimiz methodlar icerir bu methodşarı kullanarak dosyalarda okuma,yazma,copy
        islemlerini cok daha kolay yapabiliriz
         */
        String tarih=new SimpleDateFormat("hh__mm_ss_ddMMyyyy").format(new Date());
      FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File("test-output/EkranGoruntuleri/tumsayfa"+tarih+".jpg"));

        //Yeni bir sekmede techproeducation sayfasına gidip sayfanın resmini alalım
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://techproeducation.com");
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File("test-output/EkranGoruntuleri/tumsayfa"+tarih+".jpg"));
        //Tekrar amazon sayfasına dönüp iphone aratalım
        List<String> pencereler=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(pencereler.get(0));
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        //Arama sonucunun resmini alalım
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File("test-output/EkranGoruntuleri/tumsayfa"+tarih+".jpg"));
    }
}
