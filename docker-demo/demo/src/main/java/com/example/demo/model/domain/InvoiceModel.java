package com.example.demo.model.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvoiceModel {
    private String id;
    private String productName;
    private String orderId;
    private String orderDate;
    private Double price;
    private Integer quantity;
    private Double totalProductPrice;
    private Double saleTax;
    private Double tvelpFee;
    private Double paymentProcessingFee;
    private Double travelerReward;
    private Double estimatedTotalInInr;
    private Double estimatedTotalInUsd;

    public String getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getTotalProductPrice() {
        return totalProductPrice;
    }

    public Double getSaleTax() {
        return saleTax;
    }

    public Double getTvelpFee() {
        return tvelpFee;
    }

    public Double getPaymentProcessingFee() {
        return paymentProcessingFee;
    }

    public Double getTravelerReward() {
        return travelerReward;
    }

    public Double getEstimatedTotalInInr() {
        return estimatedTotalInInr;
    }

    public Double getEstimatedTotalInUsd() {
        return estimatedTotalInUsd;
    }
}
