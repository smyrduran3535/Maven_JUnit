package Slayt_Questions_Odev;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;
import utilies.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WriteExcel {
    @Test
    public void test() throws IOException {

        //aynı excel diye calistirmadi


        String path = "./src/test/java/resources/Capitals (1).xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet1 = workbook.getSheet("Sheet1");
        Row row = sheet1.getRow(0);
        Cell cell = row.createCell(3);
        cell.setCellValue("IRK");

        sheet1.getRow(1).createCell(3).setCellValue("American");
        sheet1.getRow(2).createCell(3).setCellValue("Fransız");
        sheet1.getRow(3).createCell(3).setCellValue("İngiliz");
        sheet1.getRow(4).createCell(3).setCellValue("Türk");
        sheet1.getRow(5).createCell(3).setCellValue("Yunan");
        sheet1.getRow(6).createCell(3).setCellValue("İtalyan");
        sheet1.getRow(7).createCell(3).setCellValue("Kanada");
        sheet1.getRow(8).createCell(3).setCellValue("Alman");
        sheet1.getRow(9).createCell(3).setCellValue("Japon");
        sheet1.getRow(10).createCell(3).setCellValue("Norvec");


    }

}
