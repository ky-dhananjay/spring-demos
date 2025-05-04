package org.example.completeableFuture.model.dummyjson;

import lombok.Data;

import java.util.List;
@Data
public class DjSearchUserResponse {
    private List<DummyJsonUser> users;
    private int total;
    private int skip;
    private int limit;
}
