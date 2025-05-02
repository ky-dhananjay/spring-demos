package com.rectivespring.movie_service.exceptions;

public class MovieInfoServerException extends RuntimeException{

    private String message;

    public MovieInfoServerException(String message) {
        super(message);
        this.message = message;
    }
}
