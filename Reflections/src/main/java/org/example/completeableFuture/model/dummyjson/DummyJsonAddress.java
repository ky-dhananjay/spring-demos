package org.example.completeableFuture.model.dummyjson;

import lombok.Data;

@Data
public class DummyJsonAddress {
    private String address;
    private String city;
    private String state;
    private String stateCode;
    private String postalCode;
    private String country;
    private DummyJsonCoordinates coordinates;
}
