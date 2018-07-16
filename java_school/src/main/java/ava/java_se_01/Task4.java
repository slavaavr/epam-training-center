package ava.java_se_01;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Количесво действительных чисел: ");
        int n;
        n = sc.nextInt();
        double[] arr = new double[n];
        System.out.print("Вводите действительные числа через пробел: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextDouble();
        }
        double max = 0;
        double temp;
        for (int i = 0, j = n - 1; i < n; i++, j--) {
            if (max < (temp = arr[i] + arr[j])) {
                max = temp;
            }
        }
        System.out.println("Max: " + max);
    }
}
