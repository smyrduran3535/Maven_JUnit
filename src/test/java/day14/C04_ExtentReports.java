package day14;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Test;
import org.openqa.selenium.By;
import utilies.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class C04_ExtentReports extends TestBase {
    //HATIRLAMAMIZ GEREKEN 3 CLASS VAR (DEGİSKEN)
    protected static ExtentReports extentReports;
    protected static ExtentHtmlReporter extentHtmlReporter;
    protected static ExtentTest extentTest;

    @Test
    public void extentReportsTest() {

        //      REPORT  PATH
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/reports/"+currentTime+"html_report.html";//raporları burda olusturuyoruz
//        creating HTML report in the path
        extentHtmlReporter = new ExtentHtmlReporter(path);//HTML raporu cıkacak
//        creating extent reports object for generating the Entire reports with configuration
        extentReports = new ExtentReports();


//       *************************************RAPORU CUSTOMIZE EDEBILIRIZ********************* Tek seferlik yapılır sirkete girince
        extentReports.setSystemInfo("Test Environment","Regression");//raporun uzerine testi hangi ortamda tes ettigimizi ekleyebiliriz
        extentReports.setSystemInfo("Application","TechPro Education");//uygulama adını ekleyebiliriz
        extentReports.setSystemInfo("Browser","Chrome");//hangi browserda test ediyorsak ekl
        extentReports.setSystemInfo("Takim","Eagles");//hangi takımda oldugumuzu ekl
        extentReports.setSystemInfo("Epic","Odeme Sayfasi");//epic numarası (buyuk user storylerin tepesinde olan)
        extentReports.setSystemInfo("Sprint Numarasi","Sprint-145");
        extentReports.setSystemInfo("QA","Sumeyra");
// extentHtmlReporter dosyasının uzerine ekledik
//         *************************************EXTRA RAPOR ISMI VE DOKUMAN İSMİ EKLEYEBILIRIZ*********************
        extentHtmlReporter.config().setDocumentTitle("TechProEd Extent Reports");
        extentHtmlReporter.config().setReportName("Regression Test Sonucu");

//         *************************************RAPORU AYARLARI BİTTİ*********************


        //rapor olusturduk raporu attack etmemiz lazım;eklememe yapıyoruz raporu frameworkumuze
        extentReports.attachReporter(extentHtmlReporter);
//bunların hepsi sirkete girerken bir defaya mahsus yapılır

        //extentTest  bu kısım ile de raporlama yapıyoruz.bilgi ekleme isleminde kullanılmaz yazma ils.de kull.

        //extenttest objesini olusturduk kullanarak;
        extentTest=extentReports.createTest("Extent Report Login Test","Smoke Test Raporu");//test rapurunu kırıp create isl yapıp logluycaz
        //                          T U  M   A  Y A R L A R   B İ T T İ...
        //EXTENT TEST OBJESİ İLE LOGLAMA(RAPORA YAZDIRMA ) İSLEMİ YAPABİLİRİM
        extentTest.pass("Kullanici anasayfaya gider");
        driver.get("https://www.techproeducation.com");
        //LMS sayfasına gidin
        extentTest.pass("Kullanıcı LMS sayfasına gider");
        driver.findElement(By.linkText("LMS LOGIN")).click();
        //Test bitt
        extentTest.pass("Test basariyla gerceklesti");
        //son olarak bu islemi yaparsak paopr olusacak raporu gostericez..bunun icin;"flush()" kullanıyoruz=bu onemli ve zorunlu raporun olusması icin
        //baslatır ve bitirir flush
        extentReports.flush();//eger testcase kalırsa screenshot ekliyoruz
    }
}
