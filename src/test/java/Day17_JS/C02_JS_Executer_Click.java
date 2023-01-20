package Day17_JS;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilies.TestBase;

public class C02_JS_Executer_Click extends TestBase {
    @Test
    public void clickByJSTest() {

//Techpro education ana sayfasina git
        driver.get("https://www.techproeducation.com");
        waitFor(1);
clickByJS(driver.findElement(By.linkText("LMS LOGIN")));
//LMS LOGIN elementine tikla
//Cikan sayfayinin URL inin “https://lms.techproeducation.com/” oldugunu test et
        Assert.assertEquals("https://www.techproeducation.com",driver.getCurrentUrl());
    }
}
