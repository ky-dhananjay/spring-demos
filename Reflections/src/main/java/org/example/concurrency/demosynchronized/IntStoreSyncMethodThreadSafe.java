package org.example.concurrency.demosynchronized;

public class IntStoreSyncMethodThreadSafe {
    private int x = 0;

    public synchronized void incr(){
        x++;
    }

    public int getX() {
        return x;
    }
}
