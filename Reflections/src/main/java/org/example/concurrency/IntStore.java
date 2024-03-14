package org.example.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class IntStore {
    private int x = 0;

    public synchronized void incr(){
        x++;
    }

    public int getX() {
        return x;
    }
}