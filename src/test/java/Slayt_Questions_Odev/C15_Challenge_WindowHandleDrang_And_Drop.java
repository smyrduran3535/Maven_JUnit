package Slayt_Questions_Odev;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilies.TestBase;

public class C15_Challenge_WindowHandleDrang_And_Drop extends TestBase {
    @Test
    public void Test() {

        /*
  #go to url : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
 #Fill in capitals by country
*/
  /*
   #url'ye gidin: http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
  #Ülkeye göre başkentleri doldurun
 */

        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
       // driver.switchTo().frame(0); yok

        WebElement copenhagen= driver.findElement(By.xpath("//*[@id='box4']"));
        WebElement seoul= driver.findElement(By.xpath("//*[@id='box5']"));
        WebElement roma= driver.findElement(By.xpath("//*[@id='box6']"));
        WebElement oslo= driver.findElement(By.xpath("//*[@id='box1']"));
        WebElement stolkholm= driver.findElement(By.xpath("//*[@id='box2']"));
        WebElement washington= driver.findElement(By.xpath("//*[@id='box3']"));
        WebElement madrid= driver.findElement(By.xpath("//*[@id='box7']"));

        WebElement italy= driver.findElement(By.xpath("//*[@id='box106']"));
        WebElement spain= driver.findElement(By.xpath("//*[@id='box107']"));
        WebElement norway= driver.findElement(By.xpath("//*[@id='box101']"));
        WebElement denmark= driver.findElement(By.xpath("//*[@id='box104']"));
        WebElement southKorea= driver.findElement(By.xpath("//*[@id='box105']"));
        WebElement sweden= driver.findElement(By.xpath("//*[@id='box102']"));
        WebElement unitedState= driver.findElement(By.xpath("//*[@id='box103']"));
        Actions actions=new Actions(driver);
        actions.dragAndDrop(roma,italy).release().build().perform();
        actions.dragAndDrop(oslo,norway).release().build().perform();
        actions.dragAndDrop(seoul,southKorea).release().build().perform();
        actions.dragAndDrop(washington,unitedState).release().build().perform();
        actions.dragAndDrop(madrid,spain).release().build().perform();
        actions.dragAndDrop(copenhagen,denmark).release().build().perform();
        actions.dragAndDrop(stolkholm,sweden).release().build().perform();
/*
    @Test
    public void test01() {

//  #go to url : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
// #Fill in capitals by country
       for(int i =1 ; i<8 ; i++){
           WebElement source = driver.findElement(By.id("box"+i));
           WebElement target = driver.findElement(By.id("box"+(100+i)));
           Actions actions = new Actions(driver);
           actions.dragAndDrop(source,target).perform();
       }


 */
        //baska bir yol : lambda ile
        /*
        // #Fill in capitals by country
        Actions actions = new Actions(driver);
        List<WebElement> countries = driver.findElements(By.xpath("//*[@id='countries']/div"));
        for(int i=1; i<=countries.size(); i++){
            WebElement capital = driver.findElement(By.xpath("//*[@id='box"+i+"']"));
            switch (capital.getText()){
                case "Oslo":actions.dragAndDrop(capital,countries.stream().filter(t->t.getText().equals("Norway")).findFirst().get()).build().perform();break;
                case "Stockholm":actions.dragAndDrop(capital,countries.stream().filter(t->t.getText().equals("Sweden")).findFirst().get()).build().perform();break;
                case "Washington":actions.dragAndDrop(capital,countries.stream().filter(t->t.getText().equals("United States")).findFirst().get()).build().perform();break;
                case "Copenhagen":actions.dragAndDrop(capital,countries.stream().filter(t->t.getText().equals("Denmark")).findFirst().get()).build().perform();break;
                case "Seoul":actions.dragAndDrop(capital,countries.stream().filter(t->t.getText().equals("South Korea")).findFirst().get()).build().perform();break;
                case "Rome":actions.dragAndDrop(capital,countries.stream().filter(t->t.getText().equals("Italy")).findFirst().get()).build().perform();break;
                case "Madrid":actions.dragAndDrop(capital,countries.stream().filter(t->t.getText().equals("Spain")).findFirst().get()).build().perform();break;
            }
            Array ile ;
             WebElement cities = driver.findElement(By.id("dropContent"));
        String[] arrCity = cities.getText().split("\n");
        for (int i = 1; i <= arrCity.length; i++) {
            city = driver.findElement(By.id("box" + i));
            country = driver.findElement(By.id("box" + (100+i)));
            actions.dragAndDrop(city, country).perform();
            waitFor(3);
         */
    }
}
