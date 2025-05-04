package org.example.completeableFuture.model.dummyjson;

import lombok.Data;

import java.util.List;

@Data
public class DummyJsonPost {
    int id;
    String title;
    String body;
    List<String> tags;
    DummyJsonReaction reactions;
    int views;
    int userId;
}
