package Selenium_Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03 {
    public static void main(String[] args) {

            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // Navigate to  https://testpages.herokuapp.com/styled/index.html
        driver.get("https://testpages.herokuapp.com/styled/index.html");
// Click on  Calculate under Micro Apps
        driver.findElement(By.id("calculatetest")).click();
//    Type any number in the first input

//    Type any number in the second input
        WebElement firdtnumber=driver.findElement(By.id("number1"));
        firdtnumber.sendKeys("30", Keys.TAB,Keys.TAB,"30",Keys.ENTER);
// Click on Calculate

// Print the result
      WebElement printResult=  driver.findElement(By.xpath("//*[@id='answer']"));
        System.out.println("result "+printResult.getText());
// close driver
        driver.close();

    }


}
