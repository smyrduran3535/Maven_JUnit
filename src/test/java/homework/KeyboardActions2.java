package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilies.TestBase;

public class KeyboardActions2 extends TestBase {
    @Test
    public void test01() {

        //https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");

        //video’yu gorecek kadar asagi inin
        driver.switchTo().frame(0);
        Actions actions=new Actions(driver);
        WebElement video=driver.findElement(By.id("player"));
        actions.scrollToElement(video).perform();

        //videoyu izlemek icin Play tusuna basin
        WebElement playTusu=driver.findElement(By.xpath("//button[@aria-label='Oynat']"));
        playTusu.click();

        //videoyu calistirdiginizi test edin
         WebElement calistiMi= driver.findElement(By.xpath("//a[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));
      Assert.assertTrue(calistiMi.isDisplayed());


        //Powerful, but easy to misuse yazisinin gorunur oldugunu test edin
        driver.switchTo().parentFrame();
      WebElement yazi= driver.findElement(By.id("Powerful_but_easy_to_misuse"));

        Assert.assertTrue(yazi.isDisplayed());
    }
}
