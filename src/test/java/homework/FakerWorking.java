package homework;

import com.github.javafaker.Faker;
import net.bytebuddy.asm.Advice;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilies.TestBase;

public class FakerWorking extends TestBase {

    @Test
    public void test() {


        //Faker class’i testlerimizi yaparken ihtiyav duydugumuz isim, soyisim, adres vb bilgiler icin fake
        //degerler uretmemize imkan tanir.
        //Faker degerler uretmek icin Faker class’indan bir obje uretir ve var olan method’lari kullaniriz.
        //"https://facebook.com"  Adresine gidin
        driver.get("https://facebook.com");
        //“create new account”  butonuna basin
        driver.findElement(By.linkText("Yeni Hesap Oluştur")).click();
        //“firstName” giris kutusuna bir isim yazin
        Faker faker = new Faker();
        WebElement firstName =  driver.findElement(By.name("firstname"));
        //waitForVisibility(firstName,10);
        firstName.sendKeys(faker.name().firstName());
        //“surname” giris kutusuna bir soyisim yazin
        driver.findElement(By.name("lastname")).sendKeys(faker.name().lastName());
        //“email” giris kutusuna bir email yazin
        driver.findElement(By.name("reg_email__")).sendKeys(faker.internet().emailAddress());
        //“email” onay kutusuna emaili tekrar yazin
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys(faker.internet().emailAddress());
        //Bir sifre girin
        driver.findElement(By.name("reg_passwd__")).sendKeys(faker.internet().password());
        //Tarih icin gun secin
        String day = String.valueOf(faker.number().numberBetween(1,31));
        driver.findElement(By.name("birthday_day")).sendKeys(day);
        //Tarih icin ay secin
        Select dropDown = new Select(driver.findElement(By.name("birthday_month")));
        dropDown.selectByVisibleText("May");
        //Tarih icin yil secin
        String year = String.valueOf(faker.number().numberBetween(1905,2023));
        driver.findElement(By.name("birthday_year")).sendKeys(year);
        //Cinsiyeti secin
        WebElement woman = driver.findElement(By.xpath("//input[@value='1']"));
        woman.click();
        WebElement man = driver.findElement(By.xpath("//input[@value='2']"));
        WebElement other = driver.findElement(By.xpath("//input[@value='-1']"));
        //Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        Assert.assertTrue(woman.isSelected());
        Assert.assertFalse(man.isSelected());
        Assert.assertFalse(other.isSelected());
    }
}
