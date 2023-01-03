package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import utilies.TestBase;

import java.util.Set;

public class C02_HandleWindows extends TestBase {
    @Test
    public void testHandleWindows() {

        //https://testcenter.techproeducation.com/index.php?page=multiple-windows
        driver.get("https://testcenter.techproeducation.com/index.php?page=multiple-windows");
        String windows1 = driver.getWindowHandle();
        System.out.println("windows1 = " + windows1);

        //Title in ‘Windows’ oldugunu test edin
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Windows"));

        //Click here a tiklayin
        driver.findElement(By.linkText("Click Here")).click();
      //switchToWindow("New Window"); bu TestBase deki method;diger sayfaya gecer asagıdaki loop gibi
      String windows=driver.getWindowHandle();
      for (String w:driver.getWindowHandles()){
          driver.switchTo().window(w);
          if (driver.getTitle().equals("New Window")){
           return;
          }
      }
      driver.switchTo().window(windows);
        String window2 = driver.getWindowHandle();
        System.out.println("window2 = " + window2);

        //Sonra açılan sayfadaki title in ‘New Window’ oldugunu dogrulayin
        String newTitle = driver.getTitle();
        Assert.assertTrue(newTitle.contains("New Window"));


    }
}


