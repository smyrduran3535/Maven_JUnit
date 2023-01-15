package day16;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbookFactory;
import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C01_ExcellRead {
    /* 4 tane classımız var excellde:
    Workbook=excel dosyamız
    Sheet=her acık excel sekmesi(Sheet1,Sheet2...);Syfa
    Row(satir)=java yalnızca iceride veri varsa satırları sayar.default olarak satır sayısı 0 dır
    Cell(hucre)=java her ssatıra bakar,yalnızca hücrede veri varsa hücre sayısını sayar
     */
    @Test
    public void readExcelTest() throws IOException {
String path="./src/test/java/resources/Capitals (1).xlsx"; // "."demek onceki relative xpath i dusuruyoruz
        //Dosyayı ac
        FileInputStream fileInputStream=new FileInputStream(path);

        //EXCEL DOSYASINI AC / WORKBOOK AC
        Workbook workbook= WorkbookFactory.create(fileInputStream);


        //SHEET / SAYFAYI AC
//Sheet sheet1=workbook.getSheetAt(0); index ile de sayfaya gidebiiriz
Sheet sheet1=workbook.getSheet("Sheet1");// sayfa adını vererek de sheete gidebiliriz

        //İLK SATIRA GİDİCEZ / ROW
Row row1=sheet1.getRow(0);//istedigin satırı alabilirsin


        //ILK SATIRDAKI ILK VERIYI AL
Cell cell=row1.getCell(0);//ilk hucredeki datayı ver

        //O VERIYI YAZDIR
System.out.println(cell);

//1.SATIR 2.SUTUN
        System.out.println("sheet1.getRow(0).getCell(1) = " + sheet1.getRow(0).getCell(1));// CAPITAL
        //3.SATIR 1 ELEMAN
        System.out.println("workbook.getSheetAt(1).getRow(2).getCell(0) = " + workbook.getSheetAt(0).getRow(2).getCell(0));//France
        //hocanın cozumu
        String cell31=sheet1.getRow(2).getCell(0).toString();
        System.out.println("cell31 = " + cell31);
        Assert.assertEquals("France",cell31);//stringe cevirmek zorundayız cunku test ederken string data tipi oldugundan Stringe cevirdik

        //Exceldeki toplam satır sayısını bul:
        //sheet sayfaya gitmek icin yoksa tum sayfayı yazdıramayız string olarak
        int toplamSatirSayisi=sheet1.getLastRowNum()+1;//SON SATIR NUMARASI
        System.out.println(toplamSatirSayisi);//10 0dan baslar index ama biz sayma sayısı olsun diye +1 ekleriz

        //kullanılan toplam sayır sayısı
        int kullanılanToplamSatırSayısı=sheet1.getPhysicalNumberOfRows();//fiziksel satır sayısı gorunurdeki satır sayısı
        System.out.println(kullanılanToplamSatırSayısı);//bu birden baslıyor

        //Dosyadaki elemanları COUNTRY,CAPITALS key ve valueları Map e alıp print etmek istiyorum
      //  {{USA,D.C},{FRANCE,PARIS}...}
        //variable olusturalım.Bu variable exceldeki country,capital verilerini tutacak
        Map<String ,String> ulkeBaskentleri=new HashMap<>();
        /*
       //COUNTRY i almak icin yapmak gereken kodlama :sheet1.get(0).getCell(0)
        sheet1.getRow(1).getCell(0);//usa
        sheet1.getRow(2).getCell(0);//fransa
        sheet1.getRow(3).getCell(0);//ingiltere
        sheet1.getRow(1).getCell(0);//turkey
        sheet1.getRow(0).getCell(1);//CAPITAL
        sheet1.getRow(0).getCell(2);//D.C
        sheet1.getRow(0).getCell(3);//PARIS
        sheet1.getRow(0).getCell(4);//LONDON
         bunları almak icin loop yapıyoruz
         */
        for (int sateirSayisi=1; sateirSayisi<kullanılanToplamSatırSayısı;sateirSayisi++){//1 --->11 e kadar
            String country=sheet1.getRow(sateirSayisi).getCell(0).toString();//ulkeşer her zaman 0 da
            String capital=sheet1.getRow(sateirSayisi).getCell(1).toString();//capıtalda satır sayısı her zaman 1 ekleme cıkarma olmaz
            ulkeBaskentleri.put(country,capital);

        }
        System.out.println("ulkeBaskentleri = " + "\n"+ulkeBaskentleri);
        /*
Map<String,String> ulkeBaskentleri2 = new TreeMap<>(ulkeBaskentleri);
System.out.println("ulkeBaskentleri2 = " + ulkeBaskentleri2);

TreeMap a = new TreeMap<>(ulkeBaskentleri);
System.out.println(a); bu kode order yapıyor
         */
    }
    /*


public Cell getData(String path, String sheet, int row, int column) throws Exception {
    Cell cell = WorkbookFactory.
            create(new FileInputStream(path)).
            getSheet(sheet).
            getRow(row).
            getCell(column);
    return cell;
     */
}
