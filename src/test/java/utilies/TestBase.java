package utilies;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class TestBase {
    //testbase sınıfı before ve after methodlarını koymak icin kullaniriz
    //@Before,@After :destek methoddur. test method olması icin;@Test olması lazım
    //test base testlerden once ve sonra kullanılır.
    //bunu kullanmak icin inheritance kullancaz ve before ve after methodlarını tekrar tekrar kullanmıycaz
    //test base kullanmanın tek amacı frameworku daha kullanıslı hale getirmek teKRar yapmamak
    //abstract kullancaz: abstract yaparsak child claslar methodlari overload eder.bu sınıfın objesini olusturmak istemiyorum
    //yani TestBase testbase=new TestBase :bunu istemiyorum... Y A P I L A M A Z
    // amacım :bu sinifi extend etmek icindeki hazır methodları kullanmak

    //driver objesi olustur:driver ya public yada protected olmalı. child classlarda gorulebilmeli
    protected static WebDriver driver;

    //setUp olust
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
       // WebDriverManager.chromedriver().create();==>
        // WebDriverManager.chromedriver().setup(); ve  driver = new ChromeDriver(); ikisi kaldırıp yukardakı kullanılır
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    //tearDown
    @After
    public void tearDown() {
        waitFor(5);
        //driver.quit();
    }

    //    MULTIPLE WINDOW:
//    1 parametre alir : Gecis Yapmak Istedigim sayfanin Title
//    ORNEK:
//    driver.get("https://the-internet.herokuapp.com/windows");
//    switchToWindow("New Window");
//    switchToWindow("The Internet")

    public static void switchToWindow(String targetTitle) {
            String origin = driver.getWindowHandle();
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
                if (driver.getTitle().equals(targetTitle)) {
                    return;//loop un dısına cık
                }
            }
            driver.switchTo().window(origin);
        }
    //windowNumber sıfır (0)'dan başlıyor.
    public static void switchToWindow(int windowNumber){//index numarsaını parametre olarak alır
        // ve o indexli pencereye gecis yapar
        List<String> list = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(list.get(windowNumber));
    }

    /*   HARD WAIT:
    @param : second
*/
    public static void waitFor(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //    ACTIONS_RIGHT CLICK
    public static void rightClickOnElementActions(WebElement element) {
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
    }
    //ACTIONS_DOUBLE CLICK
    public static void doubleClick(WebElement element) {
        new Actions(driver).doubleClick(element).build().perform();
    }
    //    ACTIONS_HOVER_OVER
    public static void hoverOverOnElementActions(WebElement element) {
//        Actions actions = new Actions(driver);
        new Actions(driver).moveToElement(element).perform();
    }
    //    ACTIONS_SCROLL_DOWN
    public static void scrollDownActions() {
//        Actions actions = new Actions(driver);
        new Actions(driver).sendKeys(Keys.PAGE_DOWN).perform();
    }
    //    ACTIONS_SCROLL_UP
    public static void scrollUpActions() {
//        Actions actions = new Actions(driver);
        new Actions(driver).sendKeys(Keys.PAGE_UP).perform();
    }
    //    ACTIONS_SCROLL_RIGHT
    public static void scrollRightActions(){
        new Actions(driver).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_RIGHT).perform();
    }
    //    ACTIONS_SCROLL_LEFT
    public static void scrollLeftActions(){
        new Actions(driver).sendKeys(Keys.ARROW_LEFT).sendKeys(Keys.ARROW_LEFT).perform();
    }
    //    ACTIONS_DRAG_AND_DROP
    public static void dragAndDropActions(WebElement source, WebElement target) {
//        Actions actions = new Actions(driver);
        new Actions(driver).dragAndDrop(source,target).perform();
    }
    //    ACTIONS_DRAG_AND_DROP_BY
    public static void dragAndDropActions(WebElement source, int x, int y) {
//        Actions actions = new Actions(driver);
        new Actions(driver).dragAndDropBy(source,x,y).perform();
    }
    //    DYNAMIC SELENIUM WAITS:
//===============Explicit Wait==============//
    public static WebElement waitForVisibility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static WebElement waitForClickablility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    //cok kullanılmaz
    public static void clickWithTimeOut(WebElement element, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.click();
                return;
            } catch (WebDriverException e) {
                waitFor(1);
            }
        }
    }

    //    This can be used when a new page opens// yeni sayfaya gecislerde kullanılabilir
    public static void waitForPageToLoad(long timeout) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            System.out.println("Waiting for page to load...");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            wait.until(expectation);
        } catch (Throwable error) {
            System.out.println(
                    "Timeout waiting for Page Load Request to complete after " + timeout + " seconds");
        }
    }
    //======Fluent Wait====
    // params : xpath of teh element , max timeout in seconds, polling in second
    public static WebElement fluentWait(String xpath, int withTimeout, int pollingEvery) {
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(withTimeout))//Wait 3 second each time
                .pollingEvery(Duration.ofSeconds(pollingEvery))//Check for the element every 1 second
                .withMessage("Ignoring No Such Element Exception")
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return element;

    }

}

