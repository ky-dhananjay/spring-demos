package com.rectivespring.movie_service.client;

import com.rectivespring.movie_service.domain.MovieInfo;
import com.rectivespring.movie_service.domain.Review;
import com.rectivespring.movie_service.exceptions.MovieInfoServerException;
import com.rectivespring.movie_service.exceptions.MoviesInfoClientException;
import com.rectivespring.movie_service.exceptions.ReviewClientException;
import com.rectivespring.movie_service.exceptions.ReviewServerException;
import com.rectivespring.movie_service.util.RetryUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class ReviewsRestClient {
    private WebClient webClient;

    @Value("${restClient.reviewsUrl}")
    private String reviewsUrl;

    public ReviewsRestClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public Flux<Review> retrieveReviews(String movieInfoId){
        var url = UriComponentsBuilder
            .fromHttpUrl(reviewsUrl)
            .queryParam("movieInfoId", movieInfoId)
            .buildAndExpand()
            .toUriString();
        return webClient
            .get()
            .uri(url, movieInfoId)
            .retrieve()
            .onStatus(HttpStatusCode::is4xxClientError, clientResponse -> {
                if(clientResponse.statusCode().equals(HttpStatus.NOT_FOUND)){
                    return Mono.empty();
                }

                return clientResponse.bodyToMono(String.class)
                    .flatMap(responseMessage -> Mono.error(new ReviewClientException(
                        responseMessage)));
            })
            .onStatus(HttpStatusCode::is5xxServerError, clientResponse -> clientResponse.bodyToMono(String.class)
                .flatMap(responseMessage -> Mono.error(new ReviewServerException(
                    "Reviews server error: " + responseMessage))))
            .bodyToFlux(Review.class)
            .retryWhen(RetryUtil.retrySpec())
            .log();
    }

}
