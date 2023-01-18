package Selenium_Practice.day06;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilies.TestBase;

public class UpLoadFile extends TestBase {
    @Test
    public void test() throws InterruptedException {
        //https://demo.guru99.com/test/upload/ adresine gidiniz
        driver.get("https://demo.guru99.com/test/upload/");
        //Bilgisayarınızdan herhangi bir dosyayı upload ediniz
       WebElement dosyaSec= driver.findElement(By.id("uploadfile_0"));
       //"C:\Users\USER\OneDrive\Masaüstü\image.png" dosyanın gercek yolu bu
        String farkliKisim=System.getProperty("user.home");//C:\Users\USER\
        String ortakYol="\\OneDrive\\Masaüstü\\image.png";
        String dosyaYolu=farkliKisim+ortakYol;
       // String dosyaYolu="C:\\Users\\USER\\OneDrive\\Masaüstü\\image.png"; buda calısır
        dosyaSec.sendKeys(dosyaYolu);
        // I accept terms of service bölümünü tikleyin
       WebElement click= driver.findElement(By.xpath("//*[@id='terms']"));
       click.click();
       click.sendKeys(Keys.TAB,Keys.TAB,Keys.SPACE);
        // Submit File buttonuna basınız

        // "1 file has been successfully uploaded" görünür olduğunu test edin
        Thread.sleep(2000);
        assert driver.findElement(By.xpath("//*[@id='res']")).isDisplayed();
    }
}

