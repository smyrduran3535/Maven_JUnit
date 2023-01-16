package automationexercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilies.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C24 extends TestBase {
    @Test
    public void test() throws IOException {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement page = driver.findElement(By.xpath("//body"));
        Assert.assertTrue(page.isDisplayed());
        //4. Add products to cart
        driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])[1]")).click();
        //5. Click 'Cart' button
        driver.findElement(By.xpath("(//a[@href='/view_cart'])[2]")).click();
        //6. Verify that cart page is displayed
        Assert.assertTrue(driver.findElement(By.xpath("//body")).isDisplayed());
        //7. Click Proceed To Checkout
        driver.findElement(By.xpath("//a[text()='Proceed To Checkout']")).click();
        //8. Click 'Register / Login' button
driver.findElement(By.xpath("//a[@href='/login']//u")).click();
        //9. Fill all details in Signup and create account
        Actions actions=new Actions(driver);
        scrollDownActions();
        WebElement signup_login=driver.findElement(By.xpath("//div[@class='signup-form']"));
        actions.moveToElement(signup_login).perform();
        WebElement name = driver.findElement(By.name("name"));
        name.sendKeys("Sevinc47", Keys.TAB, "sevinc34techpro@gmail.com", Keys.ENTER);
        WebElement radioButton = driver.findElement(By.id("id_gender1"));
        radioButton.sendKeys(Keys.SPACE,Keys.TAB,Keys.TAB,"12345",Keys.TAB,Keys.LEFT_CONTROL,Keys.SPACE,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ENTER);
        WebElement months=driver.findElement(By.id("months"));
        Select select=new Select(months);
        select.selectByVisibleText("April");
        WebElement year=driver.findElement(By.id("years"));
        Select select1=new Select(year);
        select1.selectByVisibleText("1999");
        WebElement checbox= driver.findElement(By.id("newsletter"));
        checbox.click();
        checbox.sendKeys(Keys.TAB,Keys.ENTER);
        driver.findElement(By.id("optin")).click();
        WebElement first_name= driver.findElement(By.id("first_name"));
        first_name.sendKeys("sevin",Keys.TAB,"Dur",Keys.TAB,"Soft",Keys.TAB,"new street 103. road",Keys.TAB,
                Keys.TAB,Keys.LEFT_CONTROL,Keys.SPACE,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.SPACE,Keys.CONTROL,Keys.TAB,Keys.TAB,
                "Texas",Keys.TAB,"Houston",Keys.TAB,"41400",Keys.TAB,"12345678925",Keys.ENTER);
        //10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        WebElement loggedUsername= driver.findElement(By.xpath("//*[@data-qa='account-created']//b"));
        Assert.assertTrue(loggedUsername.isDisplayed());
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();

        //11. Verify ' Logged in as username' at top
        Assert.assertTrue(driver.findElement(By.xpath("//i[@class='fa fa-user']")).isDisplayed());
        //12.Click 'Cart' button
        driver.findElement(By.xpath("(//a[@href='/view_cart'])[1]")).click();
        //13. Click 'Proceed To Checkout' button
        driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();
        //14. Verify Address Details and Review Your Order
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='checkout-information']")).isDisplayed());
        //15. Enter description in comment text area and click 'Place Order'
        driver.findElement(By.xpath("//textarea[@class='form-control']")).sendKeys("alısveris yapıyorum",Keys.ENTER);
        driver.findElement(By.xpath("//a[@href='/payment']")).click();
        //16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        //17. Click 'Pay and Confirm Order' button
        driver.findElement(By.name("name_on_card")).
                sendKeys("Sevin Dur",Keys.TAB,"1234567890",Keys.RIGHT,Keys.TAB,Keys.LEFT,"311",Keys.TAB,"12",Keys.TAB,"2020",Keys.ENTER);
        //18. Verify success message 'Your order has been placed successfully!'
        WebElement messageDisplay=driver.findElement(By.xpath("//*[text()='Congratulations! Your order has been confirmed!']"));
        Assert.assertTrue(messageDisplay.isDisplayed());
        //19. Click 'Download Invoice' button and verify invoice is downloaded successfully.
driver.findElement(By.xpath("//a[@href='/download_invoice/500']")).click();
waitFor(5);

        driver.findElement(By.partialLinkText("invoice.txt")).click();
        String filePath = System.getProperty("user.home")+"/invoice.txt";
        boolean indirildimi = Files.exists(Paths.get(filePath));
        Assert.assertTrue(indirildimi);


        //20. Click 'Continue' button
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
        //21. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[normalize-space()='Delete Account']")).click();
        //22. Verify 'ACCOUNT DELETED!' and click 'Continue' button
    }
}
