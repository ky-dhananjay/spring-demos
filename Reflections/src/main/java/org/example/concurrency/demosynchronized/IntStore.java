package org.example.concurrency.demosynchronized;

import java.util.concurrent.atomic.AtomicInteger;

public class IntStore {
    private int x = 0;

    public void incr(){
        x++;
    }

    public int getX() {
        return x;
    }
}