package S_Challenge;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class C04_Can_TutorialsNinjaDiffAnswr {
    static WebDriver driver;
    @BeforeClass
    public static void beforeClass() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    // ~ Navigate to http://tutorialsninja.com/demo/index.php?route=common/home
    @Before
    public void setUp() throws Exception {
        driver.get("http://tutorialsninja.com/demo/index.php?route=common/home");
    }
    @Test
    public void test01() throws InterruptedException {
        //     ~ click on Phones & PDAs
        driver.findElement(By.xpath("//*[text()='Phones & PDAs']")).click();
        //    ~ get the brandName of phones
        List<WebElement> brandNames = driver.findElements(By.xpath("//h4"));
        List<String> list1 = new ArrayList<>();
        for (WebElement w : brandNames) {
            System.out.println(w.getText());
            list1.add(w.getText());
        }
        //    ~ click on add to button for all elements
        for (int i = 1; i <= brandNames.size(); i++) {
            Thread.sleep(2000);
            driver.findElement(By.xpath("(//*[.='Add to Cart'])[" + i + "]")).click();
        }
        //    ~ click on black total added cart button
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='cart-total']")).click();
        //    ~ get the names of list from the cart
        List<WebElement> blackNames = driver.findElements(By.xpath("//td[@class='text-left']"));
        List<String> list2 = new ArrayList<>();
        for (WebElement w : blackNames){
            System.out.println(w.getText());
            list2.add(w.getText());
        }
        //    ~ compare the names from displaying list and cart list
        Collections.sort(list1);
        Collections.sort(list2);
        System.out.println("list1 = " + list1);
        System.out.println("list2 = " + list2);
        Assert.assertEquals(list1,list2);
    }
    @AfterClass
    public static void afterClass() throws Exception {
        // driver.close();
    }
}
