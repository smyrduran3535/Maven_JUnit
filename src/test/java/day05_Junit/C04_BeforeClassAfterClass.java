package day05_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_BeforeClassAfterClass {

    /*
    @BeforeClass ve @AfterClass notasyonlari sadece static method'lar icin calisir.
@BeforeClass ve @AfterClass kullanirsak olusturdugumuz @Test method'larinin hepsini ayni anda calistirip
en son @AfterClass'i calistiririz.
    Ama sadece @Before ve @After kullanirsak her test icin @Before ve @After'i kullanir.
 */

    @BeforeClass
    public static void setUp(){

        System.out.println("butun testlerdden once calıstı");
    }
    @AfterClass
    public static void tearDown(){

        System.out.println("Butun testlerden sonra calıstı");
    }
    @Before
    public void setUp01(){

        System.out.println("her testten once calısır");
    }
    @After
    public void tearDown01(){

        System.out.println("her testten once calısır");
    }
    @Test
    public void test01(){

        System.out.println("ilk test");
    }
    @Test
    public void test02(){
        System.out.println("ikinci test");

        /*

butun testlerdden once calıstı
her testten once calısır
ilk test
her testten once calısır
her testten once calısır
ikinci test
her testten once calısır
Butun testlerden sonra calıstı

         */
    }
}
