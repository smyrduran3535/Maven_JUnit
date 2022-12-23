package day05_Junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C02_BeforeAfter {
    @Before
    public void setUp(){
        System.out.println("her test metodundan once calısır");
    }
    @After
    public void tearDown(){
        System.out.println("her test metodundan sonra calısır");
    }
    @Test
    public void Test01(){//before bi kere calısacak
        System.out.println("ilk test");
    }//after bi kere calısacak
    @Test
    public void Test02(){
        System.out.println("ikinci test");
        /*
        cıktı:
her test metodundan once calısır
ilk test
her test metodundan sonra calısır
her test metodundan once calısır
ikinci test
her test metodundan sonra calısır
*****test1 ve 2 lerde after before bir daha kendini gosterdi*****
         */
    }
}
