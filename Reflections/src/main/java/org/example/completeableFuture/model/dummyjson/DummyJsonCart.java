package org.example.completeableFuture.model.dummyjson;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class DummyJsonCart {
    private int id;
    private List<DummyJsonProductInCart> products;
    private BigDecimal total;
    private double discountedTotal;
    private int userId;
    private int totalProducts;
    private int totalQuantity;
}
