package Slayt_Questions_Odev;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilies.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WebTable extends TestBase {
    @Test
    public void test() {
        //1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");
        //2. Headers da bulunan department isimlerini yazdirin
List<WebElement> departmant=driver.findElements(By.xpath("//div[@class='rt-table']//div//div//div[6]"));

    departmant.stream().forEach(t-> System.out.println(t.getText()));

//3. sutunun basligini yazdirin
       String sutun3= driver.findElement(By.xpath("//div[@class='rt-table']//div//div//div[3]//div")).getText();
        System.out.println("sutun3 = " + sutun3);
        //4. Tablodaki tum datalari yazdirin
        List<WebElement> allData=driver.findElements(By.xpath("//div[@class='rt-table']"));
        allData.stream().forEach(t-> System.out.println(t.getText()));
        //5. Tabloda kac cell (data) oldugunu yazdirin
        List<WebElement> cell=driver.findElements(By.xpath("//div[@class='rt-tbody']//div//div"));
        System.out.println("cell.size() = " + cell.size());
        //6. Tablodaki satir sayisini yazdirin

        //7. Tablodaki sutun sayisini yazdirin

        //8. Tablodaki 3.kolonu yazdirin
        List<WebElement> kolom3=driver.findElements(By.xpath("(//div[@class='rt-resizable-header-content'])[3]"));
        kolom3.stream().forEach(t-> System.out.println(t.getText()));
        //9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        String firstNameKierra=driver.findElement(By.xpath("//div[@class='rt-tbody']//div[3]//div//div[1]")).getText();
        System.out.println("firstNameKierra = " + firstNameKierra);
        //10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun
        //sayisini girdigimde bana datayi yazdirsin
    }
    public void data(String satir,String sutun){

    }
}
