package ava.java_school.java_se_02.task3;

import ava.java_school.java_se_02.task3.chancery.BeginnerKit;

public class Main {
    public static void main(String[] args) {
        BeginnerKit kit = new BeginnerKit();
        kit.getBeginnerKit().forEach(System.out::println);
    }
}
