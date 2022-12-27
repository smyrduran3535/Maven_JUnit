package Selenium_Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        String result;
        //-"amazon.com" adresine gidelim
        driver.get("https://www.amazon.com");

//-bu web adresinin sayfa basligini(title) ve adres(url)ini yazdıralım
        String actualTitle = driver.getTitle();
        String actualUrl = driver.getCurrentUrl();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        //title ve url spent iceriyor mu

        //-title ve url'nin "Spend" kelimesinin icerip icermedigini kontrol edelim
        Assert.assertFalse(actualTitle.contains("Spend") && actualUrl.contains("Spend"));
        //-Ardindan "trendyol.com" adresine gidelim
        driver.get("https://trendyol.com");
        //-bu adresin basligini alalim ve "Sitesi" kelismesini icerip icermedigini kontrol edelim
        String trendyolTitle = driver.getTitle();
        Assert.assertTrue(trendyolTitle.contains("Sitesi"));//manuel baktık sitesi iceriyor o yuzden true yaptık
        //-Bi onceki web sayfamiza geri donelim
        driver.navigate().back();
        //-sayfayi yenileyelim
        driver.navigate().refresh();
        //-Daha sonra trendyol sayfamiza tekrar donelim ve sayfayi kapatalim
        driver.navigate().forward();
        driver.quit();
    }
}