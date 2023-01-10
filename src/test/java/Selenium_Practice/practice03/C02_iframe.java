package Selenium_Practice.practice03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilies.TestBase;

public class C02_iframe extends TestBase {
    @Test
    public void test() {
        // ...Exercise 2...

        // https://the-internet.herokuapp.com/iframe sayfasina gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");
        // 'An iFrame containing the TinyMCE WYSIWYG Editor' basliginin erisilebilir oldugunu test edin ve konsolda yazdırın.
        WebElement text = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(text.isEnabled());//baslıga erisilebiliyor mu derken kullanırız
        System.out.println(text.getText());

        // TextBox'a 'Merhaba Dunya' yazin.
        WebElement iframe = driver.findElement(By.id("mce_0_ifr")); //iframi locate etmeliyiz
        driver.switchTo().frame(iframe); //iframe in web elementini parametre olarak yazmalıyız
        driver.findElement(By.xpath("//*[@id='tinymce']")).clear();
        driver.findElement(By.xpath("//*[@id='tinymce']")).sendKeys("Merhaba Dunya");

        // TextBox'in altinda bulunan 'Elemental Selenium' linkinin gorunur oldugunu test edin ve konsolda yazdirin
        driver.switchTo().defaultContent();
        WebElement seleniumYazisi = driver.findElement(By.xpath("//a[text()='Elemental Selenium']"));
        Assert.assertTrue(seleniumYazisi.isDisplayed());
        System.out.println(seleniumYazisi.getText());
    }
}
