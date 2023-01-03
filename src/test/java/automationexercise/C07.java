package automationexercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilies.TestBase;

public class C07 extends TestBase {

    // Test Case 7: Verify Test Cases Page
    // 1. Launch browser
    @Test
    public void test01() {
        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        // 3. Verify that home page is visible successfully
        String actualTitle = driver.getTitle();
        String expectedTitle = "Automation Exercise";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        // 4. Click on 'Test Cases' button
        driver.findElement(By.xpath("//*[text()=' Test Cases']")).click();
        // 5. Verify user is navigated to test cases page successfully
        String actualTitle2 = driver.getTitle();
        String expectedTitle2 = "Automation Practice Website for UI Testing - Test Cases";
        Assert.assertEquals(expectedTitle2, actualTitle2);

    }
}