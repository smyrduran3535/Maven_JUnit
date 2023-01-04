package Slayt_Questions_Odev;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilies.TestBase;

public class C13_Handle_Alert_ClassWork extends TestBase {
    @Test
    public void test01() {


        //// 1. Launch browser
        //// 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //// 3. Verify that home page is visible successfully
      WebElement page= driver.findElement(By.xpath("//*[@alt='Website for automation practice']"));
        Assert.assertTrue(page.isDisplayed());
        //// 4. Click on 'Products' button
        driver.findElement(By.xpath("//*[@href='/products']")).click();
        //// 5. Verify user is navigated to ALL PRODUCTS page successfully
       WebElement allProducts = driver.findElement(By.xpath("//*[@class='title text-center']"));
        Assert.assertTrue(allProducts.isDisplayed());
        System.out.println(driver.getCurrentUrl());
        //// 6. Enter product name in search input and click search button
       WebElement product= driver.findElement(By.id("search_product"));
               product.sendKeys("Winter Top");
               WebElement clickButton=driver.findElement(By.id("submit_search"));
              clickButton.click();
        //// 7. Verify 'SEARCHED PRODUCTS' is visible
        WebElement serached=driver.findElement(By.xpath("(//p[text()='Winter Top'])[1]"));
        Assert.assertTrue(serached.isDisplayed());
        //// 8. Verify all the products related to search are visible
        WebElement wanted2 = driver.findElement(By.xpath("(//p[text()='Winter Top'])[1]"));
        Assert.assertTrue(wanted2.isDisplayed());

    }
}
