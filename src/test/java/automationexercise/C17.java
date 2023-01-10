package automationexercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilies.TestBase;

public class C17 extends TestBase {
    //Test Case 17: Remove Products From Cart
    @Test
    public void test() throws InterruptedException {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement page = driver.findElement(By.xpath("//body"));
        Assert.assertTrue(page.isDisplayed());
        //4. Add products to cart
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])[1]")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();
        //5. Click 'Cart' button
        driver.findElement(By.xpath("(//a[@href='/view_cart'])[1]")).click();

        //6. Verify that cart page is displayed
        WebElement cartPage = driver.findElement(By.xpath("//tbody"));
        Assert.assertTrue(cartPage.isDisplayed());
        //7. Click 'X' button corresponding to particular product
        driver.findElement(By.xpath("//td/a/i")).click();
        //8. Verify that product is removed from the cart
        Thread.sleep(2000);
        WebElement verifyRemove = driver.findElement(By.xpath("//b[normalize-space()='Cart is empty!']"));
        Assert.assertTrue(verifyRemove.isDisplayed());
    }
}
