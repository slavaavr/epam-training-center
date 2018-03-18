package main.ava.task3;

import main.ava.task3.chancery.BeginnerKit;

public class Main {
    public static void main(String[] args) {
        BeginnerKit kit = new BeginnerKit();
        kit.getBeginnerKit().forEach(System.out::println);
    }
}
