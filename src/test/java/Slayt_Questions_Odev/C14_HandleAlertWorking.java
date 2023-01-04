package Slayt_Questions_Odev;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilies.TestBase;

public class C14_HandleAlertWorking extends TestBase {
    @Before
    public void setup() {
        //● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @Test
    public void acceptAlert() {
        //● Bir metod olusturun: acceptAlert
        //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        //“You successfully clicked an alert” oldugunu test edin.
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        driver.switchTo().alert().accept();
        WebElement result = driver.findElement(By.id("result"));
        Assert.assertTrue(result.isDisplayed());
    }

    //● Bir metod olusturun: dismissAlert
    @Test
    public void dismissAlert() {
        //○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        driver.switchTo().alert().dismiss();
        WebElement result = driver.findElement(By.xpath("//p[text()='You clicked: Cancel']"));
        //“successfuly” icermedigini test edin.
        Assert.assertNotEquals(result, "successfuly");
    }

    //● Bir metod olusturun: sendKeysAlert
    @Test
    public void sendKeysAlert() {
        //○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        //tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın
WebElement sendKeys=driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
sendKeys.click();
driver.switchTo().alert().sendKeys("sumeyra");
driver.switchTo().alert().accept();
        WebElement result = driver.findElement(By.xpath("//p[text()='You entered: sumeyra']"));
Assert.assertTrue(result.isDisplayed());
    }
}
