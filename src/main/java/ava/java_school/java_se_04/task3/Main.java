package ava.java_school.java_se_04.task3;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        String fileIn = "ava/java_school/java_se_04/task3/dataUtf8";
        String fileOut = "ava/java_school/java_se_04/task3/dataUtf16";
        try {
            Files.write(Paths.get(fileOut), Files.readAllLines(Paths.get(fileIn), StandardCharsets.UTF_8), StandardCharsets.UTF_16);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
