package Slayt_Questions_Odev;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilies.TestBase;

public class SlaytAction extends TestBase {
    @Test
    public void test() {
        //1 https://www.amazon.com/ adresine gidelim
        driver.get("https://www.amazon.com/");
        Actions actions=new Actions(driver);
WebElement account=driver.findElement(By.id("nav-link-accountList"));
        //2 Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin
        //mouse’u bu menunun ustune getirelim
        //3 “Create a list” butonuna basalim
        //4 Acilan sayfada “Your Lists” yazisi oldugunu test edelim
    }
}
