package day14;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Test;
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
        extentReports.setSystemInfo("Test Environment","Regression");
        extentReports.setSystemInfo("Application","TechPro Education");
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Takim","Eagles");
        extentReports.setSystemInfo("Epic","Odeme Sayfasi");
        extentReports.setSystemInfo("Sprint Numarasi","Sprint-145");
        extentReports.setSystemInfo("QA","Sumeyra");

//         *************************************EXTRA RAPOR ISMI VE DOKUMAN İSMİ EKLEYEBILIRIZ*********************
        extentHtmlReporter.config().setDocumentTitle("TechProEd Extent Reports");
        extentHtmlReporter.config().setReportName("Regression Test Sonucu");

//         *************************************RAPORU AYARLARI BİTTİ*********************
        //rapor olusturduk raporu attack etmemiz lazım;ekleme
        extentReports.attachReporter(extentHtmlReporter);

    }
}
