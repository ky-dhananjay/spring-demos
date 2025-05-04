package org.example.completableFuture;

import org.example.completeableFuture.CfCart;
import org.example.completeableFuture.CfPost;
import org.example.completeableFuture.CfProduct;
import org.example.completeableFuture.CfUser;
import org.example.completeableFuture.CfUtil;
import org.example.completeableFuture.model.dummyjson.DummyJsonCart;
import org.example.completeableFuture.model.dummyjson.DummyJsonPost;
import org.example.completeableFuture.model.dummyjson.DummyJsonUser;

import org.example.completeableFuture.model.dummyjson.dto.DjUserPostAndCartDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CfTest {
    private CfUtil cfUtil;
    private CfUser cfUser;
    private CfProduct cfProduct;
    private CfPost cfPost;
    private CfCart cfCart;

    private static final Logger _log = LoggerFactory.getLogger(CfTest.class);

    @BeforeMethod
    public void setup(){
        cfUtil = new CfUtil();
        cfUser = new CfUser(cfUtil);
        cfPost = new CfPost(cfUtil);
        cfProduct = new CfProduct(cfUtil);
        cfCart = new CfCart(cfUtil);
    }

    @Test
    public void testGetUserPostAndProducts(){
        int userId = 1;
        DummyJsonUser dummyJsonUser = new DummyJsonUser();
        List<DummyJsonCart> cartItems = new ArrayList<>();
        List<DummyJsonPost> postItems = new ArrayList<>();
        CompletableFuture<Void> cfUserDtls = cfUser.getUserAsync(userId)
            .thenAccept(user -> dummyJsonUser.setId(user.getId()));
        CompletableFuture<Void> cfCartDtls = cfCart.getCartByUserId(userId)
            .thenAccept(items -> {
                _log.info("Received: " + items);
                cartItems.addAll(items);
            });
        CompletableFuture<Void> cfPostDtls = cfPost.getPostByUserId(userId)
            .thenAccept(items -> {
                _log.info("Received: " + items);
                postItems.addAll(items);
            });
        CompletableFuture.allOf(cfUserDtls, cfPostDtls, cfCartDtls)
            .thenAccept(ignore -> {
                _log.info(String.valueOf(dummyJsonUser));
                _log.info(cartItems.toString());
                _log.info(postItems.toString());
            });
    }
}
