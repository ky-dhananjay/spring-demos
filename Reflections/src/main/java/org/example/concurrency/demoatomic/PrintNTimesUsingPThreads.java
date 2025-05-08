package org.example.concurrency.demoatomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class PrintNTimesUsingPThreads {

    public static void main(String[] args) {
//        ThreadSafeCounter threadSafeCounter = new ThreadSafeCounter();
//        Counter counter = new Counter();
        AtomicInteger counter = new AtomicInteger(0);;
        IntStream.range(0,5)
            .forEach(i -> {
                new Thread(() -> {
                    while(counter.getAndIncrement() < 5){
                        System.out.println("Hello");
                    }
                }).start();
            });
    }
}
