package Slayt_Questions_Odev;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class C03_Farkli_cozum {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //    ~ Navigate to http://tutorialsninja.com/demo/index.php?route=common/home
        driver.get("http://tutorialsninja.com/demo/index.php?route=common/home");

        //    ~ click on Phones & PDAs
        driver.findElement(By.xpath("//*[@href=\"http://tutorialsninja.com/demo/index.php?route=product/category&path=24\"]")).click();

        //    ~ get the brandName of phones
        List<String> brandNames = getBrandNames(driver);

        //    ~ click on add to button for all elements
        clickAllElement(driver);

        //    ~ click on black total added cart button
        driver.findElement(By.xpath("//*[@class=\"btn btn-inverse btn-block btn-lg dropdown-toggle\"]")).click();

        //    ~ get the names of list from the cart
        List<String> namesInCart = namesInCart(driver);

        //    ~ compare the names from displaying list and cart list
        compare(brandNames, namesInCart);

    }

public static void clickAllElement(WebDriver a){
        List<WebElement> addButtons = a.findElements(By.xpath("//*[text()='Add to Cart']"));
        addButtons.forEach(t-> t.click());
        }

public static List<String> getBrandNames(WebDriver a){
        List<WebElement> brandNames = a.findElements(By.xpath("//h4"));
        List<String> sBrandNames = new ArrayList<>();
        brandNames.forEach(t-> sBrandNames.add(t.getText()));
        Collections.sort(sBrandNames);
        return sBrandNames;
        }
public static List<String> namesInCart(WebDriver a){
        List<WebElement> names = a.findElements(By.xpath("//*[@class='text-left']"));
        List<String> sNames = new ArrayList<>();
        names.forEach(t-> sNames.add(t.getText()));
        Collections.sort(sNames);
        return sNames;
        }
public static void compare(List<String> a, List<String> b){
        if(a.equals(b)){
        System.out.println("Eşleşme başarılı");
        }else System.err.println("Eşleşme başarısız");
        }
}
/*
//        ~ Navigate to http://tutorialsninja.com/demo/index.php?route=common/home
        driver.navigate().to("http://tutorialsninja.com/demo/index.php?route=common/home");

//        ~ click on Phones & PDAs
        driver.findElement(By.xpath("//*[text()='Phones & PDAs']")).click();

//        ~ get the brandName of phones
        phonesNames = driver.findElements(By.cssSelector("div.caption>h4>a"));

        getName(phonesNames, goruntulemeListesi);
        Thread.sleep(2000);

//        ~ click on add to button for all elements
        addToCart = driver.findElements(By.xpath("//*[text()='Add to Cart']"));

        allClick(addToCart);

//        ~ click on black total added cart button
        driver.findElement(By.id("cart-total")).click();

//        ~ get the names of list from the cart
        listNames = driver.findElements(By.cssSelector("td.text-left>a"));

        getName(listNames, sepetListesi);

//        ~ compare the names from displaying list and cart list
        compareTwoList(goruntulemeListesi, sepetListesi);

        System.out.println("\n VUR DEDİK ÖLDÜRDÜN BE HOCAM !!!!!!!");

//        ~ close driver !

        Thread.sleep(2000);
        driver.close();
    }

    public static void compareTwoList(List<String> a, List<String> b) {
        System.out.println(goruntulemeListesi.equals(sepetListesi) ? "Listeler Aynı" : "Listeler Farklı");

    }

    public static void getName(List<WebElement> a, List<String> b) {

        for (WebElement y : a) {
            b.add(y.getText());
        }
        Collections.sort(b);
        System.out.println(b);
    }

    public static void allClick(List<WebElement> a) throws InterruptedException {

        for (WebElement k : addToCart) {
            k.click();
            Thread.sleep(2000);
        }
    }

 */