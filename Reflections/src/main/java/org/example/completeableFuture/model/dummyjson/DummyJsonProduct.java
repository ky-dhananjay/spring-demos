package org.example.completeableFuture.model.dummyjson;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class DummyJsonProduct {
    private int id;
    private String title;
    private String description;
    private String category;
    private BigDecimal price;
    private double discountPercentage;
    private double rating;
    private int stock;
    private List<String> tags;
    private String brand;
    private String sku;
    private double weight;
    private String warrantyInformation;
    private String shippingInformation;
    private String availabilityStatus;
    private List<DummyJsonReviews> reviews;
    private String returnPolicy;
    private int minimumOrderQuantity;
    private DummyJsonMeta meta;
    private String thumbnail;
    private List<String> images;
}
