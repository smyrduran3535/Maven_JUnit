package Selenium_Practice.day07;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilies.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ReadExcell extends TestBase{


    @Test
    public void ReadExcell() throws IOException {
        String dosyaYolu = "C:\\Users\\USER\\OneDrive\\Masaüstü\\data.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        String email = workbook.getSheet("sayfa1").getRow(1).getCell(1).toString();
        System.out.println("email = " + email);
        //Bilgisayarınızdaki data isimli excel dosyasından kullanıcı bilgilerini alıp
        String password = workbook.getSheet("sayfa1").getRow(2).getCell(1).toString();
        System.out.println("password = " + password);

        //https://www.bluerentalcars.com/ adresine gidip
driver.get("https://www.bluerentalcars.com/");
        //Excel dosyasından aldığımız kullanıcı bilgileri ile login olalım
        driver.findElement(By.xpath("//*[@class='btn btn-primary btn-sm']")).click();
        WebElement emailAddress= driver.findElement(By.xpath("//*[@id='formBasicEmail']"));
        //Login olduğumuzu doğrulayalım
        emailAddress.sendKeys(email + Keys.TAB + password + Keys.ENTER);
        String name = driver.findElement(By.xpath("//*[@id='dropdown-basic-button']")).getText();
        Assert.assertEquals("Erol Evren", name);//assert login.getText().equals("Erol Evren");
    }
}