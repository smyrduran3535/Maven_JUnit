package Selenium_Practice.practice02;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P02 extends TestBasePrcts{
    @Test
    public void test(){

  // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
  driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
  // ikinci emojiye tıklayın
    WebElement iframe= driver.findElement(By.xpath("//*[@id='emoojis']"));
    driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("(//*[@data-upgraded=',MaterialRipple'])[2]")).click();
  // tüm ikinci emoji öğelerini tıklayın
        List<WebElement> allEmoji= driver.findElements(By.xpath("//*[@id='nature']//div//img"));
       allEmoji.forEach(WebElement::click);

      //allEmoji.forEach(WebElement::click);//lambda ile click
      // for (WebElement w:allEmoji){//foreach ile click etme
      //     w.click();
      // }

  // parent iframe e geri donun =>>> bir ust sayfaya geri donun
        //driver.switchTo().defaultContent();//1.yol: sayfada kalıyor
        driver.navigate().refresh();//buda sayfayı geriye dondurur yenileyerek ilk actıgı hale doner
        //formu doldurmak icin ustu kapat
  // formu doldurun,(Formu istediğiniz metinlerle doldurun)
        //driver.findElement(By.xpath("//*[@id='text']")).sendKeys("sumeyra",Keys.TAB,"Dur"); =>boyle doldurmak yerine arraye 11 tane kutuyu index aldık
        List<WebElement> list = driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));
        List<String> veriler = new ArrayList<>(Arrays.asList(
                "Erol","Evren","selenium","lambda","java","sql","gitgithub","fsd","dfasf","lkjl","asdasd","asd","sda"));
        for (int i = 0; i < list.size(); i++) {
            list.get(i).sendKeys(veriler.get(i));
        }
   //  apply button a basin
      driver.findElement(By.xpath("//*[.='Apply']")).click();
    }
}
