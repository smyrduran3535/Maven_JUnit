package Selenium_Practice.day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_Dropdown {
    static WebDriver driver;
    @Before
    public void setUp() { //1. Launch browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
@Test
    public void test(){
    // https://the-internet.herokuapp.com/dropdown adresine gidin.
    driver.get("https://the-internet.herokuapp.com/dropdown");
// Index kullanarak Option 1 seçin ve sectiginiz option'u yazdırın
WebElement option=driver.findElement(By.xpath("//select[@id='dropdown']"));//locate ettik
Select select=new Select(option);
select.selectByIndex(1);
    System.out.println("select.getFirstSelectedOption().getText() = " + select.getFirstSelectedOption().getText());

// Value kullanarak Option 2 seçin ve sectiginiz option'u yazdırın

    select.selectByValue("2");
    System.out.println(select.getFirstSelectedOption().getText());
// Visible Text kullanarak Option 1 seçin ve sectiginiz option'u yazdırın
select.selectByVisibleText("Option 1");
    System.out.println(select.getFirstSelectedOption().getText());
// Tüm option'ları yazdırın
    List<WebElement> tumOption=select.getOptions();
     int sayac=1;
    for (WebElement w:tumOption) {
        System.out.println(sayac +".option "+w.getText());
        sayac++;
    }

// lambda ile; tumOption.stream().forEach(t-> System.out.println(t+" "));

// dropdown'daki optionlarin toplam sayısının 3'e esit oldugunu test edin :test diyorsa assert vardır

    List<WebElement> tumOpsions=select.getOptions();
    System.out.println("tumOpsions.size() = " + tumOpsions.size());
    int actualedOpsion=tumOpsions.size();
    int expectedOption=3;
    Assert.assertEquals(expectedOption,actualedOpsion);

}

    @After
    public void name() {
    }
}
