package ava.java_se_02.task2;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Chancery pen1 = new Chancery("Ручка шариковая масляная Pilot", 56);
        Chancery pen2 = new Chancery("Ручка шариковая ErichKrause R-301 ORANGE 0.7 Stick", 45);
        Chancery tape = new Chancery("Клейкая лента 19мм*33м", 29);
        Chancery copyBook = new Chancery("Тетрадь, 48 листов", 28);
        Chancery glue = new Chancery("Клей-карандаш Erich Krause 15 гр", 54);
        Employee johnDoe = new Employee("John", "Doe");
        Employee polRoberts = new Employee("Pol", "Roberts");
        Employee aliceGreen = new Employee("Alice", "Green");
        WorkerPlace office1 = new WorkerPlace(johnDoe, pen1, pen2, copyBook, tape);
        WorkerPlace office2 = new WorkerPlace(polRoberts, pen1, glue, copyBook);
        WorkerPlace office3 = new WorkerPlace(aliceGreen, pen2, copyBook);
        WorkerPlace office4 = new WorkerPlace(aliceGreen, pen1, copyBook);
        List<WorkerPlace> offices = Arrays.asList(office1, office2, office3, office4);
        int sum = offices.stream().filter(office -> office.getEmployee().equals(aliceGreen)).mapToInt(WorkerPlace::entireCostOfChancery).sum();
        System.out.printf("cost of entire chancery for %s is - %s rubles", aliceGreen, sum);
    }
}
