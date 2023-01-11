package Selenium_Practice.day04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilies.TestBase;

import java.util.ArrayList;
import java.util.List;

public class P06_Actions extends TestBase {
    @Test
    public void test() {
        //https://demoqa.com/ url'ine gidin.
        driver.get("https://demoqa.com/");
        //Alerts, Frame & Windows Butonuna click yap
        WebElement box = driver.findElement(By.xpath("(//*[@class='card-up'])[6]"));
        //clickWithText("div.card-body>h5","Alerts, Frame & Windows");
        Actions actions = new Actions(driver);
        actions.moveToElement(box).perform();
        box.click();
        //""Please select an item from left to start practice."" yazısının görünür olduğunu doğrula
        WebElement text = driver.findElement(By.xpath("//*[text()='Please select an item from left to start practice.']"));
        Assert.assertTrue(text.isDisplayed());
        //Sol'da açılan Menu den ""Browser Windows"" butonuna click yap
        driver.findElement(By.xpath("(//*[@id='item-0'])[3]")).click();
        //New Tab butonunun görünür olduğunu doğrula
        WebElement newTab = driver.findElement(By.id("tabButton"));
        Assert.assertTrue(newTab.isDisplayed());
        //New Tab butonuna click yap
        String firstTab = driver.getWindowHandle();
        newTab.click();
        //Açılan yeni Tab da ""This is a sample page"" yazısının görünür olduğunu doğrula
        List<String> allWindow = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(allWindow.get(1));
        WebElement samplePage = driver.findElement(By.xpath("//*[@id='sampleHeading']"));
        Assert.assertTrue(samplePage.isDisplayed());
        //İlk Tab'a geri dön
        driver.switchTo().window(allWindow.get(0));
        ////New Tab butonunun görünür olduğunu doğrula
        Assert.assertTrue(newTab.isDisplayed());
    }

}
