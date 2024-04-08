package org.example.concurrency.demosynchronized;

public class WorkerSyncMethodThreadSafe implements Runnable{
    private final IntStoreSyncMethodThreadSafe store;

    public WorkerSyncMethodThreadSafe(IntStoreSyncMethodThreadSafe store) {
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++){
                store.incr();
        }
    }
}
