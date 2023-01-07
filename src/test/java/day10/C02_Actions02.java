package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilies.TestBase;

public class C02_Actions02 extends TestBase {
    @Test
    public void hoverOverTest() {
        /*
        Yeni bir class olusturalim: MouseActions3
        1 https://www.amazon.com/ adresine gidelim
        2 Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin
          mouse’u bu menunun ustune getirelim
        3 “Create a list” butonuna basalim
        4 Acilan sayfada “Your Lists” yazisi oldugunu test edelim
        */
/*
MANUAL:
1. Amazon home sayfasina git
2. Account & list e uzerinde bekle :mouse over=hover over yap
3.Acilan pencerede Account linkine tokla
4.Acilan sayfanin Title inin, your Account oldugunu dogrula
 */
//        Amazon home sayfasina git
        driver.get("https://www.amazon.com/");
        //        Account & List e uzerinde bekle -mouse over - hover over
//        1. ACTIONS OBJESI
        Actions actions = new Actions(driver);

//        2.ELEMANI BUL:
        WebElement accauntList = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        waitFor(2);
//         3.UYGUN ACTİONS METHODUNU KULLAN, EN SONA PERFORM KULLANMAYI UNUTMA
        actions.moveToElement(accauntList).perform();
        waitFor(3);


//        Acilan pencerede Account linkine tikla
        driver.findElement(By.linkText("Account")).click();

//        Acilan sayfanin title inin Your Account icerdigini dogrula
        Assert.assertTrue(driver.getTitle().contains("Your Account"));


    }
}
