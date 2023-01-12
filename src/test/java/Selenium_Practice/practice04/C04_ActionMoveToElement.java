package Selenium_Practice.practice04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilies.TestBase;

import java.util.Set;

public class C04_ActionMoveToElement extends TestBase {
    @Test
    public void test() {
        // https://amazon.com adresine gidiniz
        driver.get("https://amazon.com");
        String sayfa1Handle=driver.getWindowHandle();

        // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
        Actions actions=new Actions(driver);
        WebElement dilSecenegi=driver.findElement(By.xpath("//span[@class='icp-nav-flag icp-nav-flag-us icp-nav-flag-discoverability-t1']"));
        actions.moveToElement(dilSecenegi).perform();

        // Change country/region butonuna basiniz
        driver.findElement(By.xpath("(//*[text()='Change country/region.'])[1]")).click();

        // United States dropdown'undan 'Turkey (Türkiye)' seciniz
        WebElement ddm=driver.findElement(By.xpath("//select[@id='icp-dropdown']"));
        Select select=new Select(ddm);
        select.selectByVisibleText("Turkey (Türkiye)");

        driver.findElement(By.xpath("//span[text()='Changing country/region website']")).click();
        // boş bir yere click yaptık dropdown kapansın diye

        // Go to website butonuna tiklayiniz
        driver.findElement(By.xpath("//input[@class='a-button-input']")).click();


        // acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz
        Set<String> tumHandle=driver.getWindowHandles();
        String sayfa2Handle="";
        for (String w:tumHandle){
            if (!w.equals(sayfa1Handle)){
                sayfa2Handle=w;
            }

        }
        driver.switchTo().window(sayfa2Handle);
        String actualTitle=driver.getTitle();
        Assert.assertTrue(actualTitle.contains("Elektronik"));
    }
}
