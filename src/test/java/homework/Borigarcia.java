package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilies.TestBase;

import java.time.Duration;
import java.util.List;

public class Borigarcia extends TestBase {
    @Test
    public void test() {
        //https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html adresine gidelim
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");
        //Hesap makinasından 2 basamaklı random iki tane sayı seçelim ve random 4 işlemden birini yaptıralım
        int rakam1 = (int)(Math.random()*(9)+1);
        int rakam2 = (int)(Math.random()*11);
        int rakam3 = (int)(Math.random()*(9)+1);
        int rakam4 = (int)(Math.random()*11);

        String sayi1String = ""+rakam1+rakam2;
        String sayi2String = ""+rakam3+rakam4;

        double sayi1 = Double.parseDouble(sayi1String);
        double sayi2 = Double.parseDouble(sayi2String);

        driver.findElement(By.xpath("//*[@class='keys']//span[.='"+rakam1+"']")).click();
        driver.findElement(By.xpath("//*[@class='keys']//span[.='"+rakam2+"']")).click();

        waitFor(2);

        List<WebElement> islemler =  driver.findElements(By.xpath("//*[@class='keys']//span[@class='operator btn btn-outline-success']"));
        WebElement secilenIslem = islemler.get((int)(Math.random()*4));
        secilenIslem.click();
        waitFor(2);

        driver.findElement(By.xpath("//*[@class='keys']//span[.='"+rakam3+"']")).click();
        driver.findElement(By.xpath("//*[@class='keys']//span[.='"+rakam4+"']")).click();
        driver.findElement(By.xpath("//*[@class='keys']//span[@class='btn btn-outline-warning']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//*[@id='spinner']"))));

        //Sonucu konsola yazdırıp
        String sonuc = driver.findElement(By.xpath("//*[@class='screen']")).getText();
        double actualResult = Double.parseDouble(sonuc);
        System.out.println("Gerçek Sayı = " + actualResult);

        //Sonucun doğrulamasını yapalım
        double expectedResult = 0;
        if(secilenIslem.getText().equals("+")){
            expectedResult = sayi1+sayi2;
        }else if(secilenIslem.getText().equals("-")){
            expectedResult = sayi1-sayi2;
        }else if(secilenIslem.getText().equals("x")){
            expectedResult = sayi1*sayi2;
        }else if(secilenIslem.getText().equals("÷")){
            expectedResult = sayi1/sayi2;
        }
        System.out.println("Beklenen Sayı = " + expectedResult);
        Assert.assertTrue(expectedResult==actualResult);
    }
}