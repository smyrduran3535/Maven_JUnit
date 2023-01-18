package manuelautomation;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilies.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class C01 extends TestBase {
    @Test
    public void test() throws Exception {
        //https://automationexercise.com/  adresine dogru verilerle  giris yapabileceginiz test case olusturun.++
        //2. Excelde bulunan butun mail ve sifre ile sisteme giris yapildigini dogrulayan dinamik bir method olusturun.
        //3.  Exceldeki tablodaki isimler icin de  "Turuncu" olup olmadigini test edin.
        //4. Sistemde olan kisilerin ad ve soyadlarini yazdiran diamik bir method  olusturun.
        //5.  ? olan hucreye "Yas" olarak ekleyin, ve asagidaki yaslari girin.
        //    Yesil=27
        //    Mavi=25
        //    Turuncu=35
/*

 Mail(0,0)----------Password(0,1)-------Name(0,2))--------Surname(0,3)---------Yas(0,4)
 1. mail (1,0)      1. sifre (1,1)      1. isim (1,2)     1. soyad (1,3)        1. yas (1,4)
 2. mail (2,0)      2. sifre (2,1)      2. isim (2,2)     2. soyad (2,3)        2. yas (2,4)
 3. mail (3,0)      3. sifre (3,1)      3. isim (3,2)     3. soyad (3,3)        3. yas (3,4)

 */
        //2. Excelde bulunan butun mail ve sifre ile sisteme giris yapildigini dogrulayan dinamik bir method olusturun.
        driver.get("https://automationexercise.com/");
        driver.findElement(By.xpath("//i[@class='fa fa-lock']")).click();
        // 4 tane satirimiz(row) index 0-1-2-3- ---> 1-2-3
        for (int i = 1; i < numberOfRow(); i++) {
            driver.findElement(By.xpath("//input[@data-qa='login-email']")).
                    sendKeys(getDataFromExcel(i, 0) + // mail adresini aliyorum2-0
                            Keys.TAB, getDataFromExcel(i, 1) +  // sifreyi aliyorum2-1
                            Keys.TAB +
                            Keys.ENTER);



        Assert.assertTrue(driver.findElement(By.xpath("//a[text()=' Logged in as ']")).getText().contains(getDataFromExcel(i, 2)));
        waitFor(2);
        driver.findElement(By.xpath("//i[@class='fa fa-lock']")).click();
        waitFor(2);
    }

        //3.  Exceldeki tablodaki isimler icin de  "Turuncu" olup olmadigini test edin.
        Assert.assertTrue(getAllName().contains("Turuncu"));

        //4. Sistemde olan kisilerin ad ve soyadlarini yazdiran diamik bir method  olusturun.
        nameAndSurname();

        //5.  ? olan hucreye "Yas" olarak ekleyin, ve asagidaki yaslari girin.
        //    Yesil=27
        //    Mavi=25
        //    Turuncu=35

        String path = "./src/test/java/Resources/renkTablo.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        workbook.
                getSheet("Sayfa1").
                getRow(0).
                createCell(4).
                setCellValue("Age");
        workbook.
                getSheet("Sayfa1").
                getRow(1).
                createCell(4).
                setCellValue(27);
        workbook.
                getSheet("Sayfa1").
                getRow(2).
                createCell(4).
                setCellValue(25);
        workbook.
                getSheet("Sayfa1").
                getRow(3).
                createCell(4).
                setCellValue(37);


        //kaydet
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);

        System.out.println(" yas 27 gelmesi lazim = " + getDataFromExcel(1, 4));


    }

    // workbook-sheet-row-cell
    //toplam satir sayisi
    public int numberOfRow() throws Exception {
        String path = "./src/test/java/Resources/renkTablo.xlsx";
        return WorkbookFactory.create(new FileInputStream(path)).
                getSheet("Sayfa1").getLastRowNum() + 1;
    }

    // satir ve sutun sayisin igirdigimzi veriyi bize verir.
    public String getDataFromExcel(int row, int cell) throws Exception {
        String path = "./src/test/java/Resources/renkTablo.xlsx";
        return WorkbookFactory.create(new FileInputStream(path)).
                getSheet("Sayfa1").
                getRow(row).
                getCell(cell).
                toString();
//        FileInputStream fileInputStream = new FileInputStream(path);
//        //1.
//        Workbook workbook= WorkbookFactory.create(fileInputStream);
//        //2.
//        Sheet sheet = workbook.getSheet("Sayfa1");
//        //3.
//        Row row = sheet.getRow(0);
//        //4.
//        Cell cell = row.getCell(0);
    }

    //Butun isimler
    public java.util.List<String> getAllName() throws Exception {
        String path = "./src/test/java/Resources/renkTablo.xlsx";
        java.util.List<String> list = new ArrayList<>();
        for (int i = 1; i < numberOfRow(); i++) {

            list.add(WorkbookFactory.create(new FileInputStream(path)).
                    getSheet("Sayfa1").
                    getRow(i). // 1-2     2-2     3-2
                            getCell(2).
                    toString());
        }

        return list;
    }


    //4. Sistemde olan kisilerin ad ve soyadlarini yazdiran diamik bir method  olusturun.
    public void nameAndSurname() throws Exception {
        String path = "./src/test/java/Resources/renkTablo.xlsx";
        for (int i = 1; i < numberOfRow(); i++) {
            String name = WorkbookFactory.create(new FileInputStream(path)). // workbook
                    getSheet("Sayfa1"). // sheet
                    getRow(i). // i. row
                    getCell(2). // cell =2
                    toString();
            System.out.print(name + " ");

            String surName = WorkbookFactory.create(new FileInputStream(path)).
                    getSheet("Sayfa1").
                    getRow(i).
                    getCell(3).
                    toString();
            System.out.print(surName);
            System.out.println();

        }

    }

    // satiri---- sutunu --- deger
    public void writeAge(int row, int cell, int age) throws Exception {
        String path = "./src/test/java/Resources/renkTablo.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        workbook.
                getSheet("Sayfa1").
                getRow(row).
                createCell(cell).
                setCellValue(age);
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);

    }
}