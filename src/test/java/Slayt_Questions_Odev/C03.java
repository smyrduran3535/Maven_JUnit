package Slayt_Questions_Odev;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

import static Slayt_Questions_Odev.C03_Farkli_cozum.getBrandNames;

public class C03 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

   //~ Navigate to http://tutorialsninja.com/demo/index.php?route=common/home
        driver.get("http://tutorialsninja.com/demo/index.php?route=common/home");
   //~ click on Phones & PDAs
driver.findElement(By.cssSelector("a[href='http://tutorialsninja.com/demo/index.php?route=product/category&path=24']")).click();
   //~ get the brandName of phones
        List<String> brandNames = getBrandNames(driver);
driver.findElement(By.cssSelector("a[href='http://tutorialsninja.com/demo/index.php?route=product/product&path=24&product_id=28']")).click();

      //~ click on add to button for all elements
       WebElement tumElement=driver.findElement(By.xpath("//button"));
       tumElement.click();

   //~ click on black total added cart button
driver.findElement(By.id("button-cart")).click();
   //~ get the names of list from the cart
   //~ compare the names from displaying list and cart list

    }
}
