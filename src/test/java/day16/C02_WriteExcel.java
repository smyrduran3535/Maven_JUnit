package day16;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_WriteExcel {
    @Test
    public void writeExcelTest() throws IOException {
        //excel dosyasına yazı yazdırabilirz:mesela nufus yazdırabiliriz
        //WORKBOOK > WORKSHEET/SHEET(SAYFA) > ROW (SATIR)> CELL >YAZDIR>KAYDET
        String path="./src/test/java/resources/Capitals (1).xlsx"; // "."demek onceki relative xpath i dusuruyoruz
        //Dosyayı ac
        FileInputStream fileInputStream=new FileInputStream(path);

        //EXCEL DOSYASINI AC / WORKBOOK AC
        Workbook workbook= WorkbookFactory.create(fileInputStream);


        //SHEET / SAYFAYI AC

        Sheet sheet1=workbook.getSheet("Sheet1");

        //İLK SATIRA GİDİCEZ / ROW
        Row row1=sheet1.getRow(0);//istedigin satırı alabilirsin

        //ilk satır 3.sutunu create et
        //getCell : OKUR, createCell:YAZAR
        Cell cell3=row1.createCell(2);//hucre olusturduk tıkladık henuz bisey yazdırmadık
        //tıkladıgımız sayfaya nufus yazdıralım: setCellValue ile
        cell3.setCellValue("NUFUS");

        //2.satir 3.sutuna 450000
        sheet1.getRow(1).createCell(2).setCellValue("450000");
        sheet1.getRow(2).createCell(2).setCellValue("520000");
        sheet1.getRow(3).createCell(2).setCellValue("25000");
        sheet1.getRow(4).createCell(2).setCellValue("750000");
        sheet1.getRow(5).createCell(2).setCellValue("360000");
        sheet1.getRow(6).createCell(2).setCellValue("250000");
        sheet1.getRow(7).createCell(2).setCellValue("40000");
        sheet1.getRow(8).createCell(2).setCellValue("860000");
        //KAYDET
        //  fileInputStream sistemi ile girdik fileOutputStream ile cıkıcaz
        FileOutputStream fileOutputStream=new FileOutputStream(path);
        workbook.write(fileOutputStream);//kaydettik


    }
}
