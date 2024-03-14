package org.example.completeableFuture;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.function.Supplier;

public class ApiCallSupplier implements Supplier {
    @Override
    public Object get() {
        System.out.println(Thread.currentThread().getName() + " started execution");
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest
            .newBuilder()
            .GET()
            .header("Content-Type", "application/json")
            .uri(
                URI.create(String.format("https://jsonplaceholder.typicode.com/posts/1")))
            .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
