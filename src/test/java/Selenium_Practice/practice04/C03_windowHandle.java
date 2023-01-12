package Selenium_Practice.practice04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilies.TestBase;

import java.util.Set;

public class C03_windowHandle extends TestBase {
    @Test
    public void test() {
        // 'https://www.n11.com' adresine gidin
        // 'https://www.n11.com' adresine gidin
        driver.get("https://www.n11.com");
        String sayfa1Handle = driver.getWindowHandle();

        // arama motoruna 'oppo' yazıp aratın
        driver.findElement(By.xpath("//input[@id='searchData']")).sendKeys("oppo" + Keys.ENTER);

        // ilk ürüne tıklayın
        driver.findElement(By.xpath("(//img[@class='lazy cardImage'])[1]")).click();
        Set<String> windowHandleSet = driver.getWindowHandles();

        String sayfa2Handle = "";
        for (String each : windowHandleSet) {
            if (!each.equals(sayfa1Handle)) {
                sayfa2Handle = each;

            }

        }

        System.out.println(windowHandleSet);
        System.out.println(sayfa1Handle);


        driver.switchTo().window(sayfa2Handle);

        // Basligin 'Oppo' icerdigini test edin.
        WebElement başlık = driver.findElement(By.xpath("//h1[@class='proName']"));
        String baslıkStr = başlık.getText();
        Assert.assertTrue(baslıkStr.contains("Oppo"));

        // ilk sayfaya donun ve Title'ını yazdırın
        driver.switchTo().window(sayfa1Handle);
        System.out.println("ilk sayfa title:"+ driver.getTitle());
    }
}
