package automationexercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilies.TestBase;

public class C18 extends TestBase {
    @Test
    public void test() throws InterruptedException {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that categories are visible on left side bar

        WebElement category= driver.findElement(By.xpath("//h2[normalize-space()='Category']"));
        Assert.assertTrue(category.isDisplayed());

        //4. Click on 'Women' category

        driver.findElement(By.xpath("//a[normalize-space()='Women']")).click();

        Thread.sleep(2);
        //5. Click on any category link under 'Women' category, for example: Dress

        driver.findElement(By.xpath("//div[@id='Women']//a[contains(text(),'Dress')]"));
        Thread.sleep(2);

        //6. Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
        WebElement verifyWd = driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(verifyWd.isDisplayed());
        //7. On left side bar, click on any sub-category link of 'Men' category
        driver.findElement(By.xpath("//a[normalize-space()='Men']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Tshirts']")).click();
        //8. Verify that user is navigated to that category page
        WebElement navigatedPage=driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(navigatedPage.isDisplayed());
    }
}
