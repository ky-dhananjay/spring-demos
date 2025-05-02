package com.rectivespring.movie_service.exceptions;

public class ReviewServerException extends RuntimeException{
    private String message;

    public ReviewServerException(String message) {
        super(message);
    }
}
