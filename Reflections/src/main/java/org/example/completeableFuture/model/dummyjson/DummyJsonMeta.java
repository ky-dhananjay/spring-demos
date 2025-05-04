package org.example.completeableFuture.model.dummyjson;

import lombok.Data;

import java.util.Date;
@Data
public class DummyJsonMeta {
    private Date createdAt;
    private Date updatedAt;
    private String barcode;
    private String qrCode;
}
