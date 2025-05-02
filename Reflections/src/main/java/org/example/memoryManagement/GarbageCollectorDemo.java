package org.example.memoryManagement;

public class GarbageCollectorDemo {
    public static void main(String[] args) throws InterruptedException {
        Runtime runtime = Runtime.getRuntime();

        System.out.println("Available memory 1: " + runtime.freeMemory());

        for (int i = 0; i < 100; i++) {
            Customer c;
            c = new Customer("gcd");
        }
        System.out.println("Available memory 2: " + runtime.freeMemory());

        System.gc();
        //Thread.sleep(1000);
        System.out.println("Available memory 3: " + runtime.freeMemory());
    }
}
