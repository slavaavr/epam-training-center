package ava.task1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsoleFileManager fileManager = new ConsoleFileManager();
        String userInput;
        Matcher matcher;
        System.out.println("type 'help' - to get help info");

        while (true) {
            System.out.print(fileManager.getCurrentPath().concat(" > "));
            userInput = scanner.nextLine();
            userInput = userInput.trim();
            try {
                if (Pattern.compile("exit", Pattern.CASE_INSENSITIVE).matcher(userInput).matches()) {
                    break;
                } else if (Pattern.compile("ls", Pattern.CASE_INSENSITIVE).matcher(userInput).matches()) {
                    System.out.println(fileManager.getListOfFiles());
                } else if (Pattern.compile("help", Pattern.CASE_INSENSITIVE).matcher(userInput).matches()) {
                    System.out.println(fileManager.getHelp());
                } else if (Pattern.compile("cd\\s+..", Pattern.CASE_INSENSITIVE).matcher(userInput).matches()) {
                    fileManager.climbToFolderAbove();
                } else if ((matcher = Pattern.compile("cd\\s+([^\\s]+)", Pattern.CASE_INSENSITIVE).matcher(userInput)).matches()) {
                    fileManager.goToFolder(matcher.group(1));
                } else if ((matcher = Pattern.compile("print\\s+(.+)", Pattern.CASE_INSENSITIVE).matcher(userInput)).matches()) {
                    fileManager.printFile(matcher.group(1));
                } else if ((matcher = Pattern.compile("touch\\s+([^\\s]+)", Pattern.CASE_INSENSITIVE).matcher(userInput)).matches()) {
                    fileManager.createFile(matcher.group(1));
                } else if ((matcher = Pattern.compile("rm\\s+([^\\s]+)", Pattern.CASE_INSENSITIVE).matcher(userInput)).matches()) {
                    fileManager.removeFile(matcher.group(1));
                } else if ((matcher = Pattern.compile("([^\\s]+)\\s+--append\\s+\'(.*)\'", Pattern.CASE_INSENSITIVE).matcher(userInput)).matches()) {
                    fileManager.writeToFile(matcher.group(1), matcher.group(2), true);
                } else if ((matcher = Pattern.compile("([^\\s]+)\\s+--rewrite\\s+\"(.*)\"", Pattern.CASE_INSENSITIVE).matcher(userInput)).matches()) {
                    fileManager.writeToFile(matcher.group(1), matcher.group(2), false);
                } else {
                    System.out.println("Unsupported command!");
                }
            } catch (RuntimeException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
