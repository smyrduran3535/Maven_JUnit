package day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilies.TestBase;

public class C01_Actions05 extends TestBase {
    @Test
    public void keyboardActions() {
        //Google a gidin https://www.google.com
        driver.get("https://www.google.com");
        //‘iPhone X fiyatlari’ yazdir (SHIFT TUSUNA BASILARAK)
        //‘iPhone X fiyatlari’ yazdir (SHIFT TUSUNA BASILARAK)
        //‘ cok pahali!’ Yazdır (SHIFT TUSUNA BASILMAYARAK)
        //Ve ENTER tusuna bas
        WebElement aramaKutusu=driver.findElement(By.name("q"));//id,name,x-path.css en iyisi
        //aramaKutusu.sendKeys("iphone x fiyatlari"+ Keys.ENTER); eski yontem bu actions classsız..bu kalıp harfi harfine gonderir
        // yani biz ne gonderirsek onu yazar; farklı tuslara basamayız.acsionlarda 1den fazla parametre alınabilir
        Actions actions = new Actions(driver);
        actions
                .keyDown(aramaKutusu,Keys.SHIFT)//arama kutusunun ustunde Shift bas
                .sendKeys("iphone x fiyatlari")//shifte basiliyken yaz
                .keyUp(aramaKutusu,Keys.SHIFT)//shift'e basmayi birak(realize ile benzer click de kullanılır)
                .sendKeys(" cok pahali" + Keys.ENTER)//normal halde yaz ve Enter tusuna bas
                .build()//birden fazla actions kull da build() onerilir
                .perform();
    }
}
