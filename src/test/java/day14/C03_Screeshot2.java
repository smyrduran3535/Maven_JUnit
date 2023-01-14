package day14;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import utilies.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C03_Screeshot2 extends TestBase {
    @Test
    public void screenshotOfSfesificElementstest() throws IOException {
        //tecproya git
        //sosyal medya goruntulerini al
        driver.get("https://www.techproeducation.com");
        //1.ekran goruntusunu cek
        WebElement sosyalMedyaGoruntusu=driver.findElement(By.xpath("(//div[@class='elementor-social-icons-wrapper elementor-grid'])[1]"));
        //ekran goruntusunu kaydet
        File image=sosyalMedyaGoruntusu.getScreenshotAs(OutputType.FILE);//dosya olarak kaydedicez
        //path of screenshot save folder
        String currentDate = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/EkranGoruntuleri/"+currentDate+"image.png";
        FileUtils.copyFile(image,new File(path));
        takeScreenshotOfElement(driver.findElement(By.xpath("//div[@data-id='898ce2e']")));
    }
}
