package org.example.completeableFuture.model;

import lombok.Data;

import java.util.List;

@Data
public class Post {
    int id;
    String title;
    String body;
    List<String> tags;
    Reaction reactions;
    int views;
    int userId;

}
