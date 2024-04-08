package org.example.concurrency.demoatomic;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    private int counter;

    public Counter(){
        this.counter = 0;
    }

    public int getCounter(){
        return this.counter;
    }

    public int incr(){
        return this.counter++;
    }
}
