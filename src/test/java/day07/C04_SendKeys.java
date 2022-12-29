package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilies.TestBase;

public class C04_SendKeys extends TestBase {
    @Test
    public void test(){
        //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin,
        // OK butonuna tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        driver.switchTo().alert().sendKeys("Sumeyra");
        driver.switchTo().alert().accept();
String actualResult=driver.findElement(By.xpath("//*[text()='You entered: Sumeyra']")).getText();
String exceptedResult="Sumeyra";
        //Assert.assertEquals(exceptedResult,actualResult);//bunu kullanmak dogru olmaz false verir ;cunku gorunen You entered: Sumeyra bu
        //esitlik kesinliktir o yuzden contains deriz iceriyorsa tamamadır
        Assert.assertTrue(actualResult.contains(exceptedResult));
    }
}
