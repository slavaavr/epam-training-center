package ava.task2;

public class Main {
    public static void main(String[] args) {
        String file = "java-se-05/src/main/java/ava/task2/test.properties";
        PropertyReader reader = new PropertyReader();
        reader.readPropFile(file);
        reader.getKeys().forEach(System.out::println);
        System.out.println(reader.getValue("a"));
    }
}
