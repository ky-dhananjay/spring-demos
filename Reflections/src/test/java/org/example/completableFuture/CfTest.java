package org.example.completableFuture;

import org.example.completeableFuture.CfCart;
import org.example.completeableFuture.CfPost;
import org.example.completeableFuture.CfProduct;
import org.example.completeableFuture.CfUser;
import org.example.completeableFuture.CfUtil;

import org.example.completeableFuture.model.dummyjson.dto.DjUserPostAndCartDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;

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
    public void testGetUserPostAndProducts_userCount1(){
        int userId = 6;
        DjUserPostAndCartDto userPostAndCartDto = new DjUserPostAndCartDto();
        CompletableFuture<Void> cfUserDtls = cfUser.getUserAsync(userId)
            .thenAccept(userPostAndCartDto::setUser);
        CompletableFuture<Void> cfCartDtls = cfCart.getCartByUserId(userId)
            .thenAccept(userPostAndCartDto::setCarts);
        CompletableFuture<Void> cfPostDtls = cfPost.getPostByUserId(userId)
            .thenAccept(userPostAndCartDto::setPosts);
        CompletableFuture.allOf(cfUserDtls, cfPostDtls, cfCartDtls)
            .thenAccept(ignore -> {
                _log.info(String.valueOf(userPostAndCartDto));
            });
    }
    @Test
    public void testGetUserPostAndProducts_multiuser_approach1(){
        List<Integer> userIds = List.of(1,2,3,6);
        List<DjUserPostAndCartDto> results = new CopyOnWriteArrayList<>();
        var cf =
        userIds
            .stream()
            .map(userId -> buildUserPostAndCartDetails(results, userId))
            .toList();
        CompletableFuture.allOf(cf.toArray(new CompletableFuture[0]))
            .thenAccept(ignore -> {
                Assert.assertEquals(results.size(), userIds.size(), "results size should be equal to userIds");
            });
    }

    private CompletableFuture<Void> buildUserPostAndCartDetails(List<DjUserPostAndCartDto> results, int userId){
        DjUserPostAndCartDto userPostAndCartDto = new DjUserPostAndCartDto();
        CompletableFuture<Void> cfUserDtls = cfUser.getUserAsync(userId)
            .thenAccept(userPostAndCartDto::setUser);
        CompletableFuture<Void> cfCartDtls = cfCart.getCartByUserId(userId)
            .thenAccept(userPostAndCartDto::setCarts);
        CompletableFuture<Void> cfPostDtls = cfPost.getPostByUserId(userId)
            .thenAccept(userPostAndCartDto::setPosts);
        return CompletableFuture.allOf(cfUserDtls, cfPostDtls, cfCartDtls)
            .thenAccept(ignore -> results.add(userPostAndCartDto));
    }

    @Test
    public void testGetUserPostAndProducts_multiuser_approach2(){
        List<Integer> userIds = List.of(1,2,3,6);
        List<DjUserPostAndCartDto> results = new CopyOnWriteArrayList<>();
        List<CompletableFuture<Void>> allFutures = new ArrayList<>();
            userIds
                .forEach(userId -> {
                    DjUserPostAndCartDto djUserPostAndCartDto = new DjUserPostAndCartDto();
                    allFutures.add(cfUser.getUserAsync(userId)
                        .thenAccept(djUserPostAndCartDto::setUser));
                    allFutures.add(cfPost.getPostByUserId(userId)
                        .thenAccept(djUserPostAndCartDto::setPosts));
                    allFutures.add(cfCart.getCartByUserId(userId)
                        .thenAccept(djUserPostAndCartDto::setCarts));
                    results.add(djUserPostAndCartDto);
                });
        CompletableFuture.allOf(allFutures.toArray(new CompletableFuture[0]))
            .thenAccept(ignore -> {
                Assert.assertEquals(results.size(), userIds.size(), "results size should be equal to userIds");
                _log.info(results.toString());
            });
    }

}
