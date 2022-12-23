package day05_Junit;

import org.junit.*;

public class C04_Ignore {

    @BeforeClass
    public static void setUp() {
        System.out.println("butun testlerdden once calıstı");
    }

    @AfterClass
    public static void tearDown() {
        System.out.println("Butun testlerden sonra calıstı");
    }

    @Before
    public void setUp01() {
        System.out.println("her testten once calısır");
    }

    @After
    public void tearDown01() {
        System.out.println("her testten once calısır");
    }

    @Test
    public void test01() {
        System.out.println("ilk test");
    }

    @Test
    public void test02() {
        System.out.println("ikinci test");

    }
    @Test
    @Ignore
    public void test03(){
        System.out.println("ıgnore var calısmaz");
    }
    /*
    KONSOL:
    butun testlerdden once calıstı
her testten once calısır
ilk test
her testten once calısır
her testten once calısır
ikinci test
her testten once calısır

Test ignored.
Butun testlerden sonra calıstı
     */
}

