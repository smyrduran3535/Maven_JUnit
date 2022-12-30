package Selenium_Practice.day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_RadioButton {

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
        // radiobutton elementlerini locate edin
        WebElement radioButton=driver.findElement(By.xpath("//strong['Radio']"));
        WebElement optipn1=driver.findElement(By.id("vfb-7-1"));
        WebElement optipn2=driver.findElement(By.id("vfb-7-2"));
        WebElement optipn3=driver.findElement(By.id("vfb-7-3"));
        // option2'yi secin
        optipn2.click();
        // option2 elementlerinin secili oldugunu Test edin
        Assert.assertTrue(optipn2.isSelected());
        // option1 elementlerinin secili olmadıgını test edin
        Assert.assertFalse(optipn1.isSelected());//option 1 secmedik o yuzden false der
        // option3 elementlerinin secili olmadıgını test edin
        Assert.assertFalse(optipn3.isSelected());//secmedik beklenen de false o yuzden false (F->F=F : PASSED)
    }
}