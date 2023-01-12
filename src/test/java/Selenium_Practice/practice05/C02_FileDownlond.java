package Selenium_Practice.practice05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilies.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileDownlond extends TestBase {
    @Test
    public void test() {
        //1. 'https://the-internet.herokuapp.com/download' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/download");
        //2. some-file.txt dosyasini indirelim
   WebElement someFileTxt=driver.findElement(By.xpath("//a[text()='some-file.txt']"));
   someFileTxt.click();
        //3. dosyanin basariyla indirilip indirilmedigini test edelim (dosya downloads'a indirilecektir)
        //"C:\\Users\\USER\\Downloads\\some-file.txt";: indirilenlerden dosya yolunu copy =>burası herkes icin aynı indirilen dosya
        // "C:\Users\USER\bu kısım herkes icin degisir
        // Downloads\some-file.txt"

        String dosyaYolu="C:\\Users\\USER\\Downloads\\some-file.txt";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        String farkliKisim=System.getProperty("user.home");//herkes icin farklı olan kısmı verir
        String ortakKisim= "\\Downloads\\some-file.txt";
        String dosyaYolu2=farkliKisim+ortakKisim;
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu2)));
    }
}
