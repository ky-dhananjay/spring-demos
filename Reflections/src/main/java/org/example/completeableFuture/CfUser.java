package org.example.completeableFuture;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.completeableFuture.model.dummyjson.DummyJsonUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CfUser {
    private final CfUtil cfUtil;

    ObjectMapper objectMapper = new ObjectMapper();

    private static final Logger LOG = LoggerFactory.getLogger(CfUser.class);

    private static final String DUMMY_JSON_USERS_URL = "https://dummyjson.com/users";

    public CfUser(CfUtil cfUtil){
        this.cfUtil = cfUtil;
    }

    public CompletableFuture<List<DummyJsonUser>> getAllUsersAsync() {
        CompletableFuture<HttpResponse<String>> response =
            cfUtil.getHttpClient(DUMMY_JSON_USERS_URL);
        return response
            .thenApply(httpResponse -> {
                List<DummyJsonUser> userList = null;
                try {
                    userList =
                        objectMapper.readValue(httpResponse.body(), new TypeReference<List<DummyJsonUser>>() {
                        });
                    return userList;
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            });
    }

    public CompletableFuture<DummyJsonUser> getUserAsync(int userId) {
        CompletableFuture<HttpResponse<String>> response =
            cfUtil.getHttpClient(DUMMY_JSON_USERS_URL + "/" + userId);
        return response
            .thenApply(httpResponse -> {
                DummyJsonUser user = null;
                try {
                    user =
                        objectMapper.readValue(httpResponse.body(), new TypeReference<DummyJsonUser>() {
                        });
                    return user;
                } catch (JsonProcessingException e) {
                    LOG.error(e.getMessage(), e);
                }
                return user;
            });
    }

    public CompletableFuture<List<DummyJsonUser>> searchUsersAsync(String searchParam) {
        CompletableFuture<HttpResponse<String>> response =
            cfUtil.getHttpClient(DUMMY_JSON_USERS_URL + "/search?q=" + searchParam);
        return response
            .thenApply(httpResponse -> {
                List<DummyJsonUser> userList = null;
                try {
                    userList =
                        objectMapper.readValue(httpResponse.body(), new TypeReference<List<DummyJsonUser>>() {
                        });
                    return userList;
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            });
    }

}
