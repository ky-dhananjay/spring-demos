package org.example.completeableFuture;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.completeableFuture.model.dummyjson.DummyJsonProduct;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CfProduct {
    private final CfUtil cfUtil;
    private final ObjectMapper objectMapper;

    private static final String DUMMY_JSON_PRODUCT_URL = "https://dummyjson.com/products";

    public CfProduct(CfUtil cfUtil){
        this.cfUtil = cfUtil;
        objectMapper = new ObjectMapper();
    }

    public CompletableFuture<List<DummyJsonProduct>> getAllProductAsync() {
        CompletableFuture<HttpResponse<String>> response =
            cfUtil.getHttpClient(DUMMY_JSON_PRODUCT_URL);
        return response
            .thenApply(httpResponse -> {
                List<DummyJsonProduct> userList = null;
                try {
                    userList =
                        objectMapper.readValue(httpResponse.body(), new TypeReference<List<DummyJsonProduct>>() {
                        });
                    return userList;
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            });
    }

    public CompletableFuture<DummyJsonProduct> getProductAsync(int productId) {
        CompletableFuture<HttpResponse<String>> response =
            cfUtil.getHttpClient(DUMMY_JSON_PRODUCT_URL + "/" + productId);
        return response
            .thenApply(httpResponse -> {
                DummyJsonProduct user = null;
                try {
                    user =
                        objectMapper.readValue(httpResponse.body(), new TypeReference<DummyJsonProduct>() {
                        });
                    return user;
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            });
    }

    public CompletableFuture<List<DummyJsonProduct>> searchProductAsync(String searchParam) {
        CompletableFuture<HttpResponse<String>> response =
            cfUtil.getHttpClient(DUMMY_JSON_PRODUCT_URL + "/search?q=" + searchParam);
        return response
            .thenApply(httpResponse -> {
                List<DummyJsonProduct> userList = null;
                try {
                    userList =
                        objectMapper.readValue(httpResponse.body(), new TypeReference<List<DummyJsonProduct>>() {
                        });
                    return userList;
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            });
    }
}
