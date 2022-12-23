package automationexercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement anaSayfa = driver.findElement(By.xpath("//*[@class='carousel-inner']"));
        if (anaSayfa.isDisplayed()) {
            System.out.println("passed");
        } else System.out.println("failed");
        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[@href='/login']")).click();
        //5. Verify 'Login to your account' is visible
        WebElement login = driver.findElement(By.xpath("//*[text()='Login to your account']"));
        if (login.isDisplayed()) {
            System.out.println("passed login");
        } else System.out.println("failed");
        //6. Enter correct email address and password
        WebElement email = driver.findElement(By.xpath("(//*[@name='email'])[1]"));
        email.sendKeys("smyrduran3535@gmail.com", Keys.ENTER);
        driver.findElement(By.xpath("//*[@data-qa='login-password']")).sendKeys("12345.Sd", Keys.ENTER);
        //7. Click 'login' button

        //8. Verify that 'Logged in as username' is visible
        WebElement username = driver.findElement(By.xpath("//*[text()='sumeyra']"));
        if(username.isDisplayed()) {
            // System.out.println("username pass");
        } else System.out.println("fail");
        //9. Click 'Delete Account' button
        driver.findElement(By.xpath("//*[@href='/delete_account']")).click();
        //10. Verify that 'ACCOUNT DELETED!' is visible
        WebElement delete = driver.findElement(By.xpath("//*[text()='Account Deleted!']"));
        if (delete.isDisplayed()) {
            System.out.println("delete pass");
        } else System.out.println("fail");
    }
}
