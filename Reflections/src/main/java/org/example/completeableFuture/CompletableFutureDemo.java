package org.example.completeableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Function;

public class CompletableFutureDemo {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("main thread execution started....");
        //CompletableFuture.runAsync(new ApiCallRunnable());
        ExecutorService executorService = Executors.newCachedThreadPool();
        CompletableFuture<String> future = CompletableFuture.supplyAsync(new ApiCallSupplier(),executorService);
        future.thenAcceptAsync((response) -> {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().isDaemon());
            System.out.println(response);
        },executorService);
        future.thenAcceptAsync((response) -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().isDaemon());
            System.out.println("2.response: " + response);
        },executorService);
        System.out.println("main threaded execution completed...");
    }

    public static void summerRunnable() throws InterruptedException {
        System.out.println("Thread :" + Thread.currentThread().getName());
//        CompletableFuture<Void> completableFuture = new CompletableFuture<>();
//        completableFuture.thenRunAsync(new Summer());
        CompletableFuture.runAsync(new Summer());
        Thread.sleep(5000);
        System.out.println("Thread :" + Thread.currentThread().getName() + " task completed");
    }
}
