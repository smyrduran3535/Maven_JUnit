package day15;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import utilies.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_ExtentReport2 extends TestBase {
    protected static ExtentReports extentReports;
    protected static ExtentHtmlReporter extentHtmlReporter;
    protected static ExtentTest extentTest;

    @BeforeClass
    public static void extentReportsSetUp(){

        //ayarlar kısmını koyucaz ayarlar bitti kısmına kadar
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

    }
    @Test
    public void extentReportsTest() {
extentTest.pass("PASS");
extentTest.info("Bilgilendirme notu dusebilirim");
extentTest.fail("kaldigini belirtebilirim FAİLED");
extentTest.warning("utarı mesajı");
extentTest.skip("atlama mesajı");
extentTest.fatal("sistem cokus");

    }
    @AfterClass
    public static void extentReportsTearDown(){
        extentReports.flush();
    }
}//open in ->explorer =dosyaya gotorur
