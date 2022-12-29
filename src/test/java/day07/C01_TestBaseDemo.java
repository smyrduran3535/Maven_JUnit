package day07;

import org.junit.Assert;
import org.junit.Test;
import utilies.TestBase;

public class C01_TestBaseDemo extends TestBase {
    /*
   UTILITIES
   -Utilities tekrar tekrar kullanacagimiz class'lari koydugumuz paketin adidir.
        - TestBase
        - Driver -> Sonra
        - ExcelUtil -> Sonra
        - Configuration -> Sonra

   - Utilities paketinde Test case'ler yazilmaz.
   - Sadece tekrar kullanilabilecek destek siniflari(Support Class) olusturulur.
   - Bu support class'lar test case'lerin yazilmasini hizlandirir.
 */
    @Test
    public void test01(){
        //techproeducation ana sayfasına git

        driver.get("https://www.techproeducation.com");
        //ve title 'Bottcamps' kelimesini icerdigini test edlim
        String  pageTitle= driver.getTitle();
        Assert.assertTrue(pageTitle.contains("Bootcamps"));
    }
}
