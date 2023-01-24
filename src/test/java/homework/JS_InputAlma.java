package homework;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilies.TestBase;

public class JS_InputAlma extends TestBase {
    @Test
    public void getValueTest() {
        //1)
        //	2)https://www.priceline.com/ a git
        driver.get("https://www.priceline.com/");
        //	3)Tarih kısmındaki Yazili metinleri al ve yazdır

//id:hotelDates
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String date = (String) js.executeScript("return document.getElementById('hotelDates').getAttribute('value')");
        System.out.println(date);//gettext ile alamayız input elemanı yani degeri o yuzden js kullandık,gettext olsaydı js kullanmazdık
    }
//kısacası gettext calısmıyorsa Javascript executors kullanırız
    ///  Belirli bir WebElement'in id değerini String olarak alır ve value attribute değerini String olarak döndürür
    //JavaScriptExecutor ile input elementindeki değerleri almak için aşağıdaki adımları izleyebilirsiniz:
//Web sayfasındaki input elementini locate etmek için WebDriver kullanabilirsiniz. Örneğin, "id" veya "name" attribute'una göre elementi seçebilirsiniz.
//JavaScriptExecutor'u kullanarak, input elementinin "value" attribute'unu alabilirsiniz. Örnek olarak aşağıdaki gibi bir kod kullanabilirsiniz:
//
//WebElement element = driver.findElement(By.id("inputId")); JavascriptExecutor js = (JavascriptExecutor) driver; String value = (String) js.executeScript("return arguments[0].value", element);
//executeScript metodu ile input elementinin value attribute'unu almış oldunuz.
//Not: Bu kod örneği sadece id attribute'una göre elementi seçer. Eğer elementi başka bir yolla seçmek isterseniz, locate etme kodunu değiştirmeniz gerekebilir.
    //id si yoksa eger;
    //querySelector ile alınabilir====>>> document.querySelector("#hotelDates") gibi
    //NOT:     document.querySelector("p").value;  -> TAG KULLANILABILIR  tag icin
//             document.querySelector(".example").value; -> CSS DEGERI KULLANILABILIR class icin
//             document.querySelector("#example").value; -> CSS DEGERI KULLANILABILIR id icin

    @Test
    public void JSExecutor_GetValueTest() {
        driver.get("https://www.priceline.com/");
ValueByJS("hotelDates");
    }
    public void ValueByJS(String idOfElement){
JavascriptExecutor js= (JavascriptExecutor) driver;
String metin=js.executeScript("return document.getElementById('"+idOfElement+"').value").toString();//elemanın valuesinı return edecek..elementleri bulmak icin;getElementById kull..
        //sonra stringe cevirdik..istedigimiz attribute i alabiliriz bununla en cok id kullanılır
        System.out.println("kutudaki metin = " + metin);//kutunun icindeki deger her zaman value ya esittir
    }

    @Test
    public void name() {
        driver.get("https://www.priceline.com/");
        WebElement dropdown= driver.findElement(By.id("hotelDates"));
        Select select=new Select(dropdown);
     select.selectByValue("01/22/2023 – 01/25/2023");

    }
}
