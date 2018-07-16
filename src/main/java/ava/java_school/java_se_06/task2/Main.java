package ava.java_school.java_se_06.task2;

import ava.java_school.java_se_05.task2.PropertyReader;

public class Main {
    public static void main(String[] args) {
        ava.java_school.java_se_05.task2.PropertyReader reader = new PropertyReader();
        reader.readPropFile("src/main/java/ava/java_school/java_se_06/task2/test.properties");
        System.out.println(reader.getValue("a"));
    }
}
