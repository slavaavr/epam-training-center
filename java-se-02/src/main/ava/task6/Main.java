package main.ava.task6;

public class Main {
    public static void main(String[] args) {
        AtomicBoat atomicBoat = new AtomicBoat(20, 10);
        atomicBoat.setEngine(new AtomicBoat.Engine("engine #1"));
        atomicBoat.goSwimming();
        System.out.println(atomicBoat);
    }
}
