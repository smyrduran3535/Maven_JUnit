package S_Challenge;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilies.TestBase;

import java.util.List;

public class WebTables extends TestBase {
    @Test
    public void test() {
        //https://www.way2automation.com/angularjs-protractor/webtables/
        driver.get("https://www.way2automation.com/angularjs-protractor/webtables/");
        //tüm E-mail leri yazdırın
        List<WebElement> email = driver.findElements(By.xpath("//table[@table-title='Smart Table example']//tbody//td[7]"));
        email.stream().forEach(t -> System.out.println(t.getText()));
        //Tüm E-maillerin "@" işareti içerdiğini doğrulayin
        email.forEach(t -> Assert.assertTrue(t.getText().contains("@")));

    }
}
