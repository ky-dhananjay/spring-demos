package org.example.completeableFuture.model.dummyjson.response;

import lombok.Data;
import org.example.completeableFuture.model.dummyjson.DummyJsonCart;
import org.example.completeableFuture.model.dummyjson.DummyJsonPost;

import java.util.List;

@Data
public class DjCartResponse {
    private List<DummyJsonCart> carts;
    private int total;
    private int skip;
    private int limit;
}
