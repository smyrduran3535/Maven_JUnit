package day10;

import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilies.TestBase;

public class C03_Actions03 extends TestBase {
    /*
    asagıya ve yukarıya 2 farklı yol kullanabiilriz
    -arrow_down ve page_down
    - -arrow_up ve page_up
     */
    @Test
    public void scrollUpDown() {

//        https://techproeducation.com a git
        driver.get("https://techproeducation.com");

        //once actions olusturalım
        Actions actions = new Actions(driver);
        //        Sayfanin altına doğru gidelim
        actions.sendKeys(Keys.PAGE_DOWN).perform();//perform UNUTMA !!!
        //3 defa takrarlansın asagı insin
        waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        waitFor(2);
        actions.
                sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();//burda aralara bekleme suresi veremiyoruz

                    //ARROW_DOWN ile de asagı inilir FAKAT =>
        actions.sendKeys(Keys.ARROW_DOWN).perform();//    ARROW_DOWN ;PAGE_DOWN dan daha az mesafe aldirir
        waitFor(3);

        //        Sonra sayfanın üstüne doğru gidelim
//        YUKARI CIK
        actions.sendKeys(Keys.PAGE_UP).perform();
        waitFor(2);
        actions.sendKeys(Keys.PAGE_UP).perform();
        waitFor(2);
        actions.sendKeys(Keys.PAGE_UP).perform();
        waitFor(2);

//        actions.sendKeys(Keys.ARROW_RIGHT).perform();
//        actions.sendKeys(Keys.ARROW_LEFT).perform();

    }

}
