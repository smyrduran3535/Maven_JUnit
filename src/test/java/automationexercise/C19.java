package automationexercise;

import org.junit.Test;
import utilies.TestBase;

public class C19 extends TestBase {
    @Test
    public void test() {
        driver.get("http://automationexercise.com");
        //3. Click on 'Products' button

        //4. Verify that Brands are visible on left side bar
        //5. Click on any brand name
        //6. Verify that user is navigated to brand page and brand products are displayed
        //7. On left side bar, click on any other brand link
        //8. Verify that user is navigated to that brand page and can see products
    }
}
