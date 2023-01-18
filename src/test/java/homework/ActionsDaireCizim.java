package homework;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilies.TestBase;

public class ActionsDaireCizim extends TestBase {
    @Test
    public void test() {
        driver.get("http://szimek.github.io/signature_pad/");
        WebElement canvas = driver.findElement(By.tagName("canvas"));
        Actions actions = new Actions(driver).moveToElement(canvas).clickAndHold();
        double yaricap = 10;
        for (int i = 0; i <= 20; i++) {
            double yariCapAcisi = Math.toRadians((double) i / 20 * 360);
            double x = Math.sin(yariCapAcisi) * yaricap;
            double y = Math.cos(yariCapAcisi) * yaricap;
            actions.moveByOffset((int)x,(int)y);
        }
        actions.release().perform();
        actions.build().perform();
        waitFor(5);

    }
}
