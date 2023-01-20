package Day17_JS;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import utilies.TestBase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class C01_Js_Executer_Scroll extends TestBase {

    /*
     Javascript Executer: selenyumun bir parcasıdır. javascript kodlarını java frameworkinde kullanılan bir API.
     java kodlarını okumaya yarar.Bu API selenyumdan gelir.bazı selenyum komutları yetrerli olmayabilir;
     Bu sorun JSExecuter ile cozebiliriz..

    click:Hidden elementlere tıklar. browserların dili Js dir...inputlara yazı yazma, deger atama, metinlerini alma,
    asagı,yukarı,saga ,sola scroll yapma,degistirme,arka plan rengini degistirme,borde(cerceve).... yapmak icin kullanırız....
    mecbur kalmadıkca kullanmayız...

     */
    @Test
    public void scrollIntoViewTest() throws IOException {


            driver.get("https://www.techproeducation.com");
            waitFor(3);
//        1. Elementi bul
            WebElement weOffer = driver.findElement(By.xpath("//span[.='we offer']"));
            waitFor(3);
//        2. JS executor objesi olustur
            JavascriptExecutor js = (JavascriptExecutor)driver;
//        3. Yapmak istedigim islemi js.executeScript metot u ile yap
//        scrollIntoView(true); metotu belirli bir elemente scroll yapmak icin kullanilir
//        arguments[0] ILK PARAMETREDEKI ELEMENT
            js.executeScript("arguments[0].scrollIntoView(true);",weOffer);
            waitFor(3);
//        sayfa goruntusunu al
            takeScreenShotOfPage();
        //Ayni sayfada Enroll Free elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
scrollIntoViewJs(driver.findElement(By.xpath("//span[.='Enroll Free Course']")));
waitFor(3);
takeScreenShotOfPage();
        //Ayni sayfada WHY US? elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
scrollIntoViewJs(driver.findElement(By.xpath("//h3[.='WHY US?']")));
waitFor(2);
takeScreenShotOfPage();
        //Ayni sayfada tekrar Enroll Free elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
        scrollIntoViewJs(driver.findElement(By.xpath("//span[.='Enroll Free Course']")));
        waitFor(3);
        takeScreenShotOfPage();
scrollTopJS();
waitFor(2);
scrollEndJS();
waitFor(2);
    }

}
