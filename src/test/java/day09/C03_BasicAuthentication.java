package day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilies.TestBase;

public class C03_BasicAuthentication extends TestBase {
//BasicAuthentication: dogrulama demek;
    /*
            Bir class olusturun : BasicAuthentication
       https://the-internet.herokuapp.com/basic_auth sayfasina gidin
       asagidaki yontem ve test datalarini kullanarak authentication’i yapin
       URL              : https://username:password@URL
       Username    : admin
       password    : admin
       Basarili sekilde sayfaya girin ve ‘Congratulations!’ yasizini doğrulayın
     */

    @Test
    public void basicAuthenticationTest() {
        driver.get("https://the-internet.herokuapp.com/basic_auth");
        //Authentication url ımız:
        //domain kısmı :the-internet.herokuapp.com/basic_auth
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");//Sayfaya boyle gidilir otomatik yazılıp acılır sayfa
        waitFor(3);
        String congratulations=driver.findElement(By.xpath(" //p")).getText();
        String expected="Congratulations!";
       Assert.assertTrue(congratulations.contains(expected));
    }
}
