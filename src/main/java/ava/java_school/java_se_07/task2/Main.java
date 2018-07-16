package ava.java_school.java_se_07.task2;

import ava.java_school.java_se_05.task2.PropertyReader;

public class Main {
    public static void main(String[] args) {
        String file = "src/main/java/ava/java_school/java_se_07/task2/test.properties";
        new ava.java_school.java_se_05.task2.PropertyReader().readPropFile(file);
        new ava.java_school.java_se_05.task2.PropertyReader().readPropFile(file);
        new PropertyReader().readPropFile(file);
    }
}
