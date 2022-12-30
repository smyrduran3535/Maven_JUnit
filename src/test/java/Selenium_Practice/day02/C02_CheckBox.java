package Selenium_Practice.day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_CheckBox {
    static WebDriver driver;

    @Before
    public void setUp() { //1. Launch browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test() {
        // https://demo.guru99.com/test/radio.html adresine gidin
        driver.get("https://demo.guru99.com/test/radio.html");
        // checkbox elementlerini locate edin
        WebElement checkBox1= driver.findElement(By.id("vfb-6-0"));
        WebElement checkBox2= driver.findElement(By.id("vfb-6-1"));
        WebElement checkBox3= driver.findElement(By.id("vfb-6-2"));
        // checkbox1 ve checkbox3  secili degil ise secin
        if (!(checkBox1.isSelected()&&checkBox3.isSelected())){
            checkBox1.click();
            checkBox3.click();
        }
        // checkbox1 ve checkbox3 elementlerinin secili oldugunu Test edin
        Assert.assertTrue(checkBox1.isSelected()&& checkBox3.isSelected());
        // checkbox2 elementinin secili olmadıgını test edin
        if (checkBox2.isSelected()){
            checkBox2.click();
        }
        Assert.assertTrue(checkBox2.isDisplayed());

        /*HOCANIN COZUMU
          // checkbox1 ve checkbox3 elementlerinin secili oldugunu Test edin
        Assert.assertTrue(checkBox1.isSelected());
        Assert.assertTrue(checkBox3.isSelected());
        // checkbox2 elementinin secili olmadıgını test edin
        Assert.assertFalse(checkBox2.isSelected()); passed yapar
         */
    }

    @After
    public void after() throws Exception {
       // driver.close();
    }
}
