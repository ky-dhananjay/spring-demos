package org.example.concurrency.demolock;

import java.util.stream.IntStream;

/**
 * 1. Why lock?
 */

public class TestLockDemo {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                IntStream.range(0,1000000).forEach(i -> {
                    // System.out.println("t1 running " + System.currentTimeMillis());
                    counter.incr();
                });
            }
        };

        Runnable r2 = () -> IntStream.range(0,1000000).forEach((i)-> {
            // System.out.println("t2 running " + System.currentTimeMillis());
            counter.incr();
        });

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(counter.getCounter());
    }
}
