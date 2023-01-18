package Slayt_Questions_Odev;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import utilies.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShot01 extends TestBase {
    @Test
    public void test() throws IOException {
        //1amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        //2amazon anasayfaya gittiginizi test edin ve tum sayfanin goruntusunu kaydedin
        assert driver.findElement(By.xpath("//body")).isDisplayed();
        //3- Nutella icin arama yapin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella", Keys.ENTER);
        //4- sonucun Nutella icerdigini test edin ve ilk urunun goruntusunu alin
        WebElement sonuc = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        assert sonuc.getText().contains("Nutella");

        WebElement ilkUrun = driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]"));
        ilkUrun.click();
        WebElement nutellaResim = driver.findElement(By.id("imgTagWrapperId"));
        File nutellaRsm = nutellaResim.getScreenshotAs(OutputType.FILE);
        String currentDate = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir") + "/test-output/EkranGoruntuleri/" + currentDate + "image.png";
        FileUtils.copyFile(nutellaRsm, new File(path));

    }

}

