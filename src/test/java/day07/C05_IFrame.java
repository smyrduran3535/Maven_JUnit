package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilies.TestBase;

public class C05_IFrame extends TestBase {
    @Test
    public void test() {
        //Iframe nedir?
        //https://testcenter.techproeducation.com/index.php?page=iframe
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");

        //Ana sayfadaki An iframe with a thin black border: metnin black border yazisinin oldugunu test edelim
        String actual = driver.findElement(By.xpath("//*[text()='An iframe with a thin black border:']")).getText();
        //*[.='text name']
        //tag[.='metin']; Bana bu tagli metni ver
        //tag[text()='metin'];
        String expect = "black border";
        Assert.assertTrue(actual.contains(expect));


        //Ayrica ‘Applications lists’ yazisinin sayfada oldugunu test edelim
        //  WebElement frame= driver.findElement(By.xpath("//*[text()='Applications lists']"));

        //<iframe src="/index.php" width="100%" height="300" style="border:1px solid black;">:
        // ‘Applications lists’ elementi iframe in icinde
        driver.switchTo().frame(0);//index 0 dan baslar. ilk iframe i switch yapıyoruz
        //bunu yaptıktan sonra devamını yapıyoruz:
        String icMetin = driver.findElement(By.xpath("//*[.='Applications lists']")).getText();
        String expectedText1 = "Applications lists";
        //assertequals kull aynı cunku
        Assert.assertEquals(expectedText1, icMetin);
        //  Assert.assertTrue(expectedText1.contains(icMetin));//bu da kullanilabilir
        // Assert.assertTrue(driver.findElement(By.xpath("//*[.='Applications lists']")).isDisplayed()); kull. fakat cok tercih edilmez bu yontem
        // ama yazıyı test etmek istiyoruz o yuzden equals mantıklı


        //Son olarak footer daki ‘Powered By’ yazisini varligini test edilip
        driver.switchTo().defaultContent();//Powered By iframe 'in dısında oldugu icin once iframe den cıkmak lazım.
        // driver.switchTo().defaultContent() yada parent() kullanırız iframeden cıkmak icin
        String footerText = driver.findElement(By.xpath("(//footer[@class='blog-footer'][1])//p")).getText();
        //   //p[text()='Povered By'] bunu da kullanabilirsin yukarda once baba sonra oglu bulundu
        System.out.println(footerText);
        Assert.assertTrue(footerText.contains("Povered By"));


    }

}
