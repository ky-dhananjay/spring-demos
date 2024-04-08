package org.example.concurrency.demosynchronized;

public class ConcurrentDemo {

    public static void main(String[] args) throws InterruptedException {

        threadSafeSynchronizedMethodDemo();

    }

    public static void threadSafeSynchronizedBlockDemo() throws InterruptedException {
        IntStoreThreadSafe store = new IntStoreThreadSafe();

        Thread t1 = new Thread(new WorkerSyncBlockThreadSafe(store));
        Thread t2 = new Thread(new WorkerSyncBlockThreadSafe(store));

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(store.getX());
    }

    public static void threadSafeSynchronizedMethodDemo() throws InterruptedException {
        IntStoreSyncMethodThreadSafe store = new IntStoreSyncMethodThreadSafe();

        Thread t1 = new Thread(new WorkerSyncMethodThreadSafe(store));
        Thread t2 = new Thread(new WorkerSyncMethodThreadSafe(store));

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(store.getX());
    }

    public static void nonThreadSafeDemo() throws InterruptedException {
        IntStore s1 = new IntStore();
        Thread t3 = new Thread(new Worker(s1));
        Thread t4 = new Thread(new Worker(s1));

        t3.start();
        t4.start();
        t3.join();
        t4.join();
        System.out.println(s1.getX());
    }
}
