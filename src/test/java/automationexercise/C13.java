package automationexercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilies.TestBase;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.security.Key;

public class C13 extends TestBase {
//automationexercise =Test Case 13: Verify Product quantity in Cart

    @Test
    public void VerifyProductQuantityInCart () throws AWTException {

        //2. Navigate to url 'http://automationexercise.com'
driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']")).isDisplayed());;
        //4. Click 'View Product' for any product on home page
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_4);
        driver.findElement(By.xpath("//a[@href='/product_details/2']")).click();
        //5. Verify product detail is opened
        WebElement detail=driver.findElement(By.className("product-information"));
        Assert.assertTrue(detail.isDisplayed());
        //6. Increase quantity to 4
        driver.findElement(By.id("quantity")).clear();
        driver.findElement(By.id("quantity")).sendKeys("4",Keys.ENTER);
        //7. Click 'Add to cart' button
        driver.findElement(By.xpath("//button[@type='button']")).click();
        //8. Click 'View Cart' button
        driver.findElement(By.xpath("//a[@href='/view_cart']//u")).click();
        //9. Verify that product is displayed in cart page with exact quantity
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
       WebElement displayed=driver.findElement(By.xpath("//button[@class='disabled']"));
        Assert.assertTrue(displayed.getText().contains("4"));
    }


}
