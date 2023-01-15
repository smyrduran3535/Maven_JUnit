package S_Challenge;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilies.TestBase;

public class C16_Can_Challenge_HoverOver extends TestBase {
    @Test
    public void hoverOverTest() {
        //1. "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        //2. "Hover over Me First" kutusunun ustune gelin
        Actions actions=new Actions(driver);
        WebElement hoverOverMeFirst= driver.findElement(By.xpath("(//div[@class='dropdown hover'])"));
        actions.moveToElement(hoverOverMeFirst).perform();
        //3- Link 1" e tiklayin
        driver.findElement(By.xpath("(//a[@class='list-alert'])")).click();
        //4- Popup mesajini yazdirin
        System.out.println("Pop-up mesaji : "+driver.switchTo().alert().getText());
        //5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        //6. "Click and hold" kutusuna basili tutun
        WebElement clickAndHoldButton= driver.findElement(By.id("click-box"));
        actions.clickAndHold(clickAndHoldButton).build().perform();

        //7. "Click and hold" kutusunda cikan yaziyi yazdirin
        String clickAndHoldMessage= driver.findElement(By.id("click-box")).getText();
        System.out.println("clickAndHoldMessage = " + clickAndHoldMessage);
        //8- “Double click me" butonunu cift tiklayin
        WebElement doubleClickMe=driver.findElement(By.tagName("h2"));
        actions.doubleClick(doubleClickMe).perform();

    }
}
