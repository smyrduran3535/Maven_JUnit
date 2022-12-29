package automationexercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05 {
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Signup / Login' button
    //5. Verify 'New User Signup!' is visible
    //6. Enter name and already registered email address
    //7. Click 'Signup' button
    //8. Verify error 'Email Address already exist!' is visible
    WebDriver driver;
    String result;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://automationexercise.com");
    }
    @Test
    public void test(){
        //3. Verify that home page is visible successfully

        WebElement homePage = driver.findElement(By.xpath("//*[@class='carousel-inner']"));
        result=homePage.isDisplayed()?"passed":"failed";
        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[@class='fa fa-lock']")).click();
        //5. Verify 'New User Signup!' is visible
        WebElement newUserSignup = driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
        result = newUserSignup.isDisplayed() ? "pass" : "fail";
        System.out.println("newusersignup = " + result);
        //6. Enter name and already registered email address
      driver.findElement(By.xpath("//*[@data-qa='signup-name']")).sendKeys("Sumeyra");
      driver.findElement(By.xpath("//*[@data-qa='signup-email']")).sendKeys("smyrduran3535@gmail.com");
      driver.findElement(By.xpath("//*[@data-qa='signup-button']")).click();
      WebElement already=driver.findElement(By.xpath("//*[text()='Email Address already exist!']"));
        Assert.assertTrue(already.isDisplayed());
    }

}
