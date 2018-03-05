package main.ava;

import java.util.Arrays;
import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите порядок матрицы: ");
        int range;
        range = sc.nextInt();
        int[][] arr = new int[range][range];
        for (int i = 0, k = range - 1; i < range; i++, k--) {
            for (int j = 0; j < range; j++) {
                if (i == j || j == k) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < range; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}
