package Slayt_Questions_Odev;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilies.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Files_Slayt extends TestBase {
    @Test
    public void downloadTest() {
        //Create a class:FileDownloadTest
        //downloadTest()
        //In the downloadTest() method, do the following test:

        //Go to https://the-internet.herokuapp.com/download
        driver.get("https://the-internet.herokuapp.com/download");
        //Download flower.png file
        driver.findElement(By.xpath("//a[text()='test1.pdf']")).click();
        //"C:\Users\USER\Downloads\test1.pdf"

        //Then verify if the file downloaded successfully
        String indirilenDosya=System.getProperty("user.home")+"\\Downloads\\test1.pdf";
        boolean varMi= Files.exists(Paths.get(indirilenDosya));
        Assert.assertTrue(varMi);

    }

    @Test
    public void fileUploadTest() {

        //When user goes to https://the-internet.herokuapp.com/upload
        driver.get("https://the-internet.herokuapp.com/upload");
        //When user selects an image from the desktop
        WebElement choose=driver.findElement(By.id("drag-drop-upload"));
        //And click on the upload button
        String dosyaYolu=System.getProperty("user.home")+"\\OneDrive\\Masaüstü\\a.docx";
        //Then verify the File Uploaded! Message displayed
        //"C:\Users\USER\OneDrive\Masaüstü\a.docx"
        choose.sendKeys(dosyaYolu);
        driver.findElement(By.id("file-submit")).click();
        String fileUploading=driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("File Uploaded!",fileUploading);
    }
}
