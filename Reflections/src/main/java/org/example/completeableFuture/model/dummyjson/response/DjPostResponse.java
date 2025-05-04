package org.example.completeableFuture.model.dummyjson.response;

import lombok.Data;
import org.example.completeableFuture.model.dummyjson.DummyJsonPost;

import java.util.List;

@Data
public class DjPostResponse {
    private List<DummyJsonPost> posts;
    private int total;
    private int skip;
    private int limit;
}
