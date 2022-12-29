package Selenium_Practice.day01;

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

public class C02_DropDownOptions {

    WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void teardown() {
      driver.close();
    }
    @Test
    public void test(){
        // https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com/");
// dropdown'dan "Baby" secenegini secin
        //1.locate edilmeli
        WebElement ddMenu = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        //2.select objesi olustur
        Select select = new Select(ddMenu);
        //opsiyon secilir
        select.selectByValue("search-alias=baby-products-intl-ship");
// sectiginiz option'i yazdirin
        String sectigimOption=select.getFirstSelectedOption().getText();
        System.out.println("sectigimOption = " + sectigimOption);
// dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin
List<WebElement> tumOpsions=select.getOptions();
        System.out.println("tumOpsions.size() = " + tumOpsions.size());
        int actualedOpsion=tumOpsions.size();//dropdowndaki opsionların sayısını int olarak dondurur
        int expectedOption=28;
        Assert.assertEquals(expectedOption,actualedOpsion);
    }
}
