package org.example.completeableFuture.model.dummyjson.dto;

import lombok.Data;
import org.example.completeableFuture.model.dummyjson.DummyJsonCart;
import org.example.completeableFuture.model.dummyjson.DummyJsonPost;
import org.example.completeableFuture.model.dummyjson.DummyJsonUser;

import java.util.List;
@Data
public class DjUserPostAndCartDto {
    private DummyJsonUser user;
    private List<DummyJsonCart> carts;
    private List<DummyJsonPost> posts;
}
