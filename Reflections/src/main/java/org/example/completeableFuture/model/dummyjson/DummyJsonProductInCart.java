package org.example.completeableFuture.model.dummyjson;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DummyJsonProductInCart {
    private int id;
    private String title;
    private BigDecimal price;
    private int quantity;
    private BigDecimal total;
    private double discountPercentage;
    private double discountedTotal;
    private String thumbnail;
}
