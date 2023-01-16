package automationexercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilies.TestBase;

public class C26 extends TestBase {
    @Test
    public void test() {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        Assert.assertTrue( driver.findElement(By.xpath("//body")).isDisplayed());
        //4. Scroll down page to bottom
        scrollDownActions();
        //5. Verify 'SUBSCRIPTION' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='single-widget']//h2")).isDisplayed());
        //6. Scroll up page to top
        scrollUpActions();
        //7. Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='col-sm-6']//h2")).isDisplayed());
    }
}
