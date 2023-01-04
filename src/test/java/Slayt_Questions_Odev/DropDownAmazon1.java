package Slayt_Questions_Odev;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilies.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DropDownAmazon1 extends TestBase {


        //● https://www.amazon.com/ adresine gidin.
        //- Test 1
        @Test
        public void test01() {
            driver.get("https://www.amazon.com/");
        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 28 oldugunu test edin
            WebElement dropdown= driver.findElement(By.id("searchDropdownBox"));
            Select select=new Select(dropdown);
            System.out.println(select.getOptions().size());

            //1. Kategori menusunden Books secenegini secin
          //dropdown.sendKeys("Books", Keys.ENTER);    1.yol normal klasik fakat liste seklinde asagıda gosteriyor
            select.selectByVisibleText("Books");//2.yol select ile direk veriyor

        //2. Arama kutusuna Java yazin ve aratin
            driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java",Keys.ENTER);
        //3. Bulunan sonuc sayisini yazdirin
          WebElement sonuc=driver.findElement(By.xpath("//span[.='1-16 of over 30,000 results for']"));
            List<String> mylist= new ArrayList<String>(Arrays.asList(sonuc.getText().split(" ")));
            System.out.println(mylist.get(3));

        //4. Sonucun Java kelimesini icerdigini test edin
            String java = driver.findElement(By.xpath("//*[@class='sg-col-inner']")).getText();
            Assert.assertTrue(java.contains("Java"));
    }
}
