package S_Challenge;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilies.TestBase;

public class Day13_Challenge_Sahibinden extends TestBase {
    @Test
    public void test() {
         //sahibinden.com a gidin
        driver.get("https://www.sahibinden.com");

         //anasayfada oldugunuzu dogrulayin
        WebElement page=driver.findElement(By.xpath("//a[@title='sahibinden.com anasayfasına dön']"));
        Assert.assertTrue(page.isDisplayed());
        if (driver.findElement(By.xpath("//*[@id='onetrust-reject-all-handler']")).isDisplayed()) {
            driver.findElement(By.xpath("//*[@id='onetrust-reject-all-handler']")).click();
        }
         //detayli arama tiklayin
        driver.findElement(By.xpath("//a[@title='Detaylı Arama']")).click();
         //detayli arama sayfasina geldiginizi dogrulatin
         WebElement detayliArama=driver.findElement(By.xpath("//body[@class='desktop win']"));
         Assert.assertTrue(detayliArama.isDisplayed());
         //emlak-konut-satilik seceneklerini secip
        //altta cikan butun filtre seceneklerine en az bir filtre degeri girip en sonundaki arama yap tusuna tiklayin
        //filtreler için sağıdakilere benzer methodlar oluşturun
        driver.findElement(By.xpath("(//span[text()='Emlak'])[1]")).click();
        waitFor(1);
        driver.findElement(By.xpath("//span[text()='Konut']")).click();
        waitFor(1);
        driver.findElement(By.xpath("//span[text()='Satılık']")).click();
        waitFor(1);
        driver.findElement(By.xpath("//span[text()='Daire']")).click();
               //detayli_Arama_Adres("izmir", "bayrakli", "adalet mah.");
               //detayli_Arama_Fiyat("4.000","4.000.000","USD");
               //detayli_Arama_Brut("180","400");
               //detayli_Arama_Oda_Sayisi("10 Üzeri");//0-43 arasi

        detayli_Arama_Adres("İzmir", "Bayrakli", "Adalet mah.");
        detayli_Arama_Fiyat("4.000","4.000.000","USD");
        scrollDownActions();
        scrollDownActions();
        detayli_Arama_Brut("180","400");
        detayli_Arama_Oda_Sayisi("4");//0-43 arasi

        //.
               //.
               //...
        //cikan sonuc sayisini veya sonuc yoksa bunu bildiren yaziyi konsolda yazdirin


        WebElement aramaYap=driver.findElement(By.xpath("//button[@value='Arama Yap']"));

       doubleClick(aramaYap);
        WebElement sonucYazi= driver.findElement(By.xpath("//div[@class='mtmdef pvmdef phmdef clearfix searchFooter']"));
    Assert.assertTrue(sonucYazi.isDisplayed());
        System.out.println("sonucYazi = " + sonucYazi);
    }
    public void detayli_Arama_Adres(String il, String ilce, String mah) {
        WebElement Adres1 = driver.findElement(By.xpath("(//*[@class='faceted-select'])[1]"));
        Adres1.click();
        WebElement ilyaz = driver.findElement(By.xpath("//input[@placeholder='İl']"));
        ilyaz.sendKeys(il);
        waitFor(2);
        driver.findElement(By.xpath("//a[contains(text(),'" + il + "')]")).click();
        WebElement Adres2 = driver.findElement(By.xpath("(//*[@class='faceted-select'])[2]"));
        Adres2.click();
        waitFor(2);
        WebElement semtyaz = driver.findElement(By.xpath("//input[@placeholder='İlçe']"));
        semtyaz.sendKeys(ilce);
        driver.findElement(By.xpath("//a[contains(text(),'" + ilce + "')]")).click();
        driver.findElement(By.xpath("//a[@class='collapse-pane']")).click();
        WebElement Adres3 = driver.findElement(By.xpath("(//*[@class='faceted-select'])[3]"));
        Adres3.click();
        WebElement mahlyaz = driver.findElement(By.xpath("//input[@placeholder='Semt / Mahalle']"));
        mahlyaz.sendKeys(mah);
        driver.findElement(By.xpath("//a[normalize-space()='" + mah + "']")).click();
        waitFor(2);
        driver.findElement(By.xpath("//a[@class='collapse-pane']")).click();
    }
    public void detayli_Arama_Fiyat(String min,String max, String paraCinsi){
        WebElement minDeger=driver.findElement(By.xpath("//input[@placeholder='Min TL']"));
minDeger.click();
minDeger.sendKeys(min);
        WebElement maxDeger=driver.findElement(By.xpath("//input[@placeholder='Max TL']"));
        maxDeger.click();
        maxDeger.sendKeys(max);
        WebElement doviz= driver.findElement(By.xpath("//select[@name='price_currency']"));
     doviz.click();
     doviz.sendKeys(paraCinsi);

    }
    public void detayli_Arama_Brut(String min_m2,String max_m2){
WebElement minBrut=driver.findElement(By.xpath("//input[@placeholder='Min m² (Brüt)']"));
minBrut.click();
minBrut.sendKeys(min_m2);
        WebElement maxBrut=driver.findElement(By.xpath("//input[@placeholder='Max m² (Brüt)']"));
        maxBrut.click();
        maxBrut.sendKeys(max_m2);

    }
    public void detayli_Arama_Oda_Sayisi(String odaSayisi){
        Actions actions=new Actions(driver);
   WebElement odaYer= driver.findElement(By.xpath("(//table[@class='categorySubTable']//td[@class='second']//div[@class='filtered-select closed js-filtered-select'])[1]"));
   actions.moveToElement(odaYer).perform();
   WebElement oda=driver.findElement(By.xpath("//input[@name='select_a20']"));
    Select select=new Select(oda);
    select.selectByValue(odaSayisi);
    }
}
