package org.example.completeableFuture;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class CfUtil {

    public CompletableFuture<HttpResponse<String>> getHttpClient(String uri) {
        HttpRequest request = HttpRequest
            .newBuilder()
            .uri(URI.create(uri))
            .GET()
            .build();
        try (HttpClient client = HttpClient.newBuilder().build()) {
            return client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        }
    }
}
