package Slayt_Questions_Odev;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilies.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class C10_iframe extends TestBase {
    @Test
    public void test(){
//go to web site : https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
//maximize the website
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
// ikinci emojiye tıklayın
        WebElement iFrame = driver.findElement(By.id("emoojis"));
        driver.switchTo().frame(iFrame);
// ikinci emoji altındaki tüm öğelere tıklayın
        driver.findElement(By.xpath("(//span[@data-upgraded=',MaterialRipple'])[2]")).click();
        List<WebElement> allEmojiis = driver.findElements(By.xpath("//div[@id='nature']/div/img"));
        allEmojiis.forEach(WebElement::click);
// ana iframe'e geri dön
        driver.switchTo().defaultContent();
//formu doldurun,(Formu istediğiniz metinlerle doldurun)
        List<WebElement> allInputs = driver.findElements(By.xpath("//input"));
        List<String> allWords = new ArrayList<>(Arrays.asList("OLDBOY",
                "THE FALL","STALKER","AMOUR","THE SHINING","THE BIG LEBOWSKI.","IFRAME","VERY","COOL","?","?"));
        for(int i = 0; i<allInputs.size(); i++){
            allInputs.get(i).sendKeys(allWords.get(i));
        }
// uygula butonuna tıklayın
        driver.findElement(By.id("send")).click();
        WebElement code = driver.findElement(By.id("code"));
        assertTrue(code.isDisplayed());
    }
}
