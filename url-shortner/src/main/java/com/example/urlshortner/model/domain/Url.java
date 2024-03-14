package com.example.urlshortner.model.domain;

import com.opencsv.bean.CsvBindByName;

import java.util.UUID;

public class Url extends CsvBean {
    @CsvBindByName(column = "id")
    private UUID id;
    @CsvBindByName(column = "sourceUrl")
    private String sourceUrl;
    @CsvBindByName(column = "shortenedUrl")
    private String shortenedUrl;
    @CsvBindByName(column = "createdAt")
    private Long createdAt;

    private Url(Builder builder) {
        this.id = builder.id;
        this.sourceUrl = builder.sourceUrl;
        this.shortenedUrl = builder.shortenedUrl;
        this.createdAt = builder.createdAt;
    }

    public UUID getId() {
        return id;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public String getShortenedUrl() {
        return shortenedUrl;
    }

    public Long getCreatedAt() {
        return createdAt;
    }
    public static class Builder{
        private UUID id;
        private String sourceUrl;
        private String shortenedUrl;
        private Long createdAt;

        public Builder id(UUID id) {
            this.id = id;
            return this;
        }

        public Builder sourceUrl(String sourceUrl) {
            this.sourceUrl = sourceUrl;
            return this;
        }

        public Builder shortenedUrl(String shortenedUrl) {
            this.shortenedUrl = shortenedUrl;
            return this;
        }

        public Builder createdAt(Long createdAt) {
            this.createdAt = createdAt;
            return this;
        }
        public Url build(){
            return new Url(this);
        }
    }

    @Override
    public String toString() {
        return "Url{" +
            "id=" + id +
            ", sourceUrl='" + sourceUrl + '\'' +
            ", shortenedUrl='" + shortenedUrl + '\'' +
            ", createdAt=" + createdAt +
            '}';
    }
}
