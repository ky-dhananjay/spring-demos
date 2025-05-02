package com.rectivespring.movie_service.exceptions;

public class ReviewClientException extends RuntimeException{

    private String message;

    public ReviewClientException(String message ) {
        super(message);
    }
}
