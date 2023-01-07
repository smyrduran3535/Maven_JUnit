package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilies.TestBase;

public class C04_Actions4 extends TestBase {
    @Test
    public void dragAndDrogTest() {
        //        EN FAZLA SURUKLEMEK ICIN KULLANILAN METHOD BUDUR
//        Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");
//        KAYNAK VE HEDEF ELEMENTLERI IFRAMEIN ICINDE
        driver.switchTo().frame(0);

        //        And user moves the target element(Drag me to my target) in to  destination(Drop here)
        WebElement draggable= driver.findElement(By.id("draggable"));
        WebElement droppable=driver.findElement(By.id("droppable"));
        //        dragAndDrop() surukleme islemini gerceklestirir
        Actions actions=new Actions(driver);
        actions.dragAndDrop(draggable,droppable).perform();
        waitFor(3);
    }



    @Test
    public void clickAndHoldTest() {
        driver.get("https://jqueryui.com/droppable/");
        driver.switchTo().frame(0);
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));
        Actions actions = new Actions(driver);

        actions.clickAndHold(draggable).//kaynagı tut
                moveToElement(droppable).//hedefe koy surukleyıp
                release().//kaynagı bırak
                build().//onceki methodlarının iliskisini kur/guclendir.KULLANILMASI TERCİH EDİLİR.performdan ONCE kullanılır.
                // 1 den fazla fonksiyonun oldugu textcaselerde build kullanılması gerekerir . netlik saglar..
                // Fakat build sart degil perform kullanmak sarttır
                        perform();//calıstır
    }
        @Test
        public void moveByOffSetTest(){
//        Given user is on https://jqueryui.com/droppable/
            driver.get("https://jqueryui.com/droppable/");
//        KAYNAK VE HEDEF ELEMENTLERI IFRAMEIN ICINDE
            driver.switchTo().frame(0);
//        And user moves the target element(Drag me to my target) in to  destination(Drop here)
            WebElement draggable = driver.findElement(By.id("draggable"));
            //droppable a gerek yok koordinatlar kullancaz
//        dragAndDrop() surukleme islemini gerceklestirir
            Actions actions = new Actions(driver);
            actions.clickAndHold(draggable).
                    moveByOffset(430,30).
                    release().
                    build().
                    perform();

    }
}
