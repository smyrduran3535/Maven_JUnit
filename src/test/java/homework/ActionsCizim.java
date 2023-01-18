package homework;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilies.TestBase;

public class ActionsCizim extends TestBase {
    @Test
    public void test() {

        //    - http://szimek.github.io/signature_pad/ sayfasına gidiniz
        driver.get("http://szimek.github.io/signature_pad/");
        //    - Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
        WebElement yaziTahtasi=driver.findElement(By.xpath("//canvas"));
        //mouse oraya goturmek icin action yap
        Actions actions=new Actions(driver);
        actions.moveToElement(yaziTahtasi).clickAndHold();
        //asagı yukarı cekebilmek icin donguye ihtiyacımız var
        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(5,5); //analitik duzlem yapıp cizgi cekiyor
        }
        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(0,5); //analitik duzlem yapıp cizgi cekiyor
        }
        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(5,-5); //analitik duzlem yapıp cizgi cekiyor
        }
        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(5,5); //analitik duzlem yapıp cizgi cekiyor
        }

        actions.release().build().perform();
        waitFor(5);
        driver.findElement(By.xpath("//*[text()='Clear']")).click();
        //    - Çizimden sonra clear butonuna basalım
        //    - Son olarak sayfayı temizleyiniz

    }
}
