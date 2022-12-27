package automationexercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_LoginUserWithIncorrectEmailPassword {
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Signup / Login' button
    //5. Verify 'Login to your account' is visible
    //6. Enter incorrect email address and password
    //7. Click 'login' button
    //8. Verify error 'Your email or password is incorrect!' is visible
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
      driver.close();
    }

    @Test
    public void test01() {
        driver.get("http://automationexercise.com");
        homePage();
        driver.findElement(By.xpath("//*[@href='/login']")).click();
    LoginToYourAccount();

        driver.findElement(By.xpath("//*[@data-qa='login-email']")).sendKeys("smyrduran35@gmail.com", Keys.ENTER);
        driver.findElement(By.xpath("//*[@data-qa='login-password']")).sendKeys("12345", Keys.ENTER);
        //7. Click 'login' button
        driver.findElement(By.xpath("//*[@data-qa='login-button']")).click();
    incorrect();
    }




    public void homePage(){
        WebElement home = driver.findElement(By.xpath("//*[@class='fa fa-home']"));
        Assert.assertTrue(home.isDisplayed());

    }
public void LoginToYourAccount(){
    WebElement yourAccount = driver.findElement(By.xpath("//*[text()='Login to your account']"));
    Assert.assertTrue(yourAccount.isDisplayed());
}
public void incorrect(){
    WebElement incorrect = driver.findElement(By.xpath("//*[text()='Your email or password is incorrect!']"));
    Assert.assertTrue(incorrect.isDisplayed());
}
}