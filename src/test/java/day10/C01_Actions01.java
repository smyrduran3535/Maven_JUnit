package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilies.TestBase;

public class C01_Actions01 extends TestBase {
    @Test
    public void rightClickText() {//rightClick diye method yok; "contextClick" diye method sag click yapar
        //    https://the-internet.herokuapp.com/context_menu  sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
                        //==>>>3 ADIMDA YAPIYORUZ <<<===
                           //sag click yapıcaz ama once Actions objesi olusturmam gerekiyor.
                           // obje ile metodları kullanıcaz ve perform ile islemi gerceklestirmis olucaz

//        1. ACTIONS OBJESI OLUSTUR
        Actions actions = new Actions(driver);
//       2. ELEMENT I LOCATE ADELIM
        WebElement kutu = driver.findElement(By.id("hot-spot"));
//    Kutuya sag tıklayın
//        TUM ACTIONS LAR actions OBJESIYLE BASLAR permorm() ILE BITER
        actions.contextClick(kutu).perform();
//    Alert’te cikan yazinin “You selected a context menu” oldugunu test edin : alert().getText() ile alırız
//        Object olusturmak wait gerekdiren durumlarda makul:eger hardWait yada exclipseWait gerektiren durumlarda obje olusturulur;suan gereksiz
        Assert.assertEquals("You selected a context menu",driver.switchTo().alert().getText());//tek satırda boyle de alabiliriz
//    Tamam diyerek alert’i kapatın : kabul edince kapanacak
        driver.switchTo().alert().accept();
//Elemental Selenium linkine tiklayalim
         driver.findElement(By.xpath("//a[text()='Elemental Selenium']")).click();


//7 Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        switchToWindow(1);
        String h1Tagi=driver.findElement(By.xpath("//h1")).getText();

        Assert.assertEquals("Elemental Selenium",h1Tagi);
    }
}
