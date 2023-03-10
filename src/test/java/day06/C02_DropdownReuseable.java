package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.asn1.dvcs.DVCSObjectIdentifiers;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_DropdownReuseable {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    //REUSEABLE METHOD: Dropdown icin tekrar tekrar kullanabilecegimiz bir method olusturalım:
    public void selectFromDropdown(WebElement dropdown, String secenek) {
        //selectFromDropdown(driver.findElement(By.xpath("//select[@id='year']")),"2005");=>bu dropdowndan 2005 i sececek
        // bu dropdown' dan isaretlenen 2005 secenegi secer
        //selectFromDropdown(driver.findElement(By.xpath("//*[@id='day']")),"12") gun den 12 yi secer
        //selectFromDropdown(driver.findElement(By.xpath("//*[@id='month']")),"January");
//bunları secmek icin bu methodu kullanıcaz dinamic olsun diye
        //gonderilen dropdown elementinin tum optionsları bu sekilde alınır.
        List<WebElement> options = dropdown.findElements(By.tagName("option"));//bu method gondermis oldugumuz webelementin tum elemanlatını return eder
        //tag option oldugu icin ne kadar options varsa return eder. istedigimize loop koyarak erisebiliriz
      //gonderilen dropdown elementlerinin tum optionsları alınır
        for (WebElement eachOption : options) {
            if (eachOption.getText().equals(secenek)) {//bizim istedigimiz secenege esitse tıkla
                eachOption.click();
                break;
            }
        }
        //NOTE: sonraki derste tekrar ve kullanımı
/*
    Dropdown?
         -Acilir menu demektir. Birden fazla seçenegi koyabilecegimiz liste.
    ***Dropdown nasil automate edilir? How to handle dropdown?
     1-Dropdown elementi locate edilir. 8 locatordan biri kulllaninbilir.
     2-Select classi kullanilarak bir Select objesi olusturulur; Select select = new Select(dropdownElement);
     3-Select objectini kullanarak ugun methodlarla islem yapilir
        -selectBylndex(int); index 0 dan baslar fakat cok tercih edilmez
        -selectByValue(“String”);
        -selectByVisibleText(“String”);
        -getOptions(); tum dropdown seçenekleri List<WebElement> olarak return eder
        -getFirstSelectedOption(); secili olan ilk secenegi(default) return eder.
 */
    }

    @Test
    public void selectFromDropdown() {
                                      // public void selectFromDropdown(WebElement dropdown, String secenek)
        selectFromDropdown(driver.findElement(By.xpath("//select[@id='year']")), "2005");
        selectFromDropdown(driver.findElement(By.id("month")),"November");//select elementini secmeye gerek yok yukarda sectik
        selectFromDropdown(driver.findElement(By.id("day")),"10");
        selectFromDropdown(driver.findElement(By.id("state")),"Texas");
    }
}