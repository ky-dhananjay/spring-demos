package org.example.completeableFuture.model.dummyjson.dto;

import lombok.Data;
import org.example.completeableFuture.model.dummyjson.DummyJsonComment;
import org.example.completeableFuture.model.dummyjson.DummyJsonPost;

import java.util.List;
@Data
public class PostAndComments {
    private DummyJsonPost post;
    private List<DummyJsonComment> comments;
}
