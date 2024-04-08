package org.example.concurrency.demosynchronized;

public class WorkerSyncBlockThreadSafe implements Runnable{
    private final IntStoreThreadSafe store;

    public WorkerSyncBlockThreadSafe(IntStoreThreadSafe store) {
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++){
            synchronized (store){
                store.incr();
            }
        }
    }
}
