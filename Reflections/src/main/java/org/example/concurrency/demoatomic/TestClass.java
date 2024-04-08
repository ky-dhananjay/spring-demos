package org.example.concurrency.demoatomic;

import java.util.stream.IntStream;

/**
 * 1. To see the non thread safe behaviour the number of iteration in the loop should be high
 * 2. There should be a shared object by multiple threads
 */
public class TestClass {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        // ThreadSafeCounter counter = new ThreadSafeCounter();
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
