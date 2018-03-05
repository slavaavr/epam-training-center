package main.ava;


/**
 * Задание: скомпилировать и запустить данный код из консоли
 * javac -encoding utf8 src/main/ava/Task1.java
 * java -cp src main/ava/Task1
 */
public class Task1 {

    public static void main(String[] args) {
        Logic logic = new Logic();
        System.out.println(logic.method());
    }

    static class Logic {
        String method() {
            return "I am string in logic";
        }
    }
}

