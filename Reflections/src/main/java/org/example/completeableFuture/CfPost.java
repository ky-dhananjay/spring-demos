package org.example.completeableFuture;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.example.completeableFuture.model.dummyjson.DummyJsonPost;
import org.example.completeableFuture.model.dummyjson.response.DjPostResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class CfPost {
    private final CfUtil cfUtil;
    private final ObjectMapper objectMapper;
    private static final String DUMMY_JSON_POST_URL = "https://dummyjson.com/posts";
    private static final Logger LOG = LoggerFactory.getLogger(CfPost.class);

    public CfPost(CfUtil cfUtil){
        this.cfUtil = cfUtil;
        objectMapper = new ObjectMapper();
    }

    public CompletableFuture<List<DummyJsonPost>> getAllPostAsync() {
        CompletableFuture<HttpResponse<String>> response =
            cfUtil.getHttpClient(DUMMY_JSON_POST_URL);
        return response
            .thenApply(httpResponse -> {
                try {
                    DjPostResponse djPostResponse = objectMapper.readValue(httpResponse.body(),  new TypeReference<>(){});
                    return djPostResponse.getPosts();
                } catch (JsonProcessingException e) {
                    LOG.error(e.getMessage(), e);
                    throw new RuntimeException(e);
                }
            });
    }

    public CompletableFuture<DummyJsonPost> getPostAsync(int userId) {
        CompletableFuture<HttpResponse<String>> response =
            cfUtil.getHttpClient(DUMMY_JSON_POST_URL + "/" + userId);
        return response
            .thenApply(httpResponse -> {
                DummyJsonPost user = null;
                try {
                    user =
                        objectMapper.readValue(httpResponse.body(), new TypeReference<DummyJsonPost>() {
                        });
                    return user;
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            });
    }

    public CompletableFuture<List<DummyJsonPost>> searchPostAsync(String searchParam) {
        CompletableFuture<HttpResponse<String>> response =
            cfUtil.getHttpClient(DUMMY_JSON_POST_URL + "/search?q=" + searchParam);
        return response
            .thenApply(httpResponse -> {
                List<DummyJsonPost> userList = null;
                try {
                    userList =
                        objectMapper.readValue(httpResponse.body(), new TypeReference<List<DummyJsonPost>>() {
                        });
                    return userList;
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            });
    }

    public CompletableFuture<List<DummyJsonPost>> getPostByUserId(int userId){
        CompletableFuture<HttpResponse<String>> response =
            cfUtil.getHttpClient(DUMMY_JSON_POST_URL + "/user/" + userId);
        return response
            .thenApply(httpResponse -> {
                    try {
                        DjPostResponse djPostResponse = objectMapper.readValue(httpResponse.body(),  new TypeReference<>(){});
                        return djPostResponse.getPosts();
                    } catch (JsonProcessingException e) {
                        LOG.error(e.getMessage(), e);
                        throw new RuntimeException(e);
                    }
            });
    }
}
