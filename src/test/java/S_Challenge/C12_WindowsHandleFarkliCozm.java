package S_Challenge;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilies.TestBase;

import java.util.Set;

public class C12_WindowsHandleFarkliCozm extends TestBase {
    //https://demoqa.com/ url'ine gidin.
//Alerts, Frame & Windows Butonuna click yap
//""Please select an item from left to start practice."" yazısının görünür olduğunu doğrula
//Sol'da açılan Menu den ""Browser Windows"" butonuna click yap
//New Tab butonunun görünür olduğunu doğrula
//New Tab butonuna click yap
//Açılan yeni Tab da ""This is a sample page"" yazısının görünür olduğunu doğrula
//İlk Tab'a geri dön
////New Tab butonunun görünür olduğunu doğrula
    @Test
    public void test01() {
        //https://demoqa.com/ url'ine gidin.
        driver.get("https://demoqa.com/");
//Alerts, Frame & Windows Butonuna click yap
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();
        driver.findElement(By.xpath("(//*[@class='card mt-4 top-card'])[3]")).click();
//""Please select an item from left to start practice."" yazısının görünür olduğunu doğrula
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='col-12 mt-4 col-md-6']")).isDisplayed());
        //Sol'da açılan Menu den ""Browser Windows"" butonuna click yap
        driver.findElement(By.xpath("//span[text()='Browser Windows']")).click();
//New Tab butonunun görünür olduğunu doğrula
        WebElement tabButton=driver.findElement(By.xpath("//button[@id='tabButton']"));
        System.out.println(tabButton.getText());
        Assert.assertTrue(tabButton.isDisplayed());
//New Tab butonuna click yap
        tabButton.click();
        //Açılan yeni Tab da ""This is a sample page"" yazısının görünür olduğunu doğrula
String sayfa1=driver.getWindowHandle();
        System.out.println("sayfa1 = " + sayfa1);
        Set<String> sayfalar= driver.getWindowHandles();
        for (String w:sayfalar){
            if (!w.equals(sayfa1)){
                driver.switchTo().window(w);
                break;
            }
        }
        WebElement samplePage=driver.findElement(By.id("sampleHeading"));
        System.out.println(samplePage.getText());
        Assert.assertTrue(samplePage.isDisplayed());
//İlk Tab'a geri dön
        driver.switchTo().window(sayfa1);
////New Tab butonunun görünür olduğunu doğrula
        Assert.assertTrue(tabButton.isDisplayed());

    }
}
