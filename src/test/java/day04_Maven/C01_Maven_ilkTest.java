package day04_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_Maven_ilkTest {
    public static void main(String[] args) {


        //1 https://www.amazon.com/ sayfasina gidelim





        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");
        //2 arama kutusunu locate edelim
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));

        //3 “Samsung headphones” ile arama yapalim
        aramaKutusu.sendKeys("Samsung headphones");
        aramaKutusu.submit();//entera bastı
        //4 Bulunan sonuc sayisini yazdiralim
WebElement aramaSonucu=driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        System.out.println("arama sonucu" +aramaSonucu.getText());//gettext web elementi uzerindeki yazıyı alır
        //5 Ilk urunu tiklayalim
        driver.findElement(By.xpath("//*[@class='a-section aok-relative s-image-fixed-height']")).click();
        ////6 Sayfadaki tum basliklari yazdiralim : h1 h2 h3 .... baslıkları yazdırmak icin liste atayalım
        List<WebElement> sayfaBasliklariListesi=driver.findElements(By.xpath("//h1"));
      //  for (WebElement w: sayfaBasliklariListesi){
        //    System.out.println(w.getText());
        //}
//lambda ile de yazdıralım
        sayfaBasliklariListesi.forEach(t-> System.out.println(t.getText()));

        driver.close();
    }
}