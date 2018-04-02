package ava.task3;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        String fileIn = "java-se-04/src/main/java/ava/task3/dataUtf8";
        String fileOut = "java-se-04/src/main/java/ava/task3/dataUtf16";
        try {
            Files.write(Paths.get(fileOut), Files.readAllLines(Paths.get(fileIn), StandardCharsets.UTF_8), StandardCharsets.UTF_16);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
