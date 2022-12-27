package automationexercise;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
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
import java.util.List;

public class C04_Logout_User {
    //1. Launch browser
    WebDriver driver;
String result;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        //driver.close();
    }
    @Test
    public void test01() {
//2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
//3. Verify that home page is visible successfully
WebElement logo=driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
Assert.assertTrue(logo.isDisplayed());

//4. Click on 'Signup / Login' button
       WebElement signUpLinki= driver.findElement(By.xpath("//*[@class='fa fa-lock']"));
       signUpLinki.click();
        //5. Verify 'Login to your account' is visible
       WebElement loginYazi= driver.findElement(By.xpath("//h2[text()='Login to your account']"));
Assert.assertTrue(loginYazi.isDisplayed());
//Enter correct email address and password
        WebElement email= driver.findElement(By.xpath("//*[@data-qa='login-email']"));
email.sendKeys("smyrduran3535@gmail.com");
       WebElement passwordKutusu=driver.findElement(By.xpath("//input[@data-qa='login-password']"));
       passwordKutusu.sendKeys("1234567");

//click 'login' button
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();
        //Verify that 'Logged in as username' is visible
    WebElement loggedInYazi= driver.findElement(By.xpath("//a[text()=' Logged in as ']"));
        System.out.println(loggedInYazi.getText());
        Assert.assertTrue(loggedInYazi.isDisplayed());
//click 'Logout' button
driver.findElement(By.xpath("//a[text()=' Logout']")).click();
//10. Verify that user is navigated to login page
        String expectedUrl="http://automationexercise.com/login";
        String actualUrl=driver.getCurrentUrl();
if (expectedUrl.equals(actualUrl)){
    System.out.println(" passed");
}else{
    System.out.println("failed");
}
    }
}
