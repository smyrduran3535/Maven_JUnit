package day13;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import utilies.TestBase;

public class C03_NullPointExceptions extends TestBase {

        WebDriver driver;
        Faker faker;
        @Test
        public void nullPointerExceptionTest(){

            driver.get("https://www.techproeducation.com");//(C03_NullPointExceptions.java:13)

    }

    @Test
    public void nullPointerExceptionTest2() {
        //  faker=new faker();
            System.out.println(faker.name().fullName());//java.lang.NullPointerExceptions
    }
}
