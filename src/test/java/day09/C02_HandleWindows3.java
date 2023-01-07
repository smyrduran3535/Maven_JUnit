package day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilies.TestBase;

public class C02_HandleWindows3 extends TestBase {
    @Test
    public void newWindowHandletest() {
        // 1. TechPro education sayfasinin titlenin "TechPro education" metnini icerdigini icerdigini test edin
        driver.get("https://www.techproeducation.com");
        String techProHandle = driver.getWindowHandle();
        System.out.println("techProHandle = " + techProHandle);
        Assert.assertTrue(driver.getTitle().contains("Techpro Education"));

//        2. Yeni bir pencerede Amazon sayfasini acip titleinin "Amazon" metnini icerdigini test edin
        waitFor(3);
        driver.switchTo().newWindow(WindowType.WINDOW);//1. yeni pencere olusturu2. 2. Oraya gecis yapar
        driver.get("https://www.amazon.com");
        Assert.assertTrue(driver.getTitle().contains("Amazon"));

//        3. Yeni bir pencerede linkedin sayfasini acip titleinin "LinkedIn" metnini icerdigini test edin
        waitFor(3);
        driver.switchTo().newWindow(WindowType.WINDOW);//1. yeni pencere olusturu2. 2. Oraya gecis yapar
        //selenium 3 da yukarıdaki method yoktu
        driver.get("https://www.linkedin.com");
        Assert.assertTrue(driver.getTitle().contains("LinkedIn"));
        waitFor(3);
        //driver nerede? LİNKİDİNDE
        //TechPro education sayfasına gitmek icin; driver.switchTo().window(techProHandle);
        driver.switchTo().window(techProHandle);//olan yani onceden acılan pencereye gitmek icin; new windos KULLANILMAZ. SAYFANIN ADI YAZILIR
        waitFor(3);
        //driver techproda :
        Assert.assertTrue(driver.getTitle().contains("Techpro Education"));
        waitFor(3);
    }
    }

