package Selenium_Practice.day04;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilies.TestBase;

public class P05_Actions extends TestBase {
    @Test
    public void test() {
        //-http://spicejet.com/ sayfasına gidelim
        driver.get("http://spicejet.com/");
        //        -Sayfanın altındaki about us bölümü altındaki fleet linkine tıklayalım
       WebElement aboutUs=driver.findElement(By.xpath("//*[.='About Us']"));
       Actions actions=new Actions(driver);
       actions.moveToElement(aboutUs).perform();//mause u elementin uzerine goturuyor
            //bunu yapmadan fleet e click yaptırmaz bazı siiteler..actions classı bunucozuyor
        driver.findElement(By.xpath("//*[text()='Fleet']")).click();
        //-Sayfa başlığının Fleet içerdiğini test edelim

    }
}
