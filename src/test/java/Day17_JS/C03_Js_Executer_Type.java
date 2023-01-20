package Day17_JS;

import org.junit.Test;
import org.openqa.selenium.By;
import utilies.TestBase;

public class C03_Js_Executer_Type extends TestBase {
    @Test
    public void typeTest() {
        driver.get("https://www.techproeducation.com");
        waitFor(1);
        //	1)
        //	2)Techpro education ana sayfasina git
        //	3)Arama kutusuna QA yaz
        typeWithJS(driver.findElement(By.xpath("//input[@type='search']")),"QA" );
    }
}
