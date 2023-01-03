package automationexercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C06 {
    WebDriver driver;
    String result;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void test(){
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement image = driver.findElement(By.xpath("//img[@alt='Website for automation practice']"));
        result = image.isDisplayed() ? "Pass" : "Fail";
        System.out.println("homePage " + result);
        //4. Click on 'Contact Us' button
        driver.findElement(By.xpath("//*[@class='fa fa-envelope']")).click();
        //5. Verify 'GET IN TOUCH' is visible
       WebElement getTouch= driver.findElement(By.xpath("(//*[@class='title text-center'])[1]"));
        result=getTouch.isDisplayed()?"passed":"failed";
        System.out.println("getTouch = " + result);
        //6. Enter name, email, subject and message
        driver.findElement(By.xpath("//*[@data-qa='name']")).sendKeys("Sumeyra");
        driver.findElement(By.xpath("//*[@data-qa='email']")).sendKeys("smyrduran3535@gmail.com");
        driver.findElement(By.xpath("//*[@data-qa='subject']")).sendKeys("shoppinp");
        driver.findElement(By.xpath("//*[@data-qa='message']")).sendKeys("This app is great for the shoppinp.");

        //7. Upload file
        WebElement file = driver.findElement(By.xpath("//*[@name='upload_file']"));
        file.sendKeys("C:\\Users\\Desktop\\TestBase06_Text.txt");
     // WebElement upload=  driver.findElement(By.xpath("input[type='file']"));

        //8. Click 'Submit' button
        //9. Click OK button
        //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        //11. Click 'Home' button and verify that landed to home page successfully
    }
}
