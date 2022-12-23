package automationexercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.time.Duration;
import java.util.List;

public class C01 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
       WebElement anaSayfa= driver.findElement(By.xpath("//*[@class='carousel-inner']"));
       if (anaSayfa.isDisplayed()){
           System.out.println("passed");
       }else System.out.println("failed");
        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[@href='/login']")).click();

        //5. Verify 'New User Signup!' is visible
WebElement newUserSignup=driver.findElement(By.xpath("//*[text()='Signup']"));
if (newUserSignup.isDisplayed()){
    System.out.println("passed");
}else System.out.println("failed");
        //6. Enter name and email address
      WebElement name=  driver.findElement(By.xpath("//*[@name='name']"));
              name.sendKeys("sumeyra", Keys.ENTER);
      WebElement email=  driver.findElement(By.xpath("(//*[@name='email'])[2]"));
              email.sendKeys("smyrduran3535@gmail.com",Keys.ENTER);

        //7. Click 'Signup' button
WebElement signup=driver.findElement(By.xpath("//*[@class='btn btn-default']"));
signup.click();
        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
     // WebElement visible= driver.findElement(By.xpath("//*[text()='Enter Account Information']"));
     //   if (visible.isDisplayed()){
     //       System.out.println("passed");
    //    }else System.out.println("failed");
//
        //9. Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.xpath("//*[@id='id_gender1']")).click();
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("12345.Sd",Keys.ENTER);


        WebElement date=driver.findElement(By.xpath("//*[text()='Date of Birth']"));
           WebElement days=driver.findElement(By.xpath("//*[@id='days']"));
                   days.sendKeys("22");
               WebElement months= driver.findElement(By.xpath("//*[@id='months']"));
               months.sendKeys("12");
               WebElement years= driver.findElement(By.xpath("//*[@id='years']"));
               years.sendKeys("2022");

        //10. Select checkbox 'Sign up for our newsletter!'
driver.findElement(By.xpath("//*[@for='newsletter']")).click();
        //11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.xpath("//*[text()='Receive special offers from our partners!']")).click();
        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        driver.findElement(By.xpath("//*[@id='first_name']")).sendKeys("sumeyra",Keys.ENTER);
        driver.findElement(By.xpath("//*[@id='last_name']")).sendKeys("dur",Keys.ENTER);
        driver.findElement(By.xpath("//*[@name='company']")).sendKeys("teachers",Keys.ENTER);
driver.findElement(By.xpath("//*[@id='address1']")).sendKeys(" ay mah. genclik sk. no:15",Keys.ENTER);
driver.findElement(By.xpath("//*[@id='country']")).sendKeys("turkey",Keys.ENTER);
driver.findElement(By.xpath("//*[@id='state']")).sendKeys("turkey",Keys.ENTER);
driver.findElement(By.xpath("//*[@id='city']")).sendKeys("manisa",Keys.ENTER);
driver.findElement(By.xpath("//*[@id='zipcode']")).sendKeys("45400",Keys.ENTER);
driver.findElement(By.xpath("//*[@id='mobile_number']")).sendKeys("05361235647 ",Keys.ENTER);



        //13. Click 'Create Account button'
        driver.findElement(By.xpath("//*[@class='btn btn-default']")).click();
        //14. Verify that 'ACCOUNT CREATED!' is visible
       WebElement account= driver.findElement(By.xpath("//*[text()='Account Created!']"));
       if (account.isDisplayed()){
           System.out.println("account = passed " );
       }else System.out.println("failed");
        //15. Click 'Continue' button
driver.findElement(By.xpath("//*[@data-qa='continue-button']")).click();

    }
}
