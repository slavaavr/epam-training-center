package ava.java_se_03.task1;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        CrazyLogger log = new CrazyLogger();
        log.info("John has sold bike");
        log.info("Mary bought the bike");
        log.info("John Doe found his keys");
        System.out.println(log.printLog());
        System.out.println("_____________");
        System.out.println(log.findByString("John"));
        System.out.println("_____________");
        System.out.println(log.findByString("bike"));
        System.out.println("_____________");
        System.out.println(log.findByDate(LocalDate.of(2018, 4, 1)));
    }
}
