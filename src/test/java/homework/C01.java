package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilies.TestBase;

import java.util.List;
import java.util.Set;

public class C01 extends TestBase {
    //Bir class olusturun: IframeOdev
    @Test
    public void test() {
        //https://the-internet.herokuapp.com/iframe  sitesine gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");
//sayfadaki toplam iframe sayısını bulunuz.
        List<WebElement> iframe = driver.findElements(By.tagName("iframe"));

        System.out.println("iframe.size() = " + iframe.size());

//Sayfa basliginda 'Editor' yazını içerdiğini test edelim.
        String actualTitle = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertTrue(actualTitle.contains("Editor"));

//Paragrafdaki yaziyi silelim
        driver.switchTo().frame(0);
        WebElement iframeText = driver.findElement(By.xpath("//*[text()='Your content goes here.']"));
        while (true) {
            if (!iframeText.getText().equals("")) {
                iframeText.clear();
            } else {
                break;
            }
        }

//Sonrasinda paragrafa "iframein icindeyim" yazisini yazdıralım
        driver.findElement(By.id("tinymce")).sendKeys("iframein icindeyim");
//Alt kısımdaki yazının 'Elemental Selenium' yazisini içerdiğini test edelim
driver.switchTo().defaultContent();
String disKisimMetin=driver.findElement(By.xpath("//*[text()='Powered by ']")).getText();
Assert.assertTrue(disKisimMetin.contains("Elemental Selenium"));
    }
}
