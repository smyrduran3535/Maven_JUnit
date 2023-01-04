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
        WebElement firstname=  driver.findElement(By.xpath("//*[@id='u_2_4_Lu']"));
if (!firstname.isSelected()){
    firstname.click();
}
        //- “radio buttons” elementlerini locate edin

        //- Secili degilse cinsiyet butonundan size uygun olani secin
    }
}
