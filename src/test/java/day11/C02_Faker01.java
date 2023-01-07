package day11;

import com.github.javafaker.Faker;
import org.junit.Test;
import utilies.TestBase;

public class C02_Faker01 extends TestBase {
    //fake data=mock data =gercek olmayantest icin kullanılan data
    //

    @Test
    public void javaFakerTest() {
        //her calıstırmada isimler degisiyor
        //1.adım : faker objesi ile fake data olustur
        Faker faker=new Faker();
        //2.Faker objesi ile fake data olustur
        String fName=faker.name().firstName();//string data eder
        System.out.println("fName = " + fName);
        //lastName datasi
        String lName= faker.name().lastName();
        System.out.println("lName = " + lName);
        //kullanıcı adı
        System.out.println("username " + faker.name().username());
//date
        System.out.println("date() = " + faker.date().birthday());
        //meslek ismi
        System.out.println("title = " + faker.name().title());
        //sehir
        System.out.println("city = " + faker.address().city());
        //eyalet
        System.out.println("state= " + faker.address().state());
        //full adress
        System.out.println("fullAddress = " + faker.address().fullAddress());
        //cep tel no:
        System.out.println("cellPhone= " + faker.phoneNumber().cellPhone());
        //email
        System.out.println("emailAddress = " + faker.internet().emailAddress());
        //zipcode
        System.out.println("zipCode = " + faker.address().zipCode());
        //rastgele 10 haneli numara diyelim
        System.out.println("digits(10) = " + faker.number().digits(10));
        System.out.println("howIMetYourMother().character() = " + faker.howIMetYourMother().character());
        System.out.println("hitchhikersGuideToTheGalaxy().planet = " + faker.hitchhikersGuideToTheGalaxy().planet());


        /*
    İNTEVİEW SORULARI:
           TEST DATA : kullanicai adi, sifre, tel no, email, sehir, kredi kart no,...
       Test datalarini kimden alinir?
       1. BA-Business analyst (Acceptance Criteria lari yazar)
       2. Test Lead
       3. Manual Tester
       4. Tech Lead & Team Lead & Dev Lead
       5. Developer
       6. Database
       7. API call lar
       8. Documantasyonlar. Ognegin, API swagger documani.
       9. Java Faker da fake data almak icin kullanyoruz
       NERDEN GELMEZ : end user -kullanicidan, scrum master,
        */

    }
}
