package day15;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilies.TestBase;

import java.util.List;

public class homework extends TestBase {
    //https://the-internet.herokuapp.com/tables
    //Create a class: WebTables
    //Task 1 : Table1’i print edin
    //Task 2 : 3. Row’ datalarını print edin
    //Task 3 : Son row daki dataları print edin
    //Task 4 : 5. Column datalarini print edin
    //Task 5 : Iki parametreli bir Java metot oluşturalım: printData
    //Parameter 1 = row numarasi
    //Parameter 2 = column numarasi
    //printData(2,3);  => 2nd satir, 3rd sutun daki datayı print etsin


    @Test
    public void test() {
        //https://the-internet.herokuapp.com/tables
        driver.get("https://the-internet.herokuapp.com/tables");

        //Task 1 : Table1’i print edin
        String table1 = driver.findElement(By.xpath("//table[@id='table1']")).getText();
        System.out.println("table1 = " + table1);
        List<WebElement> table1ListParca = driver.findElements(By.xpath("//table[@id='table1']//td"));

        for (WebElement w : table1ListParca) {
            System.out.println("w.getText() = " + w.getText());
        }
        System.out.println(" ------ ");
        //Task 2 : 3. Row’ datalarını print edin
        List<WebElement> row3 = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[3]//td"));
        for (WebElement w : row3) {
            System.out.println("w.getText() = " + w.getText());
        }
        //Task 3 : Son row daki dataları print edin
        List<WebElement> rowSon = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[last()]//td"));
        for (WebElement w : rowSon) {
            System.out.println("w.getText() = " + w.getText());
        }

        //Task 4 : 5. Column datalarini print edin
        List<WebElement> besinciKolon = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[last()-1]//td"));
        for (WebElement w : besinciKolon) {
            System.out.println("w.getText() = " + w.getText());
        }
    }

    @Test
    public void printDataTest() {
        printData(2, 3);//dataPrint = fbach@yahoo.com
        printData(1,2);//John
    }

    //Task 5 : Iki parametreli bir Java metot oluşturalım: printData
    //Parameter 1 = row numarasi
    //Parameter 2 = column numarasi
    //printData(2,3);  => 2nd satir, 3rd sutun daki datayı print etsin


    public void printData(int rowNo, int coloumnNo) {
        String myXpath = "//table[@id='table1']//tbody//tr[" + rowNo + "]//td[" + coloumnNo + "]";
        WebElement dataPrint = driver.findElement(By.xpath(myXpath));
        System.out.println("dataPrint = " + dataPrint.getText());
    }


}