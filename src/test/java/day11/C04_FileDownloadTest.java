package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilies.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownloadTest extends TestBase {

    @Test
    public void fileDownloadTest() {
//https://testcenter.techproeducation.com/index.php?page=file-download   adresine gidelim.
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");
//b10 all test cases dosyasını indirelim
        driver.findElement(By.partialLinkText("b10 all test cases")).click();
        waitFor(3);
//Dosyanın başarıyla indirilip indirilmediğini test edelim
        //        Dosyanın başarıyla indirilip indirilmediğini test edelim
        String filePath = System.getProperty("user.home")+"/Downloads/b10 all test cases, code.docx";
        boolean indirildimi = Files.exists(Paths.get(filePath));
        Assert.assertTrue(indirildimi);

    }
}
