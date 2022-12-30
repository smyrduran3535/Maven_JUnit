package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilies.TestBase;

public class C02_AlersAccept extends TestBase {
//Bir class olusturun: Alerts
    @Test
    public void acceptAlert() throws InterruptedException {

//https://testcenter.techproeducation.com/index.php?page=javascript-alerts  adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
//Bir metod olusturun: acceptAlert
//1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.


//        1. butona tıklayın,
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        driver
                .switchTo()//degistir
                .alert()//alertu degistir
                .accept();//OK secenegine tıklar accept
        Thread.sleep(3000);
        //alert javaspriptin urettigi uyarı mesaji..
        //driver pencereye gelemedigi icin; switchto diyoruz degistir demek uyarıyı

//        uyarıdaki OK butonuna tıklayın
//        ve result mesajının
//       “You successfully clicked an alert” oldugunu test edin.
       String actualResult= driver.findElement(By.id("result")).getText();
       String excepedResult="You successfully clicked an alert";
        Assert.assertEquals(excepedResult,actualResult);
    }

    /*
    INTERWİEV SORUSU :

    Alertleri nasıl aoutomate edersin? how to handle alerts in selenium ?
    alertler javascipt ile olusur. inspect edilemezler.
    Oncelikle alerte switch etmemiz gerekir
     */
}
