package homework;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilies.TestBase;

public class C03_ActionsClassHomeWork extends TestBase {
    @Test
    public void test01() {
        //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
      driver.get("http://webdriveruniversity.com/Actions");
       // 2- Hover over Me First" kutusunun ustune gelin
        Actions actions=new Actions(driver);
       WebElement hover= driver.findElement(By.xpath("(//div[@class='dropdown hover'])"));
       actions.moveToElement(hover).perform();
       //Link 1" e tiklayin

        WebElement link=driver.findElement(By.linkText("Link 1"));
        actions.click(link).perform();
        //Popup mesajini yazdirin
        System.out.println("driver.switchTo().alert().getText() = " + driver.switchTo().alert().getText());
        //Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        //“Click and hold" kutusuna basili tutun
        WebElement clickHold=driver.findElement(By.id("click-box"));
        actions.moveToElement(clickHold).perform();
        //7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println("clickHold.getText() = " + clickHold.getText());
        //8- “Double click me" butonunu cift tiklayin
        WebElement doubleClick=driver.findElement(By.xpath("//h2"));
        actions.contextClick(doubleClick).perform();
    }
}
