package S_Challenge;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilies.TestBase;

public class Decision_Table_Testing extends TestBase {
    @Test
    public void test() {
        //https://www.n11.com/ ' da
        //Decision table testing yaparak tum olasiliklar icin login page'in bize verecegi responselari test edin.
        //n11ValidEmail=test.123.yap@gmail.com
        //n11ValidPassword=Deneme123!
    }

    @Test
    public void text01() { //yanlış mail & doğru şifre
        hesabaGirisYap("test.12.yap@gmail.com", "Deneme123!");
        WebElement hataMesaji = driver.findElement(By.xpath("(//*[@class='errorMessage'])[4]"));
        hataMesaji.isEnabled();
    }

    @Test
    public void test02() {
        hesabaGirisYap("test123yap@gmail.com", "deneme12"); //yanlış mail & yanlış şifre
        WebElement hataMesaji = driver.findElement(By.xpath("(//*[@class='errorMessage'])[4]"));
        hataMesaji.isEnabled();
    }

    @Test
    public void test03() {
        hesabaGirisYap("test.123.yap@gmail.com", "deneme12"); //doğru mail & yanlış şifre
        WebElement hataMesaji = driver.findElement(By.xpath("(//*[@class='errorMessage'])[4]"));
        hataMesaji.isEnabled();
    }

    @Test
    public void test04() {
        hesabaGirisYap("test.123.yap@gmail.com", "Deneme123!"); //doğru mail & doğru şifre
    //WebElement hesabim=driver.findElement(By.xpath("//*[@class='myAccount myAccountElliptical']"));
    //hesabim.isDisplayed();
    }

    public void hesabaGirisYap(String mailadresi, String sifre) {
        driver.get("https://www.n11.com/");
        driver.findElement(By.xpath("//*[@title='Giriş Yap']")).click();
        WebElement textBox = driver.findElement(By.id("email"));
        textBox.click();
        textBox.sendKeys(mailadresi);
        WebElement passwordBox = driver.findElement(By.id("password"));
        passwordBox.click();
        passwordBox.sendKeys(sifre);
        driver.findElement(By.id("loginButton")).click();
    }
}