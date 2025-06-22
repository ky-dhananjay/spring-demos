package org.example.completeableFuture;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.completeableFuture.model.dummyjson.DummyJsonPost;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureDemo {



    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<?> answer = CompletableFuture.supplyAsync(() -> {
            try{
                Thread.sleep(1);
            } catch (InterruptedException ie){
                System.out.println(ie);
            }
            return "hello from future";
        });
        answer
            .handle((ans, err) -> {
                if(err != null){
                    System.out.println(err);
                } else {
                    System.out.println(ans);
                }
                return null;
            });
    }






    public static void demoDummyMethod(){
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
