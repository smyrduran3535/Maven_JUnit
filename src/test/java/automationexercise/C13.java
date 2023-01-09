package automationexercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilies.TestBase;

public class C13 extends TestBase {
//automationexercise =Test Case 13: Verify Product quantity in Cart

    @Test
    public void VerifyProductQuantityInCart () {

        //2. Navigate to url 'http://automationexercise.com'
driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']")).isDisplayed());;
        //4. Click 'View Product' for any product on home page

        //5. Verify product detail is opened
        //6. Increase quantity to 4
        //7. Click 'Add to cart' button
        //8. Click 'View Cart' button
        //9. Verify that product is displayed in cart page with exact quantity
    }


}
