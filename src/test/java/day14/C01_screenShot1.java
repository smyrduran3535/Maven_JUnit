package day14;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import utilies.TestBase;

import java.io.File;
import java.io.IOException;
import java.security.Key;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_screenShot1 extends TestBase {
    @Test
    public void test() throws IOException {
         /*
     Selenium tum ekran goruntusu nasil alinir?
    -tum ekran goruntusu selenium'dan gelen getScreenshotAs method'u ile alinir
    -getScreenshotAs method'u Selenium'daki TakeScreenshot API(baglantı kurmaya yarayan arac=>sınıf gibi sinifın ustu gibi)' indan gelir.
         */

        //Techpro education a git ve Sayfanin goruntusunu al
        driver.get("https://www.techproeducation.com");


        //-“QA” aramasi yap
        driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("QA"+ Keys.ENTER);
        //Acilen sayfanin metnini test et ve ekran goruntusu al: “Search Results for: qa”
       //TakesScreenshot ts=(TakesScreenshot)driver;
       //WebElement body= driver.findElement(By.xpath("//body"));
       //ts.getScreenshotAs()
       File goruntu= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);//goruntuyu aldık
        //OutputType direk resim dosyasını alamıyoruz o yuzden biz dosya olarak aldık ve png uzantısı ile kaydettik
        //kaydediyoruz :kaydedecegimiz yeri ayarladık bir PATH e
        //user.dir dosya yolu demek directer kısatlması dir..."dir" dosya olarak aklında kalsın
        String currentDate=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());//bu andaki zaman ile alıcaz goruntuyu
//her seferinde yeni bir ekran goruntusu yeni isimle kaydolcak...
// NEDEN YAPTIK: kayit ismini dinamic yapmak icin date objesi kullandım
        String path=System.getProperty("user.dir")+"/test-output/EkranGoruntuleri/"+currentDate+"image.png";
        File hedef=new File(path);
        //ikisi java yardımı ile birlestiriyoruz Goruntumile dosyayi birlestiriyoruz
        FileUtils.copyFile(goruntu,hedef);//kaynagı hedefe yapıstırcaz... path string oldugu icin new file a da yapıstırabiliriz
       //file olmak zorunda ici

        /*
        //kestirme hepsi bir yerde boyle kullanabiliriz
        FileUtils.copyFile(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE),
                new File(System.getProperty("user.dir")+"/test-output/EkranGoruntuleri/image.png"));
                */

        }
    }

