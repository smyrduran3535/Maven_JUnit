package Selenium_Practice.day04;

import org.junit.Test;
import utilies.TestBase;

public class P01_BasicAut extends TestBase {
    @Test
    public void test() {
        /*
                                Basic Authentication(Temel Kimlik Doğrulama)
        Basic Authentication, HTTP protokolü üzerinden bir web sayfasına erişim için kullanılan bir
    güvenlik yöntemidir. Bu yöntem, kullanıcı adı ve parola gibi kimlik bilgilerini gönderen bir
    istemci tarafından kullanılır ve sunucu tarafından doğrulanır. Eğer kimlik bilgileri doğru ise,
    sunucu istemciye erişim izni verir. Eğer kimlik bilgileri yanlış ise, sunucu istemciye erişim izni vermez.
        Basic Authentication genellikle özel veya yönetim tarafından korunan web siteleri için kullanılır.
    Örnek olarak, şirket içi yönetim arayüzleri, veritabanı yönetim sistemleri, sanal makine yönetim arayüzleri
    gibi siteler kullanabilir.
    Bu tür sitelerde, kullanıcıların sadece yetkilendirilmiş kullanıcılar tarafından erişilebileceği
    garanti edilmek istenebilir. Ayrıca bazı bölgesel / ülke veya alan spesifik hizmetlerde kullanılmakta,
    örneğin bankaların online bankacılık hizmetleri, sağlık hizmetleri, kamu hizmetleri, e-devlet hizmetleri gibi.
     */

        //http://httpbin.org/basic-auth/foo/bar adresine gidiniz
        driver.get("http://foo:bar@httpbin.org/basic-auth/foo/bar");
        //Username  : foo
        //password  : bar
        //Yukardaki verileri kullanarak güvenliği geçin

    }
}