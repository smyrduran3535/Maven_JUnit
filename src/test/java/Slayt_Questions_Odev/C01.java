package Slayt_Questions_Odev;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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


        //2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");
        //3- cookies uyarisini kabul ederek kapatin
        //4 Sayfa basliginin “Google” ifadesi icerdigini test edin
        //WebElement sayfaTitleGoogle= driver.findElement(By.xpath("//*[@src='/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png']"));
        String actualTitle = driver.getTitle();
        String exceptTitle = "Google";
        if (actualTitle.contains(exceptTitle)) {
            System.out.println("actualTitle passed ");
        } else System.out.println("actualTitle failed ");
        //5 Arama cubuguna “Nutella” yazip aratin
        WebElement aramaCubugu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaCubugu.sendKeys("Nutella", Keys.ENTER);
        //6 Bulunan sonuc sayisini yazdirin
        WebElement bulunanSonucSayisi = driver.findElement(By.xpath("//*[@id='result-stats']"));
        System.out.println("bulunanSonucSayisi.getText() = " + bulunanSonucSayisi.getText());
        //7 sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        String[] sonucList = bulunanSonucSayisi.getText().split(" ");
        int result = Integer.parseInt(sonucList[1].replace(".", ""));
        if (result > 100000000) {
            System.out.println("fazla");
        } else System.out.println("fazla degil");

        //8 Sayfayi kapatin
        driver.close();


    }
}
