package Selenium_Practice.day05;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilies.TestBase;

public class C01_Faker extends TestBase {
    @Test
    public void test() {
        /*
                               - FAKER -
        Faker class'ı, adlar, telefon numaraları, adresler, SSN vb.
    gibi gerçek görünümlü verileri dinamik olarak oluşturmanıza olanak tanır.
    Web uygulamanızın bunları doğru bir şekilde kaydedeceğini bildiğiniz sürece,
    çoğu zaman ad veya adres gibi bu değerlerin ne olduğu umurunuzda olmaz ve faker kullanmak
    bu verileri modellemenize ve bu alanlar için şimdiye kadar test çalıştırması için yeni dinamik
    değerler oluşturmanıza olanak tanır.
        Faker class'ını kullanabilmemiz için mvn repository adresinden java faker kütüphanesini
    projemize eklememiz gerekmektedir.
     */
        //"https://demoqa.com/automation-practice-form"  Adresine gidin
        driver.get("https://demoqa.com/automation-practice-form");
        // Formu doldurunuz
       Faker faker = new Faker();
        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys(faker.name().firstName(), Keys.TAB,faker.name().lastName(),Keys.TAB,
                faker.internet().emailAddress(),Keys.TAB,Keys.SPACE,Keys.TAB,faker.phoneNumber().cellPhone(),Keys.TAB
                ,"20 Jul 1980",Keys.ENTER, Keys.TAB,faker.shakespeare().romeoAndJulietQuote(),Keys.TAB,Keys.SPACE);
        WebElement gıcıkButon= driver.findElement(By.id("subjectsInput"));
        gıcıkButon.sendKeys("Maths");
        gıcıkButon.sendKeys(Keys.ENTER);

        WebElement dosyaSec=driver.findElement(By.xpath("//input[@id='uploadPicture']"));
       String dosyaYolu="C:\\Users\\USER\\OneDrive\\Masaüstü\\image.png";
       String anaYol=System.getProperty("user.home");//C:\Users\USER\
       // String ortakYol="\\OneDrive\\Masaüstü\\image.png";
       // String dosyaYolu=anaYol+ortakYol;
       dosyaSec.sendKeys(dosyaYolu);
        driver.findElement(By.id("currentAddress")).sendKeys(faker.address().fullAddress(),Keys.TAB,"NCR",Keys.
                ENTER,Keys.TAB,"Delhi",Keys.ENTER,Keys.TAB,Keys.ENTER);
        // Sayfayi kapatin

    }
}
