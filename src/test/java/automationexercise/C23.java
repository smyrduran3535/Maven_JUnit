package automationexercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilies.TestBase;

public class C23 extends TestBase {
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
        name.sendKeys("Sevinc333333", Keys.TAB, "sevinc333333techpro@gmail.com", Keys.ENTER);
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
        //12. Verify that the delivery address is same address filled at the time registration of account
      String  adress= driver.findElement(By.xpath("(//h3)[1]")).getText();
        String siparis=driver.findElement(By.xpath("//h2[text()='Review Your Order']")).getText();
        String adrresFilled="new street 103. road\n" +
            "Houston Texas 41400\n" +
            "Canada";
Assert.assertTrue(adress.contains(adrresFilled));

//13. Verify that the billing address is same address filled at the time registration of account
        Assert.assertTrue(siparis.contains(adrresFilled));
        //14. Click 'Delete Account' button
        actions.sendKeys(Keys.PAGE_UP).perform();
        driver.findElement(By.xpath("//a[normalize-space()='Delete Account']")).click();

        //15. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
    }
}
