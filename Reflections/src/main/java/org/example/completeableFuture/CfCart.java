package org.example.completeableFuture;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.example.completeableFuture.model.dummyjson.DummyJsonCart;
import org.example.completeableFuture.model.dummyjson.DummyJsonPost;
import org.example.completeableFuture.model.dummyjson.response.DjCartResponse;
import org.example.completeableFuture.model.dummyjson.response.DjPostResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CfCart {
    private final CfUtil cfUtil;
    private final ObjectMapper objectMapper;
    private static final String DUMMY_JSON_CART_URL = "https://dummyjson.com/carts";

    private static final Logger LOG = LoggerFactory.getLogger(CfCart.class);
    public CfCart(CfUtil cfUtil){
        this.cfUtil = cfUtil;
        objectMapper = new ObjectMapper();
    }

    public CompletableFuture<List<DummyJsonCart>> getAllCartAsync() {
        CompletableFuture<HttpResponse<String>> response =
            cfUtil.getHttpClient(DUMMY_JSON_CART_URL);
        return response
            .thenApply(httpResponse -> {
                List<DummyJsonCart> userList = null;
                try {
                    userList =
                        objectMapper.readValue(httpResponse.body(), new TypeReference<>() {
                        });
                    return userList;
                } catch (JsonProcessingException e) {
                    LOG.error(e.getMessage(), e);
                    throw new RuntimeException(e);
                }
            });
    }

    public CompletableFuture<DummyJsonCart> getCartAsync(int cartId) {
        CompletableFuture<HttpResponse<String>> response =
            cfUtil.getHttpClient(DUMMY_JSON_CART_URL + "/" + cartId);
        return response
            .thenApply(httpResponse -> {
                DummyJsonCart user = null;
                try {
                    user =
                        objectMapper.readValue(httpResponse.body(), new TypeReference<>() {
                        });
                    return user;
                } catch (JsonProcessingException e) {
                    LOG.error(e.getMessage(), e);
                    throw new RuntimeException(e);
                }
            });
    }

    public CompletableFuture<List<DummyJsonCart>> getCartByUserId(int userId){
        CompletableFuture<HttpResponse<String>> response =
            cfUtil.getHttpClient(DUMMY_JSON_CART_URL + "/user/" + userId);
        return response
            .thenApply(httpResponse -> {
                try {
                    DjCartResponse djCartResponse = objectMapper.readValue(httpResponse.body(),  new TypeReference<>(){});
                    return djCartResponse.getCarts();
                } catch (JsonProcessingException e) {
                    LOG.error(e.getMessage(), e);
                    throw new RuntimeException(e);
                }
            });
    }
}
