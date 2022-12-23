package Slayt_Questions_Odev;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Can_Example{
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//1. "https://www.saucedemo.com" Adresine gidin
        driver.get("https://www.saucedemo.com");
//2. Username kutusuna "standard_user" yazdirin
        driver.findElement(By.xpath("//*[@id='user-name']")).sendKeys("standard_user");
//3. Password kutusuna "secret_sauce" yazdirin
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("secret_sauce");
//4. Login tusuna basin
        driver.findElement(By.xpath("//*[@class='submit-button btn_action']")).click();
//5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        driver.findElement(By.xpath("//*[@alt='Sauce Labs Backpack']")).click();
//6. Add to Cart butonuna basin
        driver.findElement(By.xpath("//*[@class='btn btn_primary btn_small btn_inventory']")).click();
//7. Alisveris sepetine tiklayin
        driver.findElement(By.xpath("//*[@class='shopping_cart_link']")).click();
//8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
driver.findElement(By.xpath("//*[@id='checkout']")).click();
//9. Sayfayi kapatin
        driver.close();
    }
}
