package Slayt_Questions_Odev;

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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C06_example {
     /*
1-https://books-pwakit.appspot.com/ adresine gidin.
2-"BOOKS" başlığının görünür olduğunu doğrulayın
3-Arama çubuğunda "Selenium" u aratın.
4-Arama sonuçlarındaki ilk ürün isminin "Selenium" içerdiğini doğrulayın.
*/
    WebDriver driver;
    String result;
@Before
    public void SetUp(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

}
@Test
    public void test(){
    driver.get("https://books-pwakit.appspot.com/");
    //2-"BOOKS" başlığının görünür olduğunu doğrulayın
    WebElement baslik=driver.findElement(By.xpath("//*[text()='BOOKS']"));
    Assert.assertTrue(baslik.isDisplayed());
  // result=baslik.isDisplayed() ?"passed":"failed";
   //3-Arama çubuğunda "Selenium" u aratın.
driver.findElement(By.xpath("//book-app [@apptitle='BOOKS']")).sendKeys("Selenium", Keys.ENTER);
//4-Arama sonuçlarındaki ilk ürün isminin "Selenium" içerdiğini doğrulayın.

  String ilkUrunBaslik= driver.getTitle();
   if (ilkUrunBaslik.contains("Selenium")){
       System.out.println("passed");
   }else{
       System.out.println("failed");
   }


}
@After
    public void tearDown(){
  //  driver.close();
}
}
