package Selenium_Practice.day06;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilies.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class DownlondFile extends TestBase {
    @Test
    public void test() {
        //https://www.selenium.dev/downloads/ adresine gidelim
        driver.get("https://www.selenium.dev/downloads/");

       WebElement browsers=driver.findElement(By.xpath("//button[normalize-space()='Browsers']"));

        Actions actions = new Actions(driver);
        actions.scrollToElement(browsers);
        browsers.click();
        //Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfayı indirelim
        //Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım
        WebElement google=driver.findElement(By.xpath("(//div//h4)[5]"));
        actions.moveToElement(google).perform();
        driver.findElement(By.xpath("(//div[@class='card mb-3 border-0'])[5]//a[text()='documentation']")).click();
        //All versions available in Downloads altında Latest stable release olan linki tıklayalım
        driver
                .findElement(By.xpath("(//*[@class='XqQF9c'])[2]")).click();
        //Açılan pencerede chromedriver'i indirelim:kontrolumuz dısında handle alıcaz

        List<String> pencereler=new ArrayList<>(driver.getWindowHandles());
      driver.switchTo().window(pencereler.get(1));
        driver.findElement(By.xpath("//*[text()='chromedriver_win32.zip']")).click();
waitFor(3);

        //Driver'in indiğini doğrulayalım
//"C:\Users\USER\Downloads\chromedriver_win32 (1).zip"
        String dosyaYol=System.getProperty("user.home")+"\\Downloads\\chromedriver_win32 (1).zip";
       assert Files.exists(Path.of(dosyaYol));//dosyanın inip inmedigini files.exist ile yapıyoruz


    }
}
