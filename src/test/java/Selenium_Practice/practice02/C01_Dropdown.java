package Selenium_Practice.practice02;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilies.TestBase;

import java.util.List;

public class C01_Dropdown extends TestBasePrcts {
    @Test
    public void test01() {
    //Amazon sayfasına gidelim
        driver.get("https://amazon.com");
    //Dropdown menuden baby seçelim
    //arama bölumunden milk aratalım
        WebElement dropdown= driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        List<WebElement> dropdowwn=driver.findElements(By.xpath("//*[@id='searchDropdownBox']"));
        dropdowwn.forEach(t-> System.out.println(t.getText()));//select classını kullanmadan menuyu list ile yazdırdık
     /*
     Select select=new Select(dropdown);
       for(WebElement w:select.getOptions()){
           System.out.println(w.getText());
       }
       bu da butun listi veriyor...
      */
        driver.findElement(By.xpath("//*[@id='searchDropdownBox']")).
                sendKeys("Baby", Keys.TAB,"Milk",Keys.ENTER);//baby yazıp milk arattı

    }
}
