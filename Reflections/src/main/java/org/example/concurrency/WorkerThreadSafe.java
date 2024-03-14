package org.example.concurrency;

public class WorkerThreadSafe implements Runnable{
    private final IntStoreThreadSafe store;

    public WorkerThreadSafe(IntStoreThreadSafe store) {
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++){
            store.incr();
        }
    }
}
