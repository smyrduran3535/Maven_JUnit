package automationexercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilies.TestBase;

public class C15 extends TestBase {
    @Test
    public void test() {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement page = driver.findElement(By.xpath("//body"));
        Assert.assertTrue(page.isDisplayed());
        //4. Click 'Signup / Login' button

        driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();

        //5. Fill all details in Signup and create account
        WebElement name = driver.findElement(By.name("name"));
        name.sendKeys("Sevinc333", Keys.TAB, "sevinc333techpro@gmail.com", Keys.ENTER);
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
        //6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        WebElement loggedUsername= driver.findElement(By.xpath("//*[@data-qa='account-created']//b"));
        Assert.assertTrue(loggedUsername.isDisplayed());
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
        //7. Verify ' Logged in as username' at top
        WebElement kullanici=driver.findElement(By.xpath("//*[text()=' Logged in as ']/i"));
        Assert.assertTrue(kullanici.isDisplayed());
        //8. Add products to cart
        Actions actions=new Actions(driver);
        WebElement urun=driver.findElement(By.xpath("(//*[@class='btn btn-default add-to-cart'])[1]"));

        actions.scrollToElement(urun).perform();
        actions.click(urun).perform();
        //9. Click 'Cart' button
        driver.findElement(By.xpath("//a[@href='/view_cart']//u")).click();
        //10. Verify that cart page is displayed
        WebElement cartPage = driver.findElement(By.xpath("//tbody"));
        Assert.assertTrue(cartPage.isDisplayed());
        //11. Click Proceed To Checkout
        driver.findElement(By.xpath("//a[text()='Proceed To Checkout']")).click();

        //12. Verify Address Details and Review Your Order
        WebElement adress= driver.findElement(By.xpath("(//h3)[1]"));
        Assert.assertTrue(adress.isDisplayed());
        WebElement siparis=driver.findElement(By.xpath("//h2[text()='Review Your Order']"));
        Assert.assertTrue(siparis.isDisplayed());
        //13. Enter description in comment text area and click 'Place Order'
        WebElement message=driver.findElement(By.name("message"));
        message.sendKeys("Kapıya kadar bırakınız",Keys.ENTER);
        driver.findElement(By.xpath("//a[@href='/payment']")).click();
        //14. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        //15. Click 'Pay and Confirm Order' button
        driver.findElement(By.name("name_on_card")).sendKeys("Sevin Dur",Keys.TAB,"1234567890",Keys.RIGHT,Keys.TAB,Keys.LEFT,"311",Keys.TAB,"12",Keys.TAB,"2020",Keys.ENTER);
        //16. Verify success message 'Your order has been placed successfully!'
        WebElement messageDisplay=driver.findElement(By.xpath("//*[text()='Congratulations! Your order has been confirmed!']"));
        Assert.assertTrue(messageDisplay.isDisplayed());
        //17. Click 'Delete Account' button
        WebElement delete=driver.findElement(By.xpath("//a[normalize-space()='Delete Account']"));
        delete.click();
        //18. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
    }
}
