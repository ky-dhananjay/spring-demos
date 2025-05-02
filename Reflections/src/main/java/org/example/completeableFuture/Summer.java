package org.example.completeableFuture;

public class Summer implements Runnable{
    @Override
    public void run() {
        System.out.println("Thread :" + Thread.currentThread().getName() + " started");
        long sum = 0;
        for (int i = 0; i < 1000000; i++){
            sum+=i;
        }
        System.out.println(sum);
        System.out.println("Thread :" + Thread.currentThread().getName() + " completed");
    }
}