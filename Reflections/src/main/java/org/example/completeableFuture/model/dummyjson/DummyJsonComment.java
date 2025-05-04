package org.example.completeableFuture.model.dummyjson;

import lombok.Data;

@Data
public class DummyJsonComment {
    private int id;
    private String body;
    private int postId;
    private int likes;
    private DummyJsonUserInComment user;
}
