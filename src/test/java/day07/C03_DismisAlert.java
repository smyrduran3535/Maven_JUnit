package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilies.TestBase;

public class C03_DismisAlert extends TestBase {
@Test
public void dismissAlertTest(){
    driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
    //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının “You clicked: Cancel” oldugunu test edin.
    driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
    driver.switchTo().alert().dismiss();
    String actualResult=driver.findElement(By.xpath("//*[text()='You clicked: Cancel']")).getText();
    String excetedResult="You clicked: Cancel";
    Assert.assertEquals(excetedResult,actualResult);
}
}
