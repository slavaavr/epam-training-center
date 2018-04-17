package ava.task2;

public class Main {
    public static void main(String[] args) {
        String file = "java-se-07/src/main/java/ava/task2/test.properties";
        new PropertyReader().readPropFile(file);
        new PropertyReader().readPropFile(file);
        new PropertyReader().readPropFile(file);
    }
}
