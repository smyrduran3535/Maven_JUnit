package Slayt_Questions_Odev;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilies.TestBase;

public class C08_Alert extends TestBase {



        //   // go to url :http://demo.automationtesting.in/Alerts.html
        //"Alert with OK" butonuna tıklayın ve "click the button to display an  alert box:" 'a tıklayın
        //    accept Alert(I am an alert box!) and print alert on console
//Alert(I am an alert box!) konsolda yazdırın ve Alert'ü kabul edin.
        //    click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
//"Alert with OK & Cancel" butonuna tıklayın ve"click the button to display a confirm box " butonuna tıklayın
        //    cancel Alert  (Press a Button !)
//Alert'ü kapatın
        //    click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
//"Alert with Textbox" butonuna tıklayın ve "click the button to demonstrate the prompt box " butonuna tıklayın.
        //    and then sendKeys 'TechProEducation' (Please enter your name)
//Açılan alert e 'TechProEducation' (Lütfen İsminizi girin).
//Gönderdiğiniz metnin isminizi içerdiğini doğrulayın
        //    finally print on console this mesaaje "Hello TechproEducation How are you today"

        @Test
        public void testAlert() throws InterruptedException {
            // go to url :http://demo.automationtesting.in/Alerts.html
            driver.get("http://demo.automationtesting.in/Alerts.html");
            //"Alert with OK" butonuna tıklayın ve "click the button to display an  alert box:" 'a tıklayın
            driver.navigate().refresh();
            driver.findElement(By.xpath("//*[@class='analystic'][1]")).click();
            driver.findElement(By.xpath("//*[@class='btn btn-danger']")).click();
            Thread.sleep(3000);
            //Alert(I am an alert box!) konsolda yazdırın ve Alert'ü kabul edin.
            System.out.println(driver.switchTo().alert().getText());
            driver.switchTo().alert().accept();
            Thread.sleep(4000);

            //click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
            //"Alert with OK & Cancel" butonuna tıklayın ve"click the button to display a confirm box " butonuna tıklayın
            driver.findElement(By.xpath("(//*[@class='analystic'])[2]")).click();
            driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
            Thread.sleep(3000);

            //cancel Alert  (Press a Button !)
            //Alert'ü kapatın
            driver.switchTo().alert().dismiss();
            //click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
            //"Alert with Textbox" butonuna tıklayın ve "click the button to demonstrate the prompt box " butonuna tıklayın.
            driver.findElement(By.xpath("(//*[@class='analystic'])[3]")).click();
            driver.findElement(By.xpath("//*[@class='btn btn-info']")).click();
            //and then sendKeys 'TechProEducation' (Please enter your name)
            //Açılan alert e 'TechProEducation' (Lütfen İsminizi girin).
            driver.switchTo().alert().sendKeys("TechProEducation Sumeyra");
            Thread.sleep(4000);
            driver.switchTo().alert().accept();

            //Gönderdiğiniz metnin isminizi içerdiğini doğrulayın
            // finally print on console this mesaaje "Hello TechproEducation How are you today"
            String message = driver.findElement(By.xpath("//*[@id='demo1']")).getText();
            Assert.assertTrue(message.contains("Sumeyra"));
        }


}

