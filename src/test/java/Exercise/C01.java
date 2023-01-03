package Exercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilies.TestBase;

public class C01 extends TestBase {
    @Test
    public void test(){
driver.get("https://demoqa.com/checkbox");
//checkbox
       WebElement homeCheckBox= driver.findElement(By.xpath("//*[@class='rct-checkbox']"));
     if (!homeCheckBox.isSelected()){
         homeCheckBox.click();
     }
        Assert.assertTrue(homeCheckBox.isDisplayed());
    }
}
