package main.ava.task4;

import main.ava.task3.chancery.BeginnerKit;

public class Main {
    public static void main(String[] args) {
        BeginnerKit kit = new BeginnerKit();

        System.out.println("--> Start set:");
        kit.getBeginnerKit().forEach(System.out::println);
        System.out.println("--> After price sort:");
        kit.getBeginnerKit().sort(new ChanceryPriceComparator());
        kit.getBeginnerKit().forEach(System.out::println);
        System.out.println("--> After title sort:");
        kit.getBeginnerKit().sort(new ChanceryTitleComparator());
        kit.getBeginnerKit().forEach(System.out::println);
        System.out.println("--> After price and title sort:");
        kit.getBeginnerKit().sort(new ChanceryPriceComparator().thenComparing(new ChanceryTitleComparator()));
        kit.getBeginnerKit().forEach(System.out::println);
    }
}
