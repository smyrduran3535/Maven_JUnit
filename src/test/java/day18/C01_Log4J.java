package day18;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class C01_Log4J {
    //3. Logger object olustur:
//    private static Logger logger = LogManager.getLogger(Demo1.class.getName());
//4. Logger fonksiyonuyla istenilen fonksiyonu kullan
//                 logger.debug("Debug logger");
//        logger.info("Info logger");
//        logger.error("Error logger");
//        logger.fatal("Fatal logger");
private static Logger logger = LogManager.getLogger(C01_Log4J.class.getName());//bu sınıfta kullanılacak diye parantez icine okuyacagı yeri yazdık
    @Test
    public void log4LTest() {
//logger objesi ile yazdırma islemi yapılır
        logger.fatal("Fatal Log!");
        logger.error("Error Log!");
        logger.warn("Warn Log!");
        logger.debug("Debug Log!");
        logger.info("Info Log!");
       // amacımız System.out.println(); ne uygun yapı olusturmak

    }
}
