package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_Dropdown {
    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }
//eger test sınıfında 1 den fazla method olusturulmussa befare kullanılır.beforeclass fail verir
// beforeClass olmaz ama tek bir test varsa before class kullanılabilir
    //cunku beforeclass bir kere calısıcak 1 den fazla test case varsa sıkıntı olur o yuzden before kull. cunku biz her bir test icin driveri
    //kullanmamız gerekiyor. test caseler passed olur boylelikle
    @Test
    public void selectByIndexTest(){

    //Dogun yilini, ayini, ve gununu su sekilde secer : 2000, January, 10

        // 1.LOCATE droptdown element

        WebElement year =driver.findElement(By.xpath("//select[@id='year']"));

        //2.SELECT objesi olustur

        Select yearDropdown=new Select(year);

        //3.Select object i kullanarak 3 farklı sekilde secim yapabilirim:selectByIndex();secenek sırası 0'dan baslar.
        // selectByValue();selectByVisibleText();
        yearDropdown.selectByIndex(22);
        //secenek sırası ; 0 dan baslar.. biz 22.ci elemanı secmek istiyorsak biz 23 yazıcaz ;2000 yılı 23.sırada

        WebElement month = driver.findElement(By.xpath("//*[@id='month']"));
        Select monthDropDown=new Select(month);
        monthDropDown.selectByValue("0");////option un value dergeri ile secim yapilabilir. January seceneginin valuesi 0

        WebElement day = driver.findElement(By.xpath("//*[@id='day']"));
        Select dayDropdown=new Select(day);
        dayDropdown.selectByVisibleText("25");//Case sensitive:gorunen metini yazarız bu metoda

    }
    @Test
    public void printAllTest(){

        //tum eyalet isimlerini print edelim
        WebElement state=driver.findElement(By.xpath("//select[@id='state']"));
        Select stateDropdown=new Select(state);
//stateDropdown.selectByVisibleText("Texas"); bizden tek bunu istemiyor butun elementleri list elemek istiyor. o yuzden List kull !!!!!!
        List<WebElement> stateList=stateDropdown.getOptions();//butun optionsları getirir getOptions
        for (WebElement eachState:stateList){
            System.out.println(eachState.getText());//gettext yazmazsak sadece eacstate yaparsak referanslarını verir
        }
        //stateList.stream().map(WebElement::getText).forEach(System.out::println); lambda ile de boyle
    }
/*
Dropdown olusturulurken hangi html(classı) kullanılır developer? SELECT CLASSINI kullanır.sadece dropdown icin select classı kullanılır
1.What is dropdown?
Dropdown liste olusturmak icin kullanılır
2.how to handle dropdown elements? Nasıl automate edilir?
Bunu soran once select classını duymayı bekler...
-Dropdown 'ı Locate ederiz
-select objesi olustururum
-select objesi ile istedigim secenegi secerim
***NOT=>select objesi olusturma nedenim; dropdownların select classı ile olusturulması****
TUM DROPDOWN ELEMENTLERİNİ NASIL PRINT EDERİZ?
select objesini kullanarak belli secimler yapabiliriz , aynı zamanda birden fazla da secenekleri bir listeye alabiliriz
 NOT: select objesi olusturma nedenim, dropdownlarin Select classi ile olusturulmasi
3. Tum dropdown seceneklerini nasil print ederiz?
    - tum dropdown elementlerini getOptions(); methodu ile listeye koyariz
    - sonra secenekleri loop ile yazdirabilirz

4.Bir Secenegin Secili oldugunu Otamate etmek icin ne yapılır?
    Ornek: Gun olarak 10 sectik ama ya secilmediyse.. bunu nasıl anlıycaz..?????
    bizim bir tane daha methodumuz var bunu anlamak icin;
    getFirstSelectedOption() secenegi ile return eder.secili olan ilk secenegi return eder
    getFirstSelectedOption(); isselected ile aynı mantık ama getFirstSelectedOption() secili olanı return eder

     */

@Test
public void getSelectedOptionsTest(){

    //state dropdown daki varsayılan secili seceneginin "select a state" oldugunu verify edelim (otomasyon ile):Text'in varlıgını gormek istiyoruz;Select a state
    WebElement state=driver.findElement(By.xpath("//select[@id='state']"));
    Select stateDropdown=new Select(state);
    //WebElement varsayilanElemet=stateDropdown.getFirstSelectedOption(); --->memory acısından en sondaki kull
    //String varsayilanElemanText= varsayilanElemet.getText(); ---->memory acısından asagıdakı
    String varsayilanText=stateDropdown.getFirstSelectedOption().getText();//gettext ile gorucez:secili olan secenegin text ini alıp "select a state" buna esit oldugunu gormek istiyoruz
    //varsayilanText olusturarak method chain yapmıs olduk 2 adımı bire indirdik memory acısından
    Assert.assertEquals("Select a State",varsayilanText);

}

    @After
    public void tearDown() throws InterruptedException {

        Thread.sleep(3000);
        driver.close();
}




}
