package utilies;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestBase {
    //testbase sınıfı before ve after methodlarını koymak icin kullaniriz
    //@Before,@After :destek methoddur. test method olması icin;@Test olması lazım
    //test base testlerden once ve sonra kullanılır.
    //bunu kullanmak icin inheritance kullancaz ve before ve after methodlarını tekrar tekrar kullanmıycaz
    //test base kullanmanın tek amacı frameworku daha kullanıslı hale getirmek tesrar yapmamak
//abstract kullancaz: abstract yaparsak child claslar methodlari overload eder.bu sınıfın objesini olusturmak istemiyorum
    //yani TestBase testbase=new TestBase :bunu istemiyorum... amacım :bu sinifi extend etmek icindeki hazır methodları kullanmak

    //driver objesi olustur:driver ya public yada protected olmalı. child classlarda gorulebilmeli
    protected static WebDriver driver;

    //setUp olust
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    //tearDown
    @After
    public void tearDown() {
     //  driver.quit();

    }
}
