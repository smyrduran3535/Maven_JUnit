package day08;

import org.apache.commons.compress.harmony.unpack200.bytecode.forms.SwitchForm;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilies.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class C01_HandleWindows1 extends TestBase {
    //1 ) Icinde oldugumuz sayfanin window handle degerini alma
    //driver.getWindowHandle(); => istenilen pencereyi verir :O sayfanın ID yi verir

    //driver.getWindowHandles(); => tum pencereleri birlikte verir ==> Set Of String verir ; kull nedenimiz : pencerelerin kodlarını baska turlu alamayız
    //loop koyarız;w.Handle diger handle eis mi diye sorarız... bunlar selenium 3 ve 2 de ve 4 de de kull handle ve handles

    //2 ) Pencereler arasında geçiş yapma(switch)
    //driver.switchTo().window(sayfa1HandleDegeri);

    //3 ) Yeni tab olusturup geçiş yapma(switch)
    //driver.switchTo().newWindow(WindowType.TAB);

    //4 ) Yeni window olusturup geçiş yapma(switch)
    //driver.switchTo().newWindow(WindowType.WINDOW);

     @Test
    public void test() throws InterruptedException {

    //https://the-internet.herokuapp.com/windows adresine gidin.
    driver.get("https://the-internet.herokuapp.com/windows");

    //İLK SAYFANIN HANDLE INI İD SİNİ ALALIM:
    String window1Handle= driver.getWindowHandle();

    //Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    String text=driver.findElement(By.xpath("//h3")).getText();
    Assert.assertTrue(text.contains("Opening a new window"));

    //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    String title=driver.getTitle();
    String expectedTitle="The Internet";
    Assert.assertEquals(expectedTitle,title);

    //Click Here butonuna basın.
    driver.findElement(By.xpath("//*[@href='/windows/new']")).click();

    //Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
    String newWindowTitle=driver.getTitle();
         System.out.println("newWindowTitle = " + newWindowTitle);//bu ilk sayfayı print eder new window sayfası acılsa da=>  The Internet
         String expectedTitleNew="New Window";
    Thread.sleep(3000);


    //BU NOKTADA 2 PENCERE ACIK VE IKINCISINE GECİS YAPMAK İSTIYORUM

    //BUNU YAPMAK İCİN driver.getWindowHandles(); ILE TUM PENCERELERİN ID LERİNİ ALALIM
    Set<String> allWindowHandles=driver.getWindowHandles();//{window1handle,window2handle}
    System.out.println(allWindowHandles);
/*
Set<String> tumPencereler= driver.getWindowHandles();//buradan iki tane handle gelecek
tumPencereler.stream().filter(t->!t.equals(handle1)).forEach(t->driver.switchTo().window(t));
 */
    //eger listedeki id windows1 e esit degilse ,otomatik olarak window 2 ye esittir
    for (String w:allWindowHandles){
        if (!w.equals(window1Handle)){
            driver.switchTo().window(w);//burdaki w digerine esit oldu :window2 id sine esit oldu
        }
    }//burda driver 2. pencerede artık
    //    Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
    Assert.assertEquals("New Window",driver.getTitle());
    //    Sayfadaki textin “New Window” olduğunu doğrulayın.
    Assert.assertEquals("New Window",driver.findElement(By.xpath("//h3")).getText());
String window2Handle=driver.getWindowHandle();//burda driver 2.sayfanın idsini verir

    //Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.

    //1.windowsa gecis
    driver.switchTo().window(window1Handle);
    //sayfa başlığının “The Internet” olduğunu  doğrulayın.

    Assert.assertEquals("The Internet",driver.getTitle());
    Thread.sleep(3000);
    //2. windowa tekrar gecelim

    driver.switchTo().window(window2Handle);
    Thread.sleep(3000);

    //1. windowa tekrar gecelim
    driver.switchTo().window(window1Handle);

}
    //windowNumber sıfır (0)'dan başlıyor.
    public static void switchToWindow2(int windowNumber){
        List<String> list = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(list.get(windowNumber));
    }
}
