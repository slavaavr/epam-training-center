package ava.java_se_01;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a;
        double b;
        double h;
        System.out.print("Введите через пробел два числа - границы вычисления вункции tg(2x)-3 : ");
        a = sc.nextDouble();
        b = sc.nextDouble();
        System.out.print("Введите шаг: ");
        h = sc.nextDouble();
        if ((a < b && h <= 0) || (a > b && h >= 0)) {
            System.out.println("Неверно задан шаг!");
            System.exit(0);
        }
        double counter = a;
        System.out.println("x\t\t\t\ty\t\t");
        System.out.println("-------------------------");
        while (counter < b) {
            System.out.println(String.format("%-10.5s\t\t%-10.5s\t\t", counter, Math.tan(2 * counter) - 3));
            counter += h;
        }
    }
}
