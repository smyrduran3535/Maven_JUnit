package Slayt_Questions_Odev;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilies.TestBase;

import java.util.List;

public class C07_DropDownAmazon extends TestBase {
    @Test
    public void test01() {
        // https://www.amazon.com/ adresine gidin.
        driver.get("https://www.amazon.com/");
        //- Test 1
        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
        //1. Kategori menusunden Books secenegini secin
        WebElement drpdvm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(drpdvm);
        select.selectByVisibleText("Books");
    }


    @Test
    public void test02() {
        //-Test 2
        driver.get("https://www.amazon.com/");
        //2. Arama kutusuna Java yazin ve aratin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);
        //3. Bulunan sonuc sayisini yazdirin
        String[] sonucSayisi = driver.findElement(By.xpath("//*[text()='1-48 of over 6,000 results for']")).getText().split(" ");
        String sonuc = sonucSayisi[3];
        System.out.println("sonuc sayısı " + sonuc);
        //4. Sonucun Java kelimesini icerdigini test edin
        String java = driver.findElement(By.xpath("//*[@class='sg-col-inner']")).getText();
        Assert.assertTrue(java.contains("Java"));
    }
}
