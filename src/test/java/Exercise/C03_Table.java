package Exercise;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilies.TestBase;

import javax.swing.text.StyledEditorKit;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class C03_Table extends TestBase {


    @Test
    public void test() {
        //    https://en.wikipedia.org/wiki/Dell  adresine gidin
        driver.get("https://en.wikipedia.org/wiki/Dell");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement tablo = driver.findElement(By.xpath("//table[@class='wikitable sortable jquery-tablesorter']"));
        // WebElement tablo= driver.findElement(By.cssSelector(".wikitable sortable"));
        js.executeScript("arguments[0].scrollIntoView()", tablo);//tabloyu bulasaya kadar asagı iner
//tablodaki satırları yazdırın
        List<WebElement> tabloSatirlar = driver.findElements(By.xpath("//table[@class='wikitable sortable jquery-tablesorter']//tbody//tr"));

        for (int i = 0; i < tabloSatirlar.size(); i++) {
            System.out.println(tabloSatirlar.get(i).getText() + "\n");
        }
    }
//2 satır 3. sutun al
        @Test
        public void test01() {
            driver.get("https://en.wikipedia.org/wiki/Dell");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement tablo = driver.findElement(By.xpath("//table[@class='wikitable sortable jquery-tablesorter']"));
            js.executeScript("arguments[0].scrollIntoView();", tablo);//tabloyu bulasaya kadar asagı iner
             WebElement satir23=driver.findElement(By.xpath("//table[@class='wikitable sortable jquery-tablesorter']//tbody//tr[2]//td[3]"));
            System.out.println(satir23.getText());

        }

    @Test
    public void test02() throws IOException {
        //dell tablosu logosunu al
        driver.get("https://en.wikipedia.org/wiki/Dell");
        WebElement dell=driver.findElement(By.xpath("//table[2]//tbody//tr[2]"));
        File image=dell.getScreenshotAs(OutputType.FILE);
        //test-output/EkranGoruntuleri/dell.jpg
        String dosyaYeri=System.getProperty("user.home")+"/test-output/EkranGoruntuleri/dell.jpg";
        FileUtils.copyFile(image,new File(dosyaYeri));
        takeScreenshotOfElement(driver.findElement(By.xpath("(//*[@class='infobox-image logo'])[1]")));
    }
}

