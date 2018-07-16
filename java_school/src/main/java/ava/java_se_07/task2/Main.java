package ava.java_se_07.task2;

import ava.java_se_05.task2.PropertyReader;

public class Main {
    public static void main(String[] args) {
        String file = "java_school/src/main/java/ava/java_se_07/task2/test.properties";
        new PropertyReader().readPropFile(file);
        new PropertyReader().readPropFile(file);
        new PropertyReader().readPropFile(file);
    }
}
