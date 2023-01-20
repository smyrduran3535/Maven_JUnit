package Exercise;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilies.TestBase;

public class C04_Js_Type extends TestBase {
    @Test
    public void test() {
        //yahoo adresine git
        driver.get("https://login.yahoo.com/");
        JavascriptExecutor js= (JavascriptExecutor) driver;
        WebElement email=driver.findElement(By.id("login-username"));
        js.executeScript("arguments[0].value='random@gmail.com'",email);
        WebElement checkbox= driver.findElement(By.xpath("//label[@for='persistent']"));
        js.executeScript("arguments[0].click()",checkbox);
    }
}
