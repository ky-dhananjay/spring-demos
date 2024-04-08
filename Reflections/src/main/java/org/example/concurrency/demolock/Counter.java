package org.example.concurrency.demolock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private int counter;

    private Lock lock = new ReentrantLock();

    public Counter(){
        this.counter = 0;
    }

    public void incr(){
        lock.lock();
        try{
            counter++;
        } finally {
            lock.unlock();
        }
    }

    public int getCounter(){
        return this.counter;
    }
}
