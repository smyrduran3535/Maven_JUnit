package Selenium_Practice.practice02;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class P01 extends TestBasePrcts{
    @Test
    public void test01() throws InterruptedException {
        //    go to url :http://demo.automationtesting.in/Alerts.html
        driver.get("http://demo.automationtesting.in/Alerts.html");
        //    click  "Alert with OK" and click 'click the button to display an alert box:'
        //    accept Alert(I am an alert box!) and print alert on console
        //    click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
       WebElement alert=driver.findElement(By.xpath("//*[@onclick='alertbox()']"));
       alert.click();
        System.out.println(driver.switchTo().alert().getText());;
        driver.switchTo().alert().accept();
       // driver.findElement(By.className("analystic")).sendKeys(Keys.ENTER,Keys.TAB,Keys.TAB,Keys.TAB,Keys.ENTER);alert eediyor

        driver.findElement(By.xpath("(//*[@class='analystic'])[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@onclick='confirmbox()']")).click();
        //    cancel Alert  (Press a Button !)
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();
        //    click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
        //    and then sendKeys 'TechProEducation' (Please enter your name)
        driver.findElement(By.xpath("//*[text()='Alert with Textbox ']")).click();
        driver.findElement(By.cssSelector("button[onclick='promptbox()']")).click();
        driver.switchTo().alert().sendKeys("techproeducation");
        driver.switchTo().alert().accept();

        //    finally print on console this message "Hello TechProEducation How are you today"
        String actualText = driver.findElement(By.xpath("//*[@id='demo1']")).getText();
        System.out.println(actualText);

//    assertion these message
        Assert.assertNotEquals("Hello TechProEducation How are you today",actualText);

    }
}
