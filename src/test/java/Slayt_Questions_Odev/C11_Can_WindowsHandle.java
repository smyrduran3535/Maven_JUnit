package Slayt_Questions_Odev;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilies.TestBase;

import java.util.Set;

public class C11_Can_WindowsHandle extends TestBase {
    /*
       url'ye git: http://demo.guru99.com/popup.php
       ilk pencereyi al
       "Click Here" butonuna tıklayın
       setteki tüm pencereyi al
       diğer pencereye geç
       e-posta kimliğini (somepne@gmail.com) girin ve bu girişe bir şey yazın
       Gönder düğmesine tıklayarak
       ""This access is valid only for 20 days."" ifadesinin beklendiği gibi olduğunu doğrula
       Tekrar ilk pencereye geç
       İlk pencerede olduğunu doğrula
      */
    @Test
    public void test(){
        // url'ye git: http://demo.guru99.com/popup.php
        driver.get("http://demo.guru99.com/popup.php");
        // ilk pencereyi al
        String ilkPencere= driver.getWindowHandle();
        System.out.println("ilk pencere ID "+ilkPencere);
        // "Click Here" butonuna tıklayın
        driver.findElement(By.linkText("Click Here")).click();

// setteki tüm pencereyi al
        Set<String> allWindows=driver.getWindowHandles();
        System.out.println("allWindows = " + allWindows);
//       diğer pencereye geç
      for (String w:allWindows){
            if (!w.equals(ilkPencere)){
               driver.switchTo().window(w);
               break;
            }
        }
      //  e-posta kimliğini (somepne@gmail.com) girin ve bu girişe bir şey yazın
        driver.findElement(By.name("emailid")).sendKeys("somepne@gmail.com", Keys.ENTER);
      // ""This access is valid only for 20 days."" ifadesinin beklendiği gibi olduğunu doğrula
        String expected="This access is valid only for 20 days.";
        String actualed=driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals(expected,actualed);
        // Tekrar ilk pencereye geç
        driver.switchTo().window(ilkPencere);
        //   İlk pencerede olduğunu doğrula
      String ilkP= driver.getWindowHandle();
        System.out.println("ilkP = " + ilkP);
        Assert.assertTrue(ilkP.equals(ilkPencere));
    }
}
