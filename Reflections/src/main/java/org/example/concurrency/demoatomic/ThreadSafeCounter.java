package org.example.concurrency.demoatomic;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSafeCounter {
    private AtomicInteger counter;

    public ThreadSafeCounter(){
        this.counter = new AtomicInteger();
    }

    public int getCounter(){
        return this.counter.get();
    }

    public int incr(){
        return counter.incrementAndGet();
    }
}
