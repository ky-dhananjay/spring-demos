package org.example.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class IntStoreThreadSafe {
    private AtomicInteger x = new AtomicInteger();

    public void incr(){
        x.getAndIncrement();
    }

    public AtomicInteger getX() {
        return x;
    }
}
