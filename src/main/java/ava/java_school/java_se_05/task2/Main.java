package ava.java_school.java_se_05.task2;

public class Main {
    public static void main(String[] args) {
        String file = "ava/java_school/java_se_05/task2/test.properties";
        PropertyReader reader = new PropertyReader();
        reader.readPropFile(file);
        reader.getKeys().forEach(System.out::println);
        System.out.println(reader.getValue("a"));
    }
}
