package automationexercise;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
public class C01_Y {
    public static void main(String[] args) {


        String result;

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        // 3. Verify that home page is visible successfully
        WebElement image = driver.findElement(By.xpath("//img[@alt='Website for automation practice']"));
        result = image.isDisplayed() ? "Pass" : "Fail";
        System.out.println("image " + result);
        // 4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[@class='fa fa-lock']")).click();
        // 5. Verify 'New User Signup!' is visible
        WebElement yazi = driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
        result = yazi.isDisplayed() ? "Pass" : "Fail";
        System.out.println("New User Signup! is visible " + result);
        // 6. Enter name and email address
        driver.findElement(By.xpath("//*[@data-qa='signup-name']")).sendKeys("Sumeyra");
        driver.findElement(By.xpath("//*[@data-qa='signup-email']")).sendKeys("smyrduran3535@gmail.com");
        // 7. Click 'Signup' button
        driver.findElement(By.xpath("//*[@data-qa='signup-button']")).click();
        // 8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement header = driver.findElement(By.xpath("//*[.='Enter Account Information']"));
       Assert.assertTrue(header.isDisplayed());
        // 9. Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.xpath("//*[@id='id_gender1']")).click();
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("1234567");
        WebElement day = driver.findElement(By.xpath("//select[@id='days']"));
        Select selectDay = new Select(day);
        selectDay.selectByValue("14");
        WebElement month = driver.findElement(By.xpath("//select[@id='months']"));
        Select selectMonth = new Select(month);
        selectMonth.selectByValue("4");
        WebElement year = driver.findElement(By.xpath("//select[@id='years']"));
        Select selectYear = new Select(year);
        selectYear.selectByValue("1990");
        // 10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.xpath("//*[.='Sign up for our newsletter!']")).click();
        // 11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.xpath("//*[.='Receive special offers from our partners!']")).click();
        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        driver.findElement(By.xpath("//*[@data-qa='first_name']")).sendKeys("Sumeyra");
        driver.findElement(By.xpath("//*[@data-qa='last_name']")).sendKeys("Dur");
        driver.findElement(By.xpath("//*[@data-qa='company']")).sendKeys("TechPro");
        driver.findElement(By.xpath("//*[@data-qa='address']")).sendKeys("Yeni mahalle Mah");
        driver.findElement(By.xpath("//*[@data-qa='address2']")).sendKeys("105.Sokak");
        WebElement country = driver.findElement(By.xpath("//select[@id='country']"));
        Select selectCountry = new Select(country);
        selectCountry.selectByVisibleText("Canada");

        driver.findElement(By.xpath("//*[@data-qa='state']")).sendKeys("Texas");
        driver.findElement(By.xpath("//*[@data-qa='city']")).sendKeys("Houston");
        driver.findElement(By.xpath("//*[@data-qa='zipcode']")).sendKeys("77001");
        driver.findElement(By.xpath("//*[@data-qa='mobile_number']")).sendKeys("105.Sokak");
        // 13. Click 'Create Account button'
        driver.findElement(By.xpath("//*[@data-qa='create-account']")).click();
        // 14. Verify that 'ACCOUNT CREATED!' is visible
        WebElement header2 = driver.findElement(By.xpath("//*[.='Account Created!']"));
        result = header2.isDisplayed() ? "Pass" : "Fail";
        System.out.println("ACCOUNT CREATED! is visible " + result);
        // 15. Click 'Continue' button
        driver.findElement(By.xpath("//*[@data-qa='continue-button']")).click();

        // 16. Verify that 'Logged in as username' is visible
        WebElement logged = driver.findElement(By.xpath("//*[@class='fa fa-user']"));
        Assert.assertTrue(logged.isDisplayed());
       // result = logged.isDisplayed() ? "Pass" : "Fail";
       // System.out.println("Logged in as username is visible " + result);

        // 17. Click 'Delete Account' button
       // driver.findElement(By.cssSelector("a[href='/delete_account']")).click();

        // 18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
       // WebElement header3 = driver.findElement(By.xpath("(//*[.='Account Deleted!'])[1]"));
       // result = header3.isDisplayed() ? "Pass" : "Fail";
        //System.out.println("ACCOUNT DELETED! is visible " + result);
 
        //driver.close();

    }
}