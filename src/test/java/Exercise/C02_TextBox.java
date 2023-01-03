package Exercise;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilies.TestBase;

public class C02_TextBox extends TestBase {
    @Test
    public void test(){
        driver.get("https://demoqa.com/text-box/");
        driver.findElement(By.id("userName")).sendKeys("Sumeyra", Keys.TAB,"sdsdsd@gmail.com",Keys.TAB,
                Keys.ARROW_DOWN,"Turkey,Izmir,Sirinler mah. Guzel sk",Keys.TAB,Keys.ARROW_DOWN,"Turkey",Keys.TAB,Keys.ENTER);

        //elementteki texti alma
        WebElement nameText=driver.findElement(By.xpath("//*[@id='name']"));
        System.out.println("nameText.getText() = " + nameText.getText());
        WebElement emailText=driver.findElement(By.xpath("//*[@id='email']"));
        System.out.println("emailText = " + emailText);//boyle referans gelir
    }
    @Test
    public void radioButton(){
        driver.get("https://demoqa.com/automation-practice-form");
        WebElement radioButton= driver.findElement(By.xpath("//*[text()='Sports']"));
     boolean isEnable=radioButton.isEnabled();
        System.out.println("isEnable = " + isEnable);//tıklayabiliyoruz sportcheckboxa bunu gorduk
        if (!isEnable){
            radioButton.click();
        }

    }
}
