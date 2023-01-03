package Slayt_Questions_Odev;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilies.TestBase;

public class RadioButton extends TestBase {

    @Test
    public void test(){
        //- https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");
        //- Cookies’i kabul edin
        //- “Create an Account” button’una basin
        driver.findElement(By.xpath("(//*[@role='button'])[2]")).click();
        driver.findElement(By.id("u_2_b_Mg")).
                sendKeys("Sumeyra", Keys.TAB,Keys.ARROW_RIGHT,"Dur",Keys.ARROW_DOWN,"1234567891",Keys.ARROW_DOWN,"12345",Keys.ENTER);
        //- “radio buttons” elementlerini locate edin
        //- Secili degilse cinsiyet butonundan size uygun olani secin
    }
}
