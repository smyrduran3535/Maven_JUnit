package Slayt_Questions_Odev;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilies.TestBase;

public class C09_Challenge_Options extends TestBase {
    @Test
    public void test(){

        //1-https://rahulshettyacademy.com/AutomationPractice/ adresine gidin
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        //2-Dropdown Example menüsünün görünür olduğunu doğrulayın.
        WebElement example=driver.findElement(By.xpath("//*[.='Dropdown Example']"));
        Assert.assertTrue(example.isDisplayed());
        //3-Option3 ü seçin.
        WebElement dropDown=driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
        Select select=new Select(dropDown);
        select.selectByVisibleText("Option3");
        //4-Option3 ün seçili olduğunu doğrulayın.
String option3=select.getFirstSelectedOption().getText();
Assert.assertEquals("Option3",option3);
    }
}
