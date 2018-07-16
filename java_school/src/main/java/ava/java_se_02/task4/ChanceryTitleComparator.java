package ava.java_se_02.task4;

import ava.java_se_02.task3.chancery.Chancery;

import java.util.Comparator;

public class ChanceryTitleComparator implements Comparator<Chancery> {
    @Override
    public int compare(Chancery o1, Chancery o2) {
        return o1.getTitle().compareTo(o2.getTitle());
    }
}
