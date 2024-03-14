package com.example.urlshortner.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UrlRequest {
    @NotNull
    @NotBlank
    private String sourceUrl;

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    @Override
    public String toString() {
        return "UrlRequest{" +
            "sourceUrl='" + sourceUrl + '\'' +
            '}';
    }
}
