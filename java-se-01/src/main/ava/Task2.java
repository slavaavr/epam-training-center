package main.ava;

import java.util.Arrays;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите количество элементов: ");
        int n = sc.nextInt();
        System.out.println("Введите 'е' меньше которого нужно найти число: ");
        double e = sc.nextDouble();
        double[] arr = new double[n];
        for (int i = 1; i <= n; i++) {
            arr[i - 1] = 1 / Math.pow((i + 1), 2);
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] < e) {
                System.out.println(String.format("Индекс элемента, удовлетворяющий условию а(n) < %s: %s", e, i));
                break;
            }
            if(i == n-1){
                System.out.println("Индекс не был найден!");
            }
        }
        System.out.println(Arrays.toString(arr));


    }


}
