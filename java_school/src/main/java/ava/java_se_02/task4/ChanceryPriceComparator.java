package ava.java_se_02.task4;

import ava.java_se_02.task3.chancery.Chancery;

import java.util.Comparator;

public class ChanceryPriceComparator implements Comparator<Chancery> {
    @Override
    public int compare(Chancery o1, Chancery o2) {
        return o1.getPrice() - o2.getPrice();
    }
}
