package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilies.TestBase;

import java.time.Duration;

public class C02_ExplicitWait extends TestBase {
/*
 @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
       // WebDriverManager.chromedriver().create();==>
        // WebDriverManager.chromedriver().setup(); ve  driver = new ChromeDriver(); ikisi kaldırıp yukardakı kullanılır
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        *Thread.sleep(20) =====>>>>>bunu kullanmayız HARD WAITTIR.Ne bir sn eksik ne bir sn fazla calısır.TAM 20 SANIYE BEKLER.Javadan gelir
        *driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); ==> GEREKTİGİNDE 15 SN BEKLER
        ve 3 snde elemanı bularsa da devam edr calısmaya ve Dinamictir.Selenyumdan gelir

    }
 */
    //Synchronization :driver objesi ile web sitesindeki o elementlerin uyumlu calısması demek
    //impicitly wait : Sayfa üzerindeki tüm öğeler için zaman aşımı = 1-driver.manage().timeouts()
    //impicitly wait,global calısır. 1 kere kullanırsın her yerde calısır.
    //explicitly wait  : belirli elementler için zaman aşımı :1-WebdriverWait , 2-FluentWait
    //explicitly wait ; yereldir.. impicitly wait calısmadıgı durumlarda kulanırız daha guzel calısır.
    //explicitly wait  : belirli elementler için kullanılır.imlicitly wait calısıyorsa bu kullnılmaz
    //WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("..."))); bu cok guzel explicit icin
    //FARKI ONEM KATAN su;elemanı bulur bulmaz return eder yani fineElementin gorevini de yapar.

    @Test
    public void explicitWaitTest() {
//https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
//Start buttonuna tıkla
        driver.findElement(By.xpath("//div[@id='start']//button")).click();

//Hello World! Yazının sitede oldugunu test et
                             /*
                              WebElement helloWorld= driver.findElement(By.xpath("//div[@id='finish']//h4"));
                              Assert.assertEquals("Hello World!",helloWorld);//impicitly wait bu sorunu cozmedi cunku eleman gizlenmis,
                              bizim gozle goremedigimiz seyleri selenyumda goremiyor
                              */
// COZUM: Explicity waitte cunku iml.wait; elemanı bulamadı eleman gizli
        //1. WebDriverWait objesi olustur
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        //2.wait objesini olusturarak bekleme problemini cozmeye calıs
        WebElement helloWorldElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']//h4")));
        String helloWorldText = helloWorldElement.getText();
        Assert.assertEquals("Hello World!", helloWorldText);
// Note: implicitlyWait Sayfa daki webelementlerin yüklenmesi için bekliyor
// ama içerde bir buttona basınca loading yani bekleme yaparken çalışmıyor
    }
}
