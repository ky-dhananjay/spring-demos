package com.rectivespring.movie_service.exceptions;

import lombok.Data;
import lombok.Getter;

public class MoviesInfoClientException extends RuntimeException{
    private String message;
    @Getter
    private int statusCode;

    public MoviesInfoClientException(String message) {
        this.message = message;
    }

    public MoviesInfoClientException(String message, Integer statusCode) {
        super(message);
        this.message = message;
        this.statusCode = statusCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
