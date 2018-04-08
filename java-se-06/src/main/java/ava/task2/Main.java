package ava.task2;

public class Main {
    public static void main(String[] args) {
        PropertyReader reader = new PropertyReader();
        reader.readPropFile("ava/task2/test");
        System.out.println(reader.getValue("a"));
    }
}
