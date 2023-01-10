package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import utilies.TestBase;
import java.time.Duration;
public class C03_FluentWait extends TestBase {

    @Test
    public void fluentWaitTest() {//explicit wait cesididir
//https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
//Start buttonuna tıkla
        driver.findElement(By.xpath("//div[@id='start']//button")).click();
//Hello World! Yazının sitede oldugunu test et

        //ADIMLAR :1 Fluent Wait icin obje olustur
        Wait<WebDriver> wait=new FluentWait<>(driver).
                withTimeout(Duration.ofSeconds(30))//max.bekleme suresi.
                .pollingEvery(Duration.ofSeconds(3))//fluentwaiti farklı yapan bu. deneme aralıklarıdır : (su kadar sure bekle sonra bi daha dene demek)
                .withMessage("IGNORE EXCEPTION")//mesaj yazdırabilirim..opsiyonel olarak yani mecburi degil...
                .ignoring(NoSuchMethodError.class);//exceptionı yakala handle et yani imha et umursama ,zorunlu degil.

        //wait objesini kullanarak bekleme problemini coz
    WebElement helloWorldElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']//h4")));
  String helloWorldText= helloWorldElement.getText();
        Assert.assertEquals("Hello World!",helloWorldText);
    }
}
