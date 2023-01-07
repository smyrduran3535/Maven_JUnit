package day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilies.TestBase;

public class C02_HandleWindows2 extends TestBase{

    @Test
    public void windowHandle() {
        //https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String window1= driver.getTitle();
        System.out.println("window1 = " + window1);

        //Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String actualOpeningNewWindowText= driver.findElement(By.xpath("//*[.='Opening a new window']")).getText();
        String expectedOpeningNewWindowText="Opening a new window";
        Assert.assertEquals(expectedOpeningNewWindowText,actualOpeningNewWindowText);

        //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitle= driver.getTitle();
        String expectedTitle="The Internet";
        Assert.assertEquals(expectedTitle,actualTitle);

        //Click Here butonuna basın.
       // driver.findElement(By.xpath("//*[.='Click Here']"));genelde link kullanıyor hoca burda
        driver.findElement(By.linkText("Click Here")).click();

        waitFor(3);

        //2.PENCRE ACILIYOR ve IKINCI PENCEREDE ISLEM YAPMAK İSTEDİGİMDEN , O PENCEREYE SWİCTCH-GECİS YAPMALIYIZ
        //Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin

        switchToWindow(1);//windowa gecis yaptık driver artik 2. window da
        //switchToWindow("");icine sayfanın adini yazarız yada int deger koyarız
        String actualWindow2=driver.getTitle();
        String expectedWindos2="New Window";
        Assert.assertEquals(expectedWindos2,actualWindow2);
        System.out.println("window2 = " +actualWindow2);

/* URL OLUSTURDUGUMUZ METHOD İLE DE YENİ SAYFAYA GECİS YAPABİLİRİZ
public static void switchToWindow_URL(String url) {
    for (String w : driver.getWindowHandles()) {
        driver.switchTo().window(w);
        if(driver.getCurrentUrl().equals(url))
        return;
    }
}
 */

    }
}
