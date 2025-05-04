package org.example.completeableFuture.model.dummyjson.response;

import lombok.Data;
import org.example.completeableFuture.model.dummyjson.DummyJsonUserInComment;
import org.example.completeableFuture.model.dummyjson.dto.PostAndComments;

import java.util.List;
@Data
public class DjUserPostCommentResponse {
    private DummyJsonUserInComment user;
    private List<PostAndComments> posts;
}
