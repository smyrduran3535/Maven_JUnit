package day09;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilies.TestBase;

import java.util.Set;

public class C04_Cookies extends TestBase {
    @Test
    public void handleCookiesTest() {
        waitFor(2);//sure koymakta fayda var cookielerde
        //        Amazona git
        driver.get("https://amazon.com");
        //        1.toplam cookie sayisini bul
    Set<Cookie> cookies= driver.manage().getCookies();
    int allCookies=cookies.size();
        System.out.println(" sayfada " + allCookies+" tane allCookie var ");
        
        //3. Bir Cookie yi ismiyle bul
        int counter=1;
       for (Cookie w:cookies){
           System.out.println(counter+" . cookies'ın adı =" + w.getName());//tamamını ismiyle cagırdık,key value degerleriyle
           System.out.println("w = " + w);//tamamını cagırdık
           counter++;
       }
       //cookies.stream().forEach(t->switchToWindow(t.getName())); lambda ile de boyle yazdırabiliriz
        System.out.println("cookie yi ismiyle cagırıyorum = " + driver.manage().getCookieNamed("session-id"));

        //4. Yeni bir cookie ekle
             //==>cookie eklemeden once Cookie objesi olusturmalıyız cunku addcookie derlen objeyi yazıcaz icine
        Cookie myFavariCookie=new Cookie("cikolatam","antep-fistikli-cikolata");
        driver.manage().addCookie(myFavariCookie);
        System.out.println("driver.manage().getCookies().size() = " + driver.manage().getCookies().size());
        //5. Bir Cookie yi ismiyle sil
        driver.manage().deleteCookie(myFavariCookie);
        //6. Tum cookie leri sil
        driver.manage().deleteAllCookies();
        System.out.println("tum cookileri sildim yeni cookie sayısı = " + driver.manage().getCookies().size());
     //gecici olarak siliyoruz o sayfada calısırken; tekrardan sayfayı calıstırırsak cookieler sıfırdan baslar.
    }
}
