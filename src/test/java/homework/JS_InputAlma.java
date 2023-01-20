package homework;

import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import utilies.TestBase;

public class JS_InputAlma extends TestBase {
    @Test
    public void getValueTest() {
        //1)
        //	2)https://www.priceline.com/ a git
        driver.get("https://www.priceline.com/");
        //	3)Tarih kısmındaki Yazili metinleri al ve yazdır
        JavascriptExecutor js= (JavascriptExecutor) driver;


    }
}
