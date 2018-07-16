package ava.java_se_06.task2;

import ava.java_se_05.task2.PropertyReader;

public class Main {
    public static void main(String[] args) {
        PropertyReader reader = new PropertyReader();
        reader.readPropFile("java_school/src/main/java/ava/java_se_06/task2/test.properties");
        System.out.println(reader.getValue("a"));
    }
}
