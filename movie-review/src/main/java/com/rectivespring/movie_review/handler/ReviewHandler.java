package com.rectivespring.movie_review.handler;

import com.rectivespring.movie_review.domain.Review;
import com.rectivespring.movie_review.exception.ReviewDataException;
import com.rectivespring.movie_review.exception.ReviewNotFoundException;
import com.rectivespring.movie_review.repository.ReviewReactiveRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

@Component
@Slf4j
public class ReviewHandler {

    @Autowired
    private Validator validator;

    private ReviewReactiveRepository repository;

    public ReviewHandler(ReviewReactiveRepository repository) {
        this.repository = repository;
    }

    public Mono<ServerResponse> addReview(ServerRequest request) {
        return request.bodyToMono(Review.class)
            .doOnNext(this::validate)
            .flatMap(repository::save)
            .flatMap(ServerResponse.status(HttpStatus.CREATED)::bodyValue);
    }

    private void validate(Review review) {
        var constraintViolation = validator.validate(review);
        log.info("constraintViolation: {}", constraintViolation);
        if(!constraintViolation.isEmpty()){
            var errorMessage = constraintViolation
                .stream()
                .map(ConstraintViolation::getMessage)
                .sorted()
                .collect(Collectors.joining(","));
            throw new ReviewDataException(errorMessage);
        }
    }

    public Mono<ServerResponse> getAllReviews(ServerRequest request) {
        var movieInfoId = request.queryParam("movieInfoId");
        Flux<Review> reviewsFlux;
        if(movieInfoId.isPresent()){
            reviewsFlux = repository.findByMovieInfoId(Long.valueOf(movieInfoId.get()));
        } else {
            reviewsFlux = repository.findAll();
        }
        return getServerResponseMono(reviewsFlux);
    }

    private static Mono<ServerResponse> getServerResponseMono(Flux<Review> reviewsFlux) {
        return ServerResponse.ok().body(reviewsFlux, Review.class);
    }

    public Mono<ServerResponse> updateReview(ServerRequest serverRequest) {
        var reviewId = serverRequest.pathVariable("id");
        var existingReview = repository.findById(reviewId)
            .switchIfEmpty(
                Mono.error(new ReviewNotFoundException("review not found"))
            );
        return existingReview
            .flatMap(review -> serverRequest.bodyToMono(Review.class)
                .map(reqReview -> {
                    review.setComment(reqReview.getComment());
                    review.setMovieInfoId(reqReview.getMovieInfoId());
                    review.setRating(reqReview.getRating());
                    return review;
                })
                .flatMap(repository::save)
                .flatMap(savedReview -> ServerResponse.ok().bodyValue(savedReview))
            );
        // return ServerResponse.status(HttpStatus.OK).body(updatedReview, Review.class);
    }

    public Mono<ServerResponse> deleteReview(ServerRequest serverRequest) {
        var reviewId = serverRequest.pathVariable("id");
        var existingReview = repository.findById(reviewId);
        return existingReview.flatMap(review -> repository.deleteById(review.getReviewId()))
            .then(ServerResponse.noContent().build());
    }
}
