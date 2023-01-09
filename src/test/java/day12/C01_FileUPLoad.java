package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilies.TestBase;

import java.io.File;

public class C01_FileUPLoad extends TestBase {
    @Test
    public void fileUpLoading() {
        //Tests packagenin altina bir class oluşturun : C05_UploadFile
        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //chooseFile butonuna basalim
        WebElement chooseFileButton=driver.findElement(By.id("file-upload"));
        //Yuklemek istediginiz dosyayi secelim. =C:\Users\USER\OneDrive\Masaüstü once dosya yolunu bulalım:
    String dosyaYolu=System.getProperty("user.home")+"\\OneDrive\\Masaüstü\\logo.jpeg";
    chooseFileButton.sendKeys(dosyaYolu);//locate aldıgımıız yere dostamızı senkeys ile gonderiyoruz
        //Upload butonuna basalim.
        WebElement upLoadFileButton=driver.findElement(By.id("file-submit"));
        upLoadFileButton.click();
        //“File Uploaded!” textinin goruntulendigini test edelim.
        String fileUploading=driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("File Uploaded!",fileUploading);
        waitFor(5);
    }
}
