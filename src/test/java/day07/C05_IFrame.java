package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilies.TestBase;

public class C05_IFrame extends TestBase {
    @Test
    public void test(){
        //Iframe nedir?
        //https://testcenter.techproeducation.com/index.php?page=iframe
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");
        //Ana sayfadaki An iframe with a thin black border: metnin black border yazisinin oldugunu test edelim
        String actual= driver.findElement(By.xpath("//*[text()='An iframe with a thin black border:']")).getText();
        String expect="An iframe with a thin black border";
        Assert.assertTrue(actual.contains(expect));
        //Ayrica ‘Applications lists’ yazisinin sayfada oldugunu test edelim
        //Son olarak footer daki ‘Powered By’ yazisini varligini test edilip




    }

}
