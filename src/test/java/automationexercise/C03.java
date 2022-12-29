package automationexercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03 {
    static WebDriver driver;
    @BeforeClass
    public static void beforeClass() throws Exception {// 1. Launch browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Before
    public void setUp() throws Exception {// 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
    }
    @Test
    public void test01() {
        // 3. Verify that home page is visible successfully
        String expectedTitle = "Automation Exercise";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }
    @Test
    public void test02() {
        // 4. Click on 'Signup / Login' button
        driver.findElement(By.cssSelector("a[href='/login']")).click();
        // 5. Verify 'Login to your account' is visible
        WebElement text = driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        Assert.assertTrue(text.isDisplayed());
    }
    String email = "smyrduran35@gmail.com";
    String password = "1234567";
    @Test
    public void test03() {
        test02();
        // 6. Enter incorrect email address and password
        driver.findElement(By.xpath("(//input[@type='email'])[1]")).sendKeys(email);
        driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys(password);
        // 7. Click 'login' button
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
        // 8. Verify error 'Your email or password is incorrect!' is visible
        WebElement hidden = driver.findElement(By.xpath("//*[text()='Your email or password is incorrect!']"));
        Assert.assertTrue(hidden.isDisplayed());
    }
    @AfterClass
    public static void afterClass() throws Exception {
        driver.close();
    }

}

