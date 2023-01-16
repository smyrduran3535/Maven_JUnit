package automationtesting.homepage;

import org.junit.Test;
import org.openqa.selenium.By;
import utilies.TestBase;

public class C01 extends TestBase {
    @Test
    public void test() {
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        driver.get("http://practice.automationtesting.in/");
        //3) Click on Shop Menu
        driver.findElement(By.xpath("//li[@id='menu-item-40']//a")).click();
        //4) Now click on Home menu button
        driver.findElement(By.xpath("(//a[@href='https://practice.automationtesting.in'])[2]")).click();
        //5) Test whether the Home page has Three Sliders only

        //6) The Home page must contains only three sliders

    }
}
