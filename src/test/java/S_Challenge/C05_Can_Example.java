package S_Challenge;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static junit.framework.TestCase.assertTrue;

public class C05_Can_Example {
    /* Given kullanici "https://editor.datatables.net/" sayfasina gider
    Then new butonuna basar
    And editor firstname kutusuna "<firstName>" bilgileri girer
    And editor lastname kutusuna "<lastName>" bilgileri girer
    And editor position kutusuna "<position>" bilgileri girer
    And editor office kutusuna "<office>" bilgileri girer
    And editor extension kutusuna "<extension>" bilgileri girer
    And editor startdate kutusuna "<startDate>" bilgileri girer
    And editor salary kutusuna "<salary>" bilgileri girer
    When Create tusuna basar
    Then Kullanıcının eklendiğini doğrular.
    And Eklediği kullanıcı kaydını siler
    Then Kullanıcinin silindiğini doğrular.
    */
    WebDriver driver;
    @Before
            public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown() throws InterruptedException {

        Thread.sleep(3000);
        //driver.close();

    }
    @Test
    public void test01(){
        driver.get("https://editor.datatables.net/");
// Then new butonuna basar
        driver.findElement(By.xpath("//*[text()='New']")).click();
        // And editor firstname kutusuna "<firstName>" bilgileri girer
        driver.findElement(By.xpath("//*[@id='DTE_Field_first_name']")).sendKeys("Sumeyra");
        //    And editor lastname kutusuna "<lastName>" bilgileri girer
        driver.findElement(By.xpath("//*[@id='DTE_Field_last_name']")).sendKeys("Dur");
        //    And editor position kutusuna "<position>" bilgileri girer
        driver.findElement(By.xpath("//*[@id='DTE_Field_position']")).sendKeys("teacher");
        //    And editor office kutusuna "<office>" bilgileri girer
        driver.findElement(By.xpath("//*[@id='DTE_Field_office']")).sendKeys("Canada");
        //    And editor extension kutusuna "<extension>" bilgileri girer
        driver.findElement(By.xpath("//*[@id='DTE_Field_extn']")).sendKeys("Software");
        //    And editor startdate kutusuna "<startDate>" bilgileri girer
        driver.findElement(By.xpath("//*[@id='DTE_Field_start_date']")).sendKeys("2018-12-10");
        //    And editor salary kutusuna "<salary>" bilgileri girer
        driver.findElement(By.xpath("//*[@id='DTE_Field_salary']")).sendKeys("25000");
        //    When Create tusuna basar
        driver.findElement(By.xpath("//button[.='Create']")).click();
       // Then Kullanıcının eklendiğini doğrular.
        WebElement search = driver.findElement(By.xpath("//input[@type='search']"));
        search.sendKeys("Sumeyra Dur", Keys.ENTER);
        assertTrue("PASSED",search.isDisplayed());
        //And Eklediği kullanıcı kaydını siler
        driver.findElement(By.xpath("//*[@id='row_58']")).click();
    // And Eklediği kullanıcı kaydını siler

        driver.findElement(By.xpath("//*[text()='Delete']")).click();
        driver.findElement(By.xpath("//*[@class='btn']")).click();
        WebElement deleteMi=driver.findElement(By.xpath("//*[text()='No matching records found']"));
        assertTrue("PASSED",deleteMi.isDisplayed());
    }

/*
    // Given kullanici "https://editor.datatables.net/" sayfasina gider
    driver.get("https://editor.datatables.net/");
    //And editor firstname kutusuna "<firstName>" bilgileri girerV
    driver.findElement(By.xpath("//*[@class='dt-button buttons-create']")).click();
    driver.findElement(By.xpath("(//*[@id='DTE_Field_first_name'])")).sendKeys("Zeynep");
    // And editor lastname kutusuna "<lastName>" bilgileri girer
    driver.findElement(By.xpath("(//*[@id='DTE_Field_last_name'])")).sendKeys("Ekem");
    //And editor position kutusuna "<position>" bilgileri girer
    driver.findElement(By.xpath("//*[@id='DTE_Field_position']")).sendKeys("Qality Assurance");
    //And editor office kutusuna "<office>" bilgileri girer
    driver.findElement(By.xpath("//*[@id='DTE_Field_office']")).sendKeys("Izmir");
    //And editor extension kutusuna "<extension>" bilgileri girer
    driver.findElement(By.xpath("//*[@id='DTE_Field_extn']")).sendKeys("IT");
    // And editor startdate kutusuna "<startDate>" bilgileri girer
    driver.findElement(By.xpath("//*[@id='DTE_Field_start_date']")).sendKeys("2022-12-24");
    //    And editor salary kutusuna "<salary>" bilgileri girer
    driver.findElement(By.xpath("//*[@id='DTE_Field_salary']")).sendKeys("98.500");
    // When Create tusuna basar
    driver.findElement(By.xpath("//*[text()='Create']")).click();
    //    Then Kullanıcının eklendiğini doğrular.
    WebElement search=driver.findElement(By.xpath("(//*[@id='example_filter']/label/input)"));
    search.sendKeys("Zeynep");
    assertTrue("Passed",search.isDisplayed());
    //    And Eklediği kullanıcı kaydını siler
    driver.findElement(By.id("row_58")).click();
    driver.findElement(By.xpath("(//*[@class='dt-button buttons-selected buttons-remove'])")).click();
    //    Then Kullanıcinin silindiğini doğrular.
    driver.findElement(By.xpath("(//*[@class='DTE_Form_Buttons'])")).click();
    assertTrue("Passed",search.isEnabled());
    Thread.sleep(5000);   }

 */

}
