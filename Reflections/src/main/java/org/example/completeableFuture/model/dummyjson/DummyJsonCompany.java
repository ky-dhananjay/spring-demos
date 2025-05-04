package org.example.completeableFuture.model.dummyjson;

import lombok.Data;

@Data
public class DummyJsonCompany {
    private String department;
    private String name;
    private String title;
    private DummyJsonAddress address;
}
